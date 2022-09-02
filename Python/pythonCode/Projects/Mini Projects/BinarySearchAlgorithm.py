import random

searchList = []
inputIsInteger = False
inputInteger = ""

for x in range(32):
    while True:
        newNumber = random.randint(1, 100)
        if newNumber not in searchList:
            searchList.append(newNumber)
            break

searchList.sort()

while not inputIsInteger:
    try:
        inputInteger = int(input("Please enter a number to check whether it is in the list: "))
        inputIsInteger = True
    except ValueError:
        print("Please enter a numerical value")

while True:
    searchListHalfPoint = round(len(searchList) / 2)
    searchListHalf = searchList[searchListHalfPoint]
    if inputInteger == searchListHalf:
        print("Your number, " + str(inputInteger) + " is in the list")
        break
    if len(searchList) == 1:
        print("Your number, " + str(inputInteger) + " is not in the list")
        break
    elif inputInteger > searchListHalf:
        searchList = searchList[searchListHalfPoint:]
    elif inputInteger < searchListHalf:
        searchList = searchList[: searchListHalfPoint]
