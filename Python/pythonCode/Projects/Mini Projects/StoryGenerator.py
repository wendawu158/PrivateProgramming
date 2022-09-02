print("Hello there! Welcome to the story generator,\n"
      "Where you can switch out certain words in order to change\n"
      "The meaning of the story in small ways!\n"
      "The type of word you should enter will change depending on the prompt\n")

'''
You stand in awe as you look up at the -castle-.
This is it, this is what all of your training was for. You need to go in there and defeat him, -the embodiment of Wrath-
You feel -the blood pumping through your veins-.
This is it. You enter and immediately see him. Standing there and -leering- at you.
Your battle is legendary, but alas, -he is far stronger than you-.
Despite that, you fight back and -manage to defeat him. Your sword drops to the ground and you collapse.
Legends will be written about you. But you won't be there to hear them-
'''

print("You stand in awe as you look up at the...")
first_input = input("Enter a tall, man made structure : ")
print("..." + first_input + ". This is it, this is what all of your training was for."
                            " You need to go in there and defeat him, ...")
second_input = input("Enter an enemy for you to fight : ")
print("..." + second_input + ". You feel...")
third_input = input("Enter a feeling that you would feel right now : ")
print("..." + third_input + ". This is it. You enter and immediately see him. Standing there and...")
fourth_input = input("Enter what that enemy would do upon seeing you : ")
print("..." + fourth_input + " at you. Your battle is legendary, but alas, ...")
fifth_input = input("Enter a plot twist : ")
print("..." + fifth_input + ". Despite that, you...")
sixth_input = input("Enter an ending for the story : ")
print("..." + sixth_input)
print("\n\nThis is your story!\n\n")
print("You stand in awe as you look up at the " + first_input + ".\n"
      "This is it, this is what all of your training was for. You need to go in there and defeat him, " + second_input
      + "\n"
      "You feel " + third_input + ".\n"
      "This is it. You enter and immediately see him. Standing there and " + fourth_input + " at you.\n"
      "Your battle is legendary, but alas, " + fifth_input + ".\n"
      "Despite that, you fight back and " + sixth_input)
