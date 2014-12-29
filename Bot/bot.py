import mechanize
import bs4
import requests

browser = mechanize.Browser()
website = 'http://sendfile.pl'

browser.open(website)
for f in browser.forms():
    print f