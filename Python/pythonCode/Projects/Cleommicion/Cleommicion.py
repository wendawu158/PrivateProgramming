import random


# defines what the player can do

class Player:
    def __init__(self):

        # player's name

        self.name = ""

        # player's location

        self.realm = ""
        self.kingdom = ""
        self.county = ""
        self.town = ""
        self.street = ""
        self.building = ""

        # things to interact with

        self.location_npc_interact = []
        self.location_item_interact = []

        # likeliness of thugs to attack

        self.location_thug_likeliness = 0

        # linked locations, store realms - buildings

        self.linked_locations = []

        # secret linked locations, store realms - buildings

        self.secret_linked_locations = []
        
        # new location variables

        self.movement = ""
        self.new_location = ["", "", "", "", "", ""]

        # player's exp and lvl

        self.experience = 0
        self.level = 0
        self.stat_points = 50

        # player's health and mana

        self.hp = 0
        self.mp = 0

        # effects the player has, each effect should be entered as the following:
        # [effect name (raw string), hp max change, mp max change, strength change, dexterity change, endurance change,
        # constitution change, intelligence change, wisdom change, charisma change, luck change, perception change,
        # stealth change, fame change, infamy change, intimidation change,
        # length of effect (-1 is equal to infinite until changed by action)]

        self.effects = []

        # items the player has, each effect should be entered as the following:
        # [items name (raw string), hp max change, mp max change, strength change, dexterity change, endurance change,
        # constitution change, intelligence change, wisdom change, charisma change, luck change, perception change,
        # stealth change, fame change, infamy change, intimidation change, hp change after use, mp change after use,
        # OPTIONAL removable from inventory (bool), OPTIONAL effect after use (store as effect),
        # IF ARMOUR OR ITEM FOR MAIN_HAND OR OFF_HAND in use (bool), IF ARMOUR OR ITEM FOR MAIN_HAND OR OFF_HAND slot,
        # IF WEAPON melee, ranged, or magic, IF WEAPON attack type]

        self.inventory = []
        self.helmet = []
        self.chestplate = []
        self.leggings = []
        self.boots = []
        self.main_hand = []
        self.off_hand = []
        self.right_bracelet = []
        self.left_bracelet = []
        self.ring_1 = []
        self.ring_2 = []
        self.ring_3 = []
        self.ring_4 = []
        self.ring_5 = []
        self.ring_6 = []
        self.necklace = []
        self.gloves = []
        self.overcoat = []

        # currencies the player has

        self.coin = 0

        # base stats that the player has

        self.base_max_hp = 0
        self.base_max_mp = 0
        self.base_strength = 0
        self.base_dexterity = 0
        self.base_endurance = 0
        self.base_constitution = 0
        self.base_intelligence = 0
        self.base_wisdom = 0
        self.base_charisma = 0
        self.base_luck = 0
        self.base_perception = 0
        self.base_stealth = 0
        self.base_fame = 0
        self.base_infamy = 0
        self.base_intimidation = 0

        # stats after effect changes / item changes

        self.max_hp = 0
        self.max_mp = 0
        self.strength = 0
        self.dexterity = 0
        self.endurance = 0
        self.constitution = 0
        self.intelligence = 0
        self.wisdom = 0
        self.charisma = 0
        self.luck = 0
        self.perception = 0
        self.stealth = 0
        self.fame = 0
        self.infamy = 0
        self.intimidation = 0

        # stats in list and dictionary

        self.statistics = ["strength", "dexterity", "endurance", "constitution", "intelligence", "wisdom", "charisma",
                           "luck"]
        self.stat_translator = {
            "strength": self.base_strength,
            "dexterity": self.base_dexterity,
            "endurance": self.base_endurance,
            "constitution": self.base_constitution,
            "intelligence": self.base_intelligence,
            "wisdom": self.base_wisdom,
            "charisma": self.base_charisma,
            "luck": self.base_luck,
            "perception": self.base_perception,
            "stealth": self.base_stealth
        }

    def stat_choice(self):
        print(
            "You will now decide where your stat points go! Each of the eight skills have an unlimited points per\n"
            "skill and a minimum of 0 points per skill. You will have" + str(self.stat_points) + "points to share\n"
            "between your skills, so choose wisely!\n"
            "The available skills are:\n"
            "Strength - Will you be filled with muscles or only skin and bones? Determine that with your strength\n"
            "Dexterity - Sneaking and snooping and running and shooting with a bow becomes easier with more dexterity\n"
            "Endurance - Sticks and stones WON'T break your bones if you have high endurance\n"
            "Constitution - Magic and disease will just bounce right off depending on constitution\n"
            "Intelligence - Battle others in great debates or magical fights with your intelligence\n"
            "Wisdom - Others will come to you and heed your worldly knowledge for you have much wisdom\n"
            "Charisma - Win over the masses with your talking and your looks, for you are the most charismatic\n"
            "Luck - Will lady luck aid you or ail you? Improve your luck stat to find your luck\n"
            "Perception - Notice tiny details and use your improved eyesight with your perception\n"
            "Stealth - Hide away with the shadows and camouflage into the landscape using your stealth\n\n")

        stat_choice_finished = False

        while not stat_choice_finished:
            try:
                for statistic in player.statistics:
                    stat_choice = int(input("Enter a number between 0 and " + str(self.stat_points) +
                                            " to add to your " + statistic + " skill : "))

                    if stat_choice < 0:
                        stat_choice = 0
                    elif stat_choice > self.stat_points:
                        stat_choice = self.stat_points

                    self.stat_points -= stat_choice

                    self.stat_translator[statistic] = stat_choice

                print("\n\n")

                for statistic in self.statistics:
                    print(statistic + " : " + str(self.stat_translator[statistic]))

                stat_choice_confirmation = input("\n\nAre you happy with these statistics? Y/N : ")

                if stat_choice_confirmation == "Y":
                    print("\nExcellent!")
                    stat_choice_finished = True
                else:
                    print("\nAlright then, we'll do them again")
            except:
                print("Please only enter integers (numbers without decimals). Let's try that again, shall we?")

    def stat_update(self):
        for effect in self.effects:
            self.max_hp = self.base_max_hp + effect[1]
            self.max_mp = self.base_max_mp + effect[2]
            self.strength = self.base_strength + effect[3]
            self.dexterity = self.base_dexterity + effect[4]
            self.endurance = self.base_endurance + effect[5]
            self.constitution = self.base_constitution + effect[6]
            self.intelligence = self.base_intelligence + effect[7]
            self.wisdom = self.base_wisdom + effect[8]
            self.charisma = self.base_charisma + effect[9]
            self.luck = self.base_luck + effect[10]
            self.perception = self.base_perception + effect[11]
            self.stealth = self.base_stealth + effect[12]
            self.fame = self.base_fame + effect[13]
            self.infamy = self.base_infamy + effect[14]
            self.intimidation = self.base_intimidation + effect[15]

        if self.hp > self.max_hp:
            self.hp = int(self.max_hp)

        if self.mp > self.max_mp:
            self.mp = int(self.max_mp)

        while self.experience > (10 * self.level - self.luck // 4):
            self.experience -= (10 * self.level - self.luck // 4)
            self.level += 1
            self.stat_points += 1

    def location_update(self):
        self.realm_defined = False
        self.kingdom_defined = False
        self.county_defined = False
        self.town_defined = False
        self.street_defined = False
        self.building_defined = False

        self.realm_list = []
        self.kingdom_list = []
        self.county_list = []
        self.town_list = []
        self.street_list = []
        self.building_list = []

        while True:
            print("Locations will be printed as realm, kingdom, county, town, street, and building")
            print("You can travel to these locations : ")

            for location in player.linked_locations:
                print(*location, sep=', ')

            for location in location_structure:
                player.movement = input("Enter the " + location + "of the location you want to travel : ")
                player.new_location[location_structure.index(location)] = str(player.movement)

            for location in all_locations:
                if location[0] == self.new_location[0]:
                    self.realm_list = location[1].copy()
                    self.realm_defined = True
            for location in self.realm_list:
                if location[0] == self.new_location[1]:
                    self.kingdom_list = location[1].copy()
                    self.kingdom_defined = True
            for location in self.kingdom_list:
                if location[0] == self.new_location[2]:
                    self.county_list = location[1].copy()
                    self.county_defined = True
            for location in self.county_list:
                if location[0] == self.new_location[3]:
                    self.town_list = location[1].copy()
                    self.town_defined = True
            for location in self.town_list:
                if location[0] == self.new_location[4]:
                    self.street_list = location[1].copy()
                    self.street_defined = True
            for location in self.street_list:
                if location[0] == self.new_location[5]:
                    self.building_list = location[1].copy()
                    self.building_defined = True

            if self.realm_defined:
                if self.kingdom_defined:
                    if self.county_defined:
                        if self.town_defined:
                            if self.street_defined:
                                if self.building_defined:
                                    break

            print("You seemed to have entered an invalid location")

        self.realm = self.new_location[0]
        self.kingdom = self.new_location[1]
        self.county = self.new_location[2]
        self.town = self.new_location[3]
        self.street = self.new_location[4]
        self.building = self.new_location[5]

        self.location_npc_interact = self.building_list[0]
        self.location_item_interact = self.building_list[0]

        self.location_thug_likeliness = self.building_list[0]

        self.linked_locations = self.building_list[0]
        self.secret_linked_locations = self.building_list[0]

        print(self.building_list[0])


# important variables

location_structure = ["realm", "kingdom", "county", "town", "street", "building"]

# locations stored as [[realm, [[kingdom, [[county, [[town, [[street, [[building,
# [npcs, items, thugs, linked locations, secret linked locations, description]]]]]]]]]]]]]

all_locations = [["humana", [["whaywood", []], [], []]],
                 []]

# starting protocols

player = Player()

print("Welcome to Cleommicion! This is a fantasy text game about stats, quests, gear, monsters, combat and story.\n"
      "In this game you will be able to roam around the world almost completely freely except for certain areas.\n"
      "The game revolves five main mechanics:\n"
      "Stats: These will change scenarios and mechanics but will also affect combat\n"
      "Quests: These will serve to permanently upgrade your stats or give you gear and also progress the story\n"
      "Gear: These will increase your defense against damage, but can also have special abilities\n"
      "Monsters: These will drop loot, there may be gear or other items such as potions, food, etc\n"
      "Combat: This is split into melee, ranged, and magical damage and also the same three groups for defense\n"
      "Story: There will be an overarching story and many more medium and minor stories. Unlocks certain areas\n\n\n")

player.stat_choice()

while player.hp > 0:
    player.stat_update()

    action = input("")

    if action == "move":
        player.location_update()
