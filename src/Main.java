import ecs100.*;
public class Main {
    public static final double gridSize = 500;
    public static final double startX = 100;
    public static final double startY = 100;
    public static Board BOARD = null;
    public void setupGUI(){
        UI.initialise();
        UI.setWindowSize(1000,800);
        MouseListener mouseListen = new MouseListener();
        UI.addButton("Start", this::start_game);
        UI.setMouseListener(mouseListen::mousePressed);
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.setupGUI();
    }

    public void start_game(){
        BOARD = new Board();
    }
}