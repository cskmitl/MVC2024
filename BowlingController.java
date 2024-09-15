import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BowlingController {

    private Team[] teams;

    public BowlingController(Team[] teams) {
        this.teams = teams;
    }

    public void playRound() {
        for (int i = 0; i < 10; i++) {  // เล่นทั้งหมด 10 รอบ
            System.out.println("Round " + (i + 1));
            for (Team team : teams) {
                for (Cow cow : team.getCows()) {
                    playTurn(cow);  // ส่งวัวแต่ละตัวไปเล่น
                }
            }
        }
        // เมื่อเล่นครบ 10 รอบ เรียกฟังก์ชันเพื่อสรุปคะแนน
        displayFinalResults();
    }

    public void playTurn(Cow cow) {
        int remainingPins = 10;  // เริ่มต้นด้วย 10 พิน
        int firstRoll = cow.rollPins(remainingPins);  // วัวโยนครั้งแรก
        remainingPins -= firstRoll;

        if (firstRoll == 10) {
            System.out.println(cow.getName() + " got a Cow Strike!");
            cow.addScore(10);  // Cow Strike
            return;  // จบรอบถ้าได้ Strike
        }

        int secondRoll = cow.rollPins(remainingPins);  // วัวโยนครั้งที่สอง
        remainingPins -= secondRoll;

        if (remainingPins == 0) {
            System.out.println(cow.getName() + " got a Cow Spare!");
            cow.addScore(10);  // Cow Spare
        } else {
            System.out.println(cow.getName() + " got a Cow Open with " + (firstRoll + secondRoll) + " points.");
            cow.addScore(firstRoll + secondRoll);  // Cow Open
        }
    }

    // ฟังก์ชันจัดอันดับและแสดงผลคะแนน
    public void displayFinalResults() {
        // สร้างลิสต์เก็บวัวทั้งหมดเพื่อเรียงลำดับคะแนน
        List<Cow> allCows = new ArrayList<>();
        for (Team team : teams) {
            allCows.addAll(team.getCows());  // ดึงวัวแต่ละตัวในทีมมาใส่ในลิสต์
        }

        // จัดเรียงวัวตามคะแนนจากมากไปน้อย
        Collections.sort(allCows, new Comparator<Cow>() {
            @Override
            public int compare(Cow c1, Cow c2) {
                return Integer.compare(c2.getTotalScore(), c1.getTotalScore());  // เรียงจากมากไปน้อย
            }
        });

        System.out.println("\nFinal Ranking:");
        int rank = 1;
        for (int i = 0; i < allCows.size(); i++) {
            Cow cow = allCows.get(i);
            // ถ้าวัวมีคะแนนเท่ากัน ให้อยู่ในอันดับร่วมกัน
            if (i > 0 && cow.getTotalScore() == allCows.get(i - 1).getTotalScore()) {
                System.out.println("Rank " + rank + ": " + cow.getName() + " with " + cow.getTotalScore() + " points");
            } else {
                rank = i + 1;
                System.out.println("Rank " + rank + ": " + cow.getName() + " with " + cow.getTotalScore() + " points");
            }
        }

        // หาทีมที่ได้คะแนนรวมสูงสุด
        Team winningTeam = teams[0];
        for (Team team : teams) {
            if (team.getTotalTeamScore() > winningTeam.getTotalTeamScore()) {
                winningTeam = team;
            }
        }

        // แสดงทีมที่ชนะ
        System.out.println("\nWinning Team: " + winningTeam.getTeamName() + " with " + winningTeam.getTotalTeamScore() + " points!");

        // เริ่มเกมใหม่ (รีเซ็ต)
        resetGame();
    }

    // ฟังก์ชันรีเซ็ตเกมเพื่อเริ่มเกมใหม่
    public void resetGame() {
        for (Team team : teams) {
            for (Cow cow : team.getCows()) {
                cow.resetScore();  // รีเซ็ตคะแนนของวัวทุกตัว
            }
        }
        System.out.println("\nGame has been reset. Ready for a new game.");
    }
}
