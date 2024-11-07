import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        try(Socket socket = new Socket("localhost",1234)){

            System.out.println("Client is Listing");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            output.writeInt(5);
            int sq = input.readInt();
            System.out.println(sq);

        }
    }
}
