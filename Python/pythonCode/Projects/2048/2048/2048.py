import random
import pygame

# Made by Wenda Wu, Copyright 2020

grey = (32, 32, 32)
Colours = [
    [238, 228, 218],
    [237, 224, 200],
    [242, 177, 121],
    [245, 149, 99],
    [246, 124, 95],
    [246, 94, 59],
    [237, 207, 114],
    [237, 204, 97],
    [237, 200, 80],
    [237, 197, 63],
    [237, 194, 46]
]

score = 0


class Square:

    def __init__(self, x_value, y_value):
        self.is_empty = True
        self.value = 0
        self.value_changed = False

        self.x_value = x_value
        self.y_value = y_value
        self.coordinates = (x_value, y_value)

        self.is_left_side = False
        self.is_right_side = False
        self.is_top_side = False
        self.is_bottom_side = False

        if self.x_value == 20:
            self.is_left_side = True
        elif self.x_value == 380:
            self.is_right_side = True

        if self.y_value == 20:
            self.is_top_side = True
        elif self.y_value == 380:
            self.is_bottom_side = True

    def place_find(self):
        self.place = Squares.index(self)

    def random_create(self, value):
        self.is_empty = False
        self.value = value

    def move(self, direction):
        if not self.is_empty:
            if direction == "left":
                if not self.is_left_side:
                    for i in range(1, 4):
                        if Squares[self.place - i].is_empty:
                            if Squares[self.place - i].is_left_side:
                                Squares[self.place - i].value = int(self.value)
                                Squares[self.place - i].is_empty = False
                                self.value = 0
                                self.is_empty = True
                                break
                        else:
                            if Squares[self.place - i].value == self.value:
                                Squares[self.place - i].value = self.value * 2
                                Squares[self.place - i].is_empty = False
                                Squares[self.place - i].value_changed = True
                                self.value = 0
                                self.is_empty = True
                                break
                            else:
                                if not Squares[self.place - i + 1] == self:
                                    Squares[self.place - i + 1].value = int(self.value)
                                    Squares[self.place - i + 1].is_empty = False
                                    self.value = 0
                                    self.is_empty = True
                                break
            elif direction == "right":
                if not self.is_right_side:
                    for i in range(1, 4):
                        if Squares[self.place + i].is_empty:
                            if Squares[self.place + i].is_right_side:
                                Squares[self.place + i].value = int(self.value)
                                Squares[self.place + i].is_empty = False
                                self.value = 0
                                self.is_empty = True
                                break
                        else:
                            if Squares[self.place + i].value == self.value:
                                Squares[self.place + i].value = self.value * 2
                                Squares[self.place + i].is_empty = False
                                Squares[self.place + i].value_changed = True
                                self.value = 0
                                self.is_empty = True
                                break
                            else:
                                if not Squares[self.place + i - 1] == self:
                                    Squares[self.place + i - 1].value = int(self.value)
                                    Squares[self.place + i - 1].is_empty = False
                                    self.value = 0
                                    self.is_empty = True
                                break
            elif direction == "up":
                if not self.is_top_side:
                    for i in range(1, 4):
                        i *= 4
                        if Squares[self.place - i].is_empty:
                            if Squares[self.place - i].is_top_side:
                                Squares[self.place - i].value = int(self.value)
                                Squares[self.place - i].is_empty = False
                                self.value = 0
                                self.is_empty = True
                                break
                        else:
                            if Squares[self.place - i].value == self.value:
                                Squares[self.place - i].value = self.value * 2
                                Squares[self.place - i].is_empty = False
                                Squares[self.place - i].value_changed = True
                                self.value = 0
                                self.is_empty = True
                                break
                            else:
                                if not Squares[self.place - i + 4] == self:
                                    Squares[self.place - i + 4].value = int(self.value)
                                    Squares[self.place - i + 4].is_empty = False
                                    self.value = 0
                                    self.is_empty = True
                                break
            elif direction == "down":
                if not self.is_bottom_side:
                    for i in range(1, 4):
                        i *= 4
                        if Squares[self.place + i].is_empty:
                            if Squares[self.place + i].is_bottom_side:
                                Squares[self.place + i].value = int(self.value)
                                Squares[self.place + i].is_empty = False
                                self.value = 0
                                self.is_empty = True
                                break
                        else:
                            if Squares[self.place + i].value == self.value:
                                Squares[self.place + i].value = self.value * 2
                                Squares[self.place + i].is_empty = False
                                Squares[self.place + i].value_changed = True
                                self.value = 0
                                self.is_empty = True
                                break
                            else:
                                if not Squares[self.place + i - 4] == self:
                                    Squares[self.place + i - 4].value = int(self.value)
                                    Squares[self.place + i - 4].is_empty = False
                                    self.value = 0
                                    self.is_empty = True
                                break

    def create_visual(self):
        if self.is_empty:
            pygame.draw.rect(screen, (204, 192, 179), (self.x_value, self.y_value, 100, 100))
        else:
            self.colour_index_1 = int(self.value)
            self.colour_index_2 = -1

            while True:
                self.colour_index_1 /= 2
                self.colour_index_2 += 1
                if self.colour_index_1 == 1:
                    break

            self.colour = Colours[self.colour_index_2]

            pygame.draw.rect(screen, self.colour, (self.x_value, self.y_value, 100, 100))

            self.text = font.render(str(self.value), True, grey)
            self.text_rect = self.text.get_rect()
            self.text_rect.center = (self.x_value + 50, self.y_value + 50)

            screen.blit(self.text, self.text_rect)

# Made by Wenda Wu, Copyright 2020

Squares = []

x = 20
y = 20

for j in range(16):

    Squares.append(Square(x, y))
    x += 120
    Squares[j].place_find()

    if x == 500:
        x = 20
        y += 120

running = True
game_over = False
key_was_down = False
game_just_started = True
alternating_text = 0
random_values = [2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 8]

# Made by Wenda Wu, Copyright 2020

for j in range(4):
    empty_squares = []

    for k in Squares:
        if k.is_empty:
            empty_squares.append(k)

    random.choice(empty_squares).random_create(random.choice(random_values))

pygame.init()

font = pygame.font.Font(r'Files\clear-sans\ClearSans-Bold.ttf', 46)
font_big = pygame.font.Font(r'Files\clear-sans\ClearSans-Bold.ttf', 72)

icon = pygame.image.load(r'Files\2048.png')
pygame.display.set_icon(icon)

screen = pygame.display.set_mode((500, 640))

pygame.display.set_caption("2048")

# Made by Wenda Wu, Copyright 2020

while running:
    screen.fill((184, 172, 159))
    pygame.draw.rect(screen, (75, 75, 75), (0, 500, 500, 640))

    if not game_over:
        if game_just_started:
            score_text = font.render("Use wasd or arrow keys", True, grey)
        else:
            score_text = font_big.render("Score " + str(score), True, grey)

        score_text_rect = score_text.get_rect()
        score_text_rect.center = (250, 565)
        screen.blit(score_text, score_text_rect)
    else:
        if alternating_text <= 400:
            game_over_text = font_big.render("Game over!", True, grey)
        else:
            game_over_text = font.render("Press enter to restart", True, grey)

        if alternating_text == 800:
            alternating_text = 0

        alternating_text += 1

        game_over_text_rect = game_over_text.get_rect()
        game_over_text_rect.center = (250, 565)
        screen.blit(game_over_text, game_over_text_rect)

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        elif event.type == pygame.KEYDOWN:
            if event.key in (pygame.K_LEFT, pygame.K_a):
                for j in range(16):
                    Squares[j].move("left")
                    key_was_down = True
            elif event.key in (pygame.K_RIGHT, pygame.K_d):
                for j in range(1, 17):
                    j = -j
                    Squares[j].move("right")
                    key_was_down = True
            elif event.key in (pygame.K_UP, pygame.K_w):
                for j in range(16):
                    Squares[j].move("up")
                    key_was_down = True
            elif event.key in (pygame.K_DOWN, pygame.K_s):
                for j in range(1, 17):
                    j = -j
                    Squares[j].move("down")
                    key_was_down = True
            elif event.key == pygame.K_RETURN:
                for j in Squares:
                    j.value = 0
                    j.is_empty = True

                for j in range(4):
                    empty_squares = []

                    for k in Squares:
                        if k.is_empty:
                            empty_squares.append(k)

                    random.choice(empty_squares).random_create(random.choice(random_values))

                score = 0
                key_was_down = False
                game_over = False
                game_just_started = True

            if key_was_down:
                game_just_started = False
                empty_squares = []

                for j in Squares:
                    if j.is_empty:
                        empty_squares.append(j)

                if len(empty_squares) == 0:
                    for j in range(16):
                        if not Squares[j].is_left_side:
                            if Squares[j].value == Squares[j - 1].value:
                                break
                        if not Squares[j].is_right_side:
                            if Squares[j].value == Squares[j + 1].value:
                                break
                        if not Squares[j].is_top_side:
                            if Squares[j].value == Squares[j - 4].value:
                                break
                        if not Squares[j].is_bottom_side:
                            if Squares[j].value == Squares[j + 4].value:
                                break
                        if j == 15:
                            game_over = True
                    continue

                random.choice(empty_squares).random_create(random.choice(random_values))

                key_was_down = False

    for j in Squares:
        j.create_visual()

    for j in Squares:
        if j.value_changed:
            score += j.value
            j.value_changed = False

    pygame.display.update()

# Made by Wenda Wu, Copyright 2020
