from win10toast import ToastNotifier
import time

# create a notification

toast = ToastNotifier()

# make a delay

time.sleep(60)

# show the notification

toast.show_toast("Notification", "Notification body", duration=20)
