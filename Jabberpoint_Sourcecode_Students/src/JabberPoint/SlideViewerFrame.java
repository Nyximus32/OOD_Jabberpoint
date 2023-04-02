package JabberPoint;

import Constants.FileInfo;
import Constants.SlideDesign;
import JabberPoint.Navigation.KeyController;
import JabberPoint.Navigation.MenuController;
import JabberPoint.Presentation.Presentation;
import JabberPoint.Presentation.SlideViewerComponent;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;

/**
 * <p>The applicatiewindow for a slideviewcomponent</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideViewerFrame extends JFrame implements SlideDesign, FileInfo {

    public SlideViewerFrame(String title, SlideViewerComponent slideViewerComponent) {
        super(title);
        setupWindow(slideViewerComponent);
    }

    //Set up the GUI
    public void setupWindow(SlideViewerComponent slideViewerComponent) {
        Presentation presentation = slideViewerComponent.getPresentation();
        setTitle(JABTITLE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        getContentPane().add(slideViewerComponent);
            addKeyListener(new KeyController(presentation)); //Add a controller
            setMenuBar(new MenuController(this, presentation));    //Add another controller
        setSize(new Dimension(SLIDEWIDTH, SLIDHEIGHT)); //Same sizes a slide has
        setVisible(true);
    }
}
