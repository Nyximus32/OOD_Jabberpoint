package JabberPoint.io;

import JabberPoint.Presentation.Presentation;

import java.io.IOException;

public abstract class FileSaver {
    abstract public void saveFile(Presentation p, String fn) throws IOException;
}
