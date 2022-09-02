if __name__ == "__main__":
    Signals = [0.0]*5
    SignalPattern = ""

    for i in range(5):
        Signals[i] = float(input(f"Enter tower number {i + 1}'s signal strength : "))
        if Signals[i] > 100.0 or Signals[i] < 0.0:
            print("Invalid Reading")
            Signals[i] = float(input(f"Enter tower number {i + 1}'s signal strength : "))

        Signals[i] = round(Signals[i])

        if Signals[i] > 80:
            SignalPattern += 'S'
        elif Signals[i] < 30:
            SignalPattern += 'P'
        else:
            SignalPattern += 'M'

    print(SignalPattern)

    for i in range(5):
        print(f"Tower {i + 1}'s signal strength was : {Signals[i]}")
