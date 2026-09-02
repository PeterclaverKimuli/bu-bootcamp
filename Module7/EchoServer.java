
// A minimal TCP server that accepts one connection and echoes back what it receives 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        // Bind to port 9000 and wait for a connection
        ServerSocket server = new ServerSocket(9000);
        System.out.println("Waiting for connection on port 9000");

        Socket client = server.accept(); // blocks until a client connects
        System.out.println("Client connected: " + client.getInetAddress());

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println("Received: " + line);
            out.println("Echo: " + line); // send it back
        }

        client.close();
        server.close();
    }
}
