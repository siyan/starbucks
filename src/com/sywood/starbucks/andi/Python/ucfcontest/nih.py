def brute_force(values, money):
    best = 0
    for i in range(len(values)):
        for j in values[i]:
            if j <= money:
                best = max(values[i][j] + brute_force(values[:i] + values[i + 1:], money - j), best)
    return best

for x in range(int(input())):
    n, money = [int(i) for i in input().split()]
    values = []
    for i in range(n):
        data = [int(i) for i in input().split()]
        values.append({})
        for j in range(4):
            values[-1][data[j * 2]] = data[j * 2 + 1]
    print("Budget #" + str(x + 1) + ": Maximum number of " + str(brute_force(values, money)) + " lives saved.")
