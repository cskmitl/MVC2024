public class Cow {
    private String name;
    private int totalScore;

    public Cow(String name) {
        this.name = name;
        this.totalScore = 0;
    }

    public String getName() {
        return name;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void addScore(int score) {
        this.totalScore += score;
    }

    public void resetScore() {
        this.totalScore = 0;
    }

    // สมมุติว่า rollPins() เป็นเมธอดในการสุ่มจำนวนพิน
    public int rollPins(int remainingPins) {
        return (int) (Math.random() * (remainingPins + 1));
    }
}
