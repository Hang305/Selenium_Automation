package Learning;

public class FigureData {
    private String imgSrc;
    private String imgDecs;
    private String imgLink;

    public FigureData(String imgSrc, String imgDecs, String imgLink) {
        this.imgSrc = imgSrc;
        this.imgDecs = imgDecs;
        this.imgLink = imgLink;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public String getImgDecs() {
        return imgDecs;
    }

    public String getImgLink() {
        return imgLink;
    }

    @Override
    public String toString() {
        return "FigureData{" +
                "imgSrc='" + imgSrc + '\'' +
                ", imgDecs='" + imgDecs + '\'' +
                ", imgLink='" + imgLink + '\'' +
                '}';
    }
}
