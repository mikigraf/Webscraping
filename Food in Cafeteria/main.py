__author__ = 'spejs'
import smtplib
from datetime import datetime
import urllib2
import ninja
import getpass




from bs4 import BeautifulSoup


mensa = urllib2.urlopen('http://www.stwdo.de/gastronomie/speiseplaene/hauptmensa/').read()
soup = BeautifulSoup(mensa)
food = raw_input("Notify me when available: ")
fromaddr = raw_input("Send email from: ")
toaddr = raw_input("Send to: ")
username = raw_input("Email username: ")
passwd = getpass.getpass()

def checkIfInMensa(food, fromaddr, toaddr, username, passwd):
    soup2 = soup.body.get_text();
    if (food in soup2):
        print(food + ' IN MENSA')
        print('Email was sent to: ' + toaddr)
    msg = "\r\n".join([
        "From: " + fromaddr,
        "To: " + toaddr,
        "Subject: " + food + " IN MENSA"
        "SPACE IS CHILLIN, MIKE IS CHILLIN, WHAT MORE CAN I SAY? WE KILLIN IT!",
        ""
    ])
    server = smtplib.SMTP('smtp.gmail.com:587')
    server.ehlo()
    server.starttls()
    server.login(username, passwd)
    server.sendmail(fromaddr, toaddr, msg)
    server.quit()


checkIfInMensa(food, fromaddr, toaddr, username, passwd)

