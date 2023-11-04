package org.example;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class ChatClient {

    public static class ChatClientMain {
        public static void main(String[] args) {
            ChatClient chatClient = new ChatClient();
            chatClient.startClient("Mafalda");
        }
    }


    public void startClient(String username) {
        try {
            Socket socket = new Socket("localhost", 5000);

            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            Scanner consoleScanner = new Scanner(System.in);

            // Thread para receber mensagens do servidor
            Thread receiveThread = new Thread(() -> {
                while (true) {
                    if (scanner.hasNextLine()) {
                        String serverMessage = scanner.nextLine();
                        System.out.println("Servidor: " + serverMessage);
                    }
                }
            });
            receiveThread.start();

            // Thread para enviar mensagens para o servidor
            Thread sendThread = new Thread(() -> {
                while (true) {
                    String clientMessage = consoleScanner.nextLine();
                    writer.println(username+": "+clientMessage);
                    // Adicionamos esta linha para esperar que o usuário pressione "Enter"
                    if (clientMessage.equals("")) {
                        System.out.println("Pressione Enter para enviar a mensagem.");
                    }
                }
            });
            sendThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
