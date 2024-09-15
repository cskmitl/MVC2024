import java.util.List;

public class BowlingView {

    public void displayScores(List<Cow> cows) {
        System.out.println("\nFinal Scores:");
        for (Cow cow : cows) {
            System.out.println(cow.getName() + ": " + cow.getTotalScore() + " points");
        }
    }
}
