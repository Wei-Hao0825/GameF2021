import java.awt.*;

public class Sprite
{
    int x;
    int y;

    final int UP = 0;
    final int UR = 1;
    final int RT = 2;
    final int DR = 3;
    final int DN = 4;
    final int DL = 5;
    final int LT = 6;
    final int UL = 7;

    final int STAND = 0;
    final int RUN = 1;
    final int ATTACK = 2;
    final int SKILL = 3;
    final int HIT = 4;
    final int DEATH = 5;

    boolean moving = false;
    boolean attack = false;
    boolean skill = false;
//    boolean skill = false;
//    boolean hit = false;
//    boolean death = false;

    int direction = DN;
    int action = STAND;

    Animation[][] animation;

    public Sprite(int x, int y, String name, int[] directions, String[] actions, String fileType, int[] count, int delay) {

        this.x = x;
        this.y = y;

        animation = new Animation[directions.length][actions.length];

        for(int i = 0; i < animation.length; i++)
            for(int j = 0; j < actions.length; j++)
                    animation[i][j] = new Animation( name + directions[i] + actions[j], fileType, count[j], delay);
    }


    public void draw(Graphics pen) {
        if  (moving)
            pen.drawImage(animation[direction][RUN].currentImage(), x, y, null);
        else if (attack) {
            pen.drawImage(animation[direction][ATTACK].currentImage(), x, y, null);
        }
        else if (skill)
            pen.drawImage(animation[direction][SKILL].currentImage(), x, y, null);
//        if(hit)
//            pen.drawImage(animation[direction][HIT].currentImage(), x, y, null);
//        if(death)
//            pen.drawImage(animation[direction][DEATH].currentImage(), x, y, null);
        else
            pen.drawImage(animation[direction][STAND].currentImage(), x, y, null);
        moving = false;
        attack = false;
        skill = false;
    }



    public void moveUp(int dy) {
        moving = true;
        direction = UP;
        y -= dy;
    }
    public void moveUpRight(){
        moving = true;
        direction = UR;
//        x += dx;
//        y -= dy;
    }
    public void moveRight(int dx) {
        moving = true;
        direction = RT;
        x += dx;
    }
    public void moveDownRight() {
        moving = true;
        direction = DR;
//        x += dx;
//        y += dy;
    }
    public void moveDown(int dy) {
        moving = true;
        direction = DN;
        y += dy;
    }
    public void moveDownLeft() {
        moving = true;
        direction = DL;
//        x -= dx;
//        y += dy;
    }
    public void moveLeft(int dx) {
        moving = true;
        direction = LT;
        x -= dx;
    }

    public void moveUpLeft() {
        moving = true;
        direction = UL;
//        x -= dx;
//        y -= dy;
    }
    public void attack() {
        moving = false;
        attack = true;
        action = ATTACK;
    }
    public void skill() {
        moving = false;
        skill = true;
        action = SKILL;
    }
    public void hit() {
        moving = false;
        action = HIT;
    }
    public void death() {
        moving = false;
        action = DEATH;
    }
}
