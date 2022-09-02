Students = []

class Student:
    def __init__(self, name, year, subjects):
        self.name = name
        self.year = year
        self.subjects = subjects

    #to find max year use max(i.year for i in Students)
