#include <stdio.h>
#include <ctype.h>
#include <string.h>

// has_lowercase(char *password)
// Behavior: Scans the password string to check for the presence of lowercase letters
// Parameters: password - pointer to null-terminated string to check
// Returns: 1 if at least one lowercase letter is found, 0 otherwise
// Exceptions: None
int has_lowercase(char *password) {
    for (int i = 0; password[i]; i++) {
        if (islower(password[i])) {
            return 1;
        }
    }
    return 0;
}

// has_uppercase(char *password)
// Behavior: Scans the password string to check for the presence of uppercase letters
// Parameters: password - pointer to null-terminated string to check
// Returns: 1 if at least one uppercase letter is found, 0 otherwise
// Exceptions: None
int has_uppercase(char *password) {
    for (int i = 0; password[i]; i++) {
        if (isupper(password[i])) {
            return 1;
        }
    }
    return 0;
}

// has_digit(char *password)
// Behavior: Scans the password string to check for the presence of numeric digits
// Parameters: password - pointer to null-terminated string to check
// Returns: 1 if at least one digit is found, 0 otherwise
// Exceptions: None
int has_digit(char *password) {
    for (int i = 0; password[i]; i++) {
        if (isdigit(password[i])) {
            return 1;
        }
    }
    return 0;
}

// has_special(char *password)
// Behavior: Scans the password string to check for the presence of special characters (non-alphanumeric)
// Parameters: password - pointer to null-terminated string to check
// Returns: 1 if at least one special character is found, 0 otherwise
// Exceptions: None
int has_special(char *password) {
    for (int i = 0; password[i]; i++) {
        if (!isalnum(password[i])) {
            return 1;
        }
    }
    return 0;
}

// main()
// Behavior: Prompts user for password input, evaluates password strength based on five criteria (length, lowercase, uppercase, digit, special char), and displays strength score and rating
// Parameters: None
// Returns: 0 on successful execution
// Exceptions: None
int main() {
    char password[256];
    int score = 0;

    printf("Enter a password: ");
    fgets(password, sizeof(password), stdin);

    // Remove newline from fgets
    password[strcspn(password, "\n")] = '\0';

    if (strlen(password) >= 8) score++;
    if (has_lowercase(password)) score++;
    if (has_uppercase(password)) score++;
    if (has_digit(password)) score++;
    if (has_special(password)) score++;

    printf("Score: %d\n", score);

    if (score <= 2) {
        printf("Strength: Weak\n");
    } else if (score <= 4) {
        printf("Strength: Moderate\n");
    } else {
        printf("Strength: Strong\n");
    }

    return 0;
}
