package me.yeunikey.practice.utils;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Console {

    private static Console instance;
    private Logger logger = Logger.getLogger("Practice");

    public Console() {
        instance = this;

        setupLogger();
    }

    public void setupLogger() {
        logger.setUseParentHandlers(false);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new ConsoleFormatter());

        logger.addHandler(consoleHandler);
        logger.setLevel(Level.INFO);
    }

    public static void info(Object msg) {
        Console.getInstance().getLogger().info(msg.toString());
    }

    public static void severe(Object msg) {
        Console.getInstance().getLogger().severe(msg.toString());
    }

    public static void warning(Object msg) {
        Console.getInstance().getLogger().warning(msg.toString());
    }

    public Logger getLogger() {
        return logger;
    }

    public static Console getInstance() {
        return instance;
    }
}
