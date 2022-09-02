import random

numbers = ("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
lower_letters = ("a", "b", "c", "d", "e", "f",
                 "g", "h", "i", "j", "k", "l",
                 "m", "n", "o", "p", "q", "r",
                 "s", "t", "u", "v", "w", "x",
                 "y", "z")
upper_letters = ("A", "B", "C", "D", "E", "F",
                 "G", "H", "I", "J", "K", "L",
                 "M", "N", "O", "P", "Q", "R",
                 "S", "T", "U", "V", "W", "X",
                 "Y", "Z")
special_symbols = (" ", "!", "\"", "#", "$", "%",
                   "&", "\'", "(", ")", "*", "+",
                   ",", "-", ".", r"/", ":", ";",
                   "<", "=", ">", "?", "@", "\\",
                   "[", "]", "^", "_", "`", "{",
                   "|", "}", "~")

selected_characters = []

numbersTF = input("Would you like for numbers to be in your password? Y/N : ")
lowerTF = input("Would you like for lowercase letters to be in your password? Y/N : ")
upperTF = input("Would you like for uppercase letters to be in your password? Y/N : ")
specialTF = input("Would you like for special characters to be in your password? Y/N : ")

YNtranslator = {
    "Y": True,
    "N": False
}

try:
    if YNtranslator[numbersTF]:
        for x in numbers:
            selected_characters.append(x)

    if YNtranslator[lowerTF]:
        for x in lower_letters:
            selected_characters.append(x)

    if YNtranslator[upperTF]:
        for x in upper_letters:
            selected_characters.append(x)

    if YNtranslator[specialTF]:
        for x in special_symbols:
            selected_characters.append(x)
except:
    print("Please only enter Y or N")
    quit()

try:
    password_length = int(input("Enter the desired length of your password : "))
except:
    print("Please enter a number")
    quit()

password = ""

for x in range(password_length):
    password += random.choice(selected_characters)

print("Your password is :")
print(password)
