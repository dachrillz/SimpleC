package lang;

import lang.ast.*;

/*
Program ::= Function*;
Function ::= <ID> Var* Block;

Block ::= Statement*;

abstract Statement;
IdDecl : Statement ::= <ID>;
ExpressionStatement : Statement ::= Expr;
IdDeclAndUse : Statement ::= <ID> Expr;
IdUse : Statement ::= <ID> Expr;
While : Statement ::= Condition:Expr Do:Block;
IfElse    : Statement ::= Condition:Expr Then:Block Else:Block;
If    : Statement ::= Condition:Expr Then:Block;
Return : Statement ::= Expr;
CallStatement : Statement ::= FuncCall;

abstract Expr;

LT : Expr ::= Left:Expr Right:Expr;
GT : Expr ::= Left:Expr Right:Expr;
GTE : Expr ::= Left:Expr Right:Expr;
LTE : Expr ::= Left:Expr Right:Expr;
EQ : Expr ::= Left:Expr Right:Expr;
NEQ : Expr ::= Left:Expr Right:Expr;
Mul : Expr ::= Left:Expr Right:Expr;
Div : Expr ::= Left:Expr Right:Expr;
Plus : Expr ::= Left:Expr Right:Expr;
Mod : Expr ::= Left:Expr Right:Expr;
Minus : Expr ::= Left:Expr Right:Expr;
Numeral : Expr ::= <NUMERAL>;
Var     : Expr ::= <ID>;
FuncCall: Expr ::= <Name> Args:Expr*;
*/


/**
 * Traverses each node, passing the data to the children.
 * Returns the data unchanged.
 * Overriding methods may change the data passed and the data returned.
 */
public abstract class TraversingVisitor implements lang.ast.Visitor {

	protected Object visitChildren(ASTNode node, Object data) {
		for (int i = 0; i < node.getNumChild(); ++i) {
			node.getChild(i).accept(this, data);
		}
		return data;
	}

	public Object visit(IntType node, Object data){
		return visitChildren(node, data);
	}
	
	public Object visit(BooleanType node, Object data){
		return visitChildren(node, data);
	}

	public Object visit(FuncCall node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(Minus node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(Plus node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Mod node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(Mul node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Div node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(NEQ node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(EQ node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(LTE node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(GTE node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(GT node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(LT node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(CallStatement node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(Return node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(If node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(IfElse node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(While node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(ExpressionStatement node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(List node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Opt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Program node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Numeral node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(IdDecl node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Decl node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(IdUse node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Block node, Object data){
		return visitChildren(node, data);
	}

	public Object visit(Function node, Object data){
		return visitChildren(node, data);
	}
}
