import sorting_functions as sf
import pandas as pd
from random import random
from math import floor
import matplotlib.pyplot as plt
import time
import sys
import json
MAX_ARRAY_SIZE=4000
MAX_NUMBER=1000
NUMBER_OF_SAMPLES=1

def main():
    sys.setrecursionlimit(50000)
    times={}
    array_sizes=[]
    durations=[]
    for i in range(1,MAX_ARRAY_SIZE//10):
        times[i]=[]
    for array_size in range(1,MAX_ARRAY_SIZE//10):
        for i in range(NUMBER_OF_SAMPLES):
            start=time.time()
            print(f' {array_size*10_00/MAX_ARRAY_SIZE}',end='%\r')
            arr=[floor(MAX_NUMBER*random()) for _ in range(10*array_size)]
            sf.heap_sort(arr)
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
    df.plot(kind='scatter',x='col1',y='col2')
    times={}
    array_sizes=[]
    durations=[]
    for i in range(1,MAX_ARRAY_SIZE//10):
        times[i]=[]
    for array_size in range(1,MAX_ARRAY_SIZE//10):
        for i in range(NUMBER_OF_SAMPLES):
            start=time.time()
            print(f' {array_size*10_00/MAX_ARRAY_SIZE}',end='%\r')
            arr=[floor(MAX_NUMBER*random()) for _ in range(10*array_size)]
            sf.bubble_sort(arr)
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
    df.plot(kind='scatter',x='col1',y='col2')
    plt.show()
    df.to_csv("raw,csv")
if __name__ == "__main__":
    main()
