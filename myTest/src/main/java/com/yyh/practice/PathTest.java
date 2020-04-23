package com.yyh.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.EnumSet;
import java.util.stream.Stream;

public class PathTest {
    public static void main(String[] args) throws IOException {
        //fixPath();

        //comparePath();

        //copyFileVisit();

        //searchFile();

        //streamOfPath();

        //readFile();


        findFile();
        return;
    }

    private static void findFile() throws IOException {
        Path startPath = Paths.get("C:/Software");

        System.out.println("Find all files ending with the '.properties' extension and following symbolic links: ");
        Stream<Path> resultAsStream1
                = Files.find(
                startPath,
                Integer.MAX_VALUE,
                (path, attr) -> path.toString().endsWith(".txt"),
                FileVisitOption.FOLLOW_LINKS
        );

        resultAsStream1.forEach(System.out::println);

        System.out.println("\n\nFind all regular files whose names start with 'application': ");
        Stream<Path> resultAsStream2
                = Files.find(
                startPath,
                Integer.MAX_VALUE,
                (path, attr) -> attr.isRegularFile()
                        && path.getFileName().toString().startsWith("lomb")
        );

        resultAsStream2.forEach(System.out::println);

        System.out.println("\n\nFind all directories created after 16 March 2019: ");
        Stream<Path> resultAsStream3
                = Files.find(
                startPath,
                Integer.MAX_VALUE,
                (path, attr) -> attr.isDirectory()
                        && attr.creationTime().toInstant().
                        isAfter(LocalDate.of(2019, 3, 16).atStartOfDay().
                                toInstant(ZoneOffset.UTC))
        );

        resultAsStream3.forEach(System.out::println);

        System.out.println("\n\nFind all Java files: ");
        Stream<Path> resultAsStream4 = fetchFilesMatching(startPath, "glob:**/*.java");

        resultAsStream4.forEach(System.out::println);
    }

    private static Stream<Path> fetchFilesMatching(Path root, String syntaxPattern)
            throws IOException {

        final PathMatcher matcher = root.getFileSystem().getPathMatcher(syntaxPattern);

        return Files.find(
                root, Integer.MAX_VALUE, (path, attr)
                        -> matcher.matches(path) && !attr.isDirectory()
        );
    }

    private static void readFile() {
        String FILE_PATH = "C:/Users/yhyeoh/IdeaProjects/testdoc.txt";
        System.out.println("Using Files.lines(): ");
        try (Stream<String> filesStream = Files.lines(
                Paths.get(FILE_PATH), StandardCharsets.UTF_8)) {

            filesStream.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            // handle IOException if needed, otherwise remove the catch block
        }

        System.out.println("\nUsing BufferedReader.lines(): ");
        try (BufferedReader brStream = Files.newBufferedReader(
                Paths.get(FILE_PATH), StandardCharsets.UTF_8)) {

            brStream.lines().forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            // handle IOException if needed, otherwise remove the catch block
        }
    }

    private static void streamOfPath() throws IOException {
        Path directory = Paths.get("C:/Data1/music");

        Stream<Path> streamOfPath = Files.walk(directory, FileVisitOption.FOLLOW_LINKS);

        streamOfPath.filter(e -> e.startsWith("C:/Data1/music/Alter Bridge - Walk the Sky [2019] [320]"))
                .forEach(System.out::println);
    }

    private static void searchFile() throws IOException {
        Path searchFile = Paths.get("Redis-in-Action.pdf");

        SearchFileVisitor searchFileVisitor = new SearchFileVisitor(searchFile);
        EnumSet opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        //Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();
        //for (Path root : roots) {
        //    System.out.println("rt: " + root);
        //}
        Path root = Paths.get("C:/Users/yhyeoh/Documents/Books");
        if (!searchFileVisitor.isFileFound()) {
            Files.walkFileTree(root, opts, Integer.MAX_VALUE, searchFileVisitor);
        }

        if (!searchFileVisitor.isFileFound()) {
            System.out.println("The file " + searchFile + " was not found!");
        }
    }

    private static void copyFileVisit() throws IOException {
        Path copyFrom = Paths.get("D:/learning/packt");
        Path copyTo = Paths.get("D:/e-courses");

        CopyFileVisitor copyFileVisitor = new CopyFileVisitor(copyFrom, copyTo);
        EnumSet opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        Files.walkFileTree(copyFrom, opts, Integer.MAX_VALUE, copyFileVisitor);
    }

    private static void comparePath() {
        Path path1 = Paths.get("/learning/packt/JavaModernChallenge.pdf");
        Path path2 = Paths.get("/LEARNING/PACKT/JavaModernChallenge.pdf");
        Path path3 = Paths.get("D:/learning/packt/JavaModernChallenge.pdf");

        boolean path1EqualsPath2 = path1.equals(path2);
        boolean path2EqualsPath3 = path2.equals(path3);
        System.out.println("path1.equals(path2): " + path1EqualsPath2);
        System.out.println("path2.equals(path3): " + path2EqualsPath3);

        /*boolean path1IsSameFilePath2 = Files.isSameFile(path1, path2);
        boolean path1IsSameFilePath3 = Files.isSameFile(path1, path3);
        boolean path2IsSameFilePath3 = Files.isSameFile(path2, path3);
        System.out.println("\nisSameFile(path1, path2): " + path1IsSameFilePath2);
        System.out.println("isSameFile(path1, path3): " + path1IsSameFilePath3);
        System.out.println("isSameFile(path2, path3): " + path2IsSameFilePath3);*/

        int path1compareToPath2 = path1.compareTo(path2);
        int path1compareToPath3 = path1.compareTo(path3);
        int path2compareToPath3 = path2.compareTo(path3);
        System.out.println("\npath1.compareTo(path2): " + path1compareToPath2);
        System.out.println("path1.compareTo(path3): " + path1compareToPath3);
        System.out.println("path2.compareTo(path3): " + path2compareToPath3);

        boolean sw = path1.startsWith("/learning/packt");
        boolean ew = path1.endsWith("JavaModernChallenge.pdf");
        System.out.println("\nStart width: " + sw);
        System.out.println("End with: " + ew);
    }

    private static void fixPath() {
        // fix path
        Path base1 = Paths.get("D:/learning/packt");

        Path path1 = base1.resolve("JBossTools3.pdf");
        System.out.println("path1: " + path1);

        Path path2 = base1.resolve("MasteringJSF22.pdf");
        System.out.println("path2: " + path2 + "\n");

        Path basePath = Paths.get("D:/learning/packt");
        String[] books = {"Book1.pdf", "Book2.pdf", "Book3.pdf"};
        for (String book : books) {
            Path nextBook = basePath.resolve(book);
            System.out.println("nextBook: " + nextBook);
        }

        // fix path
        Path base2 = Paths.get("D:/learning/packt/JavaModernChallenge.pdf");

        Path path3 = base2.resolveSibling("MasteringJSF22.pdf");
        System.out.println("path3 \n" + path3);

        Path path4 = base2.getParent().resolveSibling("publisher").resolve("MyBook.pdf");
        System.out.println("path4 \n" + path4);
    }
}
