package JabberPoint.Presentation;

import Constants.SlideDesign;

import java.util.Vector;

/**
 * <p>A slide. This class has drawing functionality.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Slide implements SlideDesign {
    protected String title; //The title is kept separately
    protected Vector<SlideItem> items; //The SlideItems are kept in a vector

    public Slide() {
        items = new Vector<>();
    }

    //Add a JabberPoint.Presentation.SlideItem
    public void addSlideItem(SlideItem anItem) {
        items.addElement(anItem);
    }

    //Return the title of a slide
    public String getTitle() {
        return title;
    }

    //Change the title of a slide
    public void setTitle(String newTitle) {
        title = newTitle;
    }

    //Create a JabberPoint.Presentation.TextItem out of a String and add the JabberPoint.Presentation.TextItem
    public void addText(int level, String message) {
        addSlideItem(new TextItem(level, message));
    }

    //Return all the SlideItems in a vector
    public Vector<SlideItem> getSlideItems() {
        return items;
    }

    //Returns the size of a slide
    public int getSize() {
        return items.size();
    }

    //Draws the slide
}
