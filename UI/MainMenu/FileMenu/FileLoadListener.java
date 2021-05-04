package UI.MainMenu.FileMenu;

import IO.SimulationFile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileLoadListener implements ActionListener {
    private static FileLoadListener instance;

    private FileLoadListener() {

    }

    public static FileLoadListener getInstance() {
        if (instance == null) {
            synchronized (FileLoadListener.class) {
                if (instance == null) {
                    instance = new FileLoadListener();
                    return instance;
                }
            }
        }
        return instance;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setCurrentDirectory(new File("./data"));

        int response = fileChooser.showOpenDialog(null);

        if ( response == JFileChooser.APPROVE_OPTION ) {
            // use the SimulationFile class to build a map and send it on to the simulation panel
            SimulationFile creator = new SimulationFile(fileChooser.getSelectedFile().getAbsolutePath());
            // TODO: simulation panel integration
        }
    }
}
