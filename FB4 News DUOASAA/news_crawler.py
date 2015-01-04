import smtplib
import urllib2
from bs4 import BeautifulSoup



def fetchNews():
    news = urllib2.urlopen('http://www.fh-dortmund.de/de/fb/4/aktuelles.php').read()
    soup = BeautifulSoup(news)
    soup2 = soup.body.get_text();
    print(soup2)


fetchNews()