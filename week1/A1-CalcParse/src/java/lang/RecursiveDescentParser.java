package lang;
import lang.ast.LangParser;
import lang.ast.LangScanner;
import static lang.ast.LangParser.Terminals.*;
/**
* Abstract base class for recursive decent parsers.
* You should implement the parseProgram() method to parse a MiniS program.
*/
public class RecursiveDescentParser {

    static public class T {
		static public final short EOF = 0;
		static public final short OD = 1;
		static public final short FI = 2;
		static public final short ID = 3;
		static public final short UNTIL = 4;
		static public final short DO = 5;
		static public final short THEN = 6;
		static public final short NOT = 7;
		static public final short NUMERAL = 8;
		static public final short FOR = 9;
		static public final short ASSIGN = 10;
		static public final short IF = 11;

		static public final String[] NAMES = {
			"EOF",
			"OD",
			"FI",
			"ID",
			"UNTIL",
			"DO",
			"THEN",
			"NOT",
			"NUMERAL",
			"FOR",
			"ASSIGN",
			"IF"
		};
    }
    
    private LangScanner scanner;
    private beaver.Symbol currentToken;
    /** Initialize the parser and start parsing via the parseProgram() method. */
    public String parse(LangScanner scanner) {
        this.scanner = scanner;
        parseProgram();
        accept(EOF); // Ensure all input is processed.
        return "ok";
    }

    protected void parseProgram(){
        switch(peek()){
            case T.ID: S(); break;
            case T.FOR: S(); break;
            case T.IF: S(); break;
            default: error("Error in the custom parser :P");
        }   
    }

    protected void S(){
        switch(peek()){
            case T.FOR: accept(T.FOR); accept(T.ID); accept(T.ASSIGN); 
                        E(); accept(T.UNTIL); E(); accept(T.DO); S(); accept(T.OD); break;
            case T.IF: accept(T.IF); E(); accept(T.THEN); S(); accept(T.FI); break;
            case T.ID: accept(T.ID); accept(T.ASSIGN); E(); break;  
            default: error("Error in statement");
        }
    }

    protected void E(){
        switch(peek()){
            case T.ID: accept(T.ID); break;
            case T.NUMERAL: accept(T.NUMERAL); break;
            case T.NOT: accept(T.NOT); accept(T.NUMERAL); break;
            default: error("Error in expression");
        }
    }

    /** Returns the current token without proceeding to the next. */
    protected int peek() {
        if (currentToken == null) accept();
        return currentToken.getId();
    }
    /** Read the next token from the scanner. */
    protected void accept() {
        try {
            currentToken = scanner.nextToken();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /** Ensure the current token is of a certain type; then read the next. */
    protected void accept(int expectedToken) {

        if (peek() != expectedToken) {
            error("expected token " +
            LangParser.Terminals.NAMES[expectedToken] +
            " got token " +
            LangParser.Terminals.NAMES[currentToken.getId()]);
        }
        accept();
    }

    protected static void error(String message) {
        throw new RuntimeException(message);
    }
}