import sorting_functions as sf
import pandas as pd
from random import random
from math import floor
import time
import sys
MAX_ARRAY_SIZE=5000
MAX_NUMBER=1000
NUMBER_OF_SAMPLES=10

def main():
    sys.setrecursionlimit(50000)
    times=[]
    for array_size in range(10,MAX_ARRAY_SIZE//10):
        for i in range(NUMBER_OF_SAMPLES):
            start=time.time()
            print(array_size/MAX_ARRAY_SIZE)
            arr=[floor(MAX_NUMBER*random()) for _ in range(10*array_size)]
            sf.quick_sort(arr)
            end=time.time()
            execution_time=end-start
            times.append(execution_time)
    print(times)
if __name__ == "__main__":
    main()
