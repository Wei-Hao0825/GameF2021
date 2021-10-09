import java.awt.*;

public class Rect {
    int x;
    int y;

    int h;
    int w;

    public Rect(int x,int y,int h,int w) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
    }

    public void moveUp(int dy) {
        y -= dy;
    }
    public void moveDown(int dy) {
        y += dy;
    }

    public void moveLeft(int dx) {
        x -= dx;
    }

    public void moveRight(int dx) {
        x += dx;
    }

    public void draw(Graphics pen) {
        pen.drawRect(x,y,w,h);
    }
}
