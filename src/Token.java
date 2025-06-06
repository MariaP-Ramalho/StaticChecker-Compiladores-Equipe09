package src;

public class Token {
    public final String lexeme;
    public final String atomCode;
    public final int symbolTableIndex;
    public final int line;

    public Token(String lexeme, String atomCode, int symbolTableIndex, int line) {
        this.lexeme = lexeme;
        this.atomCode = atomCode;
        this.symbolTableIndex = symbolTableIndex;
        this.line = line;
    }
}
