# 
#  120 ms
#  greedy를 이용해 1의자릿수 부터 소수 판별 후
#  소수이면 자릿수 올려서 다시 소수판별
#  n자릿수까지 반복 (n 번)
import math


def is_prime(n):
    if n in [0, 1]:
        return False
    if n in [2, 3]:
        return True
    #소수는 2,3 제외 6의 배수의 +- 1
    if not ((n + 1 % 6 != 0) or (n - 1 % 6 != 0)):
        return False

    for i in range(2, math.floor(math.sqrt(n)) + 1):
        if n % i == 0:
            return False

    return True


N = int(input())

amazings = [0]
for _ in range(N):
    new_amazings = []
    for amazing in amazings:
        for i in range(10):
            n = amazing * 10 + i
            new_amazings.append(n) if is_prime(n) else None

    amazings = new_amazings


print(*amazings, sep='\n')
