import sys


def max_path(current):
    if current == n:
        return 0
    else:
        global visited
        b = 18 * visited + current
        if b not in dp:
            longest_path = const
            for node in graph[current]:
                if not ((visited >> current) & 1):
                    a = visited
                    visited ^= powers[current]
                    temp = graph[current][node] + max_path(node)
                    visited = a
                    if temp > longest_path:
                        longest_path = temp
            dp[b] = longest_path
        return dp[b]

all_data = [m.split() for m in sys.stdin.read().split('\n')]
n, m = [int(i) - 1 for i in all_data[0]]
graph = [{} for i in range(n)]
for i in range(m + 1):
    data = [int(i) for i in all_data[i + 1]]
    if data[0] < n:
        graph[data[0]][data[1]] = data[2]

powers = [1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536]

const = -float("inf")
visited = 0
dp = {}
print(max_path(0))
