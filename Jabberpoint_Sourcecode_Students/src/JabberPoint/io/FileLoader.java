package JabberPoint.io;

import JabberPoint.Presentation.Presentation;

import java.io.IOException;

public abstract class FileLoader {
    abstract public void loadFile(Presentation p, String fn) throws IOException;
}
