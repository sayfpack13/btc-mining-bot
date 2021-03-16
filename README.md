# btc-mining-bot

A simple selenium java project for mining bitcoin online using free mining web services.

Installation:

for windows:
1) btc.jar + chromedriver.exe + accounts.txt in same folder 

for linux/ubuntu/debian:

1) btc_linux.jar + accounts.txt in same folder 


installation commands for chromedriver + java

2) sudo apt-get update
 
sudo apt-get install -y unzip xvfb libxi6 libgconf-2-4

sudo apt-get install default-jdk 

sudo curl -sS -o - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add

sudo echo "deb [arch=amd64]  http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list

sudo apt-get -y update

sudo apt-get -y install google-chrome-stable

wget https://chromedriver.storage.googleapis.com/2.41/chromedriver_linux64.zip

unzip chromedriver_linux64.zip

sudo mv chromedriver /usr/bin/chromedriver

sudo chown root:root /usr/bin/chromedriver

sudo chmod +x /usr/bin/chromedriver




=======================================================================================

Usage:

1) Create as many accounts as you can on this website:
https://app.stormgain.com/

2) Save all of your accounts and paste them into the main.java -> accounts variable or you can modify and import them from an external file

4) You can use cookies, which is not necessary because I only added them to bypass the cloudflare protection of other websites

6) Build the executable .JAR file and you're ready to go


=======================================================================================

Requirements:

1) selenium library (java):
https://selenium-release.storage.googleapis.com/3.141/selenium-java-3.141.59.zip

2) free/paid vps from azure/google/aws, you can google for free vps methods.... i will upload my own methods if you are interested :)

=======================================================================================

VARS:

accounts // accounts list

enable_cookies // use cookies ?

silent_mode // gui mode or silent mode

times // how many times repeat the same mining process

sleep //hours between mining process

max_attempts // if something wrong happened how many times we can try it again


=======================================================================================

imagine using only 1 account, how much you can earn per month:
you can earn 0.0247321428571429$ / hour
that means you can earn up to 4$ / week
and 16$ / month



what about creating and using 10 accounts ?

it's hard for me to calculate it but you......

give it a try.

