package JabberPoint.Navigation;

import Constants.ButtonLbls;
import Constants.ErrorMsgs;
import Constants.FileInfo;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;


import JabberPoint.AboutBox;

public class HelpMenuBuilder implements ButtonLbls, ErrorMsgs, FileInfo{
    private final Frame frame;

    public HelpMenuBuilder(Frame frame) {
        this.frame = frame;
    }

    public Menu build() {
        Menu helpMenu = new Menu(HELP);
        addAboutMenu(helpMenu);
        return helpMenu;
    }

    private void addAboutMenu(Menu menu) {
        MenuItem menuItem = mkMenuItem(ABOUT);
        menuItem.addActionListener(actionEvent -> AboutBox.show(frame));
        menu.add(menuItem);
    }

    public MenuItem mkMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
