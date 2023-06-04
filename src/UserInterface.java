import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UserInterface {
    private final BufferedReader reader;
    private final ThreeDigitNumber threeDigitNumber;

    public UserInterface() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.threeDigitNumber = new ThreeDigitNumber();

    }

    public void start() {
        System.out.println("A random number has been created. Start guessing.");
        for (int i = 10; i > 0; i--) {
            System.out.println("You have " + i + " chances");
            try {
                String input = reader.readLine();
                if (input.length() != 3) {
                    System.out.println("Enter a three digit number");
                    i++;
                    continue;
                }
                String output = processInput(input);
                System.out.println(output);
                if (output.equals("***")) {
                    System.out.println("Congratulations!!! You have correctly guessed the number");
                    return;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(":( Better luck next time");
    }

    private String processInput(String input) {
        StringBuilder builder = new StringBuilder();
        int[] inputs = Arrays.stream(input.split(""))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray();
        for (int i = 0; i < 3; i++) {
            if (threeDigitNumber.isInRightPosition(inputs[i], i)) {
                builder.append("*");
            } else if (threeDigitNumber.containsNumber(inputs[i])) {
                builder.append("!");
            } else {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
