import java.util.Scanner;

public class PasswordChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        int score = calculateScore(password);
        String strength = getStrength(score);

        System.out.println("Score: " + score);
        System.out.println("Strength: " + strength);

        scanner.close();
    }

    /**
     * Calculates password strength score
     */
    public static int calculateScore(String password) {
        int score = 0;

        if (password.length() >= 8) {
            score++;
        }
        if (hasLowercase(password)) {
            score++;
        }
        if (hasUppercase(password)) {
            score++;
        }
        if (hasDigit(password)) {
            score++;
        }
        if (hasSpecialChar(password)) {
            score++;
        }

        return score;
    }

    /**
     * Converts score to human-readable strength
     */
    public static String getStrength(int score) {
        if (score <= 2) {
            return "Weak";
        } else if (score <= 4) {
            return "Moderate";
        } else {
            return "Strong";
        }
    }

    private static boolean hasLowercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasUppercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDigit(String password) {
        for (
