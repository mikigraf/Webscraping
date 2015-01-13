import bs4,urllib2,BeautifulSoup

def walk():
    path = raw_input("Name of the file with list of www to walk trough: ")
    lookingFor = raw_input("What to look for: ")

    with open(path,'r') as f:
        for line in f:
            print(line)
            website = urllib2.urlopen(line).read()
            soup = BeautifulSoup(website)
            body = soup.body.get_text()
            if(lookingFor in soup):
                print(lookingFor + " found on" + line)




walk()
