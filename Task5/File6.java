import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ELearningPlatform {
    private static List<Course> courses = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static User loggedInUser = null;

    public static void main(String[] args) {
        // Initialize some courses
        courses.add(new Course("Java Programming", "Learn the basics of Java programming."));
        courses.add(new Course("Web Development", "Introduction to web development with HTML, CSS, and JavaScript."));
        courses.add(new Course("Data Structures", "Understand fundamental data structures and algorithms."));

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            if (loggedInUser == null) {
                System.out.println("E-Learning Platform");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");

                input = scanner.nextLine();

                switch (input) {
                    case "1":
                        register(scanner);
                        break;
                    case "2":
                        login(scanner);
                        break;
                    case "3":
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else {
                System.out.println("Welcome, " + loggedInUser.getName() + "!");
                System.out.println("1. View Courses");
                System.out.println("2. View My Courses");
                System.out.println("3. Logout");
                System.out.print("Choose an option: ");

                input = scanner.nextLine();

                switch (input) {
                    case "1":
                        viewCourses();
                        break;
                    case "2":
                        viewMyCourses();
                        break;
                    case "3":
                        loggedInUser = null; // Logout
                        System.out.println("Logged out successfully.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }

    private static void register(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        users.add(new User(name, email, password));
        System.out.println("Registration successful!");
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                loggedInUser = user;
                System.out.println("Login successful!");
                return;
            }
        }
        System.out.println("Invalid email or password.");
    }

    private static void viewCourses() {
        System.out.println("Available Courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i));
        }
        System.out.print("Enter course number to view details or 0 to go back: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice > 0 && choice <= courses.size()) {
            Course course = courses.get(choice - 1);
            System.out.println("Course Details:");
            System.out.println(course);
            // In a real application, this would show detailed lessons
        }
    }

    private static void viewMyCourses() {
        // This method should show the courses the user is enrolled in.
        // For simplicity, we assume the user is always enrolled in all courses.
        System.out.println("Enrolled Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }
}
