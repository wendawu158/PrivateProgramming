import random

alive = True
north_south = 0
east_west = 0
easy_monster = True
monster_hp = 0
player_hp = 60
easy_monster_names = ("Goblin", "Orc", "Golem")
trader_items = ("healing potion", "bread")
trader_wares = []
reward_names = ("healing potion", "axe", "sword", "bread", "dozen coins")
attack = 0
new_attack = 0
attack_difference = 0
coins = 20
inventory = ["healing potion"]
min_attack = 0
max_attack = 5
trader = False
quest = False
quest_types = ("Kill", "Travel")
quests = []

print("If you don't know what to do then respond with check actions, do not use capital letters")

while alive:
    coords = [north_south, east_west]
    quest = not bool(random.randint(0, 49))
    trader = not bool(random.randint(0, 14))
    monster = not bool(random.randint(0, 9))
    monster_name = random.choice(easy_monster_names)
    monster_hp = random.randint(10, 20)
    while monster:
        if easy_monster:
            monster_action = input("You see a " + monster_name + "! What do you want to do? : ")
            if monster_action == "attack":
                max_attack = attack + 5
                monster_damaged = random.randint(min_attack, max_attack)
                monster_hp = monster_hp - monster_damaged
                if monster_hp <= 0:
                    monster_hp = 0
                print("You damage the " + monster_name + " by " + str(monster_damaged) + "! The " + monster_name +
                      " has " + str(monster_hp) + " hp left!")
                player_damaged = random.randint(0, 3)
                player_hp = player_hp - player_damaged
                print("You are damaged by " + str(player_damaged) + "! You have " + str(player_hp) + " hp left!")
                if player_hp == 0:
                    alive = False
                    break
                if monster_hp == 0:
                    print("You kill the " + monster_name + " !")
                    reward = bool(random.randint(0, 4))
                    if reward:
                        reward_name = random.choice(reward_names)
                        print("You find a " + reward_name + " on the " + monster_name + "!")
                        if reward_name == "axe" or reward_name == "sword":
                            new_attack = random.randint(1, 10)
                            equip = input("Do you want to equip this " + reward_name + " ? It has a +" + str(new_attack)
                                          + " in attack yes/no : ")
                            if equip == "yes":
                                attack_difference = new_attack - attack
                                print("You equip the " + reward_name + "! You gain "
                                      + str(attack_difference) + " in attack!")
                                attack = new_attack
                        elif reward_name == "dozen coins":
                            print("You put the dozen coins in your coin pouch")
                            coins += 12
                        else:
                            print("You put the " + reward_name + " in your inventory")
                            inventory.append(reward_name)
                    for quest_complete_a in quests:
                        if quest_complete_a[0] == "Kill":
                            if quest_complete_a[2] == monster_name:
                                quest_complete_a[1] -= 1
                    monster = False
            elif monster_action == "run":
                player_damaged = random.randint(0, 3)
                player_hp = player_hp - player_damaged
                print("You are damaged by " + str(player_damaged) + "! You have " +
                      str(player_hp) + " hp left and you run away!")
                monster = False
                north_south = north_south + random.randint(-1, 1)
                east_west = east_west + random.randint(-1, 1)
                if north_south >= 15:
                    north_south = 15
                if north_south <= -15:
                    north_south = -15
                if east_west >= 15:
                    east_west = 15
                if east_west <= -15:
                    east_west = -15
            elif monster_action == "check inventory":
                if inventory:
                    itemsRemain = True
                    items_a = inventory
                    while itemsRemain:
                        items_b = items_a[0]
                        print("You have " + str(items_a.count(items_b)) + " " + items_b)
                        if items_a[0] == items_a[-1]:
                            itemsRemain = False
                        items_a = list(filter(items_b.__ne__, items_a))
                    if items_a:
                        items_b = items_a[0]
                        print("You have " + str(items_a.count(items_b)) + " " + items_b)
            elif monster_action == "consume item":
                consume = input("What do you want to consume? : ")
                if consume in inventory:
                    if consume == "healing potion":
                        print("You drink the potion and you feel loads better, hp +15")
                        player_hp += 15
                        inventory.remove("healing potion")
                    elif consume == "bread":
                        print("You eat the bread and sate your hunger, hp +10")
                        player_hp += 10
                        inventory.remove("bread")
                    else:
                        print("That item does not exist")
                else:
                    print("You don't have that item and/or That item does not exist")
            elif monster_action == "check actions":
                print("attack - you attack the monster and you both take damage")
                print("run - you run away but you still take some damage")
                print("check inventory - you find out what items you have")
                print("consume item - you consume an item from your inventory")
            else:
                print("I'm not familiar with that action")
    if player_hp == 0:
        break
    for quest_remove_a in quests:
        if quest_remove_a[0] == "Travel":
            if quest_remove_a[2] == coords:
                quest_remove_b = quests.index(quest_remove_a)
                quests.pop(quest_remove_b)
                coins += quest_remove_a[3]
                print("You've completed a quest! Your reward is " + quest_remove_a[3] + " coins!")
        elif quest_remove_a[0] == "Kill":
            if quest_remove_a[1] == 0:
                quest_remove_b = quests.index(quest_remove_a)
                quests.pop(quest_remove_b)
                coins += quest_remove_a[3]
                print("You've completed a quest! Your reward is " + quest_remove_a[3] + " coins!")
    if trader:
        trader_slot_1 = random.choice(trader_items)
        trader_slot_1_cost = random.randint(10, 30)
        trader_slot_2 = random.choice(trader_items)
        trader_slot_2_cost = random.randint(10, 30)
        trader_slot_3 = random.choice(trader_items)
        trader_slot_3_cost = random.randint(10, 20)
        while trader:
            trader_action = input("You see a trader! Would you like to browse their wares? yes/no : ")
            if trader_action == "yes":
                while trader_action == "yes":
                    print("The trader has")
                    if trader_slot_1 != "sold":
                        print(trader_slot_1.title() + " for " + str(trader_slot_1_cost) + " coins")
                    else:
                        print("Sold his first item")
                    if trader_slot_2 != "sold":
                        print(trader_slot_2.title() + " for " + str(trader_slot_2_cost) + " coins")
                    else:
                        print("Sold his second item")
                    if trader_slot_3 != "sold":
                        print(trader_slot_3.title() + " for " + str(trader_slot_3_cost) + " coins")
                    else:
                        print("Sold his third item")
                    trader_purchase = input("Would you like to buy an item ? yes/no : ")
                    if trader_purchase == "yes":
                        trader_purchase_number = input("The trader seems happy at your decision, which item of 1, 2, or"
                                                       + " 3 would you like to buy? : ")
                        if trader_purchase_number == "1" and coins >= trader_slot_1_cost and trader_slot_1 != "sold":
                            print("You buy " + trader_slot_1 + " from the trader for " + str(trader_slot_1_cost) +
                                  " coins")
                            inventory.append(trader_slot_1)
                            coins -= trader_slot_1_cost
                            trader_slot_1 = "sold"
                        elif trader_purchase_number == "2" and coins >= trader_slot_2_cost and trader_slot_2 != "sold":
                            print("You buy " + trader_slot_2 + " from the trader for " + str(trader_slot_2_cost) +
                                  " coins")
                            inventory.append(trader_slot_2)
                            coins -= trader_slot_2_cost
                            trader_slot_2 = "sold"
                        elif trader_purchase_number == "3" and coins >= trader_slot_3_cost and trader_slot_3 != "sold":
                            print("You buy " + trader_slot_3 + " from the trader for " + str(trader_slot_3_cost) +
                                  " coins")
                            inventory.append(trader_slot_3)
                            coins -= trader_slot_3_cost
                            trader_slot_3 = "sold"
                        elif coins < trader_slot_1_cost or coins < trader_slot_2_cost or coins < trader_slot_3_cost:
                            print("The trader shakes his head, it seems you don't have enough coins for that item")
                        elif trader_slot_1 == "sold" or trader_slot_2 == "sold" or trader_slot_3 == "sold":
                            print("The trader has already sold that item to you!")
                        else:
                            print("The trader only has 3 items!/I don't understand")
                    if trader_purchase == "no":
                        trader_action = "no"
                        trader = False
                    if trader_slot_1 == "sold" and trader_slot_2 == "sold" and trader_slot_3 == "sold":
                        print("The trader has sold you all of his wares")
                        trader_purchase = "no"
                        trader_action = "no"
                        trader = False
                    if trader_purchase == "yes":
                        trader_action = input("Would you like to buy anything else? yes/no : ")
            if trader_action == "no":
                print("The trader leaves you on his merry way")
                trader = False
            else:
                print("I'm not familiar with that action")
    if quest:
        while 1 == 1:
            quest_accept = input("Adventurer! I need your aid! Will you help me? : ")
            if quest_accept == "yes":
                quest_accept = True
                break
            elif quest_accept == "no":
                quest_accept = False
                break
            else:
                print("I'm sorry adventurer, I'm not quite sure what you mean?")
        if quest_accept:
            quest_type = random.choice(quest_types)
            if quest_type == "Kill":
                quest_amount = random.randint(1, 5)
                quest_target = random.choice(easy_monster_names)
                quest_reward = random.randint(20, 50)
                print("Excellent! I need you to kill " + str(quest_amount) + " " + quest_target + "s. Good luck adventurer!")
                quests.append([quest_type, quest_amount, quest_target])
            if quest_type == "Travel":
                quest_amount = 1
                quest_target = [random.randint(-15, 15), random.randint(-15, 15)]
                quest_reward = random.randint(5, 20)
                print("Excellent! I need you to travel to " + str(quest_target[0]) + ", " + str(quest_target[1]) +
                      ". Good luck adventurer!")
                quests.append([quest_type, quest_amount, quest_target])
    action = input("What do you want to do? : ")
    if action == "travel":
        travel_direction = input("Travel where? : ")
        if travel_direction == "north" and north_south <= 15:
            print("You travel north")
            north_south += 1
        elif travel_direction == "south" and north_south >= -15:
            print("You travel south")
            north_south -= 1
        elif travel_direction == "east" and east_west <= 15:
            print("You travel east")
            east_west += 1
        elif travel_direction == "west" and east_west >= -15:
            print("You travel west")
            east_west -= 1
        elif north_south == 15 or north_south == -15 or east_west == 15 or east_west == -15:
            print("You can't travel in that direction anymore!")
        else:
            print("I'm not familiar with that compass direction")
    elif action == "locate self":
        print("You are at " + str(north_south) + ", " + str(east_west))
    elif action == "check actions":
        print("travel - you move in one direction (north, south, east, west) by one square."
              " The world is a 15 by 15 square")
        print("locate self - you find out what your coordinates are")
        print("check inventory - you find out what items you have")
        print("check coin pouch - you find out how many coins you have")
        print("consume items - you consume an item from your inventory")
        print("check quests - you check what quests you have")
    elif action == "check inventory":
        if inventory:
            itemsRemain = True
            items_a = inventory
            while itemsRemain:
                items_b = items_a[0]
                print("You have " + str(items_a.count(items_b)) + " " + items_b)
                if items_a[0] == items_a[-1]:
                    itemsRemain = False
                items_a = list(filter(items_b.__ne__, items_a))
            if items_a:
                items_b = items_a[0]
                print("You have " + str(items_a.count(items_b)) + " " + items_b)
        else:
            print("You have no items in your inventory")
    elif action == "check coin pouch":
        print("You have " + str(coins) + " coins in your coin pouch")
    elif action == "consume items":
        consume = input("What do you want to consume? : ")
        if consume in inventory:
            if consume == "healing potion":
                print("You drink the potion and you feel loads better, hp +15")
                player_hp += 15
                inventory.remove("healing potion")
            elif consume == "bread":
                print("You eat the bread and sate your hunger, hp +10")
                player_hp += 10
                inventory.remove("bread")
            else:
                print("That item does not exist")
        else:
            print("You don't have that item and/or That item does not exist")
    elif action == "check quests":
        checking_quest_b = 0
        if quests:
            for checking_quest_a in quests:
                checking_quest_b += 1
                print("Quest " + str(checking_quest_b) + ":")
                if checking_quest_a == "Travel":
                    print("Travel to " + checking_quest_a[2] + " for " + str(checking_quest_a[3]) + " coins")
                if checking_quest_a == "Kill":
                    print("Kill" + str(checking_quest_a[1]) + " " + checking_quest_a[2] + "s for " +
                          str(checking_quest_a[3]) + " coins")
        else:
            print("You have no quests at the moment")
    else:
        print("I'm not familiar with that action")
