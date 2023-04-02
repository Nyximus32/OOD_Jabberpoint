package JabberPoint.Presentation;

/**
 * <p>Presentations keeps track of the slides in a presentation.</p>
 * <p>Only one instance of this class is available.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation {
    private String showTitle; //The title of the presentation
    private final SlideController slideController; //The controller of the slides

    public Presentation(SlideController slideController) {
        this.slideController = slideController;
    }

    public SlideController getSlideController() {
        return this.slideController;
    }

    public String getTitle() {
        return this.showTitle;
    }

    public void setTitle(String nt) {
        this.showTitle = nt;
    }

}