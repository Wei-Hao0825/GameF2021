public class Hero extends Sprite {

//    static String[] directions = {"_up", "_dn", "_lt", "_rt", "_ul", "_ur", "_dl", "_dr"};
    static int[] directions = {0, 1, 2, 3, 4, 5, 6, 7};
    static String[] actions = {"_stand_", "_run_", "_attack_", "_skill_", "_hit_", "_death_"};
    static int[] counts = {4, 8, 7, 7, 3, 4};
    public Hero(int x, int y, String name) {
        super(x, y, name, directions, actions, "png", counts, 10);
    }
}
