import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(1234)){

            System.out.println("Sever is Listing");
            Socket socket = serverSocket.accept();
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            int n = input.readInt();
            int sqaure = n*n;
            output.writeInt(sqaure);
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
