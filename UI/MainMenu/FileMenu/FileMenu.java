package UI.MainMenu.FileMenu;

import javax.swing.*;

public class FileMenu extends JMenu {
    JMenuBar bar;

    private JMenuItem loadItem, statisticsItem, editMutationsItem, exitItem;

    public FileMenu(JMenuBar bar) {
        super("File");
        this.bar = bar;
        fillFileMenu();
    }

    private void fillFileMenu() {
        this.loadItem = new JMenuItem("Load");
        this.loadItem.addActionListener(FileLoadListener.getInstance());
        this.add(this.loadItem);

        this.statisticsItem = new JMenuItem("Statistics");
        this.add(this.statisticsItem);

        this.editMutationsItem = new JMenuItem("Edit Mutations");
        this.add(this.editMutationsItem);

        this.addSeparator();

        this.exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(event -> System.exit(0));
        this.add(this.exitItem);
    }
}
