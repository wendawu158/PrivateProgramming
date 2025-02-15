import sys

import pygame

if __name__ == '__main__':

    time = 0
    seconds = 0
    minutes = 0
    displayTime = ""

    fileNames = ["", "minutes.wav", "", "seconds.wav"]

    pygame.init()
    pygame.display.set_caption("Debate Timer")
    icon = pygame.image.load(r'Files\icon.png')
    pygame.display.set_icon(icon)

    font = pygame.font.Font(r'Files\clear-sans\ClearSans-Bold.ttf', 46)
    screen = pygame.display.set_mode((200, 100))
    screen.fill((40, 42, 40))
    pygame.display.update()

    play = False
    playCounter = 0

    paused = False
    pausedTime = 0
    totalPausedTime = 0

    pauseStart = 0

    while True:
        screen.fill((40, 42, 40))

        if minutes == 5 and seconds == 45:
            raise SystemExit

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                raise SystemExit
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_SPACE:
                    paused = not paused
                    if paused:
                        pauseStart = pygame.time.get_ticks()
                    else:
                        totalPausedTime += pausedTime
                        pausedTime = 0

        if play:
            if playCounter != 4:
                if not pygame.mixer.music.get_busy():
                    pygame.mixer.music.load(f"Files/Audio files/{fileNames[playCounter]}")
                    pygame.mixer.music.play()
                    playCounter += 1
            else:
                play = False
                playCounter = 0

        if paused:
            pausedTime = pygame.time.get_ticks() - pauseStart
        else:
            time = (pygame.time.get_ticks() - totalPausedTime) // 1000
            seconds = time % 60
            minutes = time // 60

            if seconds < 10:
                displayTime = font.render(f"{minutes}:0{seconds}", True, (0, 0, 0))
            else:
                displayTime = font.render(f"{minutes}:{seconds}", True, (0, 0, 0))

            displayTimeRect = displayTime.get_rect()
            displayTimeRect.center = (100, 50)
            screen.blit(displayTime, displayTimeRect)

            if seconds == 30 or (seconds == 0 and minutes != 0):
                play = True
                fileNames[0] = str(minutes) + ".wav"
                fileNames[2] = str(seconds) + ".wav"

            pygame.display.update()
