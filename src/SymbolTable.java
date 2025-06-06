package src;

import java.util.*;

public class SymbolTable {
    private static final List<SymbolEntry> table = new ArrayList<>();

    public static int insert(String lexeme, String atomCode, int originalLength, int truncatedLength, int line) {
        String lex = lexeme.toUpperCase();

        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).lexeme.equals(lex)) {
                table.get(i).addLine(line);
                return i;
            }
        }

        SymbolEntry entry = new SymbolEntry(atomCode, lex, originalLength, truncatedLength);
        entry.addLine(line);
        table.add(entry);
        return table.size() - 1;
    }

    public static SymbolEntry get(int index) {
        if (index >= 0 && index < table.size()) {
            return table.get(index);
        }
        return null;
    }

    public static int size() {
        return table.size();
    }

    public static List<SymbolEntry> getAll() {
        return Collections.unmodifiableList(table);
    }

    public static class SymbolEntry {
        public final String atomCode;
        public final String lexeme;
        public final int originalLength;
        public final int truncatedLength;
        public String type = "--";
        private final List<Integer> lines = new ArrayList<>();

        public SymbolEntry(String atomCode, String lexeme, int originalLength, int truncatedLength) {
            this.atomCode = atomCode;
            this.lexeme = lexeme;
            this.originalLength = originalLength;
            this.truncatedLength = truncatedLength;
        }

        public void setType(String typeCode) {
            this.type = typeCode;
        }

        public void addLine(int lineNumber) {
            if (lines.size() < 5 && !lines.contains(lineNumber)) {
                lines.add(lineNumber);
            }
        }

        public List<Integer> getLines() {
            return lines;
        }
    }
}
