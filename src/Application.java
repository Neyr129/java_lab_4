import java.io.*;
import java.net.*;
import java.awt.*;
import java.lang.*;

// UI
public class Application extends Frame{ 
  
  public static final int FRAME_WIDTH  = 400;
  public static final int FRAME_HEIGHT = 400;
  private static Frame frame;

  public static void main(String args[]) {
    System.out.println("I'm alive!");
    init();
  }

  private static void init(){
    initFrame( FRAME_WIDTH, FRAME_HEIGHT );
    startServer();
  }

  private static void initFrame( int width, int height ){
    frame = new Application();
    frame.resize( width, height );
    frame.setLocationRelativeTo(null);
    frame.show();
  }

  private static void startServer(){
    new Server().start();
  }

  public boolean handleEvent(Event evt){
    if (evt.id==Event.WINDOW_DESTROY) {
      System.exit(0);
    }
    return super.handleEvent(evt);
  }

  public boolean mouseDown(Event evt,int x,int y){
    //Поток клиента порождается щелчком мыши 
    try{ new ClientThread().start(); } catch(Exception e){ System.out.println("ERRSOCK+"+e); }
    //в окне сервера
    return(true);
  }

}
