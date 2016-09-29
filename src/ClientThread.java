import java.io.*;
import java.net.*;
import java.awt.*;
import java.lang.*;

// Client thread
class ClientThread extends Thread{ 
  private DataInputStream inputStream = null; 
  private Socket socket = null;

  public ClientThread() throws IOException { 
    socket = new Socket("localhost", Server.PORT ); 
    inputStream = new DataInputStream( socket.getInputStream() ); // Socket reader
  }
  
  // Thread start
  public void run(){ 
    while (true) {
      try { 
        String msg = inputStream.readLine();
        if( msg==null ) break;
        System.out.println(msg);        
      } 
      catch(Exception e){ 
        System.out.println("ERRSOCK+"+e); 
      }
    } 
  }

}
