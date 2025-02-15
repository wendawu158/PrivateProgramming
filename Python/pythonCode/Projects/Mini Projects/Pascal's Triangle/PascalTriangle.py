def computePascalsTriangle(rows):
    initialValue = [1]

    triangle = [initialValue]

    for i in range(rows):
        triangle[i].insert(0, 0)
        triangle[i].append(0)

        row = []
        for j in range(len(triangle[i]) - 1):
            row.append(triangle[i][j] + triangle[i][j + 1])

        triangle[i].remove(0)
        triangle[i].remove(0)

        triangle.append(row)

        '''for j in triangle[i]:
            print(j, end=" ")

        print()'''

    return triangle
