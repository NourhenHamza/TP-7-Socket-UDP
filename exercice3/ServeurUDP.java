import java.net.*;
import java.util.Date;

public class ServeurUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(1250);

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);

                // Attente de la réception d'un datagramme
                socket.receive(receivedPacket);

                // Récupération de l'adresse et du port de l'émetteur
                InetAddress clientAddress = receivedPacket.getAddress();
                int clientPort = receivedPacket.getPort();

                // Création de la date et de l'heure courante
                String currentDate = new Date().toString();
                byte[] responseData = currentDate.getBytes();

                // Création d'un nouveau datagramme avec la date et l'heure courante
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);

                // Envoi du datagramme contenant la date et l'heure courante à l'émetteur
                socket.send(responsePacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
