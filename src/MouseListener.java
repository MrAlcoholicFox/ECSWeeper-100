import ecs100.UI;

public class MouseListener {
    public void mousePressed(String s, double x, double y){
        if (s.equals("pressed")){
            Main.BOARD.boardClick(x, y);
        }
    }


}
