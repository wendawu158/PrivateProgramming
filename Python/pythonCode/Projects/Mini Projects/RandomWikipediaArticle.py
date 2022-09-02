import requests
from bs4 import BeautifulSoup
import webbrowser

interest = ""

while interest.upper() != "Y":

	response = requests.get(
		url="https://en.wikipedia.org/wiki/Special:Random",
	)
	soup = BeautifulSoup(response.content, 'html.parser')

	title = soup.find(id="firstHeading")
	print(title.string)

	interest = input("Does the above topic interest you? Y/N : ")

webbrowser.open("https://en.wikipedia.org/wiki/" + title.string)
