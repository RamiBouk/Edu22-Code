from random import random
from math import floor
from math import log2, log
import sys
# Functions:


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


# Conststants:
ARRAY_SIZE = 100_00


def main():
    sys.setrecursionlimit(50000)
    while (True):
        array = [floor(10*random()) for i in range(10)]
        new_array = quick_sort(array.copy())
        array.sort()
        print(new_array == array)


if __name__ == "__main__":
    main()
