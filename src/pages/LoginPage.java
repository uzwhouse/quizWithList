package pages;

import static utils.Utils.*;

public class LoginPage {
    public static void loginPage() {
        showLoginPage();
        switch (readConsole(BLUE + "Choice: " + RESET)) {
            case "1" -> login();
            case "2" -> register();
            case "q" -> quit();
            default -> System.out.println(RED + "Wrong choice !!!" + RESET);
        }
    }

    private static void quit() {
        System.out.println(YELLOW + "QUIT" + RESET);
        System.exit(0);
    }

    private static void register() {
        System.out.println(YELLOW + "Register..." + RESET);
    }

    private static void login() {
        System.out.println(YELLOW + "Login..." + RESET);
    }

    public static void showLoginPage() {
        System.out.println("1 -> LOGIN");
        System.out.println("2 -> REGISTER");
        System.out.println("q -> QUIT");
    }
}