import java.io.*;
import java.net.*;
import java.awt.*;
import java.lang.*;

// Client thread
class ClientThread extends Thread{ 
  private DataInputStream inputStream = null; 
  private Socket socket = null;
  private static int commonMoney = 0;

  public ClientThread() throws IOException { 
    socket = new Socket("localhost", Server.PORT ); 
    inputStream = new DataInputStream( socket.getInputStream() ); // Socket reader
  }
  
  // Thread start
  public void run(){ 
    while (true) {
      try { 
        String msg = inputStream.readLine();
        if( msg != null ) { 
          System.out.println(msg);        
          commonMoney += 1;
          System.out.println(commonMoney);        
        }
        else{
          break;
        }
      } 
      catch(Exception e){ System.out.println("ERRSOCK+"+e); }
    } 
  }

}
