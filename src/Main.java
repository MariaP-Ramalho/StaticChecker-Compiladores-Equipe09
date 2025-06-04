package src;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java Main <nome_do_arquivo_sem_extensao>");
            return;
        }

        String baseName = args[0];
        String filePath = baseName + ".251";
        File sourceFile = new File(filePath);

        if (!sourceFile.exists()) {
            System.out.println("Arquivo não encontrado: " + filePath);
            return;
        }

        try {
            FileHandler.readFile(sourceFile);
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        ReservedWords.initialize();

    }
}
