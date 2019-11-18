package com.lviv.iot.labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        final CareerTree tree = readTreeFromFile();

        System.out.println(tree.getMaxCareerValueForNodes() + "\n");
        System.out.println(tree);


        System.out.println(System.lineSeparator());
    }

    private static CareerTree readTreeFromFile() {
        try {
            Scanner scanner = new Scanner(new File("/Users/admin/Documents/studying/scala/part3lab4/src/main/java/com/lviv/iot/labs/input.txt"));

            final int treeHeight = scanner.nextInt();
            CareerTree careerTree = new CareerTree(treeHeight);

            for (int i = 0; i < treeHeight; i++) {
                careerTree.getCareerVertical().add(new CareerHorizontal());
                for(int j = 0; j <= i; j++) {
                    careerTree.getCareerVertical().get(i).getValues().add(new CareerPoint(scanner.nextInt()));
                }
            }
            return careerTree;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
