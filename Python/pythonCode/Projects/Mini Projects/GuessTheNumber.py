import random

number = random.randint(1, 100)
alphabet = "abcdefghijklmnopqrstuvwxyz"
print("I'm thinking of a number")

while True:
    guessStringForm = input("What is your guess? : ")
    try:
        guessIntForm = int(guessStringForm)
        if guessIntForm > 100 or guessIntForm < 0:
            print("The number is bigger than zero and smaller than one hundred!")
        elif guessIntForm == number:
            print("Well done! The number was " + str(number))
            break
        elif guessIntForm > number:
            print("No, " + guessStringForm + " is too big")
        elif guessIntForm < number:
            print("No, " + guessStringForm + " is too small")
    except ValueError:
        print("You need to enter a number")
