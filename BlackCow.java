// BlackCow.java
import java.util.Random;

public class BlackCow extends Cow {

    private Random random = new Random();

    public BlackCow(String name) {
        super(name);
    }

    @Override
    public int rollPins(int remainingPins) {
        int pinsKnockedDown = super.rollPins(remainingPins);

        // โอกาส 20% ที่จะโกง (รายงานว่าล้มพินทั้งหมด)
        if (random.nextDouble() < 0.2) {
            System.out.println(getName() + " reported all pins down, but cheated!");
            return remainingPins;
        }

        return pinsKnockedDown;
    }
}
