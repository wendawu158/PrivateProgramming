total = 0
numbers = [0]*10

for i in range(10):
    numbers[i] = int(input(f"Please enter the {i + 1}th number : "))
    total += numbers[i]

average = total / 10

print(f"The average was {average}")
print(f"The numbers were : ", end="")
for i in range(10):
    print(f"{numbers[i]}", end=" ")
