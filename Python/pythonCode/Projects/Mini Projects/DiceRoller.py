import random

while True:
    rollDice = input("Do you want to roll the dice? : ")
    if rollDice == "Yes":
        dice = random.randint(1, 6)
        print("The dice says " + dice)
    elif rollDice == "No":
        break
    else:
        print("Please enter \"Yes\" or \"No\"")