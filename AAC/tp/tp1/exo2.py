import random
import time

def triFusion(L):
    if len(L) == 1:
        return L
    else:
        return fusion( triFusion(L[:len(L)//2]) , triFusion(L[len(L)//2:]) )



def triFusion1(L):
    if len(L) == 1:
        return L
    else:
        return fusion1( triFusion1(L[:len(L)//2]) , triFusion1(L[len(L)//2:]) )


def fusion(l1,l2):
    n1=len(l1)
    n2=len(l2)
    i=0
    j=0
    f=[]
    for k in range(n1+n2):
        if ((i<n1) and ((j>=n2) or (l1[i]<l2[j]))):
            f.append(l1[i])
            i=i+1
        else:
            f.append(l2[j])
            j=j+1            
    #print(f)
    return f




def fusion1(A,B):
    #print(A,B)
    if len(A) == 0:
        return B
    elif len(B) == 0:
        return A
    elif A[0] <= B[0]:
        return [A[0]] + fusion1( A[1:] , B )
    else:
        return [B[0]] + fusion1( A , B[1:] )



def triBulles(L):
    for i in range(len(L),0,-1):
        for j in range(0,i-1):
            #print(L) 
            if L[j+1] < L[j]:
                L[j+1] , L[j] = L[j] , L[j+1]
    return L

#L=[27,10,12,20,25,13,15,22]
#L = [2,55,12,10,23,87,11,74,36,42,58]
#print(triFusion(L))
#print(triBulles(L))

L = [random.randrange(0,1000) for i in range(3900)]

print("triFusion")

start = time.time()
print(triFusion(L))
#print(triBulles(L))
end = time.time()
temps_execution = end - start
print(temps_execution)
""""
print("triFusion1")

start = time.time()
print(triFusion1(L))
#print(triBulles(L))
end = time.time()
temps_execution = end - start
print(temps_execution)

"""
print("triBulles")

start = time.time()
#print(triFusion1(L))
print(triBulles(L))
end = time.time()
temps_execution = end - start
print(temps_execution)
