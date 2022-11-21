import argparse
import random
import numpy as np
import pandas as pd
import time
import matplotlib.pyplot as plt
import math


def classic_matrix_mult(A, B):
    n = len(A)
    R = [[0]*n]*n
    for i in range(n):
        for j in range(n):
            for k in range(n):
                R[i][j] += A[i][k]*B[i][k]
    return R


def add(A, B):
    n = len(A)
    return [[A[i][j]+B[i][j] for j in range(n)] for i in range(n)]


def subtract(A, B):
    n = len(A)
    return [[A[i][j]-B[i][j] for j in range(n)] for i in range(n)]


def divide(A):
    n = len(A)
    m = n // 2
    A11 = [[A[i][j] for j in range(m)] for i in range(m)]
    A12 = [[A[i][j] for j in range(m)] for i in range(m, n)]
    A21 = [[A[i][j] for j in range(m, n)] for i in range(m)]
    A22 = [[A[i][j] for j in range(m, n)] for i in range(m, n)]
    return A11, A12, A21, A22


def strassen_matrix_mult(A, B, threshold=512):
    if len(A) <= threshold:
        C = classic_matrix_mult(A, B)

    else:
        A11, A12, A21, A22 = divide(A)
        B11, B12, B21, B22 = divide(B)

        s1 = strassen_matrix_mult(A11, subtract(B12, B22))
        s2 = strassen_matrix_mult(add(A11, A12), B22)
        s3 = strassen_matrix_mult(add(A21, A22), B11)
        s4 = strassen_matrix_mult(A22, subtract(B21, B11))
        s5 = strassen_matrix_mult(add(A11, A22), add(B11, B22))
        s6 = strassen_matrix_mult(subtract(A12, A22), add(B21, B22))
        s7 = strassen_matrix_mult(subtract(A11, A21), add(B11, B12))

        C11 = add(subtract(add(s5, s4), s2), s6)
        C12 = add(s1, s2)
        C21 = add(s3, s4)
        C22 = subtract(subtract(add(s1, s5), s3), s7)

        C = []
        for i in range(len(C12)):
            C.append(C11[i] + C12[i])
        for i in range(len(C22)):
            C.append(C21[i] + C22[i])
    return C


def numpy_mult(A, B):
    return np.dot(A, B)


def gen_matrix(n):
    return [[random.randrange(0, 9) for _ in range(n)] for _ in range(n)]


def gen_rand_matrices(sizes):
    print("generating random matrices")
    A = []
    for i in range(len(sizes)):
        A.append(gen_matrix(sizes[i]))
    B = []
    for i in range(len(sizes)):
        B.append(gen_matrix(sizes[i]))
    return A, B


def mult(A, B, function_name, threshold):
    if function_name == "strassen":
        strassen_matrix_mult(A, B, threshold)
    if function_name == "classic":
        classic_matrix_mult(A, B)
    if function_name == "numpy":
        np.dot(A, B)


def duration(A, B, function_name, threshold):
    start = time.time()
    #  print(function(A,B))
    mult(A, B, function_name, threshold)
    end = time.time()
    temps = end - start
    return temps


def study(A, B, function_name, sizes, threshold=512):
    durations = []
    for i in range(len(sizes)):
        durations.append(duration(A[i], B[i], function_name, threshold))
    return durations

    times = {}


if __name__ == "__main__":
    times = {}
    parser = argparse.ArgumentParser(
        description='This script is to test the complexity of Strassens algorithm compared to the classic algorithm as well as numpy.dot')

    parser.add_argument('-matrix_size', type=int, default=1024, nargs='?',
                        help=f'the size of the largest matrix to test up to. (default 1024)')
    parser.add_argument('-threshold', type=int, default=265, nargs='?',
                        help=f'The threshold when Strassens algorithm switch to the classic algo (default 265)')

    args = parser.parse_args()
    # Generating the random matrices.
    sizes = [2**i for i in range(int(math.log2(args.matrix_size))+1)]
    A, B = gen_rand_matrices(sizes)
    times["matrix sizes"] = sizes
    times["durations"] = []
    algo_names = ["classic", "strassen", "numpy"]

    for algo_name in algo_names:
        print(f"Studying: {algo_name}")
        times["durations"] = study(A, B, algo_name, sizes, args.threshold)
        df = pd.DataFrame(times)
        print(df)
        plt.plot(df["matrix sizes"], df["durations"],
                 label=f'{algo_name} sort')

       # Drawing the graph.

    plt.legend(loc=2)
    plt.rcParams["figure.figsize"] = (20, 10)
    plt.title(" Naive vs Strassen Matrix Multiplication")
    plt.xlabel('Matrix size')
    plt.ylabel('Time execution in Seconds')
    plt.rcParams["figure.figsize"] = (20, 10)
    plt.show()
