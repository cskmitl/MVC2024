// WhiteCow.java
public class WhiteCow extends Cow {

    public WhiteCow(String name) {
        super(name);
    }

    @Override
    public int rollPins(int remainingPins) {
        int pinsKnockedDown = super.rollPins(remainingPins);

        // โอกาส 10% ที่จะบอกว่าล้างท่อ (รายงานว่าไม่มีพินล้ม)
        if (random.nextDouble() < 0.1) {
            System.out.println(name + " reported no pins down, but underreported!");
            return 0;
        }

        return pinsKnockedDown;
    }
}
