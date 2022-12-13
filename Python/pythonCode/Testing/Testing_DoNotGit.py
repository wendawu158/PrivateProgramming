class Something:

    numberOfThings = 0

    def __init__(self, j):
        self.hello = j
        Something.numberOfThings += 1

    @classmethod
    def createWithoutHello(cls):
        cls.numberOfThings += 1
        return cls("Hello")

    @staticmethod
    def createNotWithHello():
        Something.numberOfThings = 0

    def __str__(self):
        return str("No string value")


i = Something(1)

k = Something.createWithoutHello()

Something.createNotWithHello()


print(str(i))
