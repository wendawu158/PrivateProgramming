# Decided to code in oop, hope it don't turn out oops
import random

class BjBot:

    def __init__(self, deck, players):
        self.openingDeck = deck
        self.players = players

        self.aggressive = False
        self.convertedHand = []
        self.handValue = 0
        self.losingChance = 0

        self.remainingDeck = deck
        self.convertedRemainingDeck = []
        self.lowestPossibleDeck = deck
        self.highestPossibleDeck = deck
        self.cardsInPlay = 0

    def StickOrTwist(self, hand, cardsInPlay):
        for i in hand:
            if isinstance(i, str): self.convertedHand.append(10)
            else: self.convertedHand.append(i)

        for i in self.remainingDeck:
            if isinstance(i, str): self.convertedRemainingDeck.append(10)
            else: self.convertedRemainingDeck.append(i)


    def EndOfRound(self, removedCards):
        for i in removedCards:
            self.remainingDeck.remove(i)

