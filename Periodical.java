
public class Periodical extends LibraryItem {
    public Periodical(String title, String ISBN, String publisher, int availableCopies, String format) {
        super(title, ISBN, publisher, availableCopies, format);
        ValidateFormat();
    }

    @Override
    // this one only checks physical or digital. can't be audio
    protected void ValidateFormat() {
        if (!Format.equals("physical") && !Format.equals("digital")) {
            throw new IllegalArgumentException("Periodicals must be physical or digital.");
        }
    }
}