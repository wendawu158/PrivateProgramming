import random

# Define variables for the program
numberOfItems = 0
bill = 0.0
randomNumber = 0
item = ""

# Requests for the number of items from the user
print("How many items do you want?")
numberOfItems = int(input())

# Exits the loop when the number of items entered is equal to numberOfItems
for i in range(numberOfItems):
    # Resets item for a new item to be entered
    item = ""

    # Requests for an item from the user
    while item not in ("c", "t", "b"):
        print("Enter a valid item: c - coffee, t - tea, b - biscuit")
        item = str(input())

        # Prints an error message
        if item not in ("c", "t", "b"):
            print("Invalid input")

    # Determines what the price of the item entered would be
    if item == "c":
        bill += 2.25
    elif item == "t":
        bill += 1.85
    else:
        bill += 3.05

# Generates a random number between 1 and 10 inclusive
randomNumber = random.randint(1, 10)

# Changes the bill depending on the random number
if randomNumber == 1:
    bill = 0

if randomNumber <= 6:
    bill /= 2

# Rounds the bill to 2 decimal places
bill = round(bill, 2)

# Displays the random number and the bill
print(f"Your random number was {randomNumber}")
print(f"Your bill is {bill}")
