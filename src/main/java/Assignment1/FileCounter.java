package Assignment1;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter folder path: ");
        String folderPath = scanner.nextLine();

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        int javaFileTotal = 0;
        int issueTotal = 0;

        if (files != null) {
            for (File f : files) {
                if (f.isFile() && f.getName().endsWith(".java")) {
                    javaFileTotal++;

                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(f));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.toLowerCase().contains("solved")) {
                                issueTotal++;
                            }
                        }
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("Could not read: " + f.getName());
                    }
                }
            }
        } else {
            System.out.println("Invalid folder path.");
        }

        System.out.println("Number of Java Files = " + javaFileTotal);
        System.out.println("Number of Issues = " + issueTotal);
    }
}

