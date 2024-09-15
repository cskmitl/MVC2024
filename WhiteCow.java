// WhiteCow.java
import java.util.Random;

public class WhiteCow extends Cow {

    private Random random = new Random();

    public WhiteCow(String name) {
        super(name);
    }

    @Override
    public int rollPins(int remainingPins) {
        int pinsKnockedDown = super.rollPins(remainingPins);

        // โอกาส 10% ที่จะบอกว่าล้างท่อ (รายงานว่าไม่มีพินล้ม)
        if (random.nextDouble() < 0.1) {
            System.out.println(getName() + " reported no pins down, but underreported!");
            return 0;
        }

        return pinsKnockedDown;
    }
}
