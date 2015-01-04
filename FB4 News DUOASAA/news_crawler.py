import smtplib
import urlib2
from bs4 import BeautifulSoup

news = urlib2.urlopen('http://www.fh-dortmund.de/de/fb/4/aktuelles.php').read()
soup = BeautifulSoup(news)

def fetchNews():
    soup2 = soup.body.get_text();
    