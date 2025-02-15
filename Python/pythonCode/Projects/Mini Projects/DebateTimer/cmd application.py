"""
2024 Wenda Wu. All rights reserved.
"""

from pydub import AudioSegment
from pydub.playback import play
import time
import os

if __name__ == '__main__':

    # Keeps track of how long has passed in a manner useful
    # for converting into filenames of the audio files
    seconds = 0
    minutes = 0

    # Determines which file to open
    fileNames = ["", "minutes.wav", ""]

    # Tells us the start time
    timeStart = time.time()

    # Tells us the delta time
    currentTime = 0.0
    passedTime = 0.0

    # Creates a window to display the time passed
    command = "start cmd /K echo "

    # Loops for the five minutes of debate time
    while minutes < 5:

        # Allows us to determine when 30 seconds have passed
        while currentTime - timeStart < passedTime + 23:
            currentTime = time.time()

        # Note that we do not do
        # passedTime = time.time() - timeStart
        # Due to the possibility of the internal clock being inaccurate/delayed

        # Adding the time in our other variables
        seconds += 30

        # Determining if a new minute has passed
        if seconds == 60:
            seconds = 0
            minutes += 1

        # Determining the files to be played
        fileNames[0] = str(minutes) + ".wav"
        fileNames[2] = str(seconds) + ".wav"

        # Playing the actual files
        for counter in range(len(fileNames)):

            sound = AudioSegment.from_wav("Audio files/" + fileNames[counter])
            sound = sound.speedup(1.2)
            sound = sound.set_sample_width(2)
            play(sound)

        print(f"{minutes} minutes and {seconds} seconds")

        command += str(f"{minutes} minutes and {seconds} seconds")

        os.system(command)

        # Stores the new passedTime
        passedTime = float(seconds + minutes * 60)





