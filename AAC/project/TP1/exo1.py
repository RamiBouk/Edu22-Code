import pandas as pd
from random import random
from math import floor
import matplotlib.pyplot as plt
import time
import sys
import argparse


def bubble_sort(array):
    sorted = False
    array_size = len(array)
    while (not sorted):
        sorted = True
        for i in range(1, array_size):
            if (array[i-1] > array[i]):
                array[i], array[i-1] = array[i-1], array[i]
                sorted = False
    return array


def merge_sort(array):
    length = len(array)
    if (length == 1):
        return array

    array1 = merge_sort(array[:length//2])
    array2 = merge_sort(array[length//2:])

    i, j = 0, 0
    result_array = []
    while (len(array1) and len(array2)):
        if (array1[0] < array2[0]):
            result_array.append(array1.pop(0))
        else:
            result_array.append(array2.pop(0))
    resutls_array = result_array+array1+array2
    return resutls_array


def quick_sort(array):
    if (len(array) == 1):
        return array

    poped = array.pop()
    sorted_array = quick_sort(array)
    length = len(sorted_array)

    if (poped >= sorted_array[length-1]):
        sorted_array.append(poped)
        return sorted_array

    high, low = length-1, 0
    while (low < high):
        mid = (high+low)//2
        if (poped <= sorted_array[mid]):
            high = mid
        else:
            low = mid+1

    sorted_array.insert(low, poped)
    return sorted_array


def insertion_sort(array):
    length = len(array)
    for i in range(1, length):
        j = i
        while (j > 0 and array[j-1] > array[j]):
            array[j-1], array[j] = array[j], array[j-1]
            j -= 1
    return array


def heapify(arr, N, root):
    largest = root
    left = 2*root+1
    right = 2*root+2

    if left < N and arr[largest] < arr[left]:
        largest = left

    if right < N and arr[largest] < arr[right]:
        largest = right

    if largest != root:
        arr[root], arr[largest] = arr[largest], arr[root]
        heapify(arr, N, largest)


def heap_sort(arr):
    N = len(arr)
    for i in range(N//2 - 1, -1, -1):
        heapify(arr, N, i)

    for i in range(N-1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]
        heapify(arr, i, 0)

    return arr


def selection_sort(array):
    if (len(array) == 1):
        return array
    min_index = 0
    for i in range(len(array)):
        if (array[i] < array[min_index]):
            min_index = i
    min = array.pop(min_index)
    array = selection_sort(array)
    array.insert(0, min)
    return array


def run_algo(sort_name, arr):
    if sort_name == "bubble":
        bubble_sort(arr)
    if sort_name == "quick":
        quick_sort(arr)
    if sort_name == "merge":
        merge_sort(arr)
    if sort_name == "insertion":
        insertion_sort(arr)
    if sort_name == "heap":
        heap_sort(arr)
    if sort_name == "selection":
        selection_sort(arr)


MAX_ARRAY_SIZE = 4_000
MIN_ARRAY_SIZE = 0
MAX_NUMBER = 1_000
NUMBER_OF_SAMPLES = 5
STEP = 10


def study(
    algo_name,
    max_array_size=MAX_ARRAY_SIZE,
    min_array_size=MIN_ARRAY_SIZE,
    max_number=MAX_NUMBER,
    number_or_samples=NUMBER_OF_SAMPLES,
    step=STEP,

):
    times = {}
    execution_time = 0
    array_sizes = []
    durations = []
    for array_size in range(max_array_size, min_array_size, -step):
        for i in range(number_or_samples, 0, -1):

            start = time.time()
            # Printing an estimation of the duration left
            print(f' {floor((max_array_size-array_size)*100/max_array_size)}%' +
                  f' ETA:{floor(number_or_samples*array_size*execution_time/step)}s',
                  end='  \r')

            arr = [floor(max_number*random()) for _ in range(array_size)]
            run_algo(algo_name, arr)
            end = time.time()
            execution_time = end-start
            array_sizes.append(array_size)
            durations.append(execution_time)
    times["array sizes"] = array_sizes
    times["durations"] = durations
    return times


def main():
    # example run "python exo1.py quick insertion bubble -num_samp 5 -max_arr 1000"

    parser = argparse.ArgumentParser(
        description='this is a python script to study different sorting algorithms ' +
        'run example: python exo1.py quick insertion bubble -num_samp 5 -max_arr 1000')

    parser.add_argument('algo_name', type=str, nargs='+',
                        help='Tne names of algos that you wish to study from the following:\n bubble, quick, insertion, merge, heap, selection')

    parser.add_argument('-max_n', type=int, default=MAX_NUMBER, nargs='?',
                        help=f'The largest number in any array (default {MAX_NUMBER})')

    parser.add_argument('--min_arr', default=0, type=int, nargs='?',
                        help=f'The smallest array in testing set (default {MIN_ARRAY_SIZE})')

    parser.add_argument('-max_arr', type=int, default=MAX_ARRAY_SIZE, nargs='?',
                        help=f'The largest size of array in testing set (default {MAX_ARRAY_SIZE})')

    parser.add_argument('-step', type=int, default=STEP, nargs='?',
                        help=f'The steps to advance from the min to  max array size (default {STEP})')

    parser.add_argument('-num_samp', type=int, default=NUMBER_OF_SAMPLES, nargs='?',
                        help=f'The number of samples taken for each array size (default {NUMBER_OF_SAMPLES})')
    parser.add_argument('-no_graph', action='store_true',
                        help=f'to not draw the graph at the end')
    args = parser.parse_args()

    sys.setrecursionlimit(50000)

    times = {}
    arr_sizes = []
    durations = []
    algo_name = "merge"
    fig, axes = plt.subplots()
    for algo_name in args.algo_name:
        print("studying: "+algo_name)
        times = study(
            min_array_size=args.min_arr,
            number_or_samples=args.num_samp,
            max_array_size=args.max_arr,
            algo_name=algo_name,
        )
        df = pd.DataFrame(times)
        axes.scatter(df["array sizes"], df["durations"],
                     label=f'{algo_name} sort', sizes=[1])
    if not args.no_graph:
        axes.set_yscale("symlog",base=2)
        plt.legend(loc=2)
        plt.rcParams["figure.figsize"] = (20, 10)
        plt.yscale('symlog'  )
        plt.xlabel('Array size')
        plt.ylabel('Executation time (ms)')
        plt.show()


if __name__ == "__main__":
    main()
