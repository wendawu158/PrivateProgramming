userInput = ""
while True:
    while not (userInput == "A" or userInput == "B" or userInput == "C"):
        print("\n")
        userInput = input("Would you like to :\n"
                          "A - Read all contacts\n"
                          "B - Add a contact\n"
                          "C - Delete a contact BUGGED\n"
                          "Please enter A, B, or C : ")
        print("\n")
    if userInput == "A":
        print("Name - Label - Numbers - Emails")
        with open("ContactBook.txt", "r") as r:
            for line in sorted(r):
                print(line, end="")
        userInput = ""
    elif userInput == "B":
        contacts_file_add = open("ContactBook.txt", "a")
        newContactName = input("What is the full name of the contact? : ")
        newContactLabelPossibility = input("Would you like to add a label? Y/N : ")
        newContactLabel = ""
        if newContactLabelPossibility != "N":
            newContactLabel = input("What would you like for the contact's label to be? : ")
        while True:
            newContactNumbers = []
            newContactNumber = input("What is the phone number of the contact? : ")
            newContactNumber = str(newContactNumber)
            newContactNumbers.append(newContactNumber)
            newContactNumberPossibility = input("Would you like to add another phone number? Y/N : ")
            if newContactNumberPossibility == "N":
                break
        while True:
            newContactEmails = []
            newContactEmail = input("What is the email of the contact? : ")
            newContactEmails.append(newContactEmail)
            newContactEmailPossibility = input("Would you like to add another email? Y/N : ")
            if newContactEmailPossibility == "N":
                break
        newContact = (newContactName + " - " + newContactLabel + " - " +
                      ', '.join(newContactNumbers) + " - " + ', '.join(newContactEmails))
        contacts_file_add.write(newContact)
        userInput = ""
        contacts_file_add.close()
    elif userInput == "C":
        newContactFile = []
        with open("ContactBook.txt", "r") as r:
            for line in sorted(r):
                print(line, end="")
        contacts_file_delete = open("ContactBook.txt", "r")
        for contact in contacts_file_delete:
            newContactFile.append(contact)
        print("\n")
        deleteContact = input("Please copy and paste the contact you wish to delete here : ")
        contacts_file_delete.close()
        new_contacts_file = open("ContactBook.txt", "w")
        new_contacts_file.seek(0)
        new_contacts_file.truncate()
        for deleteContact in newContactFile:
            newContactFile.remove(deleteContact)
        for contact in newContactFile:
            new_contacts_file.write(contact)
        userInput = ""
        new_contacts_file.close()