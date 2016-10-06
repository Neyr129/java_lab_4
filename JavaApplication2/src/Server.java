import java.io.*;
import java.net.*;
import java.awt.*;
import java.lang.*;


class Server extends Thread{ 
  public static final int PORT = 2525;
  private static Socket socket;
  private static PrintStream printStream;
  private static int amount = 200;
  
  // Thread start
  @Override
  public void run(){
    try  {
      listenPort( PORT );
    } catch(Exception e) { System.out.println("ERRSOCK+"+e); }
  }

  private static void listenPort( int port ) throws IOException, Exception{
    ServerSocket serverSocket = new ServerSocket( port ); // port listener
    while( true  ){  
      socket = serverSocket.accept(); // recieve client's Socket object
      processRequest( socket );
      socket.close(); // close connection
    }
  }

  private static void processRequest( Socket socket ) throws IOException{
    printStream= new PrintStream(socket.getOutputStream());
    int money =  getMoney();
    printStream.println( Integer.toString( money ) );
    Application.jLabel.setText("sent " + String.valueOf(money) + " money");
    printStream.flush(); // push to socket
  }

  private static int getMoney(){
    return ((int)(Math.random()*1000));
  }
}


