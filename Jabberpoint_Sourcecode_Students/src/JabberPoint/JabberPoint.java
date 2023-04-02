package JabberPoint;

import Constants.ErrorMsgs;
import Constants.FileInfo;
import JabberPoint.Presentation.SlideViewerComponent;
import JabberPoint.Presentation.StyleMaker;
import JabberPoint.io.FileLoader;
import JabberPoint.io.XMLAccessor;

import javax.swing.*;
import java.io.IOException;

/**
 * JabberPoint.JabberPoint Main Program
 * <p>This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class JabberPoint implements FileInfo, ErrorMsgs {
    /**
     * The main program
     */
    public static void main(String[] argv) {

        StyleMaker.createStyles();
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent();
        new SlideViewerFrame(JABTITLE, slideViewerComponent);
        try {
            FileLoader fileLoader = XMLAccessor.loadSpecificFile(argv);
            if (argv.length == 0) { //a demo presentation
                fileLoader.loadFile(slideViewerComponent.getPresentation(), "");
            } else {
                fileLoader.loadFile(slideViewerComponent.getPresentation(), argv[0]);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, IOEX + ex, JABERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
