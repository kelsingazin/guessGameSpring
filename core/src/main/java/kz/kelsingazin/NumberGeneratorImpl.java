package kz.kelsingazin;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {

    // Fields
    private final Random random = new Random();
    private int maxNumber = 100;

    public int next() {
        return random.nextInt(maxNumber);
    }

    public int getMaxNumber() {
        return maxNumber;
    }
}
