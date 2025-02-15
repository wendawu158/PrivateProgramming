import os
command = "start cmd /K echo "
for i in range(0,5):
    command += str(i+1)

os.system(command)