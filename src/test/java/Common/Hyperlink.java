package Common;

public class Hyperlink {
    private String text;
    private String link;

    public Hyperlink(String text, String link) {
        this.text = text;
        this.link = link;
    }

    public String getText() {
        return text;
    }

    public String getLink() {
        return link;
    }
}
