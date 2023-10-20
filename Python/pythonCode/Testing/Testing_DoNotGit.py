def getNumber():

   n = int(input("Enter a number : "))

   return n


def findIfPrime(n):

   isPrime = True

   for i in range(n):
       if n % i == 0:
          is



def main():
   number = getNumber()
   isPrime = findIfPrime(number)
   display(isPrime)


main()
