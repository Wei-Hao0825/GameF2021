import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Main extends Applet implements Runnable, KeyListener
{
    // Set the default key pressed values
    boolean pressed_UP = false;
    boolean pressed_DN = false;
    boolean pressed_LT = false;
    boolean pressed_RT = false;

    // ATTACK, SKILL
    boolean pressed_ATTACK = false;
    boolean pressed_F1 = false;

    // Initialize UP, DOWN, LEFT, RIGHT arrow key codes
    final static int UP = KeyEvent.VK_UP;
    final static int DN = KeyEvent.VK_DOWN;
    final static int LT = KeyEvent.VK_LEFT;
    final static int RT = KeyEvent.VK_RIGHT;
    final static int A  = KeyEvent.VK_A;
    final static int F1 = KeyEvent.VK_F1;

    // Animation instance
    Hero actor = new Hero(100, 100, "tianmo_nv/");
    public void paint(Graphics pen)
    {

        actor.draw(pen);

    }

    @Override
    public void init()
    {
        //super.init();
        Thread t = new Thread(this);
        t.start();

        addKeyListener(this);
        requestFocus();
    }

    @Override
    public void run()
    {
        while(true)
        {
            if(pressed_UP)
            {
                actor.moveUp(3);
            }
            if(pressed_DN)
            {
                actor.moveDown(3);
            }
            if(pressed_LT)
            {
                actor.moveLeft(3);
            }
            if(pressed_RT)
            {
                actor.moveRight(3);
            }

            if(pressed_UP && pressed_LT)
            {
                actor.moveUpLeft();
            }
            if(pressed_UP && pressed_RT)
            {
                actor.moveUpRight();
            }
            if(pressed_DN && pressed_LT)
            {
                actor.moveDownLeft();
            }
            if(pressed_DN && pressed_RT)
            {
                actor.moveDownRight();
            }


            if(pressed_ATTACK)
            {
                actor.attack();
            }
            if(pressed_F1)
            {
                actor.skill();
            }
            //r1.moveLeft(1);
            repaint();
            try
            {
                Thread.sleep(15);
            } catch (Exception e){}
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int code = e.getKeyCode();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == UP) pressed_UP     = true;
        if (code == DN) pressed_DN     = true;
        if (code == LT) pressed_LT     = true;
        if (code == RT) pressed_RT     = true;
        if (code == A)  pressed_ATTACK = true;
        if (code == F1) pressed_F1     = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == UP) pressed_UP     = false;
        if (code == DN) pressed_DN     = false;
        if (code == LT) pressed_LT     = false;
        if (code == RT) pressed_RT     = false;
        if (code == A)  pressed_ATTACK = false;
        if (code == F1) pressed_F1     = false;
    }


}
