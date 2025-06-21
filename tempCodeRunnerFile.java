import java.util.Date;
import javax.swing.*;
import java.awt.*;         
import java.awt.event.*;
import java.text.SimpleDateFormat;
public class Main {
    public static void main(String[] args){
       MyWindow m1 = new MyWindow();
    }
}
class MyWindow extends JFrame{

    private JLabel heading;
    private JLabel clockLabel;
    private Font font = new Font("" , Font.BOLD , 35);

    MyWindow(){
        setTitle("My Clock");
        setSize(400 , 200);
        setLocation(300 , 50);
        this.createGui();
        this.startClock();
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
    }

    public void createGui(){
        heading = new JLabel("My Clock");
        clockLabel = new JLabel("clock");
        heading.setFont(font);
        clockLabel.setFont(font);
        this.setLayout(new GridLayout(2 , 1));
        this.add(heading);
        this.add(clockLabel);
        heading.setForeground(Color.WHITE);
        clockLabel.setForeground(Color.WHITE);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
    }

    public void startClock(){
        
        Thread t = new Thread(){
            public void run(){
            try{
                while(true){
                   Date d = new Date();
                   SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss a");
                   String dateTime = sdf.format(d);
                   SwingUtilities.invokeLater(() -> clockLabel.setText(dateTime));
                   Thread.currentThread().sleep(1000);
                }
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    };
        t.start();
    }
}
