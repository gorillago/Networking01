import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Networking01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter a hostname: ");
            String hostname = scanner.next();
            System.out.println("Please enter a port: ");
            String portString = scanner.next();
            int port = Integer.parseInt(portString);

            Socket socket = new Socket(hostname, port);
            String connection = socket.getInetAddress().toString();
            String connectionPort = Integer.toString(socket.getPort());
            String localAddress = socket.getLocalAddress().toString();
            String localPort = Integer.toString(socket.getLocalPort());

            System.out.printf("Connection to: %s\nPort Number: %s\nLocal Address: %s\nLocal Port: %s\n",
                    connection, port, localAddress, localPort);

        } catch (IOException e) {
            System.out.println("Failed to resolve hostname.");
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("Not a valid port.");
            System.exit(1);
        }
    }
}
