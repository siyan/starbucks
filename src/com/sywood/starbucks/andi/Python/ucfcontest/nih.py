def brute_force(values, money):
    return max([values[i][j][1] + brute_force(values[:i] + values[i + 1:], money - values[i][j][0]) for i in range(len(values)) for j in range(4) if values[i][j][0] <= money] + [0])

for x in range(int(input())):
    n, money = [int(i) for i in input().split()]
    values = []
    for i in range(n):
        data = [int(i) for i in input().split()]
        values.append([[data[j * 2], data[j * 2 + 1]] for j in range(4)])
    print("Budget #" + str(x + 1) + ": Maximum number of " + str(brute_force(values, money)) + " lives saved.")
