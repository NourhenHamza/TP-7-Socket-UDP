# TP-7-Socket-UDP
# Serveur UDP - Exercices de Sockets en Java

 
## Exercice 2 - Échange d'Objets Voiture

- Le client crée un objet Voiture et l'envoie au serveur.
- Le serveur reçoit l'objet Voiture, fixe la quantité de carburant avec la méthode `setCarburant()`, puis renvoie l'objet modifié au client.

### Utilisation

1. Compiler le serveur UDP: `javac ServeurUDP.java`
2. Compiler le client Voiture: `javac ClientVoitureUDP.java`
3. Exécuter le serveur: `java ServeurUDP`
4. Exécuter le client Voiture: `java ClientVoitureUDP`

## Exercice 3 - Envoi de la Date et de l'Heure Courante

- Le serveur répond à chaque datagramme reçu (quel que soit leur contenu) en renvoyant un datagramme contenant la date et l'heure courante.

### Utilisation

1. Compiler le serveur UDP: `javac ServeurUDP.java`
2. Compiler le client Date: `javac ClientDateUDP.java`
3. Exécuter le serveur: `java ServeurUDP`
4. Exécuter le client Date: `java ClientDateUDP`
