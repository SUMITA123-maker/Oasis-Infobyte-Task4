import java.util.*;

class User {
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class Exam {
    private static final Map<String, String> questions = new LinkedHashMap<>();
    private static final Map<String, String> answers = new HashMap<>();
    static {
        questions.put("What is Java?", "A) Programming Language B) Drink C) Animal D) Car");
        answers.put("What is Java?", "A");
        
        questions.put("Who developed Java?", "A) Microsoft B) Oracle C) Sun Microsystems D) Google");
        answers.put("Who developed Java?", "C");
        
        questions.put("Which keyword is used to define a class in Java?", "A) class B) struct C) define D) interface");
        answers.put("Which keyword is used to define a class in Java?", "A");
        
        questions.put("Which data type is used to store a single character in Java?", "A) char B) string C) int D) boolean");
        answers.put("Which data type is used to store a single character in Java?", "A");
        
        questions.put("What is the size of an int in Java?", "A) 2 bytes B) 4 bytes C) 8 bytes D) 16 bytes");
        answers.put("What is the size of an int in Java?", "B");
        
        questions.put("Which method is used to print something in Java?", "A) print() B) echo() C) println() D) display()");
        answers.put("Which method is used to print something in Java?", "C");
        
        questions.put("Which of the following is NOT a Java access modifier?", "A) public B) private C) protected D) accessible");
        answers.put("Which of the following is NOT a Java access modifier?", "D");
        
        questions.put("Which loop is used to execute a block of code at least once?", "A) for B) while C) do-while D) foreach");
        answers.put("Which loop is used to execute a block of code at least once?", "C");
        
        questions.put("What is the parent class of all Java classes?", "A) Object B) Class C) Main D) Super");
        answers.put("What is the parent class of all Java classes?", "A");
        
        questions.put("Which exception is thrown when a divide by zero occurs?", "A) ArithmeticException B) NullPointerException C) IOException D) NumberFormatException");
        answers.put("Which exception is thrown when a divide by zero occurs?", "A");
        
        questions.put("What is used to handle exceptions in Java?", "A) try-catch B) throw C) catch D) final");
        answers.put("What is used to handle exceptions in Java?", "A");
    }

    public int startExam() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int attempted = 0;
        System.out.println("Exam Started! Answer the following MCQs:");
        
        for (Map.Entry<String, String> entry : questions.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.print("Your Answer: ");
            String answer = scanner.next().toUpperCase();
            attempted++;
            
            if (answers.get(entry.getKey()).equals(answer)) {
                System.out.println("Correct! ✅");
                score++;
            } else {
                System.out.println("Wrong! ❌ The correct answer is: " + answers.get(entry.getKey()));
            }
            
            System.out.println("Do you want to continue? (y/n): ");
            String choice = scanner.next().toLowerCase();
            if (choice.equals("n")) {
                System.out.println("Submitting your exam...");
                break;
            }
        }
        System.out.println("\nExam Finished! Your Score: " + score + "/" + attempted);
        return score;
    }
}

public class OnlineExaminationSystem {
    private static User user = new User("admin", "1234");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        if (login()) {
            showMenu();
        } else {
            System.out.println("Invalid login. Exiting.");
        }
    }

    private static boolean login() {
        System.out.print("Enter Username: ");
        String username = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        return username.equals(user.username) && password.equals(user.password);
    }

    private static void showMenu() {
        Exam exam = new Exam();
        while (true) {
            System.out.println("\n1. Start Exam\n2. Change Password\n3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    exam.startExam();
                    showMenu();
                    break;
                case 2:
                    changePassword();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void changePassword() {
        System.out.print("Enter New Password: ");
        user.password = scanner.next();
        System.out.println("Password Updated Successfully!");
    }
}
