import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;  

public class HTTPdisplaydate {
  public static void main(String[] args) throws Exception {
    final ServerSocket server = new ServerSocket(8080);
    System.out.println("Listening for connection on port 8080 .... ");

    while (true) {
        try (Socket client = server.accept()) {
            Date now = new Date();
            String httpResponse = "HTTP/1.1 200 OK  \r\n\r\n" + now;
            client.getOutputStream().write(httpResponse.getBytes("UTF-8"));
        }  
    }
    
  }
}
