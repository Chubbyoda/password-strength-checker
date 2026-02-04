#include <stdio.h>
#include <ctype.h>
#include <string.h>

int has_lowercase(char *password) {
    for (int i = 0; password[i]; i++) {
        if (islower(password[i])) {
            return 1;
        }
    }
    return 0;
}

int has_uppercase(char *password) {
    for (int i = 0; password[i]; i++) {
        if (isupper(password[i])) {
            return 1;
        }
    }
    return 0;
}

int has_digit(char *password) {
    for (int i = 0; password[i]; i++) {
        if (isdigit(password[i])) {
            return 1;
        }
    }
    return 0;
}

int has_special(char *password) {
    for (int i = 0; password[i]; i++) {
        if (!isalnum(password[i])) {
            return 1;
        }
    }
    return 0;
}

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
