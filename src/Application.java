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
  public static JButton jButton;
  public static JLabel jLabel;

  public static void main(String args[]) {
    System.out.println("I'm alive!");
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

    jButton = new JButton("Click Here to Begin!");
    jButton.setBounds(0, 0, 220, 30);

    jLabel=new JLabel(" qweqweqw ewqweq eqw");
    jLabel.setBounds(100, 100, 220, 1);

    jFrame.add(jPanel);
    jPanel.add(jLabel);
    jPanel.add(jButton);
    jPanel.add(jLabel);


    jButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        btnCLickHandler();
      };
    });


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


  public static boolean btnCLickHandler(){
    try{ 
      new ClientThread().start(); 
      Thread.sleep (1000);
      new ClientThread().start(); 
    } catch(Exception e){ System.out.println("ERRSOCK+"+e); }
    //в окне сервера
    return(true);
  }


}
