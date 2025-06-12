package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TabReportGenerator {

    public static void generate(String baseName) throws IOException {
        String filename = baseName + ".TAB";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        writer.write("Código da Equipe: EQ09\n");
        writer.write("Componentes:\n");
        writer.write("  Maria Eduarda Pamponet Ramalho; mariaeduarda.ramalho@ucsal.edu.br; (71) 98732-4542\n");
        writer.write("  Lavínia Énora Santana Cunha; Lavínia.cunha@ucsal.edu.br; (71) 98745-1493\n");
        writer.write("  Beatriz Nascimento Gibaut Santos; beatriznascimento.santos@ucsal.edu.br; (71) 99958-7888\n");
        writer.write("  João Antônio Luz dos Santos; joaoantonio.santos@ucsal.edu.br; (71) 99721-1113\n");
        writer.write("\nRELATÓRIO DA TABELA DE SÍMBOLOS. Texto fonte analisado: " + baseName + ".251\n\n");

        List<SymbolTable.SymbolEntry> symbols = SymbolTable.getAll();

        for (int i = 0; i < symbols.size(); i++) {
            SymbolTable.SymbolEntry entry = symbols.get(i);
            writer.write(String.format("Entrada: %d\n", i + 1));
            writer.write(String.format("Código do átomo: %s\n", entry.atomCode));
            writer.write(String.format("Lexema: %s\n", entry.lexeme));
            writer.write(String.format("Tamanho antes da truncagem: %d\n", entry.originalLength));
            writer.write(String.format("Tamanho depois da truncagem: %d\n", entry.truncatedLength));
            writer.write(String.format("Tipo do símbolo: %s\n", entry.type));

            List<Integer> lines = entry.getLines();
            writer.write("Linhas de ocorrência: ");
            for (int j = 0; j < lines.size(); j++) {
                writer.write(String.valueOf(lines.get(j)));
                if (j < lines.size() - 1) writer.write(", ");
            }
            writer.write("\n------------------------------------------------------------------------\n");
        }

        writer.close();
    }
}
