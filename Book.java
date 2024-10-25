public class Book extends LibraryItem {
    // i changed these into subclasses. extended the library item superclass
    public Book(String title, String ISBN, String publisher, int availableCopies, String format) {
        super(title, ISBN, publisher, availableCopies, format);
        ValidateFormat();
    }
    // overridden validating method from the library item. this one checks for physical digital and audio
    @Override
    protected void ValidateFormat() {
        if (!Format.equals("physical") && !Format.equals("digital") && !Format.equals("audio")) {
            throw new IllegalArgumentException("Books must be physical, digital, or audio.");
        }
    }
}