package kz.kelsingazin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameImpl implements Game {
    //Constance
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    //Fields
    private NumberGenerator numberGenerator;
    private int guessCount = 10;
    private int number;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private int guess;
    private boolean validNumberRange = true;

    public GameImpl(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void reset() {
        smallest = 0;
        guess = 0;
        biggest = numberGenerator.getMaxNumber();
        remainingGuesses = guessCount;
        number = numberGenerator.next();
        log.debug("The number is {}", number);
    }

    public int getNumber() {
        return number;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getSmallest() {
        return smallest;
    }

    public int getBiggest() {
        return biggest;
    }

    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    public void check() {
        checkValidNumberRange();
        if (validNumberRange) {
            if (guess > number) {
                biggest = guess - 1;
            }

            if (guess < number) {
                smallest = guess + 1;
            }
        }
            remainingGuesses--;
    }

    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    public boolean isGameWon() {
        return guess == number;
    }

    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    //private methods
    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
