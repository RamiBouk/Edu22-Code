
import matplotlib.pyplot as plt
import numpy as np
import random
import time
##################    Naive   ###############################


def classic_matrix_mult(A, B):
    C = [[0]*len(A) for i in range(len(A[0]))]
    for i in range(len(A)):
        for j in range(len(A[0])):
            for k in range(len(A)):
                C[i][j] += A[i][k]*B[i][k]
    return C

####################  Strassen  ###########################


def somme(A, B):
    C = [[0]*len(A) for i in range(len(A[0]))]
    for i in range(len(A)):
        for j in range(len(A[0])):
            C[i][j] = A[i][j]+B[i][j]
    return C


def differance(A, B):
    C = [[0]*len(A) for i in range(len(A[0]))]
    for i in range(len(A)):
        for j in range(len(A[0])):
            C[i][j] = A[i][j]-B[i][j]
    return C
################ diviser #######################


def diviser(A):
    n = len(A)
    m = n // 2
    A11 = [[A[i][j] for j in range(m)] for i in range(m)]
    A12 = [[A[i][j] for j in range(m)] for i in range(m, n)]
    A21 = [[A[i][j] for j in range(m, n)] for i in range(m)]
    A22 = [[A[i][j] for j in range(m, n)] for i in range(m, n)]
    return A11, A12, A21, A22


def strassen_matrix_mult(A, B):
    if len(A) == 2 and len(B[0]) == 2:
        C = [[A[0][0] * B[0][0] + A[0][1] * B[1][0], A[0][0] * B[0][1] + A[0][1] * B[1][1]],
             [A[1][0] * B[0][0] + A[1][1] * B[1][0], A[1][0] * B[0][1] + A[1][1] * B[1][1]]]
    else:
        A11, A12, A21, A22 = diviser(A)
        B11, B12, B21, B22 = diviser(B)

        s1 = strassen_matrix_mult(A11, differance(B12, B22))
        s2 = strassen_matrix_mult(somme(A11, A12), B22)
        s3 = strassen_matrix_mult(somme(A21, A22), B11)
        s4 = strassen_matrix_mult(A22, differance(B21, B11))
        s5 = strassen_matrix_mult(somme(A11, A22), somme(B11, B22))
        s6 = strassen_matrix_mult(differance(A12, A22), somme(B21, B22))
        s7 = strassen_matrix_mult(differance(A11, A21), somme(B11, B12))

        C11 = somme(differance(somme(s5, s4), s2), s6)
        C12 = somme(s1, s2)
        C21 = somme(s3, s4)
        C22 = differance(differance(somme(s1, s5), s3), s7)

        C = []
        for i in range(len(C12)):
            C.append(C11[i] + C12[i])
        for i in range(len(C22)):
            C.append(C21[i] + C22[i])

    return C
############################      temps d'execution ################


def temps_execution(A, B, function):
    start = time.time()
    #  print(function(A,B))
    function(A, B)
    end = time.time()
    temps = end - start
    print("le temps d'execution  pour la matrice de taille ",
          {len(A)}, "=>", temps)
    return temps
#######################   gen_matrix ################


def gen_matrix(n):
    matrice = []
    for i in range(n):
        matrice.append([random.randrange(0, 9) for i in range(n)])
    return matrice

###################### " Numpy #############


def nump(A, B):
    return np.dot(A, B)


####################  Essayer ##################
array1 = [2, 4, 8, 16, 32, 64, 128, 256, 512]
array2 = array1
A = []
for i in range(len(array1)):
    A.append(gen_matrix(array1[i]))
B = []
for i in range(len(array2)):
    B.append(gen_matrix(array2[i]))
######################## temps d'execution  de classic_matrix_mult #################
print("classic_matrix_mult")
temps_execution1 = []
for i in range(len(array1)):
    temps_execution1.append(temps_execution(A[i], B[i], classic_matrix_mult))
######################## temps d'execution  de strassen_matrix_mult #################
print("strassen_matrix_mult")
temps_execution2 = []
for i in range(len(array1)):
    temps_execution2.append(temps_execution(A[i], B[i], strassen_matrix_mult))

######################## temps d'execution  avec np.dot(A,B) ##################
print("Numpy")
temps_execution3 = []
for i in range(len(array1)):
    temps_execution3.append(temps_execution(A[i], B[i], nump))

# Graphe   "##########################"
plt.title(" Naive vs Strassen Matrix Multiplication")
plt.xlabel('DIMENSION : N X N')
plt.ylabel('Time execution in Seconds')
plt.plot(array1, temps_execution1, label='Naive')
plt.plot(array1, temps_execution2, label='Strassen')
plt.plot(array1, temps_execution3, label='Numpy')
plt.legend()
plt.show()
