userEmailString = input("What is your email? : ")

userEmailList = userEmailString.split("@")

userEmailUsername = userEmailList[0]
userEmailDomain = userEmailList[1]

print("Your username is: " + userEmailUsername +
    "\nYour domain is: " + userEmailDomain)