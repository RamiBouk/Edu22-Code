import time
def recursive2(x,n):
    if n==0 :
        return 1
    z=recursive2(x,n//2)
    if n % 2 ==0:
        return z*z
    return z*z*x
test =[ 100, 1000, 10000, 100000,1000000,10000000]
for n in test:
    start = time.time()
    print("testing: "+str(n));
    result=recursive2(100,n)
    end = time.time()
    temps_execution = end - start
    print(temps_execution)
