slang = {}
for i in range(int(input())):
    data = input().split()
    slang[data[0]] = " ".join(data[1:])
for i in range(int(input())):
    print(" ".join([i if i not in slang else slang[i] for i in input().split()]))