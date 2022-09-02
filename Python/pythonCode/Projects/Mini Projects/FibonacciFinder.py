print("Welcome to the Fibonacci Finder! Enter a number to check whether it's in the Fibonacci sequence or not")

while True:

    try:
        number = int(input("Enter a number to check : "))

        a = 0
        b = 1

        while True:

            c = a + b
            a = int(b)
            b = int(c)

            if number == a:
                print(number, "is in the Fibonacci sequence")
                break
            elif number < a:
                print(number, "is not in the Fibonacci sequence")
                break

    except ValueError:
        print("Please enter a number")
