package UI.MainMenu.SimulationMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationMenu extends JMenu implements ActionListener {
    JMenuBar bar;

    private JMenuItem playItem, pauseItem, stopItem, setTicksPerDayItem;

    private boolean playing, started;

    public SimulationMenu(JMenuBar mainMenuBar) {
        super("Simulation");
        this.bar = mainMenuBar;
        this.playing = this.started = false;
        fillSimulationMenu();
    }

    private void fillSimulationMenu() {
        this.playItem = new JMenuItem("Play");
        this.playItem.addActionListener(this);
        this.playItem.addActionListener(SimulationListener.getInstance());
        this.add(this.playItem);

        this.pauseItem = new JMenuItem("Pause");
        this.pauseItem.addActionListener(this);
        this.pauseItem.addActionListener(SimulationListener.getInstance());
        this.add(this.pauseItem);

        this.stopItem = new JMenuItem("Stop");
        this.stopItem.addActionListener(this);
        this.stopItem.addActionListener(SimulationListener.getInstance());
        this.add(this.stopItem);

        this.addSeparator();

        this.setTicksPerDayItem = new JMenuItem("Set ticks per day");
        this.setTicksPerDayItem.addActionListener(this);
        this.setTicksPerDayItem.addActionListener(SimulationListener.getInstance());
        this.add(this.setTicksPerDayItem);
    }

    public static void main(String [] args) {

    }

    /**
     * Checks if the simulation is playing.
     * @return      True if yes, false otherwise.
     */
    public boolean isPlaying() { return this.playing; }


    /**
     * Checks if the simulation started.
     * @return      True if yes, false otherwise.
     */
    public boolean isStarted() { return this.started; }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.playItem) {
            // play button
            if (!this.started) {
                this.started = true;
            }
            if (!this.playing) {
                this.playing = true;
            }
        }
        else if (actionEvent.getSource() == this.pauseItem) {
            // pause button
            if (this.playing) {
                this.playing = false;
            }
        }
        else if (actionEvent.getSource() == this.stopItem) {
            // stop button
            if (this.started && this.playing) {
                this.started = false;
                this.playing = false;
            }
        }
        else if (actionEvent.getSource() == this.setTicksPerDayItem) {
            // set ticks button
        }
    }
}
