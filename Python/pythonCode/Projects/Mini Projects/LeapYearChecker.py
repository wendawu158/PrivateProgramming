print("This is the leap year checker! Please, enter a year to check whether it is a leap year or not")

while True:
    try:
        year = int(input("Enter a year number : "))
        if year % 400 == 0 or (year % 100 != 0 and year % 4 == 0):
            print(year, "is a leap year")
        else:
            print(year, "is not a leap year")
    except ValueError:
        print("Please enter a number")
