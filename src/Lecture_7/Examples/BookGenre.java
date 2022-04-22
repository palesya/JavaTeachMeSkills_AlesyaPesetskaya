package Lecture_7.Examples;

public enum BookGenre {
    NOVEL("This is novel."),
    SCIENCE("This is science."),
    FANTASY("This is fantasy."),
    FAIRY_TAILS("This is fairy-tail.");

    private String description;

    BookGenre(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
