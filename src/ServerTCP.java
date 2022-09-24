import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) {
        System.out.println("-------------------------------Server-------------------");
        ServerSocket socketServer = null;
        Socket socket = null;

        BufferedReader in = null;
        PrintWriter out = null;
        try{
            socketServer = new ServerSocket(5000);
            while (true){
                socket = socketServer.accept();
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);

                String str = in.readLine();
                System.out.println(str);
            }

        }catch (Exception e){

        }
    }
}
