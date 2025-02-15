import pygame
import random


origin = (0, 0)
basePoint = (1000, 0)
tipPoint = (0, 1000)
tip2Point = (1000, 1000)


def midpoint(p1, p2, factor=1/2):
    return (
        (p1[0] + p2[0]) * factor,
        (p1[1] + p2[1]) * factor
            )


originBaseMid = midpoint(origin, basePoint)
originTipMid = midpoint(origin, tipPoint)
tip2BaseMid = midpoint(tip2Point, basePoint)
tip2TipMid = midpoint(tip2Point, tipPoint)


def area(p1, p2, p3):
    return abs(
        (
            p1[0] * (p2[1] - p3[1]) +
            p2[0] * (p3[1] - p1[1]) +
            p3[0] * (p1[1] - p2[1])
        ) / 2.0)


A = area(origin, basePoint, tipPoint) + area(basePoint, tipPoint, tip2Point)

while True:
    initRandX = random.random() * basePoint[0]
    initRandY = random.random() * tipPoint[1]

    point = (initRandX, initRandY)

    A1 = area(point, origin, basePoint)
    A2 = area(point, basePoint, tip2Point)
    A3 = area(point, tipPoint, origin)
    A4 = area(point, tipPoint, tip2Point)

    if A == (A1 + A2 + A3 + A4):
        break

pointDirection = random.randint(1, 3)

pygame.init()

screen = pygame.display.set_mode((1000, 1000))

screen.fill((255, 255, 255))

pygame.draw.line(screen, (0, 0, 0), origin, basePoint)
pygame.draw.line(screen, (0, 0, 0), tip2Point, basePoint)
pygame.draw.line(screen, (0, 0, 0), origin, tipPoint)
pygame.draw.line(screen, (0, 0, 0), tipPoint, tip2Point)


pygame.display.update()

running = True

while running:

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
            break

    midpoints = (midpoint(origin, point, factor=2/3),
                 midpoint(basePoint, point, factor=2/3),
                 midpoint(tipPoint, point, factor=2/3),
                 midpoint(tip2Point, point, factor=2/3),
                 midpoint(originBaseMid, point, factor=2/3),
                 midpoint(originTipMid, point, factor=2/3),
                 midpoint(tip2BaseMid, point, factor=2/3),
                 midpoint(tip2TipMid, point, factor=2/3)
                 )

    pointDirection = random.randint(0, 7)

    pygame.draw.line(screen, (0, 0, 0), midpoints[pointDirection], midpoints[pointDirection])
    point = midpoints[pointDirection]

    pygame.display.update()

