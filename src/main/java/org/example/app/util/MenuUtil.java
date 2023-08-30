package org.example.app.util;

import java.util.Scanner;

public class MenuUtil {
    private static final Scanner sc = new Scanner(System.in);
    public static Integer loggedUserId = 5;

    public static void logging(String name, String password) {

        loggedUserId = 5;

    }

    public static int getIndex() {
        int cmd = sc.nextInt();
        return cmd;
    }

    public static String getInput() {
        String str = sc.next();
        return str;
    }
}
