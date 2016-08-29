for i in range(int(input())):
    n = int(input())
    total = int(n * 1.2) + 1
    while total != int("".join(list(reversed([i for i in str(total)])))):
        total += 1
    print("Input cost: " + str(n))
    print(total - n, total)

