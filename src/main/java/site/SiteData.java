package site;

import java.util.Objects;

public class SiteData {
    private int houseNumber;
    private int width;
    private int length;
    private int area;
    private int start;

    public SiteData(int houseNumber, int width, int length, int area) {
        this.houseNumber = houseNumber;
        this.width = width;
        this.length = length;
        this.area = area;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "SiteData{" +
                "houseNumber=" + houseNumber +
                ", width=" + width +
                ", length=" + length +
                ", area=" + area +
                ", start=" + start +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiteData data = (SiteData) o;
        return houseNumber == data.houseNumber && width == data.width && length == data.length && area == data.area && start == data.start;
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseNumber, width, length, area, start);
    }
}
