package UI.MainMenu.SimulationMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationListener implements ActionListener {
    private static SimulationListener instance;

    private SimulationListener() {

    }

    public static SimulationListener getInstance() {
        if (instance == null)
            synchronized (SimulationListener.class) {
                if (instance == null) {
                    instance = new SimulationListener();
                }
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
