package lang.ast; // The generated scanner will belong to the package lang.ast

import lang.ast.LangParser.Terminals; // The terminals are implicitly defined in the parser
import lang.ast.LangParser.SyntaxError;

%%

// define the signature for the generated scanner
%public
%final
%class LangScanner
%extends beaver.Scanner

// the interface between the scanner and the parser is the nextToken() method
%type beaver.Symbol 
%function nextToken 

// store line and column information in the tokens
%line
%column

// this code will be inlined in the body of the generated scanner class
%{
  private beaver.Symbol sym(short id) {
    return new beaver.Symbol(id, yyline + 1, yycolumn + 1, yylength(), yytext());
  }
%}

// macros
WhiteSpace = [ ] | \t | \f | \n | \r
ID = [a-zA-Z]+
NUMERAL = [0-9]+
COMMENT = \/\/([a-zA-Z]|([ ] | \t .))* \n

%%

// discard whitespace information and comments
{WhiteSpace}  { }
{COMMENT}     { }

// token definitions
"int"         { return sym(Terminals.INT);      }
"("           { return sym(Terminals.LPAREN);   }
")"           { return sym(Terminals.RPAREN);   }
"{"           { return sym(Terminals.LBRACE);   }
"}"           { return sym(Terminals.RBRACE);   }
";"           { return sym(Terminals.SEMICOLON);}
"="           { return sym(Terminals.EQUALS);   }
"*"           { return sym(Terminals.MUL);      }
"+"           { return sym(Terminals.PLUS);     }
"/"           { return sym(Terminals.DIV);      }
"-"           { return sym(Terminals.MINUS);    }
"%"           { return sym(Terminals.MOD);      }
"<"           { return sym(Terminals.LT);       }
">="          { return sym(Terminals.GTE);      }
"<="          { return sym(Terminals.LTE);      }
"!="          { return sym(Terminals.NEQ);      }
"=="          { return sym(Terminals.EQ);       }
">"           { return sym(Terminals.GT);       }
","           { return sym(Terminals.COMMA);       }
"return"      { return sym(Terminals.RETURN);   }
"while"       { return sym(Terminals.WHILE);    }
"if"          { return sym(Terminals.IF);       }
"else"        { return sym(Terminals.ELSE);     }
{ID}          { return sym(Terminals.ID);       }
{NUMERAL}     { return sym(Terminals.NUMERAL);  }
<<EOF>>       { return sym(Terminals.EOF);      }

/* error fallback */
[^]           { throw new SyntaxError("Illegal character <"+yytext()+">"); }
