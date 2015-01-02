__author__ = 'spejs'
import smtplib
from datetime import datetime
import urllib2

from bs4 import BeautifulSoup


mensa = urllib2.urlopen('http://www.stwdo.de/gastronomie/speiseplaene/hauptmensa/').read()
soup = BeautifulSoup(mensa)


def checkIfInMensa(food, fromaddr, toaddr, username, passwd):
    soup2 = soup.body.get_text();
    if (food in soup2):
        print('HAMBURGERS IN MENSA!')
        print('Email was sent to imspacedreamer@gmail.com')
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

    else:
        print(datetime.now().strftime('%H:%M'))

checkIfInMensa(food='Hamburger', fromaddr='pythonmegatron@gmail.com', toaddr='imspacedreamer@gmail.com',
               email='imspacedreamer@gmail.com', username='pythonmegatron@gmail.com', passwd='sadasd ')

