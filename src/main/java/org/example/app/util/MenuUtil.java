package org.example.app.util;

import org.example.app.constant.LoginRegister;
import org.example.app.constant.Menu;
import org.example.app.constant.SearchAndBook;

import java.util.Arrays;
import java.util.Scanner;

public class MenuUtil {
    private static final Scanner sc = new Scanner(System.in);

    public static int getIndex() {
        int cmd = sc.nextInt();
        return cmd;
    }

    public static String getInput() {
        String str = sc.next();
        return str;
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
