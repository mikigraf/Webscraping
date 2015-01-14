import smtplib
import urllib2
from bs4 import BeautifulSoup
import time
import os

news = urllib2.urlopen('http://www.fh-dortmund.de/de/fb/4/isc/aktuelles/index.php?archive=1').read()
soup = BeautifulSoup(news)

# get news and save them into log file
def fetchOldNews():
    soup2 = soup.body.get_text();
    print(soup2)
    soup2Encoded = soup2.encode('utf-8')
    file = open('LOG.txt','a')
    file.write(soup2Encoded)
    file.close()


# compare news, that are already in the log file with newly fetched news
def compare():
    file = open('LOG.txt', 'r')
    oldNews = file.read();
    soup2 = soup.body.get_text()
    newNews = soup2.encode('utf-8')
    print(newNews)
    if(oldNews == newNews):
        time.sleep(3600)
        compare()
    else:
        msg = "\r\n".join([
        "From: pythonmegatron@gmail.com",
        "To: imspacedreamer@gmail.com",
        "Subject: " + newNews[:15] + " ",
        newNews,
        ""
        ])
        server = smtplib.SMTP('smtp.gmail.com:587')
        server.ehlo()
        server.starttls()
        server.login('pythonmegatron@gmail.com', psw)
        server.sendmail('pythonmegatron@gmail.com', 'imspacedreamer@gmail.com', msg)
        server.quit()
        time.sleep(3600)
        compare()

def saveAllNews():
    running = True
    while(running == True):
        fetchOldNews()

def deleteLogFile():
    os.remove('LOG.txt')

