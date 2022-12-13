numOne = 10

numTwo = int(input("Enter a second number : "))
while numTwo <= numOne:
    print(f"Number two too low, please enter a number bigger than {numOne}")
    numTwo = int(input("Enter a second number : "))
