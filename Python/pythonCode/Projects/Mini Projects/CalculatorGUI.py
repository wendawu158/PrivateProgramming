import tkinter as tk

root = tk.Tk()
root.title("Simple Calculator")

e = tk.Entry(root, width=35, borderwidth=5)
e.grid(row=0, column=0, columnspan=4, padx=10, pady=10)

first_number = 0
sign = ""


def button_clicked(number):
    current = e.get()
    e.delete(0, tk.END)
    e.insert(0, str(current) + str(number))


def button_clear():
    e.delete(0, tk.END)


def button_add():
    global first_number
    global sign
    sign = "+"
    first_number = e.get()
    e.delete(0, tk.END)


def button_subtract():
    global first_number
    global sign
    sign = "-"
    first_number = e.get()
    e.delete(0, tk.END)


def button_multiply():
    global first_number
    global sign
    sign = "*"
    first_number = e.get()
    e.delete(0, tk.END)


def button_divide():
    global first_number
    global sign
    sign = "/"
    first_number = e.get()
    e.delete(0, tk.END)


def button_equal():
    second_number = e.get()
    e.delete(0, tk.END)
    final_number = 0
    if sign == "+":
        final_number = int(first_number) + int(second_number)
    elif sign == "-":
        final_number = int(first_number) - int(second_number)
    elif sign == "*":
        final_number = int(first_number) * int(second_number)
    elif sign == "/":
        final_number = int(first_number) / int(second_number)
    e.insert(0, final_number)


# Define Buttons

button_1 = tk.Button(root, text="1", padx=40, pady=20, command=lambda: button_clicked(1))
button_2 = tk.Button(root, text="2", padx=40, pady=20, command=lambda: button_clicked(2))
button_3 = tk.Button(root, text="3", padx=40, pady=20, command=lambda: button_clicked(3))

button_4 = tk.Button(root, text="4", padx=40, pady=20, command=lambda: button_clicked(4))
button_5 = tk.Button(root, text="5", padx=40, pady=20, command=lambda: button_clicked(5))
button_6 = tk.Button(root, text="6", padx=40, pady=20, command=lambda: button_clicked(6))

button_7 = tk.Button(root, text="7", padx=40, pady=20, command=lambda: button_clicked(7))
button_8 = tk.Button(root, text="8", padx=40, pady=20, command=lambda: button_clicked(8))
button_9 = tk.Button(root, text="9", padx=40, pady=20, command=lambda: button_clicked(9))

button_0 = tk.Button(root, text="0", padx=40, pady=20, command=lambda: button_clicked(0))

button_AC = tk.Button(root, text="AC", padx=82, pady=20, command=button_clear)
button_EQUALS = tk.Button(root, text="=", padx=86, pady=20, command=button_equal)

button_ADD = tk.Button(root, text="+", padx=39, pady=20, command=button_add)
button_MINUS = tk.Button(root, text="-", padx=41, pady=20, command=button_subtract)
button_MULTIPLY = tk.Button(root, text="*", padx=41, pady=20, command=button_multiply)
button_DIVIDE = tk.Button(root, text="/", padx=40, pady=20, command=button_divide)

# Display Buttons

button_1.grid(row=3, column=0)
button_2.grid(row=3, column=1)
button_3.grid(row=3, column=2)

button_4.grid(row=2, column=0)
button_5.grid(row=2, column=1)
button_6.grid(row=2, column=2)

button_7.grid(row=1, column=0)
button_8.grid(row=1, column=1)
button_9.grid(row=1, column=2)

button_0.grid(row=4, column=0)

button_AC.grid(row=4, column=1, columnspan=2)
button_EQUALS.grid(row=5, column=1, columnspan=2)

button_ADD.grid(row=5, column=0)
button_MINUS.grid(row=6, column=0)
button_MULTIPLY.grid(row=6, column=1)
button_DIVIDE.grid(row=6, column=2)

root.mainloop()
