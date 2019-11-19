package connection;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FileMessage;
import model.UserMessage;

public class FileFetch {

    private final int port;

    private final UserMessageSocket userMessageSocket = new UserMessageSocket();

    private final FileMessageSocket fileMessageSocket = new FileMessageSocket();

    public FileFetch(Ports port) {
        this.port = port.getValue();
    }

    public void run(UserMessage um) {
        try {
            while (true) {
                // send user to SG
                Socket socket = new Socket("localhost", port);
                userMessageSocket.sendUserMessage(socket, um);
                System.out.println(um.toString());

                socket.close();

                // get file messages from SG
                Socket socketToSG = new Socket("localhost", Ports.FETCH.getValue());
                ArrayList<FileMessage> fileMessages = fileMessageSocket.receiveFileMessageList(socket);
                socketToSG.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileUpload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileUpload.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}