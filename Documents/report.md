# Report

## SlideViewerComponent

— Moved static variables to an Interface

— Created a font maker class, because the SlideViewerComponent is not supposed to be responsible for the creation of fonts

— Making it so, the only thing this class is responsible for is redrawing a presentation slide. This also fixes the weird dependency between this and Presentation.

— Removed unused code
## Presentation

— Created a Slide Navigation class, which is responsible for moving between slides. This makes the presentation class more clear and simple.

— Fixed a bug where, when you go to a specific slide, the slide number changes, even if the slide doesn't exist.

— Presentation is no longer dependent on the SlideViewerComponent class.

— Renamed append() to addSlide(), for easier understanding.

## Slide

— broke down the draw() method into 2 smaller ones, since there was code prepetition.

— Renamed the 2 append methods to addSlideItem() and addText(), for easier understanding.

## MenuController

— Break down the constructor into 3 classes responsible for the File, Help and View navigation buttons. That way it is easier to implement more buttons/categories later on and it makes debugging easier.

## SlideItem

— Removed unused code

## Constants package

— Moved all constants to 5 different interfaces. That makes changing them easier and makes the classes visually better.

## Style

— Created a styleMaker class to store the styles created for the different slide levels.

## TextItem

removed unused code

## Accessor

— Broke down the Accessor and XML Accessor classes to create 2 separate abstract classes responsible for loading and saving presentations. This also allowed to remove the load functionality from the DemoPresentation class, since it wasn't going to be used ever.

## KeyController

— Simplified switch case