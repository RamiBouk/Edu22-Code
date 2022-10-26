from random import random
from math import floor
from math import log2
import sys
## Conststants:
ARRAY_SIZE=15

## Functions:
def bubble_sort(array):
    sorted=False
    while(not sorted):
        sorted=True
        for i in range(1,ARRAY_SIZE):
            if(array[i-1]>array[i]):
                array[i],array[i-1]=array[i-1],array[i]
                sorted=False
    return array

def merge_sort(array):
    length=len(array)
    if(length==1):
        return array
    array1=merge_sort(array[:length//2])
    array2=merge_sort(array[length//2:])
    i,j=0,0
    result_array=[]
    while(len(array1) and len(array2)):
        if(array1[0]<array2[0]):
           result_array.append(array1.pop(0))
        else:
           result_array.append(array2.pop(0))
    resutls_array=result_array+array1+array2
    return resutls_array

def quick_sort(array):
    if(len(array)==1):
        return array
    poped=array.pop()
    sorted_array=quick_sort(array)
    length=len(sorted_array)
    for i in range(length):## this is bad the loop can be replaced with something better with O(len(n))
        if(poped<array[i]):
            sorted_array.insert(i,poped)
            return sorted_array
    sorted_array.append(poped)
    return sorted_array

def insertion_sort(array):
    length=len(array)
    for i in range(1,length):
        j=i
        while(j>0 and array[j-1]>array[j]):
            array[j-1],array[j]=array[j],array[j-1]
            j-=1
    return array
def heapify(array):
    for i in range(1,tree_depth):
        m=2**(i-1)
        left_tree.append(tree[i][:m])
        right_tree.append(tree[i][m:])


def heap_sort(array):
    create_tree_from_list(array)
    ## create heap 
    heapify(create_tree_from_list(array))
    ## solving
    return array

def selection_sort(array):
    if(len(array)==1):
        return array
    min_index=0
    for i in range(len(array)):
        if(array[i]<array[min_index]):
            min_index=i
    min=array.pop(min_index)
    array=selection_sort(array)
    array.insert(0, min)
    return array


def main():
    print(sys.getrecursionlimit())
    sys.setrecursionlimit(50000)
    array=[floor(1000*random()) for i in range(ARRAY_SIZE)]
    print("the originial array:")
    print(array)
    print("new array:")
    new_array=heap_sort(array.copy())
    print(new_array)
    print("sorted array:")
    array.sort()
    print(array)
    if(new_array==array):
        print("Success")
    else:
        print("Fail")
if __name__ == "__main__":
    main()
