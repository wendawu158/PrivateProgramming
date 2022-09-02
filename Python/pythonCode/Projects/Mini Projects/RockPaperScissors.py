import random

print("Welcome to rock, paper, scissors!\n"
      "Enter 1 for rock\n"
      "Enter 2 for paper\n"
      "Enter 3 for scissors")

while True:
    try:
        userMove = int(input("Enter 1, 2, or 3 : "))
        computerMove = random.randint(1, 3)
        if userMove == 1:
            if computerMove == 1:
                print("You play rock, computer plays rock, you draw!")
            elif computerMove == 2:
                print("You play rock, computer plays paper, you lose!")
            elif computerMove == 3:
                print("You play rock, computer plays scissors, you win!")
        elif userMove == 2:
            if computerMove == 1:
                print("You play paper, computer plays rock, you win!")
            elif computerMove == 2:
                print("You play paper, computer plays paper, you draw!")
            elif computerMove == 3:
                print("You play paper, computer plays scissors, you lose!")
        elif userMove == 3:
            if computerMove == 1:
                print("You play scissors, computer plays rock, you lose!")
            elif computerMove == 2:
                print("You play scissors, computer plays paper, you win!")
            elif computerMove == 3:
                print("You play scissors, computer plays scissors, you draw!")
    except TypeError:
        print("Please enter a number")