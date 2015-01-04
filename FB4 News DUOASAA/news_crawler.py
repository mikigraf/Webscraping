import smtplib
import urllib2
from bs4 import BeautifulSoup



def fetchNews():
    news = urllib2.urlopen('http://www.fh-dortmund.de/de/fb/4/isc/aktuelles/index.php?archive=1').read()
    soup = BeautifulSoup(news)
    file = open('LOG.txt','w')
    file.write(soup)
    file.close()
    print('fetched')


def compare():
    file = open('LOG.txt', 'r')
    oldNews = file.get_text();
    newNews = urllib2.urlopen('http://www.fh-dortmund.de/de/fb/4/isc/aktuelles/index.php?archive=1').read()
    soup = BeautifulSoup(newNews)
    if(oldNews == newNews ):
        fetchNews()
    else:
        return

fetchNews()
compare()