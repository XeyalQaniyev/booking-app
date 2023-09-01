package org.example.app.util;

import org.example.app.constant.LoginRegister;
import org.example.app.constant.Menu;
import org.example.app.constant.SearchAndBook;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUtil {
    private static final Scanner sc = new Scanner(System.in);

    public static Integer getIndex() {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException ex) {
                sc.next();
                System.err.println("Wrong format! Please enter an integer:");
            }
        }
    }

    public static String getInput() {
        while (true) {
            try {
                return sc.next();
            } catch (InputMismatchException ex) {
                sc.next();
                System.err.println("Wrong format! Please enter a string:");
            }
        }
    }

    public static void showMenu() {
        Arrays.stream(Menu.values())
                .forEach(it -> System.out.printf("\n%d-%s", it.getIndex(), it.getDescription()));
        System.out.println("");
    }

    public static void showSearchAndRezervMenu() {
        Arrays.stream(SearchAndBook.values())
                .forEach(it -> System.out.printf("%d-%s\n", it.getIndex(), it.getDescription()));

    }

    public static void showLoginAndRegisterMenu() {
        Arrays.stream(LoginRegister.values())
                .forEach(it -> System.out.printf("%d-%s\n", it.getIndex(), it.getDescription()));
    }
}
