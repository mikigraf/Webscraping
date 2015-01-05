import smtplib
import datetime


def sendEmail(From,To,Subject,Msg,Usrname,Psw,Srv):
    #convert types into strings | it does actually nothing, if the parameters are already in form of strings
    From = str(From)
    To = str(To)
    Subject = str(Subject)
    Msg = str(Msg)
    Usrname = str(Usrname)
    Psw = str(Psw)
    Srv = str(Srv)

    message = "\r\n".join(["From: " + From,"To: " + To, "Subject: " + Subject, ""])

    server = smtplib.SMTP(Srv)
    server.ehlo()
    server.starttls()
    server.login(Usrname,Psw)
    server.sendmail(From,To,message)
    server.quit()


