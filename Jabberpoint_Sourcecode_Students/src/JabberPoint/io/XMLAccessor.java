package JabberPoint.io;

import Constants.FileInfo;


/**
 * JabberPoint.io.XMLAccessor, reads and writes XML files
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class XMLAccessor implements FileInfo {
    /**
     * Text of messages
     */
    public static FileLoader loadFile(String filename) {
        if (filename.endsWith(DEFAULT_EXTENSION)) {
            return new XMLLoad();
        } else {
            throw new IllegalArgumentException("Unknown file type: " + filename);
        }
    }

    public static FileLoader loadSpecificFile(String[] arguments) {
        if (arguments.length == 0) {
            return new DemoPresentation();
        } else {
            return new XMLLoad();
        }
    }

    public static FileSaver saveFile(String filename) {
        if (filename.endsWith(DEFAULT_EXTENSION)) {
            return new XMLSave();
        } else {
            throw new IllegalArgumentException("Unknown file type: " + filename);
        }
    }
}
