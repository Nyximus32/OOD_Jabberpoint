package JabberPoint.Presentation;

import java.util.ArrayList;

public class SlideController {
    private ArrayList<Slide> showList; //An ArrayList with slides
    private int currentSlideNumber; //The number of the current slide

    public SlideController() {
        this.showList = new ArrayList<>();
        this.currentSlideNumber = 0;
    }

    public int getSize() {
        return showList.size();
    }

    public int getSlideNumber() {
        return currentSlideNumber;
    }

    public void setSlideNumber(int number) {
        if (number >= 0 && number < getSize()) {
            currentSlideNumber = number;
        }
    }

    public void prevSlide() {
        if (currentSlideNumber > 0) {
            setSlideNumber(currentSlideNumber - 1);
        }
    }

    public void nextSlide() {
        if (currentSlideNumber < (showList.size() - 1)) {
            setSlideNumber(currentSlideNumber + 1);
        }
    }

    public void clear() {
        showList = new ArrayList<>();
        setSlideNumber(-1);
    }

    public void addSlide(Slide slide) {
        showList.add(slide);
    }

    public Slide getSlide(int number) {
        if (number >= 0 && number < getSize()) {
            return this.showList.get(number);
        }
        return null;
    }

    public Slide getCurrentSlide() {
        return getSlide(currentSlideNumber);
    }
}
