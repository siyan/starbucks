import sys


def bisect_h(x):
    lo, hi = 0, n_buildings
    while lo < hi:
        mid = (lo + hi) // 2
        if x < horizontal[mid]:
            hi = mid
        else:
            lo = mid + 1
    return lo


def bisect_v(x):
    x = x[1], x[0]
    lo, hi = 0, n_buildings
    while lo < hi:
        mid = (lo + hi) // 2
        if x < vertical[mid]:
            hi = mid
        else:
            lo = mid + 1
    return lo


input = sys.stdin.readline
n_buildings = int(input())
buildings = {tuple(int(i) for i in input().split()) for j in range(n_buildings)}

n_turnings = int(input())
turnings = [tuple(int(i) for i in input().split()) for j in range(n_turnings)]
horizontal = sorted(buildings)
vertical = sorted((i[1], i[0]) for i in buildings)
result = 0
dp_h = {}
dp_v = {}
for i in range(n_turnings - 1):
    if turnings[i][0] == turnings[i + 1][0]:
        if turnings[i] not in dp_h:
            dp_h[turnings[i]] = bisect_h(turnings[i])
        if turnings[i + 1] not in dp_h:
            dp_h[turnings[i + 1]] = bisect_h(turnings[i + 1])
        if turnings[i][1] > turnings[i + 1][1]:
            result += dp_h[turnings[i]] - dp_h[turnings[i + 1]] + (turnings[i + 1] in buildings)
        else:
            result += dp_h[turnings[i + 1]] - dp_h[turnings[i]] + (turnings[i] in buildings)
    else:
        if turnings[i] not in dp_v:
            dp_v[turnings[i]] = bisect_v(turnings[i])
        if turnings[i + 1] not in dp_v:
            dp_v[turnings[i + 1]] = bisect_v(turnings[i + 1])

        if turnings[i][0] > turnings[i + 1][0]:
            result += dp_v[turnings[i]] - dp_v[turnings[i + 1]] + (turnings[i + 1] in buildings)
        else:
            result += dp_v[turnings[i + 1]] - dp_v[turnings[i]] + (turnings[i] in buildings)

print(result)