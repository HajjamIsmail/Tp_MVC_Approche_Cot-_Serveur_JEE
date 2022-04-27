#Introduction
Le But de ce Tp est de mettre en pratique L'architecture MVC en utilisant **Spring Web**, **Spring Security**, **JPA** et **thymeleaf** en utilisant biensur l'approche rendu coté serveur.
#Concept Générale :
##Architecture JEE :
Il existe 2 type de composant :
###Servlet :
>C'est une class java a pour but d'effectuer des traitement coté serveur (Controller).   
>Il recoit la requet http et utilisent l'objet request qui permet de lire les requettes http.
###JSP :
>JSP = Java Server Pages (View).           
>Génére le code HTML, il recupère le résultat dans le model.

Dans une application web il existe 2 approche :
###Approche rendu serveur :
- le client recoit le HTML(JSP)
###Approche rendu client :
- le client recoit le JSON
- JSON vers HTML
- pour faire cela il faut utiliser des framework comme angular, react, ...
- dans cette approche on a pas besoin de model et de JSP(HTML)
#Pratique :
Dans cette Activité pratiqué nous allons mettre en oeuvre tous ces notions :
###Architecture du projet :
![](D:\EMSI\4em Année\S8\4-JEE\1-Classe\3-TP\Tp4\img\1.png)
###Model :
![](D:\EMSI\4em Année\S8\4-JEE\1-Classe\3-TP\Tp4\img\DiagrameDeClasse.png)
###Entities :
![](D:\EMSI\4em Année\S8\4-JEE\1-Classe\3-TP\Tp4\img\2.png)
###POM.XML :
Après définitions des models. il faut vérifier dans le fichier xml les dépendences suivantes :
-Ajouter les dépendance du Bootstrap :
>        <dependency>
>            <groupId>org.webjars</groupId>
>            <artifactId>bootstrap</artifactId>
>            <version>5.1.3</version>
>        </dependency>

- Ajouter les dépendances thymeleaf :
>       <dependency>
>           <groupId>nz.net.ultraq.thymeleaf</groupId>
>           <artifactId>thymeleaf-layout-dialect</artifactId>
>        </dependency>

- Ajouter les dépendances des validations :
>       <dependency>
>           <groupId>org.springframework.boot</groupId>
>           <artifactId>spring-boot-starter-validation</artifactId>
>       </dependency>
###application.properties :
Dans ce fichier en mets notre configuration :
- Définir le port
- Définir le url de la base de données(h2-database/mysql)
>Vous trouverez les configurations des 2 database (h2/mysql), on cas ou vous voulez migrez en une autre base de donnée
###Package java/com.example.tp4.repositories :
on a définit ici notre entité JPA pour faire le traitement des données
- **MedecinRepository** : est dédié pour l'entité Medecin
- **PatientRepository** : est dédié pour l'entité Patient
###Package java/come.example.tp4.sec :
Ce package on a définit notre sécurité de l'application (Gestion des roles) :   
Dans la partie sécurité il existe 3 principes de sécurité :
* inMemoryAuthentication
* jdbc Authentication 
* userDetailsService

Dans notre tp j'ai travaillé sur les 3 mais la plus recommendé est **userDetailsService**
>Vous trouverez la démonstration dans la class **SecurityConfig**

###Package java/com.example.tp4.web :
Dans ce package on a définit nos controller :
>**MedecinController** : pour le traitement de l'entité Medecin
>**PatientController** : pour le traitement de l'entité Patient
>**SecurityController** : cette class à pour but de faire une redirection vers une page qui affiche '403' c-à-d en cas de fraudement d'autorisation !

###ressource/template :
Cette partie est dédié pour les vues(Views).

#Conclusion :
Ce tp a pour but de mettre en pratiques 2 notions principaux :
- Faire une application native (Approche coté serveur)
- Faire la securité de l'application en pratiquant 3 principe : **inMemoryAuthentication**, **jdbc Authentication**, **userDetailsService**








