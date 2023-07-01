import control.GameManager;
import core.editor.LevelEditor;
import core.editor.MapLoader;
import game.MarioLogic;
import game.util.loaders.Creator;
import persistence.*;


public class Driver {
    public static void main(String[] args) {
        Config.getInstance().setPath(args[0]);
        Persistence.getInstance().readUsers();
        /*MapLoader loader = new MapLoader(Config.getInstance().getProperty("DefaultMapsDir"));
        MarioLogic logic = new MarioLogic();
        LevelEditor.getInstance().init(loader, logic, new Creator());*/
        GameManager.getInstance().showWelcome();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Persistence.getInstance().saveUsers();
        }, "Shutdown-Hook"));
    }
}
