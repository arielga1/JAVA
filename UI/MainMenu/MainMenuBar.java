package UI.MainMenu;

import UI.MainMenu.FileMenu.FileMenu;
import UI.MainMenu.HelpMenu.HelpMenu;
import UI.MainMenu.SimulationMenu.SimulationMenu;

import javax.swing.*;

public class MainMenuBar extends JMenuBar {
    private JMenu fileMenu, simulationMenu, helpMenu;

    public MainMenuBar() {
        fillMenuBar();
    }

    private void fillMenuBar() {
        // files menu
        this.fileMenu = new FileMenu(this);
        this.add(this.fileMenu);

        // Simulation menu
        this.simulationMenu = new SimulationMenu(this);
        this.add(this.simulationMenu);

        // help menu
        this.helpMenu = new HelpMenu(this);
        this.add(this.helpMenu);
    }

    public static void main(String [] args) {

    }
}
