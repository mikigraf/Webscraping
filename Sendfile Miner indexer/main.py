__author__ = 'FLUTTERSHYSUCKS'
from bs4 import BeautifulSoup
import requests
import time
link = "http://www.sendfile.pl/"
number = raw_input("PODAJ 6-CIO CYFROWY NUMER PLIKU, OD KTOREGO MA ZACZYNAC SIE LISTA (np. 235000)")
interwal = raw_input("CO ILE SEKUND MA BYC SPRAWDZANY KOLEJNY PLIK/LINK? ZALECAM CZAS OKOLO 5-15 SEKUND.: ")

for number in range(int(number),300000,1):
    time.sleep(int(interwal))
    link2 = "http://www.sendfile.pl/" + str(number)
    soup = BeautifulSoup(requests.get(link2).text)
    for link in soup.find_all('title'):
        title1 = str(soup.find_all('title'))
        print(soup.title)
        print(" " + link2)
        open("SENDFILEMINER.txt",'a').write(soup.title.string.encode("utf-8") + " " + link2 + "\n")

