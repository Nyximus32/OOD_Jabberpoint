package JabberPoint.Navigation;

import Constants.ButtonLbls;
import Constants.ErrorMsgs;
import Constants.FileInfo;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.io.IOException;

import javax.swing.*;

import JabberPoint.io.FileLoader;
import JabberPoint.io.FileSaver;
import JabberPoint.Presentation.Presentation;
import JabberPoint.io.XMLAccessor;

public class FileMenuBuilder implements ButtonLbls, FileInfo, ErrorMsgs {
    private final Presentation presentation;
    private final Frame frame;

    public FileMenuBuilder(Presentation presentation, Frame frame) {
        this.presentation = presentation;
        this.frame = frame;
    }
    public Menu build() {
        Menu fileMenu = new Menu(FILE);
        addOpenMenu(fileMenu);
        addNewMenu(fileMenu);
        addSaveMenu(fileMenu);
        addExitMenu(fileMenu);
        return fileMenu;
    }

    private void addOpenMenu(Menu menu) {
        MenuItem menuItem = mkMenuItem(OPEN);
        menuItem.addActionListener(actionEvent -> {
            presentation.getSlideController().clear();
            FileLoader XMLLoad = XMLAccessor.loadFile(TESTFILE);
            try {
                XMLLoad.loadFile(presentation, TESTFILE);
                presentation.getSlideController().setSlideNumber(0);
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(frame, IOEX + exc, LOADERR, JOptionPane.ERROR_MESSAGE);
            }
            frame.repaint();
        });
        menu.add(menuItem);
    }
    private void addNewMenu(Menu menu) {
        MenuItem menuItem = mkMenuItem(NEW);
        menuItem.addActionListener(actionEvent -> {
            presentation.getSlideController().clear();
            frame.repaint();
        });
        menu.add(menuItem);
    }
    private void addSaveMenu(Menu menu) {
        MenuItem menuItem = mkMenuItem(SAVE);
        menuItem.addActionListener(actionEvent -> {
            FileSaver XMLSave = XMLAccessor.saveFile(SAVEFILE);
            try {
                XMLSave.saveFile(presentation, TESTFILE);
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(frame, IOEX + exc, SAVEERR, JOptionPane.ERROR_MESSAGE);
            }
        });
        menu.add(menuItem);
    }
    private void addExitMenu(Menu menu) {
        MenuItem menuItem = mkMenuItem(EXIT);
        menuItem.addActionListener(actionEvent -> System.exit(0));
        menu.add(menuItem);
    }

    public MenuItem mkMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
