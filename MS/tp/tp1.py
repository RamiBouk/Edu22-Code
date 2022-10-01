from random import random
import math
def main():
    n=11
    i=0
    x=1
    while(i<n):
        rand=random()
        print(x)
        if x==1:
            if rand<1/3:
                y=2
            else:
                y=3

        if x==2:
            if rand<1/3:
                y=3
            else:
                y=2
        if x==3:
            if rand<1/2:
                y=1
            else:
                y=4
        if x==4:
            y==3
        x=y
        i+=1
if __name__ == "__main__":
    main()
