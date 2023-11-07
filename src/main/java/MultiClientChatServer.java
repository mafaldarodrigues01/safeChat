import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;
import java.util.List;

public class MultiClientChatServer {
    private static List<PrintWriter> clientWriters = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Servidor aguardando conexões...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Novo cliente conectado.");

                // Cria uma nova thread para lidar com a conexão do cliente
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Adiciona um novo PrintWriter à lista de clientes
    public static synchronized void addClientWriter(PrintWriter writer) {
        clientWriters.add(writer);
    }

    // Remove um PrintWriter da lista de clientes
    public static synchronized void removeClientWriter(PrintWriter writer) {
        clientWriters.remove(writer);
    }

    // Envia uma mensagem para todos os clientes
    public static synchronized void broadcastMessage(String message) {
        for (PrintWriter writer : clientWriters) {
            writer.println(message);
        }
    }
}
