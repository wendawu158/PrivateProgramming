import Student
import Teacher
import Class

if __name__ == '__main__':
    i = 1
    ValidSubjects = ("Art and design", "Biology", "Business Management", "Chemistry", "Classical studies",
                     "Computing science", "Design and Technology", "Drama", "Economics", "English",
                     "Environmental sciences", "French", "Geography", "German", "History", "Latin", "Mandarin",
                     "Mathematics", "Modern studies", "Music", "PE", "Physics", "RMPS", "Spanish", "Statistics")
    Students = []
    Teachers = []
    Subjects = {}
    SubjectsTaught = []
    while True:
        name = str(input("Input the " + str(i) + "th student's full name : ")).capitalize()
        try:
            year = int(input("Input the " + str(i) + "th student's year of study : "))
        except ValueError:
            print("Invalid year of study")
            print("Please enter an integer")
            continue
        j = 1
        while True:
            subject = str(input("Input the " + str(j) + "th subject of the " + str(i) + "th student : ")).capitalize()
            if subject not in ValidSubjects:
                print("Invalid subject")
                print("Please enter one of the following subjects :")
                for i in ValidSubjects:
                    if i != len(ValidSubjects):
                        print(i, end=", ")
                    else:
                        print(i)
                continue
            try:
                subjectTestScore = int(input("Input the last end of year test score of the " + str(j) +
                                       "th subject of the " + str(i) + "th student : "))
                if subjectTestScore < 0 or subjectTestScore > 100:
                    raise ValueError
            except ValueError:
                print("Invalid test score")
                print("Please enter a positive integer between 0 and 100 inclusive")
                continue
            Subjects[subject] = subjectTestScore
            if input("Is that the last subject for that student? Y/N : ") in ("y", "Y"):
                break
            j += 1
        Students.append(Student.Student(name, year, Subjects))
        if input("Is that the last student? Y/N : ") in ("y", "Y"):
            break
        i += 1
    i = 0
    while True:
        i += 1
        name = str(input("Input the " + str(i) + "th teacher's full name : ")).capitalize()
        j = 1
        while True:
            subject = str(input("Input the " + str(j) + "th subject" +
                                " taught by the " + str(i) + "th teacher : ")).capitalize()
            if subject not in ValidSubjects:
                print("Invalid subject")
                print("Please enter one of the following subjects :")
                for i in ValidSubjects:
                    if i != len(ValidSubjects):
                        print(i, end=", ")
                    else:
                        print(i)
                continue
            j += 1
            SubjectsTaught.append(subject)
            if input("Is that the last subject for that teacher? Y/N : ") in ("y", "Y"):
                break
        Teachers.append(Teacher.Teacher(name, SubjectsTaught))
        if input("Is that the last teacher? Y/N : ") in ("y", "Y"):
            break
    AllStudentsOrganised = []
    for j in range(max(i.year for i in Students) - 1):
        AllStudentsOrganised.append([])
    for j in AllStudentsOrganised:
        for k in Subjects:
            j.append([])

    # Students sorted [i (year) [ j (subject)[]]]

    StudentsSorted = []
    for i in range(max(i.year for i in Students) - 1):
        StudentsSorted.append([])
    for i in StudentsSorted:
        for j in Subjects:
            i.append([])
    for i in StudentsSorted:
        for j in i:
            for k in Students:
                if k.year == (StudentsSorted.index(i) + 1):
                    if Subjects[i.index(j)] in k.subjects:
                        j.append(Student)

    for i in StudentsSorted:
        for j in i:
            j = sorted(key=lambda k: k.subjects.get())
