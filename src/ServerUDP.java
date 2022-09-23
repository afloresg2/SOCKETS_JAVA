import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerUDP {
    public static void main(String[] args) {

        try{
            DatagramSocket socketServer = new DatagramSocket(7777);
            byte bufer[] = new byte[50];

            while (true){
                DatagramPacket reception = new DatagramPacket(bufer,bufer.length);
                socketServer.receive(reception);

                String response = new String(reception.getData());

                response.toUpperCase();
                System.out.println(response);
                byte[] sendEcho = response.getBytes();
                DatagramPacket echo = new DatagramPacket(sendEcho,response.length(),reception.getAddress(),reception.getPort());
                socketServer.send(echo);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
