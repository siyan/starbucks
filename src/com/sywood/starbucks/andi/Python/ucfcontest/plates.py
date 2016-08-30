def update(poles, i):
    temp = list(poles)
    for j in range(n):
        temp[j] -= 2.5
    temp[i] = speed
    return tuple(temp)

def possible(poles):
    if any([i <= 0 for i in poles]):
        return False
    if poles in memo:
        return True
    else:
        memo.add(poles)
        return any(possible(update(poles, i)) for i in range(n))

for i in range(int(input())):
    n, speed = [int(i) for i in input().split()]
    poles = tuple([speed for i in range(n)])
    memo = set() # not dp, just a record to see if chester ever comes back to a certain state
    print("Circus Act " + str(i + 1) + ":")
    print("Chester can do it!" if possible(poles) else "Chester will fail!")