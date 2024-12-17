package me.yeunikey.practice;

import me.yeunikey.practice.entities.Point;
import me.yeunikey.practice.entities.Shape;
import me.yeunikey.practice.utils.Console;
import me.yeunikey.starter.Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PracticeApplication implements Application {

    private static String PROJECT_PATH = "D:\\projects\\other\\Practice1\\src\\main\\java\\me\\yeunikey\\practice";
    private static Console console = new Console();

    @Override
    public void onStart() {
        File source = new File(PROJECT_PATH, "source");
        Shape shape = parseShape(source);

        if (shape == null) {
            Console.severe("Shape is null (Check source or `PROJECT_PATH` param)");
            return;
        }

        Console.info("Perimeter: " + shape.calculatePerimeter());
        Console.info("Longest side: " + shape.getLongestSide());
    }

    public Shape parseShape(File file) {

        Shape shape = new Shape();

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();

                Point point = new Point(x, y);
                shape.addPoint(point);
            }
        } catch (FileNotFoundException e) {
            Console.severe("That source not found");
            return null;
        }

        return shape;
    }

    public static Console getConsole() {
        return console;
    }
}
