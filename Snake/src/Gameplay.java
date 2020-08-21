import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;


public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private int[] snakeXlength = new int [750];
    private int[] snakeYlength = new int [750];


    private boolean left =false;
    private boolean right =false;
    private boolean up =false;
    private boolean down =false;

    private ImageIcon rightmouth;
    private ImageIcon leftmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;

    private Timer timer;
    private int delay = 100;

    private ImageIcon snakeimage;


    private ImageIcon titleImage;

     public Gameplay()
     {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();

     }
    public void paint(Graphics g)
    {
        //draw title image border
        g.setColor(Color.white);
        g.drawRect(24, 10,851,55);

        //draw title image
        titleImage = new ImageIcon("snaketitle.jpg");
        titleImage.paintIcon(this, g,25, 11);

        //draw border for gameplay
        g.setColor(Color.WHITE);
        g.drawRect(24,73,851,577);

        //draw background for the gameplay
        g.setColor(Color.BLACK);
        g.fillRect(25, 75,850,575);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
