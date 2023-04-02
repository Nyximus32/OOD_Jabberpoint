package JabberPoint.Navigation;

import Constants.ButtonLbls;
import Constants.ErrorMsgs;
import Constants.FileInfo;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;

import javax.swing.*;

import JabberPoint.Presentation.Presentation;

public class ViewMenuBuilder implements ButtonLbls, ErrorMsgs, FileInfo {
    private final Presentation presentation;
    private final Frame frame;

    public ViewMenuBuilder(Presentation presentation, Frame frame) {
        this.presentation = presentation;
        this.frame = frame;
    }

    public Menu build() {
        Menu viewMenu = new Menu(VIEW);
        addNextMenu(viewMenu);
        addPreviousMenu(viewMenu);
        addGotoMenu(viewMenu);
        return viewMenu;
    }

    private void addNextMenu(Menu menu) {
        MenuItem menuItem = mkMenuItem(NEXT);
        menuItem.addActionListener(actionEvent -> {
            presentation.getSlideController().nextSlide();
            frame.repaint();
        });
        menu.add(menuItem);
    }

    private void addPreviousMenu(Menu menu) {
        MenuItem menuItem = mkMenuItem(PREV);
        menuItem.addActionListener(actionEvent -> {
            presentation.getSlideController().prevSlide();
            frame.repaint();
        });
        menu.add(menuItem);
    }

    private void addGotoMenu(Menu menu) {
        MenuItem menuItem = mkMenuItem(GOTO);
        menuItem.addActionListener(actionEvent -> {
            String pageNumberStr = JOptionPane.showInputDialog(PAGENR);
            int pageNumber = Integer.parseInt(pageNumberStr);
            presentation.getSlideController().setSlideNumber(pageNumber - 1);
        });
        menu.add(menuItem);
    }

    public MenuItem mkMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
