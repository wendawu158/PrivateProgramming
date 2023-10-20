for i in range(0, 1000):
    for j in range(0, 1000):
        if i * j > 1000:
            break
        elif 12 * i + 10 * j + 1 == i * j:
            print(f"{i}, {j}")