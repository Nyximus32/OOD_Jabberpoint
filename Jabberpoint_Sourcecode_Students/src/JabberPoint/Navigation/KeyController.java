package JabberPoint.Navigation;

import JabberPoint.Presentation.Presentation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/**
 * <p>This is the JabberPoint.Navigation.KeyController (KeyListener)</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class KeyController extends KeyAdapter {
    private final Presentation presentation; //Commands are given to the presentation

    public KeyController(Presentation p) {
        presentation = p;
    }

    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_PAGE_DOWN, KeyEvent.VK_DOWN, KeyEvent.VK_ENTER, '+' -> {
                presentation.getSlideController().nextSlide();
            }
            case KeyEvent.VK_PAGE_UP, KeyEvent.VK_UP, '-' -> {
                presentation.getSlideController().prevSlide();
            }
            case 'q', 'Q' -> System.exit(0);
            //Should not be reached
            default -> {
            }
        }
    }
}
