package src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) return;

        String baseName = args[0];
        File sourceFile = new File(baseName + ".251");
        if (!sourceFile.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
            ReservedWords.initialize();
            Lexer lexer = new Lexer(reader);

            List<Token> tokens = new ArrayList<>();
            Token token;
            while ((token = lexer.nextToken()) != null) {
                tokens.add(token);
            }

            LexReportGenerator.generate(baseName, tokens);
            TabReportGenerator.generate(baseName);

            System.out.println("Relatorios Gerados");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

