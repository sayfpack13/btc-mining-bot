# btc-mining-bot

A simple selenium java project for mining bitcoin online using free mining web services.

# Installation:

# for windows
1) btc.jar + chromedriver.exe + accounts.txt in same folder 

# for debian...

1) btc_linux.jar + accounts.txt in same folder 


2)
sudo apt-get update

sudo apt install libnss3-dev libgdk-pixbuf2.0-dev libgtk-3-dev libxss-dev

sudo apt upgrade

sudo mkdir /usr/java

cd /usr/java

wget https://download.java.net/openjdk/jdk14/ri/openjdk-14+36_linux-x64_bin.tar.gz

sudo tar -xzvf openjdk-14+36_linux-x64_bin.tar.gz

sudo nano /etc/profile


# OpenJDK 14

JAVA_HOME=/usr/java/jdk-14

PATH=$PATH:$HOME/bin:$JAVA_HOME/bin

export JAVA_HOME

export PATH

sudo update-alternatives --install "/usr/bin/java" "java" "/usr/java/jdk-14/bin/java" 1

sudo update-alternatives --install "/usr/bin/javac" "javac" "/usr/java/jdk-14/bin/javac" 1

3)
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb

sudo dpkg -i google-chrome-stable_current_amd64.deb

sudo apt install google-chrome-stable

apt-get -f install

sudo apt-get install -y xvfb

sudo apt-get -y install xorg xvfb gtk2-engines-pixbuf

sudo apt-get -y install dbus-x11 xfonts-base xfonts-100dpi xfonts-75dpi xfonts-cyrillic xfonts-scalable

sudo apt-get -y install imagemagick x11-apps



4)
wget https://chromedriver.storage.googleapis.com/90.0.4430.24/chromedriver_linux64.zip

unzip chromedriver_linux64.zip

sudo mv chromedriver /usr/bin/chromedriver

sudo chown root:root /usr/bin/chromedriver

sudo chmod +x /usr/bin/chromedriver




=======================================================================================

# Usage:

1) Create as many accounts as you can on this website:
https://app.stormgain.com/

2) Save all of your accounts and paste them into the main.java -> accounts variable or you can modify and import them from an external file

4) You can use cookies, which is not necessary because I only added them to bypass the cloudflare protection of other websites

6) Build the executable .JAR file and you're ready to go


=======================================================================================

# Requirements

1) selenium library (java):
https://selenium-release.storage.googleapis.com/3.141/selenium-java-3.141.59.zip

2) free/paid vps from azure/google/aws, you can google for free vps methods.... i will upload my own methods if you are interested :)

=======================================================================================

# VARS:

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

