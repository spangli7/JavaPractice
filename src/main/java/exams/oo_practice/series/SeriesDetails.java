package exams.oo_practice.series;

public class SeriesDetails {
  private int numberOfEpisodes;
  private int totalLength;

  public SeriesDetails(int numberOfEpisodes, int totalLength) {
    this.numberOfEpisodes = numberOfEpisodes;
    this.totalLength = totalLength;
  }

  public int getNumberOfEpisodes() {
    return numberOfEpisodes;
  }

  public void setNumberOfEpisodes(int numberOfEpisodes) {
    this.numberOfEpisodes = numberOfEpisodes;
  }

  public int getTotalLength() {
    return totalLength;
  }

  public void setTotalLength(int totalLength) {
    this.totalLength = totalLength;
  }
}
