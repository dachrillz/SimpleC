package lang.ast;

import beaver.*;
import java.util.ArrayList;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "parser.beaver".
 */
public class LangParser extends Parser {
	static public class Terminals {
		static public final short EOF = 0;
		static public final short LPAREN = 1;
		static public final short ID = 2;
		static public final short NUMERAL = 3;
		static public final short RPAREN = 4;
		static public final short LT = 5;
		static public final short GT = 6;
		static public final short GTE = 7;
		static public final short LTE = 8;
		static public final short EQ = 9;
		static public final short NEQ = 10;
		static public final short INT = 11;
		static public final short SEMICOLON = 12;
		static public final short PLUS = 13;
		static public final short MINUS = 14;
		static public final short IF = 15;
		static public final short WHILE = 16;
		static public final short RETURN = 17;
		static public final short RBRACE = 18;
		static public final short MUL = 19;
		static public final short DIV = 20;
		static public final short MOD = 21;
		static public final short LBRACE = 22;
		static public final short COMMA = 23;
		static public final short ELSE = 24;
		static public final short EQUALS = 25;

		static public final String[] NAMES = {
			"EOF",
			"LPAREN",
			"ID",
			"NUMERAL",
			"RPAREN",
			"LT",
			"GT",
			"GTE",
			"LTE",
			"EQ",
			"NEQ",
			"INT",
			"SEMICOLON",
			"PLUS",
			"MINUS",
			"IF",
			"WHILE",
			"RETURN",
			"RBRACE",
			"MUL",
			"DIV",
			"MOD",
			"LBRACE",
			"COMMA",
			"ELSE",
			"EQUALS"
		};
	}

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9pDbZjiN4KKXl#vkt5iDdPYSFn8Y6DxanW2uH4W4720F1rU1aG35EaeW8Q23Y4e40KK22G" +
		"Y8K222YGA2XeA2f22H445I3GGWaaW3qByvfKmV7Fdx6QkirasGaZSet$$C$yvz#oPsJjpLy" +
		"hs#ODdJINZKOteCgsqqIfLjKxT$gVKjCGuvgvHluQqtXzEJMt6CMUZwJ#cfdRZc7EbrVaXD" +
		"NKPnvohJFykDNKOnvnhJ3zOcDzoutjLrbBTQVgt1JiTsMPzZwcJgUbwuvXpY#dVfwORZKC$" +
		"VTfk#f7KTAjnhBF3vdueDUqrhlKJzLzIqzsWLuF#P6gQ047zEJK91FL4QgWdSlLuQgZ7S$L" +
		"OQgZ7SlLeQgX7WqgVA#Wp$WgRjLjtw29r#bF1TBEkqxWgSIue2xcTicXK5$nyRZ6sa5TQw#" +
		"TZNOlDssfq#hbWLdUhLPYpt3cBMgvr5dDlhrUO3MRgBgimwsTocxLeL6VyT6unDcFgj9$AB" +
		"SQcJPso7c9iIlT9okX1$Xky#6qzkbINwmfjqjLeb#ZQWhAbC3ftLM#YsW3ZMhLj$v1$sw8L" +
		"62Qs0NJwFwLwbVIEdOMATsbF4brsGVx5TMzrtRkXxervxy$uF$nlhCvVu5V$UzvHEQZ12Mh" +
		"j2bavXwmbQcCVjwk3PsoOx#jK5tDSJTThMCyUhPHZrKkiKxcGcpNCBUQu5dBABUIqybszBU" +
		"GiivmHziywhM$QJvnrfUcyOevheP$#fZcnJc$JdflrCs8vZLUje7h$7wknpzglCAYrdCSLK" +
		"vUpTxfvacjpQKMDbVvDXV#3EipwL5NXSmE8wkBLM$mS5f#uHglAk5wjbVoqfn0Bg716#7gL" +
		"uXrfnJuwJACNvZVtP6ULvqpop2HsL0aMFL#$r5TZJBh$sNZl4xmQTe2T#Al09l0S60CJadi" +
		"FZ1BV1Mz62##In$2tKIgStIlmFmHxyLy4NuCtGJVu15J1byJntLRyIPXQdC1o3yFZu27mE7" +
		"WQxH7u9V0s#80n$Uaa$1JCwUkU1oNmCkX2#nGUW5#3tm2VuU#7lm0FW7sCtuBV0OVmtuNvR" +
		"#4UnNyTl8y$3vu4pp3F3lW5z0Fmgo3SUuRnvyIsm$nRoNQ3FM0yhg5xXRKu4lmQk1uywplM" +
		"mfrEuyNShAVcKsVAxjzlznwmd07JsqpVOZnvRZrtU54l$SORZSUC9nhqCfZK#OXnbiIgIUm" +
		"hnkt9cDyewphV7EtxFZwF7gug$mSSdm4PxnW1ntkrdRUD0oNEweoTKG9bi1HKG9PZY9mXU9" +
		"1uOpZsIydWs3sb18udF#nvnxwA6FqRY2NrIm==");

	static public class SyntaxError extends RuntimeException { public SyntaxError(String msg) {super(msg);}}
	// Disable syntax error recovery
	protected void recoverFromError(Symbol token, TokenStream in) {
		throw new SyntaxError("Cannot recover from the syntax error");
	}

	public LangParser() {
		super(PARSING_TABLES);
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		switch(rule_num) {
			case 0: // program = programlist.a
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final List a = (List) _symbol_a.value;
					 return new Program(a);
			}
			case 1: // programlist = function.a
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Function a = (Function) _symbol_a.value;
					 return new List().add(a);
			}
			case 2: // programlist = programlist.a function.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final List a = (List) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 2];
					final Function b = (Function) _symbol_b.value;
					 return a.add(b);
			}
			case 5: // function = INT ID.id LPAREN opt$functionarguments.arg RPAREN LBRACE statementlist.sl RBRACE
			{
					final Symbol id = _symbols[offset + 2];
					final Symbol _symbol_arg = _symbols[offset + 4];
					final List arg = (List) _symbol_arg.value;
					final Symbol _symbol_sl = _symbols[offset + 7];
					final List sl = (List) _symbol_sl.value;
					 return new Function(id, arg, sl);
			}
			case 6: // functionarguments = functionargument.a
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final ASTNode a = (ASTNode) _symbol_a.value;
					 return new List().add(a);
			}
			case 7: // functionarguments = functionarguments.a COMMA functionargument.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final List a = (List) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final ASTNode b = (ASTNode) _symbol_b.value;
					 return a.add(b);
			}
			case 8: // functionargument = INT ID.a
			{
					final Symbol a = _symbols[offset + 2];
					 return new Var(a);
			}
			case 9: // statement = INT ID.a SEMICOLON
			{
					final Symbol a = _symbols[offset + 2];
					 return new IdDecl(a);
			}
			case 10: // statement = ID.a EQUALS expr.b SEMICOLON
			{
					final Symbol a = _symbols[offset + 1];
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new IdUse(a, b);
			}
			case 11: // statement = WHILE LPAREN expr.a RPAREN LBRACE statementlist.b RBRACE
			{
					final Symbol _symbol_a = _symbols[offset + 3];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 6];
					final List b = (List) _symbol_b.value;
					 return new While(a,b);
			}
			case 12: // statement = IF LPAREN expr.a RPAREN LBRACE statementlist.b RBRACE ELSE LBRACE statementlist.c RBRACE
			{
					final Symbol _symbol_a = _symbols[offset + 3];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 6];
					final List b = (List) _symbol_b.value;
					final Symbol _symbol_c = _symbols[offset + 10];
					final List c = (List) _symbol_c.value;
					 return new If(a,b,c);
			}
			case 13: // statement = expr.a SEMICOLON
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					 return new ExpressionStatement(a);
			}
			case 14: // statement = RETURN SEMICOLON
			{
					 return new Return();
			}
			case 15: // statementlist = statement.a
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Statement a = (Statement) _symbol_a.value;
					 return new List().add(a);
			}
			case 16: // statementlist = statementlist.a statement.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final List a = (List) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 2];
					final Statement b = (Statement) _symbol_b.value;
					 return a.add(b);
			}
			case 17: // expr = expr.a LT arexpr.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new LT(a,b);
			}
			case 18: // expr = expr.a GT arexpr.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new GT(a,b);
			}
			case 19: // expr = expr.a GTE arexpr.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new GTE(a,b);
			}
			case 20: // expr = expr.a LTE arexpr.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new LTE(a,b);
			}
			case 21: // expr = expr.a EQ arexpr.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new EQ(a,b);
			}
			case 22: // expr = expr.a NEQ arexpr.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new NEQ(a,b);
			}
			case 23: // expr = arexpr.a
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					 return a;
			}
			case 24: // arexpr = arexpr.a PLUS term.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new Plus(a,b);
			}
			case 25: // arexpr = arexpr.a MINUS term.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new Minus(a,b);
			}
			case 26: // arexpr = term.a
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					 return a;
			}
			case 27: // term = term.a MUL factor.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new Mul(a,b);
			}
			case 28: // term = term.a DIV factor.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new Div(a,b);
			}
			case 29: // term = term.a MOD factor.b
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					final Symbol _symbol_b = _symbols[offset + 3];
					final Expr b = (Expr) _symbol_b.value;
					 return new Mod(a,b);
			}
			case 30: // term = factor.a
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					 return a;
			}
			case 31: // factor = LPAREN expr.a RPAREN
			{
					final Symbol _symbol_a = _symbols[offset + 2];
					final Expr a = (Expr) _symbol_a.value;
					 return a;
			}
			case 32: // factor = op.a
			{
					final Symbol _symbol_a = _symbols[offset + 1];
					final Expr a = (Expr) _symbol_a.value;
					 return a;
			}
			case 33: // op = ID.a
			{
					final Symbol a = _symbols[offset + 1];
					 return new Var(a);
			}
			case 34: // op = NUMERAL.a
			{
					final Symbol a = _symbols[offset + 1];
					 return new Numeral(a);
			}
			case 3: // opt$functionarguments = 
			{
				return new Symbol(null);
			}
			case 4: // opt$functionarguments = functionarguments
			{
				return _symbols[offset + 1];
			}
			default:
				throw new IllegalArgumentException("unknown production #" + rule_num);
		}
	}
}
