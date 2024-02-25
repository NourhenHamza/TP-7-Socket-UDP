import java.io.*;
import java.net.*;

public class ClientVoitureUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getLocalHost();
            int serverPort = 1250;

            // Création d'un objet Voiture
            Voiture voiture = new Voiture("Sedan", "Toyota");

            // Envoi de l'objet Voiture au serveur
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutput out = new ObjectOutputStream(bos);
            out.writeObject(voiture);
            out.flush();
            byte[] data = bos.toByteArray();

            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, serverPort);
            socket.send(packet);

            // Réception de l'objet modifié du serveur
            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);

            // Conversion du tableau de bytes en objet Voiture
            ByteArrayInputStream bis = new ByteArrayInputStream(responsePacket.getData());
            ObjectInput in = new ObjectInputStream(bis);
            Voiture updatedVoiture = (Voiture) in.readObject();

            // Affichage des informations
            System.out.println("Voiture après mise à jour : " + updatedVoiture.getCarburant() + " litres de carburant");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
