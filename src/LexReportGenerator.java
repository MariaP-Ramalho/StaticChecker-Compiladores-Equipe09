package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LexReportGenerator {

    public static void generate(String baseName, List<Token> tokens) throws IOException {
        String filename = baseName + ".LEX";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        writer.write("Código da Equipe: EQ09\n");
        writer.write("Componentes:\n");
        writer.write("      Maria Eduarda Pamponet Ramalho; mariaeduarda.ramalho@ucsal.edu.br; (71) 98732-4542\n");
        writer.write("      Lavínia Énora Santana Cunha; Lavínia.cunha@ucsal.edu.br; (71) 98745-1493\n");
        writer.write("      Beatriz Nascimento Gibaut Santos; beatriznascimento.santos@ucsal.edu.br; (71) 99958-7888\n");
        writer.write("      João Antônio Luz dos Santos; joaoantonio.santos@ucsal.edu.br; (71) 99721-1113\n");
        writer.write("\nRELATÓRIO DE ANÁLISE LÉXICA. Texto fonte analisado: " + baseName + ".251\n\n");

        for (Token token : tokens) {
            String linha = String.format(
                    "Lexeme: %s, Codigo: %s, IndiceTabSimb: %s, Linha: %d.",
                    token.lexeme,
                    token.atomCode,
                    token.symbolTableIndex >= 0 ? (token.symbolTableIndex + 1) : "-",
                    token.line
            );
            writer.write(linha);
            writer.write("\n------------------------------------------------------------------------\n");
        }

        writer.close();
    }
}

