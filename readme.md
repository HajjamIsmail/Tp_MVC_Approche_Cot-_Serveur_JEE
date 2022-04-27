<h1>Introduction</h1>
Le But de ce Tp est de mettre en pratique L'architecture MVC en utilisant **Spring Web**, **Spring Security**, **JPA** et **thymeleaf** en utilisant biensur l'approche rendu coté serveur.
<h1>Concept Générale :</h1>
<h3>Architecture JEE :</h3>
Il existe 2 type de composant :
<h3>Servlet :</h3>
>C'est une class java a pour but d'effectuer des traitement coté serveur (Controller).   
>Il recoit la requet http et utilisent l'objet request qui permet de lire les requettes http.
<h3>JSP :</h3>
>JSP = Java Server Pages (View).           
>Génére le code HTML, il recupère le résultat dans le model.

Dans une application web il existe 2 approche :
<h3>Approche rendu serveur :</h3>
- le client recoit le HTML(JSP)
<h3>Approche rendu client :</h3>
- le client recoit le JSON
- JSON vers HTML
- pour faire cela il faut utiliser des framework comme angular, react, ...
- dans cette approche on a pas besoin de model et de JSP(HTML)
<h1>Pratique :</h1>
Dans cette Activité pratiqué nous allons mettre en oeuvre tous ces notions :
<h3>Architecture du projet :</h3>
<img src="D:\EMSI\4em Année\S8\4-JEE\1-Classe\3-TP\Tp4\img\1.png"/>
<h3>Model :</h3>
<img src="D:\EMSI\4em Année\S8\4-JEE\1-Classe\3-TP\Tp4\img\DiagrameDeClasse.png"/>
<h3>Entities :</h3>
<img src="D:\EMSI\4em Année\S8\4-JEE\1-Classe\3-TP\Tp4\img\2.png">
<h3>POM.XML :</h3>
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
<h3>application.properties :<h3/>
Dans ce fichier en mets notre configuration :
- Définir le port
- Définir le url de la base de données(h2-database/mysql)

>Vous trouverez les configurations des 2 database (h2/mysql), on cas ou vous voulez migrez en une autre base de donnée
 
<h3>Package java/com.example.tp4.repositories :</h3>
on a définit ici notre entité JPA pour faire le traitement des données
- **MedecinRepository** : est dédié pour l'entité Medecin
- **PatientRepository** : est dédié pour l'entité Patient
<h3>Package java/come.example.tp4.sec :</h3>
Ce package on a définit notre sécurité de l'application (Gestion des roles) :   
Dans la partie sécurité il existe 3 principes de sécurité :
* inMemoryAuthentication
* jdbc Authentication 
* userDetailsService

Dans notre tp j'ai travaillé sur les 3 mais la plus recommendé est **userDetailsService**

>Vous trouverez la démonstration dans la class **SecurityConfig**

<h3>Package java/com.example.tp4.web :</h3>
Dans ce package on a définit nos controller :

>**MedecinController** : pour le traitement de l'entité Medecin
>**PatientController** : pour le traitement de l'entité Patient
>**SecurityController** : cette class à pour but de faire une redirection vers une page qui affiche '403' c-à-d en cas de fraudement d'autorisation !

<h3>ressource/template :</h3>
Cette partie est dédié pour les vues(Views).

<h1>Conclusion :</h1>
Ce tp a pour but de mettre en pratiques 2 notions principaux :
- Faire une application native (Approche coté serveur)
- Faire la securité de l'application en pratiquant 3 principe : **inMemoryAuthentication**, **jdbc Authentication**, **userDetailsService**








