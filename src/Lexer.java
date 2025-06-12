package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private final List<String> lines;
    private int lineIndex = 0;
    private int charIndex = 0;

    public Lexer(BufferedReader reader) throws IOException {
        lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
    }

    public Token nextToken() {
        while (lineIndex < lines.size()) {
            String line = lines.get(lineIndex);

            while (charIndex < line.length()) {
                char c = line.charAt(charIndex);

                if (Character.isWhitespace(c)) {
                    charIndex++;
                    continue;
                }

                if (c == '"') {
                    StringBuilder full = new StringBuilder();
                    StringBuilder valid = new StringBuilder();
                    int count = 0;

                    while (charIndex < line.length()) {
                        char ch = line.charAt(charIndex);
                        full.append(ch);
                        if (count < 32) count++;
                        if (valid.length() < 32) valid.append(ch);
                        charIndex++;
                        if (ch == '"' && full.length() > 1) break;
                    }

                    int index = SymbolTable.insert(valid.toString(), "IDN06", full.length(), valid.length(), lineIndex + 1);
                    return new Token(valid.toString(), "IDN06", index, lineIndex + 1);
                }

                if (c == '\'' && (charIndex + 2 < line.length()) && line.charAt(charIndex + 2) == '\'') {
                    String lexeme = line.substring(charIndex, charIndex + 3);
                    charIndex += 3;
                    int index = SymbolTable.insert(lexeme, "IDN07", 3, 3, lineIndex + 1);
                    return new Token(lexeme, "IDN07", index, lineIndex + 1);
                }

                if (Character.isDigit(c)) {
                    StringBuilder full = new StringBuilder();
                    StringBuilder valid = new StringBuilder();
                    int validCount = 0;

                    while (charIndex < line.length()) {
                        char ch = line.charAt(charIndex);
                        if (Character.isDigit(ch) || ch == '.' || ch == 'e' || ch == '-' || ch == '+') {
                            full.append(ch);
                            if (validCount < 32) {
                                valid.append(ch);
                                validCount++;
                            }
                            charIndex++;
                        } else break;
                    }

                    String fullStr = full.toString();
                    String code = fullStr.matches("^\\d+$") ? "IDN04" : "IDN05";
                    int index = SymbolTable.insert(valid.toString(), code, fullStr.length(), valid.length(), lineIndex + 1);
                    return new Token(valid.toString(), code, index, lineIndex + 1);
                }

                if (Character.isLetter(c)) {
                    StringBuilder full = new StringBuilder();
                    StringBuilder valid = new StringBuilder();
                    int validCount = 0;

                    while (charIndex < line.length()) {
                        char ch = line.charAt(charIndex);
                        if (Character.isLetterOrDigit(ch) || ch == '_') {
                            full.append(ch);
                            if (validCount < 32) {
                                valid.append(ch);
                                validCount++;
                            }
                            charIndex++;
                        } else break;
                    }

                    String fullLex = full.toString().toUpperCase();
                    String validLex = valid.toString().toUpperCase();

                    if (ReservedWords.isReserved(fullLex)) {
                        return new Token(validLex, ReservedWords.getCode(fullLex), -1, lineIndex + 1);
                    }

                    String code = "IDN02";
                    int index = SymbolTable.insert(validLex, code, fullLex.length(), validLex.length(), lineIndex + 1);
                    return new Token(validLex, code, index, lineIndex + 1);
                }

                if (charIndex + 1 < line.length()) {
                    String two = line.substring(charIndex, charIndex + 2);
                    if (ReservedWords.isReserved(two)) {
                        charIndex += 2;
                        return new Token(two, ReservedWords.getCode(two), -1, lineIndex + 1);
                    }
                }

                String one = String.valueOf(c);
                if (ReservedWords.isReserved(one)) {
                    charIndex++;
                    return new Token(one, ReservedWords.getCode(one), -1, lineIndex + 1);
                }

                charIndex++;
            }

            lineIndex++;
            charIndex = 0;
        }

        return null;
    }
}
