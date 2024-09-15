import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<Cow> cows;

    public Team(String teamName) {
        this.teamName = teamName;
        cows = new ArrayList<>();
        // เพิ่มวัวในทีม (สมมุติว่าทีมมีวัว 3 ตัว)
        cows.add(new Cow(teamName + " Cow 1"));
        cows.add(new Cow(teamName + " Cow 2"));
        cows.add(new Cow(teamName + " Cow 3"));
    }

    public List<Cow> getCows() {
        return cows;
    }

    public String getTeamName() {
        return teamName;
    }

    // ฟังก์ชันคำนวณคะแนนรวมของทีม
    public int getTotalTeamScore() {
        int totalScore = 0;
        for (Cow cow : cows) {
            totalScore += cow.getTotalScore();
        }
        return totalScore;
    }
}
