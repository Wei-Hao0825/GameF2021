import java.awt.*;

public class Polygon
{
    int x;
    int y;

    int[] xPoints;
    int[] yPoints;

    public Polygon (int x, int y, int[] xPoints, int[] yPoints)
    {
        this.x = x;
        this.y = y;

        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }

    public void draw(Graphics pen)
    {
        int[] xs = new int[xPoints.length];
        int[] ys = new int[yPoints.length];
        for (int i = 0; i < xPoints.length; i++)
        {
            xs[i] = xPoints[i] + x;
            ys[i] = yPoints[i] + y;
        }
        pen.drawPolygon(xs, ys, xPoints.length);
    }

    public void moveLeft(int dx)
    {
        x -= dx;
    }

    public void moveRight(int dx)
    {
        x += dx;
    }

    public void moveUp(int dy)
    {
        y -= dy;
    }

    public void moveDown(int dy)
    {
        y += dy;
    }

    public void moveBy(int dx, int dy)
    {
        x += dx;
        y += dy;
    }
}
