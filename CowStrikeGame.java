public class CowStrikeGame {

    public static void main(String[] args) {
        // สร้างทีม
        Team whiteTeam = new Team("White");
        Team blackTeam = new Team("Black");
        Team brownTeam = new Team("Brown");

        // สร้างคอนโทรลเลอร์
        BowlingController controller = new BowlingController(new Team[]{whiteTeam, blackTeam, brownTeam});

        // เล่นเกม
        controller.playRound();
    }
}
