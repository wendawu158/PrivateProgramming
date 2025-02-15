import pygame
import random


origin = (0, 0)
basePoint = (1000, 0)
# tipPoint = (500, round(0.5 * pow(3, 0.5) * basePoint[0]))
tipPoint = (0, 1000)


def area(p1, p2, p3):
    return abs(
        (
            p1[0] * (p2[1] - p3[1]) +
            p2[0] * (p3[1] - p1[1]) +
            p3[0] * (p1[1] - p2[1])
        ) / 2.0)

A = area(origin, basePoint, tipPoint)

while True:
    initRandX = random.random() * basePoint[0]
    initRandY = random.random() * tipPoint[1]

    point = (initRandX, initRandY)

    A1 = area(point, origin, basePoint)
    A2 = area(point, basePoint, tipPoint)
    A3 = area(point, tipPoint, origin)

    if A == (A1 + A2 + A3):
        break

pointDirection = random.randint(1, 3)

pygame.init()

screen = pygame.display.set_mode((1000, 1000))

screen.fill((255, 255, 255))

pygame.draw.line(screen, (0, 0, 0), origin, basePoint)
pygame.draw.line(screen, (0, 0, 0), tipPoint, basePoint)
pygame.draw.line(screen, (0, 0, 0), origin, tipPoint)

pygame.display.update()

running = True

while running:

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
            break

    pointOriginMid = (
        point[0] - 0.5 * (point[0] - origin[0]),
        point[1] - 0.5 * (point[1] - origin[1])
    )
    pointBaseMid = (
        point[0] - 0.5 * (point[0] - basePoint[0]),
        point[1] - 0.5 * (point[1] - basePoint[1])
    )
    pointTipMid = (
        point[0] - 0.5 * (point[0] - tipPoint[0]),
        point[1] - 0.5 * (point[1] - tipPoint[1])
    )

    pointDirection = random.randint(1, 3)

    '''
    pointDirection = random.randint(1, 5)
    if pointDirection >= 4:
        pointDirection = 1
    '''

    if pointDirection == 1:
        pygame.draw.line(screen, (0, 0, 0), pointOriginMid, pointOriginMid)
        point = pointOriginMid
    elif pointDirection == 2:
        pygame.draw.line(screen, (0, 0, 0), pointBaseMid, pointBaseMid)
        point = pointBaseMid
    else:
        pygame.draw.line(screen, (0, 0, 0), pointTipMid, pointTipMid)
        point = pointTipMid

    pygame.display.update()

