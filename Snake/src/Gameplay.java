import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;


public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private int[] snakexlength = new int [750];
    private int[] snakeylength = new int [750];


    private boolean left =false;
    private boolean right =false;
    private boolean up =false;
    private boolean down =false;

    private ImageIcon rightmouth;
    private ImageIcon leftmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;

    private int lengthofsnake = 3;

    private Timer timer;
    private int delay = 100;

    private ImageIcon snakeimage;
    private int moves = 0;

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
        if(moves==0)
        {
            snakexlength[2] = 50;
            snakexlength[1] = 75;
            snakexlength[0] = 100;

            snakeylength[2] = 100;
            snakeylength[1] = 100;
            snakeylength[0] = 100;

        }
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

        rightmouth = new ImageIcon("rightmouth.png");
        rightmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);

        for (int a=0; a< lengthofsnake;a++)
        {
            if(a==0 && right)
            {
                rightmouth = new ImageIcon("rightmouth.png");
                rightmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
            }

            if(a==0 && left)
            {
                leftmouth = new ImageIcon("leftmouth.png");
                leftmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
            }

            if(a==0 && down)
            {
                downmouth = new ImageIcon("downmouth.png");
                downmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
            }

            if(a==0 && up)
            {
                upmouth = new ImageIcon("upmouth.png");
                upmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
            }
            if(a!=0)
            {
                snakeimage = new ImageIcon("snakeimage.png");
                snakeimage.paintIcon(this,g,snakexlength[a],snakeylength[a]);
            }
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (right)
        {
            for (int r = lengthofsnake -1; r>=0;r--)
            {
                snakeylength[r+1] =snakeylength[r];
            }

            for (int r = lengthofsnake; r>=0; r--)
            {
                if (r == 0)
                {
                    snakexlength[r] =snakexlength[r] +25;
                }
                else
                {
                    snakexlength[r] = snakexlength[r-1];
                }
                if(snakexlength[r] > 850)
                {
                    snakexlength[r] = 25;
                }
            }
            repaint();
            }
        }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            moves++;
            right = true;
            if (!left)
            {
                right = true;
            }
            else
            {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            moves++;
            left = true;
            if (!right)
            {
                left = true;
            }
            else
            {
                left = false;
                right = true;
            }
            up = false;
            down = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            moves++;
            up = true;
            if (!down)
            {
                up = true;
            }
            else
            {
                up = false;
                down = true;
            }
            right = false;
            left = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            moves++;
            down = true;
            if (!up)
            {
                down = true;
            }
            else
            {
                down = false;
                up = true;
            }
            right = false;
            left = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
