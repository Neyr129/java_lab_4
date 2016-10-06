
import java.io.*;
import java.net.*;
import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;

// UI
public class ClientThread extends JFrame{ 

  public static final int FRAME_WIDTH  = 400;
  public static final int FRAME_HEIGHT = 400;
  private static JFrame jFrame;

  public static JPanel jPanel;
  public static JButton jButton;
  public static JLabel jLabel;

  public static void main(String args[]) {
    System.out.println("Client is alive");
    SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        try{ 
          init();
        }
        catch(Exception exception){
          System.out.println(exception);
        };
      } 
    });
  };
  

  private static void init() throws IOException{
    initFrame( FRAME_WIDTH, FRAME_HEIGHT );
  }

  private static void initFrame( int width, int height ) throws IOException{
    jFrame = new ClientThread();
    jFrame.resize( width, height );
    jFrame.setLocationRelativeTo(null);
    jFrame.show();

    jPanel = new JPanel();
    jPanel.setBackground(Color.GRAY);

    jLabel=new JLabel("hi from client");
    jLabel.setBounds(100, 100, 220, 1);

    jButton=new JButton("Knock-knock");
    jButton.setBounds(100, 100, 220, 1);

    jFrame.add(jPanel);
    jPanel.add(jLabel);
    jPanel.add(jButton);

    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    jButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        try{ btnCLickHandler();}
        catch(Exception exception){ System.out.println(exception); };
      } 
    });
  }

  private static void startClient() throws IOException{
    new Client().start();
  }

  public static boolean btnCLickHandler(){
    try{ 
      startClient();
      Thread.sleep (1000);
    } catch(Exception e){ System.out.println("ERRSOCK+"+e); }
    //в окне сервера
    return(true);
  }

}
