from win10toast import ToastNotifier
import time

try:
    hours = int(input("Enter the number of hours you want to sleep for : "))
    minutes = int(input("Enter the number of minutes you want to sleep for : "))
    seconds = int(input("Enter the number of seconds you want to sleep for : "))
except ValueError:
    quit()

total_time = (hours * 3600 + minutes * 60 + seconds)

toast = ToastNotifier()

time.sleep(total_time)

toast.show_toast("Notification", "Notification body", duration=20)