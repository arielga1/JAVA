package UI.MainMenu.HelpMenu;

import javax.swing.*;

public class HelpMenu extends JMenu {
    JMenuBar bar;

    private JMenuItem helpItem, aboutItem;

    public HelpMenu(JMenuBar mainMenuBar) {
        super("Help");
        this.bar = mainMenuBar;
        fillHelpMenu();
    }

    private void fillHelpMenu() {
        this.helpItem = new JMenuItem("Help");
        this.add(this.helpItem);

        this.aboutItem = new JMenuItem("About");
        this.add(this.aboutItem);
    }

    public static void main(String [] args) {

    }
}
