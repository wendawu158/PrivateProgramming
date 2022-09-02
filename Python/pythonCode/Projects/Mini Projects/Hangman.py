from random_word import RandomWords

print("This game is called Hangman. At the beginning the computer picks a random english word and"
      + " each turn you guess one letter. You can guess wrongly 9 times before"
      + " the man is hung. Good luck!")
while True:
    playAgain = ""

    length = 0
    guesses = 0
    guessPosition = 0

    words = RandomWords()
    word = words.random_word()
    wordChar = []
    guessedLetters = []
    lettersGuessed = []

    for char in word:
        length += 1
        wordChar.append(char)
        guessedLetters.append(" ")

    print("Let's start! The word I'm thinking of has " + str(length) + " letters.")
    print(word)
    while True:
        guess = input("What is your guess? : ")
        if len(guess) == 1:
            if guess not in lettersGuessed:
                if guess in wordChar:
                    lettersGuessed.append(guess)
                    for letter in wordChar:
                        if letter == guess:
                            guessPosition = wordChar.index(letter)
                            guessedLetters[guessPosition] = letter
                            wordChar.pop(guessPosition)
                    if " " not in guessedLetters:
                        print("Well done! You've guessed all the letters! The word was " + word)
                        break
                    else:
                        print("Well done! The letter \"" + str(guess) + "\" was in the word")
                        print("You've guessed " + (', '.join(guessedLetters)))
                else:
                    lettersGuessed.append(guess)
                    guesses += 1
                    print("Sorry! That letter is not in the word!")
                    print("You have " + str(9 - guesses) + " guesses left!")
                    if guesses == 9:
                        print("The word was " + word)
                        break
            else:
                print("You've already guessed that!")
        else:
            print("Your guess can only be one letter long!")
    while playAgain != "yes" and playAgain != "no":
        playAgain = input("Do you want to play again? : ")
    if playAgain == "yes":
        print("Great!")
    elif playAgain == "no":
        print("Bye then!")
        break
