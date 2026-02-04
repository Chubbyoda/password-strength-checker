import java.util.Scanner;

public class PasswordChecker {

    // main(String[] args)
    // Behavior: Entry point for the program; prompts user for password input, calculates strength score, and displays both score and strength rating
    // Parameters: args - command line arguments (not used)
    // Returns: void
    // Exceptions: None
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
     * calculateScore(String password)
     * Behavior: Evaluates password strength by checking five criteria: minimum length (8 chars), presence of lowercase, uppercase, digit, and special character. Increments score for each criterion met.
     * Parameters: password - the password string to evaluate
     * Returns: int score between 0-5, where each point represents one criterion met
     * Exceptions: None
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
     * getStrength(int score)
     * Behavior: Maps a numeric score to a human-readable strength level. Score 0-2 returns "Weak", 3-4 returns "Moderate", 5 returns "Strong".
     * Parameters: score - integer value representing password strength (typically 0-5)
     * Returns: String containing strength level ("Weak", "Moderate", or "Strong")
     * Exceptions: None
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

    // hasLowercase(String password)
    // Behavior: Iterates through each character in the password to check for the presence of lowercase letters
    // Parameters: password - the password string to check
    // Returns: true if at least one lowercase letter is found, false otherwise
    // Exceptions: None
    private static boolean hasLowercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    // hasUppercase(String password)
    // Behavior: Iterates through each character in the password to check for the presence of uppercase letters
    // Parameters: password - the password string to check
    // Returns: true if at least one uppercase letter is found, false otherwise
    // Exceptions: None
    private static boolean hasUppercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    // hasDigit(String password)
    // Behavior: Iterates through each character in the password to check for the presence of numeric digits
    // Parameters: password - the password string to check
    // Returns: true if at least one digit is found, false otherwise
    // Exceptions: None
    private static boolean hasDigit(String password) {
        for (
