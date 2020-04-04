package com.yyh.practice;


import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountTest {
    public static void main(String args[]) throws IOException {
        Path path = Paths.get("C:\\Users\\yhyeoh\\IdeaProjects\\untitled");

        //no filter applyied
        System.out.println("\nNo filter:");
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path)) {
            for (Path file : ds) {
                System.out.println(file.getFileName());
            }
        }

        System.out.println("\nFilter PNG, JPG and BMP files via glob pattern:");
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path, "*.{png,jpg,bmp}")) {
            for (Path file : ds) {
                System.out.println(file.getFileName());
            }
        }

    }


}
