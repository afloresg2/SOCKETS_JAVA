import java.io.*;
import java.net.Socket;

public class ClientTCP {
    public static void main(String[] args) {
        System.out.println("-------------------Client--------------------------");
        Socket socketClient = null;
        BufferedReader in = null;
        PrintWriter out = null;
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        try{
            socketClient = new Socket("localhost",5000);
            in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream())),true);

            String str = keyboard.readLine();
            out.print(str);

            out.close();
            in.close();
            keyboard.close();
            socketClient.close();

        }catch (Exception e){

        }
    }
}
