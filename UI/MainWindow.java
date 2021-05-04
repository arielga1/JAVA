package UI;

import UI.MainMenu.MainMenuBar;
import UI.SimulationPanel.SimulationPanel;

import javax.swing.*;

public class MainWindow extends JFrame {

    private MainMenuBar menuBar;
    private SimulationPanel simPanel;

    public MainWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(null);

        // menu
        this.menuBar = new MainMenuBar();
        this.setJMenuBar(this.menuBar);

        // simulation panel
        this.simPanel = new SimulationPanel();
        this.simPanel.setBounds(0, 0, 800, 500);

        this.add(this.simPanel);

        this.setVisible(true);
    }

    public static void main(String [] args) {
        MainWindow window = new MainWindow();
    }
}
