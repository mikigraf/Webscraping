__author__ = 'FLUTTERSHYSUCKS'
from bs4 import BeautifulSoup
import requests
import time
link = "http://www.sendfile.pl/"
number = raw_input("PODAJ 6-CIO CYFROWY NUMER PLIKU, OD KTOREGO MA ZACZYNAC SIE LISTA (np. 235000)")
interwal = raw_input("CO ILE SEKUND MA BYC SPRAWDZANY KOLEJNY PLIK/LINK? ZALECAM CZAS OKOLO 5-15 SEKUND.: ")



for number in range(int(number),300000,1):
    time.sleep(int(interwal))

    str(number)
    link2 = "http://www.sendfile.pl/" + str(number)
    r = requests.get(link2)
    data = r.text
    soup = BeautifulSoup(data)
    for link in soup.find_all('title'):
        title1 = str(soup.find_all('title'))
        print(soup.title)
        print(" " + link2)
        open("SENDFILE MINER",'a').write(soup.title.string.encode("utf-16"))
        open("SENDFILE MINER",'a').write(" " + link2 + "\n")

