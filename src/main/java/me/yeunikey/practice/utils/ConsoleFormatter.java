package me.yeunikey.practice.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class ConsoleFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {

        String color;
        switch (record.getLevel().getName()) {
            case "SEVERE": color = AnsiColor.RED; break;
            case "WARNING": color = AnsiColor.YELLOW; break;
            case "INFO": color = AnsiColor.GREEN; break;
            case "CONFIG": color = AnsiColor.CYAN; break;
            default: color = AnsiColor.BLUE; break;
        }

        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(record.getMillis()));

        return String.format(
                "%s[%s] [%s] %s: %s%s%n",
                color, time, "PracticeApplication", record.getLevel(), record.getMessage(), AnsiColor.RESET
        );
    }

    public static class AnsiColor {
        public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String CYAN = "\u001B[36m";
    }

}
