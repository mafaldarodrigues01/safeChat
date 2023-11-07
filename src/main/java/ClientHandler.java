import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private PrintWriter writer;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(clientSocket.getInputStream());
            writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Adiciona o PrintWriter do cliente à lista
            MultiClientChatServer.addClientWriter(writer);

            while (true) {
                if (scanner.hasNextLine()) {
                    String clientMessage = scanner.nextLine();
                    System.out.println(clientMessage);

                    // Envie a mensagem para todos os clientes
                    MultiClientChatServer.broadcastMessage(clientMessage);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Remove o PrintWriter do cliente da lista quando desconectado
            MultiClientChatServer.removeClientWriter(writer);
        }
    }
}
