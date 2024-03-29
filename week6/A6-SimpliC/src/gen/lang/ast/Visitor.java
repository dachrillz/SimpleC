package lang.ast;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Visitor interface for Calc language. Each concrete node type must
 * have a visit method.
 * @ast interface
 * @aspect Visitor
 * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/Visitor.jrag:44
 */
public interface Visitor {

		 
		public Object visit(LT node, Object data);

		 
		public Object visit(GT node, Object data);

		 
		public Object visit(GTE node, Object data);

		 
		public Object visit(LTE node, Object data);

		 
		public Object visit(EQ node, Object data);

		 
		public Object visit(NEQ node, Object data);

		 
		public Object visit(Mul node, Object data);

		 
		public Object visit(Div node, Object data);

		 
		public Object visit(Minus node, Object data);

		 
		public Object visit(Plus node, Object data);

		 
		public Object visit(Mod node, Object data);

		 
		public Object visit(Numeral node, Object data);

		 
		public Object visit(FuncCall node, Object data);


		 

		public Object visit(CallStatement node, Object data);

		 
		public Object visit(Return node, Object data);

		 
		public Object visit(If node, Object data);

		 
		public Object visit(IfElse node, Object data);

		 
		public Object visit(While node, Object data);

		 
		public Object visit(ExpressionStatement node, Object data);

		 
		public Object visit(List node, Object data);

		 
		public Object visit(Opt node, Object data);

		 
		public Object visit(Program node, Object data);

		 
		public Object visit(IdDecl node, Object data);

		 
		public Object visit(IdUse node, Object data);

		 
		public Object visit(Block node, Object data);

		 
		public Object visit(Function node, Object data);

		 
		public Object visit(Decl node, Object data);

		 
		public Object visit(IntType node, Object data);

		 
		public Object visit(BooleanType node, Object data);
}
