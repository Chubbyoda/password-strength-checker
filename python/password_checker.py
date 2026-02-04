import re

# check_password_strength(password)
# Behavior: Evaluates password strength by checking five criteria (minimum 8 characters, uppercase letter, lowercase letter, digit, special character) and generates improvement suggestions for unmet criteria
# Parameters: password - string containing the password to evaluate
# Returns: tuple containing (strength: str, feedback: list) where strength is "Weak", "Medium", or "Strong", and feedback contains specific improvement recommendations
# Exceptions: None
def check_password_strength(password):
    score = 0
    feedback = []

    if len(password) >= 8:
        score += 1
    else:
        feedback.append("Password should be at least 8 characters long.")

    if re.search(r"[A-Z]", password):
        score += 1
    else:
        feedback.append("Add at least one uppercase letter.")

    if re.search(r"[a-z]", password):
        score += 1
    else:
        feedback.append("Add at least one lowercase letter.")

    if re.search(r"[0-9]", password):
        score += 1
    else:
        feedback.append("Add at least one number.")

    if re.search(r"[!@#$%^&*(),.?\":{}|<>]", password):
        score += 1
    else:
        feedback.append("Add at least one special character.")

    if score <= 2:
        strength = "Weak"
    elif score <= 4:
        strength = "Medium"
    else:
        strength = "Strong"

    return strength, feedback


# main()
# Behavior: Prompts user to enter a password, evaluates its strength, and displays the strength rating along with specific improvement suggestions
# Parameters: None
# Returns: None
# Exceptions: None
def main():
    password = input("Enter a password to check: ")
    strength, feedback = check_password_strength(password)

    print(f"\nPassword Strength: {strength}")
    if feedback:
        print("Suggestions:")
        for item in feedback:
            print("-", item)


if __name__ == "__main__":
    main()
