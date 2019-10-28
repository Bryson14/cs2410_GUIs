package inClass.chatroom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatBotClient {
    public static void main(String[] args) throws Exception {
        BufferedWriter wr;
        BufferedReader rd;
        Scanner scan;
        Socket sck;
        String response, send;

        sck = new Socket("144.39.205.68", 5555);
        rd = new BufferedReader(new InputStreamReader(sck.getInputStream()));
        wr = new BufferedWriter(new OutputStreamWriter(sck.getOutputStream()));
        scan = new Scanner(System.in);

        while(true) {
            System.out.print("> ");
            send = scan.nextLine();
            wr.write(send + "\r\n");
            wr.flush();
            response = rd.readLine().trim();
            System.out.println("From Server: " + response);

        }

    }
}
