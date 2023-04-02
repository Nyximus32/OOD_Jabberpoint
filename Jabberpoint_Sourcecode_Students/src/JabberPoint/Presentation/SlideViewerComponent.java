package JabberPoint.Presentation;

import Constants.SlideDesign;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;


/**
 * <p>JabberPoint.Presentation.SlideViewerComponent is a graphical component that ca display Slides.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideViewerComponent extends JComponent implements SlideDesign {

    private final Presentation presentation; //The presentation
    private final Font labelFont;

    public SlideViewerComponent() {
        setBackground(BGCOLOR);
        presentation = new Presentation(new SlideController());
        labelFont = FontMaker.makeFont(FONTNAME, FONTSTYLE, FONTHEIGHT);

    }

    public Presentation getPresentation() {
        return this.presentation;
    }

    //Draw the slide
    public void paintComponent(Graphics g) {
        this.repaint();
        Slide slide = this.presentation.getSlideController().getCurrentSlide();
        if (presentation.getSlideController().getSlideNumber() < 0 || slide == null) {
            return;
        }
        g.setColor(BGCOLOR);
        g.fillRect(0, 0, getSize().width, getSize().height);
        g.setFont(labelFont);
        g.setColor(COLOR);
        g.drawString("Slide " + (1 + presentation.getSlideController().getSlideNumber()) + " of " + presentation.getSlideController().getSize(), XPOS, YPOS);
        Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
        this.draw(g, area, slide);
    }

    public void draw(Graphics g, Rectangle area, Slide slide) {
        int y = area.y;
        y += drawElements(new TextItem(0, slide.getTitle()), y, g, area);
        for (int number = 0; number < slide.getSize(); number++) {
            SlideItem currentItem = slide.getSlideItems().elementAt(number);
            y += drawElements(currentItem, y, g, area);
        }
    }

    private int drawElements(SlideItem slideItem, int y, Graphics g, Rectangle area) {
        float scale = getScale(area);
        Style style = Style.getStyle(slideItem.getLevel());
        slideItem.draw(area.x, y, scale, g, style);

        return slideItem.getBoundingBox(g, scale, style).height;
    }

    private float getScale(Rectangle area) {
        return Math.min(((float) area.width) / ((float) SLIDEWIDTH), ((float) area.height) / ((float) SLIDHEIGHT));
    }
}
