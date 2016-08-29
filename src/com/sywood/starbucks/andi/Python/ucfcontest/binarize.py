for i in range(int(input())):
    a = str(bin(int(input())))
    print(2 ** (len(a) - (3 if a.count("0") == len(a) - 2 else 2)))