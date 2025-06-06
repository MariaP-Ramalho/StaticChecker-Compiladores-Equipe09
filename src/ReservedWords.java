package src;

import java.util.HashMap;
import java.util.Map;

public class ReservedWords {
    private static final Map<String, String> reservedWords = new HashMap<>();

    public static void initialize() {
        reservedWords.clear();

        reservedWords.put("INTEGER", "PRS10");
        reservedWords.put("REAL", "PRS02");
        reservedWords.put("CHARACTER", "PRS03");
        reservedWords.put("STRING", "PRS04");
        reservedWords.put("BOOLEAN", "PRS05");
        reservedWords.put("VOID", "PRS06");
        reservedWords.put("TRUE", "PRS07");
        reservedWords.put("FALSE", "PRS08");
        reservedWords.put("VARTYPE", "PRS09");
        reservedWords.put("FUNCTYPE", "PRS10");
        reservedWords.put("PARAMTYPE", "PRS11");
        reservedWords.put("DECLARATIONS", "PRS12");
        reservedWords.put("ENDDECLARATIONS", "PRS13");
        reservedWords.put("PROGRAM", "PRS14");
        reservedWords.put("ENDPROGRAM", "PRS15");
        reservedWords.put("FUNCTIONS", "PRS16");
        reservedWords.put("ENDFUNCTIONS", "PRS17");
        reservedWords.put("ENDFUNCTION", "PRS18");
        reservedWords.put("RETURN", "PRS19");
        reservedWords.put("IF", "PRS20");
        reservedWords.put("ELSE", "PRS21");
        reservedWords.put("ENDIF", "PRS22");
        reservedWords.put("WHILE", "PRS23");
        reservedWords.put("ENDWHILE", "PRS24");
        reservedWords.put("BREAK", "PRS25");
        reservedWords.put("PRINT", "PRS26");


        reservedWords.put(";", "SRS01");
        reservedWords.put(",", "SRS02");
        reservedWords.put(":", "SRS03");
        reservedWords.put(":=", "SRS04");
        reservedWords.put("?", "SRS05");
        reservedWords.put("(", "SRS06");
        reservedWords.put(")", "SRS07");
        reservedWords.put("[", "SRS08");
        reservedWords.put("]", "SRS09");
        reservedWords.put("{", "SRS10");
        reservedWords.put("}", "SRS11");
        reservedWords.put("+", "SRS12");
        reservedWords.put("-", "SRS13");
        reservedWords.put("*", "SRS14");
        reservedWords.put("/", "SRS15");
        reservedWords.put("%", "SRS16");
        reservedWords.put("==", "SRS17");
        reservedWords.put("!=", "SRS18");
        reservedWords.put("#", "SRS18");
        reservedWords.put("<", "SRS19");
        reservedWords.put("<=", "SRS20");
        reservedWords.put(">", "SRS21");
        reservedWords.put(">=", "SRS22");
    }

    public static boolean isReserved(String lexeme) {
        return reservedWords.containsKey(lexeme.toUpperCase());
    }

    public static String getCode(String lexeme) {
        return reservedWords.getOrDefault(lexeme.toUpperCase(), null);
    }
}
