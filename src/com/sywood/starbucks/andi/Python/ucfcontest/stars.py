def analyze(node, prev=None):
    if visited[node]:
        return 0, True
    else:
        length = 1
        cycle = False
        visited[node] = True
        for i in graph[node]:
            if i != prev:
                a, b = analyze(i, node)
                length += a
                cycle |= b
        return length, cycle

for i in range(int(input())):
    v, e = [int(i) for i in input().split()]
    graph = [set() for i in range(v)]
    for j in range(e):
        a, b = [int(i) for i in input().split()]
        graph[a - 1].add(b - 1)
        graph[b - 1].add(a - 1)
    visited = [False for i in range(v)]
    constellations = 0
    cycles = 0
    for j in range(v):
        if not visited[j]:
            length, b = analyze(j)
            constellations += (1 if length > 1 else 0)
            cycles += int(b)
    print("Night sky #" + str(i + 1) + ": " + str(constellations) + " constellations, of which " + str(cycles) + " need to be fixed.")
