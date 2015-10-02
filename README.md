# open-crip

Open CRIP project (Connexion - Recherche - Inscription - Paiement)

# Lancer le projet

1.	Récupérer le projet
git clone https://github.com/alexandreghanem/open-crip.git

2.	Aller sur la branche develop et mettre à jour le repos
cd open-crip/
git checkout develop
git pull origin develop
NB : Vérifier toujours que vous êtes sur la bonne branche : ici c'est develop
HP6400@GHANEM-LAPTOP MINGW32 ~/open-crip (develop)

3.	Aller sur eclipse et faire un import existing maven project

4.	Build projet avec maven
Faites click droit sur pom.xml  puis run as maven build... ajouter clean install à Goals puis run
ou lancer la commande
```
$ cd github-maven-example/example
$ mvn clean install
```

5. Ajouter votre projet à Tomcat
