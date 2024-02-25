import java.io.*;
import java.net.*;

public class ServeurVoitureUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(1250);

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                socket.receive(packet);

                // Conversion du tableau de bytes en objet Voiture
                ByteArrayInputStream bis = new ByteArrayInputStream(packet.getData());
                ObjectInput in = new ObjectInputStream(bis);
                Voiture voiture = (Voiture) in.readObject();

                // Modification de la quantité de carburant
                voiture.setCarburant(50);

                // Envoi de l'objet modifié au client
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutput out = new ObjectOutputStream(bos);
                out.writeObject(voiture);
                out.flush();
                byte[] response = bos.toByteArray();

                DatagramPacket responsePacket = new DatagramPacket(response, response.length, packet.getAddress(), packet.getPort());
                socket.send(responsePacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
