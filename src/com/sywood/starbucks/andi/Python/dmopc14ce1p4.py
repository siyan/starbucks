import sys


def dijkstra():
    time = [float("inf") for i in range(v)]
    intersections = [float("inf") for i in range(v)]
    time[0] = 0
    intersections[0] = 0
    queue = {i for i in range(v)}
    while len(queue) > 0:
        best = (min([value for key, value in enumerate(time) if key in queue]))
        for i in queue:
            if time[i] == best:
                current = i
                queue.remove(current)
                break

        for neighbour in graph[current]:
            temp = time[current] + graph[current][neighbour]
            if temp < time[neighbour]:
                time[neighbour] = temp
                intersections[neighbour] = intersections[current] + 1
            if temp == time[neighbour]:
                if intersections[current] + 1 < intersections[neighbour]:
                    intersections[neighbour] = intersections[current] + 1
    return str(intersections[-1]) + "\n" + str(round(time[-1]))


all_data = sys.stdin.read().split("\n")
v, e = int(all_data[0]), int(all_data[1])
graph = [{} for i in range(v)]
for i in range(e):
    a, b, dist, speed = [int(i) for i in all_data[i + 2].split()]
    time = dist / speed * 20
    if b - 1 not in graph[a - 1] or time < graph[a - 1][b - 1]:
        graph[a - 1][b - 1] = time
        graph[b - 1][a - 1] = time
print(dijkstra())
