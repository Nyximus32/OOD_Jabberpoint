package JabberPoint.io;

import JabberPoint.Presentation.BitmapItem;
import JabberPoint.Presentation.Presentation;
import JabberPoint.Presentation.Slide;

/**
 * A built-in demo presentation
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

class DemoPresentation extends FileLoader {

    public void loadFile(Presentation presentation, String unusedFilename) {
        presentation.setTitle("Demo Presentation");
        Slide slide;
        slide = new Slide();
        slide.setTitle("JabberPoint");
        slide.addText(1, "The Java prestentation tool");
        slide.addText(2, "Copyright (c) 1996-2000: Ian Darwin");
        slide.addText(2, "Copyright (c) 2000-now:");
        slide.addText(2, "Gert Florijn and Sylvia Stuurman");
        slide.addText(4, "Calling Jabberpoint without a filename");
        slide.addText(4, "will show this presentation");
        slide.addText(1, "Navigate:");
        slide.addText(3, "Next slide: PgDn or Enter");
        slide.addText(3, "Previous slide: PgUp or up-arrow");
        slide.addText(3, "Quit: q or Q");
        presentation.getSlideController().addSlide(slide);

        slide = new Slide();
        slide.setTitle("Demonstration of levels and styles");
        slide.addText(1, "Level 1");
        slide.addText(2, "Level 2");
        slide.addText(1, "Again level 1");
        slide.addText(1, "Level 1 has style number 1");
        slide.addText(2, "Level 2 has style number 2");
        slide.addText(3, "This is how level 3 looks like");
        slide.addText(4, "And this is level 4");
        presentation.getSlideController().addSlide(slide);

        slide = new Slide();
        slide.setTitle("The third slide");
        slide.addText(1, "To open a new presentation,");
        slide.addText(2, "use File->Open from the menu.");
        slide.addText(1, " ");
        slide.addText(1, "This is the end of the presentation.");
        slide.addSlideItem(new BitmapItem(1, "JabberPoint.jpg"));
        presentation.getSlideController().addSlide(slide);
    }
}
