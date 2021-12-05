Application client/serveur SOAP

Fonctionnalités principales :
- Recherche des chambres disponibles dans l'hotel selon des critères bien défini
- Reservation d'une chambres si disponible, avec la possibilité d'avoir une réduction selon l'agence.

Structure :
reservation-back-web : contient les services SOAP 
reservation-views : contient la couche présentation. Une intérface graphique pour faciliter la réservation

Installation:
- Allez dans le module back-web puis lancer la ligne de commande
- mvn clean install
- démarrer le serveur avec Spring boot :
- mvn spring-boot:run

- Allez dans le module views:
- mvn clean install
- mvn spring-boot:run

Enjoy