import sorting_functions as sf
import pandas as pd
from random import random
from math import floor
import matplotlib.pyplot as plt
import time
import sys


def algo(sort_name, arr):
    if sort_name == "bubble":
        sf.bubble_sort(arr)
    if sort_name == "new_quick":
        sf.quick_sort(arr)
    if sort_name == "merge":
        sf.merge_sort(arr)
    if sort_name == "insertion":
        sf.insertion_sort(arr)
    if sort_name == "heap":
        sf.heap_sort(arr)
    if sort_name == "selection":
        sf.selection_sort(arr)


MAX_ARRAY_SIZE = 7000
MAX_NUMBER = 1_000
NUMBER_OF_SAMPLES = 5
STEP = 10


def study(max_array_size=MAX_ARRAY_SIZE,
          min_array_size=0,
          max_number=MAX_NUMBER,
          number_or_samples=NUMBER_OF_SAMPLES,
          step=STEP,
          algo_name="bubble",
          array_sizes=[],
          durations=[],
          ):
    execution_time = 0
    for array_size in range(max_array_size, min_array_size, -step):
        for i in range(number_or_samples, 0, -1):
            start = time.time()
            print(f' {floor((max_array_size-array_size)*100/max_array_size)}%' +
                  f' ETA:{number_or_samples*array_size*execution_time/step}s', end='\r')

            arr = [floor(max_number*random()) for _ in range(array_size)]
            algo(algo_name, arr)
            end = time.time()
            execution_time = end-start
            array_sizes.append(array_size)
            durations.append(execution_time)


def main():
    sys.setrecursionlimit(50000)
    times = {}
    arr_sizes = []
    durations = []
    algo_name = "merge"
    study(array_sizes=arr_sizes,
          durations=durations,
          min_array_size=5000,
          max_array_size=10000,
          algo_name=algo_name,
          )
    times["array sizes"] = arr_sizes
    times["durations"] = durations
    df = pd.DataFrame(times)
    print(df)
    df.to_csv(f"data/{algo_name}.csv", mode="a")
    df.plot(kind="scatter", x="array sizes", y="durations")
    plt.show()


if __name__ == "__main__":
    main()
