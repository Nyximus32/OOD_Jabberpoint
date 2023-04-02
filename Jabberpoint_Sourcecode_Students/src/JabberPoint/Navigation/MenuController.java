package JabberPoint.Navigation;

import Constants.ButtonLbls;
import Constants.ErrorMsgs;
import Constants.FileInfo;
import JabberPoint.Presentation.Presentation;

import java.awt.MenuBar;
import java.awt.Frame;

/**
 * <p>The controller for the menu</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar implements ButtonLbls, ErrorMsgs, FileInfo {

    public MenuController(Frame frame, Presentation pres) {
        add(new FileMenuBuilder(pres, frame).build());
        add(new ViewMenuBuilder(pres, frame).build());
        add(new HelpMenuBuilder(frame).build());
    }
}
