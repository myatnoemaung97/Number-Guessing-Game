import java.util.Arrays;
import java.util.Random;

public class ThreeDigitNumber {
    private final Random random;
    private int[] threeDigitNumber = new int[3];

    public ThreeDigitNumber() {
        this.random = new Random();
        this.threeDigitNumber = generateThreeDigitNumber();
    }

    private int[] generateThreeDigitNumber() {
        int firstDigit, secondDigit, thirdDigit;
        firstDigit = random.nextInt(10);
        while (true) {
            secondDigit = random.nextInt(10);
            if (secondDigit != firstDigit) {
                break;
            }
        }
        while (true) {
            thirdDigit = random.nextInt(10);
            if (thirdDigit != firstDigit && thirdDigit != secondDigit) {
                break;
            }
        }
        threeDigitNumber[0] = firstDigit;
        threeDigitNumber[1] = secondDigit;
        threeDigitNumber[2] = thirdDigit;
        return threeDigitNumber;
    }

    public boolean containsNumber(int number) {
        return Arrays.stream(threeDigitNumber).anyMatch(i -> i == number);
    }

    public boolean isInRightPosition(int number, int index) {
        return threeDigitNumber[index] == number;
    }
}
