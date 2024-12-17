package me.yeunikey.starter;

import me.yeunikey.practice.PracticeApplication;

public class Starter {

    private static Application application;

    public static void main(String[] args) {
        application = new PracticeApplication();
        application.onStart();
    }

    public static Application getApplication() {
        return application;
    }

}
