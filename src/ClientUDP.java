import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDP {
    public static void main(String[] args) {
        System.out.println("-----------CLIENT-------------------");

        try{
            DatagramSocket socketClient = new DatagramSocket();
            int port = 7777;
            InetAddress host = InetAddress.getByName("localhost");

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String str = keyboard.readLine();
            byte[] messageToSend = str.getBytes();

            DatagramPacket request = new DatagramPacket(messageToSend,str.length(),host,port);
            socketClient.send(request);
            byte bufer[] = new byte[50];
            DatagramPacket reception = new DatagramPacket(bufer,bufer.length);
            socketClient.receive(reception);
            System.out.println("Server Response :"+ new String(reception.getData()));


        }catch (Exception e){
            System.out.println(e);
        }

    }
}
