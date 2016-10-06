import java.io.*;
import java.net.*;
import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;

// UI
public class Application extends JFrame{ 

  public static final int FRAME_WIDTH  = 400;
  public static final int FRAME_HEIGHT = 400;
  private static JFrame jFrame;

  public static JPanel jPanel;
  public static JLabel jLabel;

  public static void main(String args[]) {
    System.out.println("Server is alive");
    SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        init();
      } 
    });
  };
  

  private static void init(){
    initFrame( FRAME_WIDTH, FRAME_HEIGHT );
    startServer();
  }

  private static void initFrame( int width, int height ){
    jFrame = new Application();
    jFrame.resize( width, height );
    jFrame.setLocationRelativeTo(null);
    jFrame.show();

    jPanel = new JPanel();
    jPanel.setBackground(Color.GRAY);

    jLabel=new JLabel("hi from server");
    jLabel.setBounds(100, 100, 220, 1);

    jFrame.add(jPanel);
    jPanel.add(jLabel);

    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  public boolean handleEvent(Event evt){
    if (evt.id==Event.WINDOW_DESTROY) {
      System.exit(0);
    }
    return super.handleEvent(evt);
  }


  private static void startServer(){
    new Server().start();
  }

}
