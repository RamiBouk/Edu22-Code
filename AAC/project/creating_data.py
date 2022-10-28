import sorting_functions as sf
import pandas as pd
from random import random
from math import floor
import matplotlib.pyplot as plt
import time
import sys
import json
MAX_ARRAY_SIZE=1000
MAX_NUMBER=1000
NUMBER_OF_SAMPLES=10
STEP=10
def algo(sort_name,arr):
    if sort_name=="bubble":
        sf.bubble_sort(arr)
    if sort_name=="quick":
        sf.quick_sort(arr)
    if sort_name=="merge":
        sf.merge_sort(arr)
    if sort_name=="insertion":
        sf.insertion_sort(arr)
    if sort_name=="heap":
        sf.heap_sort(arr)
    if sort_name=="selection":
        sf.selection_sort(arr)

def study(max_array_size=MAX_ARRAY_SIZE,
          max_number=MAX_NUMBER,
          number_or_samples=NUMBER_OF_SAMPLES,
          step=STEP,
          plot=True,
          algo_name="bubble",
        ):
    times={}
    array_sizes=[]
    durations=[]
    for i in range(1,max_array_size//step):
        times[i]=[]
    for array_size in range(1,max_array_size//step):
        for i in range(number_or_samples):
            start=time.time()
            print(f' {array_size*step*100/max_array_size}',end='%\r')
            arr=[floor(max_number*random()) for _ in range(10*array_size)]
            algo(algo_name,arr)
            end=time.time()
            execution_time=end-start
            array_sizes.append(array_size)
            durations.append(execution_time)
            times[array_size].append(execution_time)
    times={}
    times["col1"]=array_sizes
    times["col2"]=durations
    df = pd.DataFrame(times)
    print(df)
    if plot:
        df.plot(kind="scatter",x="col1",y="col2")
    df.to_csv("raw.csv")
    return df

def main():
    sys.setrecursionlimit(50000)
    df1=study(algo_name="bubble",max_array_size=1500)
   # df2=study(algo_name="quick_sort")
    plt.show()
    df.to_csv("raw.csv")
if __name__ == "__main__":
    main()
