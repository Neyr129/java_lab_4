import java.io.*;
import java.net.*;
import java.awt.*;
import java.lang.*;

class Client extends Thread{ 
  private DataInputStream inputStream = null; 
  private Socket socket = null;
  private static int commonMoney = 0;

  public Client() throws IOException { 
    socket = new Socket("localhost", 2525); 
    inputStream = new DataInputStream( socket.getInputStream() ); // Socket reader
  }
  
  public void run(){ 
    while (true) {
      try { 
        String msg = inputStream.readLine();
        if( msg != null ) { 
          System.out.println(msg + " added to the Account"  );        
          commonMoney += Integer.parseInt(msg);
          ClientThread.jLabel.setText(String.valueOf(commonMoney));
          System.out.println( "account is: "+ commonMoney);        
        }
        else{
          break;
        }
      } 
      catch(Exception e){ System.out.println("ERRSOCK+"+e); }
    } 
  }

}
