__author__ = 'spejs'
import mechanize
from bs4 import BeautifulSoup
import requests
import mechanize
from email.mime.text import MIMEText
import smtplib
import time
from datetime import datetime, timedelta, date
from threading import Timer
import re
import urllib2

mensa = urllib2.urlopen('http://www.stwdo.de/gastronomie/speiseplaene/hauptmensa/').read()
soup = BeautifulSoup(mensa)

def checkIfInMensa(food,email,passwd):
    soup2 =  soup.body.get_text();
    if(food in soup2):
            print('HAMBURGERS IN MENSA!')
            print('Email was sent to imspacedreamer@gmail.com')
            fromaddr = 'pythonmegatron@gmail.com'
            toaddr = 'imspacedreamer@gmail.com'
            passwd =
            msg = "\r\n".join([
          "From: pythonmegatron@gmail.com",
          "To: " + email,
          "Subject: HAMBURGERS IN MENSA",
          "SPACE IS CHILLIN, MIKE IS CHILLIN, WHAT MORE CAN I SAY? WE KILLIN IT!",
          ""
          ])
            username = 'pythonmegatron@gmail.com'

            server = smtplib.SMTP('smtp.gmail.com:587')
            server.ehlo()
            server.starttls()
            server.login(username, passwd)
            server.sendmail(fromaddr, toaddr, msg)
            server.quit()

    else:
        currentTime = datetime.now().strftime('%H:%M')
        print(datetime.now().strftime('%H:%M'))


checkIfInMensa(food='Hamburger',email='imspacedreamer@gmail.com',passwd=' ')

