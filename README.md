# ProjectBank
Dit is de GitHub voor Project 3/4 2019/2020  
Hier komt de Arduino code en Java code op te staan die gebruikt gaat worden tijdens het Project 3/4

Pushen en pullen naar Git:  
=======

Pullen van Git:  
(Doe dit aan het begin van elke sessie / en voordat je commit, anders krijg je een merge wat je wilt voorkomen)  
git pull  

Pushen naar Git:  
   git add .  
   git commit -m "tekst"  
   git push  


Als je net een account heb aangemaakt, open Git Bash in een folder  
Eerste command:  git config --global user.email "VUL_IN"  
Tweede command:  git config --global user.name "VUL_IN"  

(Doe dit in de hoofdmap voor elke keer dat je een nieuwe REPO gaat gebruiken)  
git clone LINK_NAAR_REPO 

Als je elke keer moet inloggen kan je gebruik maken van een SSH-key  
Maak hem aan via:  
ssh-keygen -t rsa  
Je kopieert hem via:  
clip < ~/.ssh/id_rsa.pub  
Voeg de gekopieerde key toe aan:  
https://github.com/settings/keys  