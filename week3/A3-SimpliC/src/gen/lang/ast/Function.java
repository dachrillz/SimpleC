/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.HashSet;
/**
 * @ast node
 * @declaredat /home/chrille/compilers/week3/A3-SimpliC/src/jastadd/lang.ast:2
 * @astdecl Function : ASTNode ::= <ID:String> Var* Block;
 * @production Function : {@link ASTNode} ::= <span class="component">&lt;ID:String&gt;</span> <span class="component">{@link Var}*</span> <span class="component">{@link Block}</span>;

 */
public class Function extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/chrille/compilers/week3/A3-SimpliC/src/jastadd/PrettyPrint.jrag:15
   */
  public void prettyPrint(PrintStream out, String ind){
		//a function always starts with int in simpliC
		out.print(ind + "int ");
		out.print(getID());
		out.print("(");
		if(hasVar()){
                out.print("int ");
                getVar(0).prettyPrint(out, ind);
                for (int i = 1; i < getNumVar(); i++){
                    out.print(", int ");
                    getVar(i).prettyPrint(out, ind);
                }
            }
            out.print(")");
            out.println(ind+"{");
            getBlock().prettyPrint(out, ind+"    ");
            out.println(ind+"}");
			out.println("");
	}
  /**
   * @aspect Visitor
   * @declaredat /home/chrille/compilers/week3/A3-SimpliC/src/jastadd/Visitor.jrag:82
   */
  public Object accept(Visitor visitor, Object data){
		return visitor.visit(this, data);
	}
  /**
   * @aspect NameAnalysis
   * @declaredat /home/chrille/compilers/week3/A3-SimpliC/src/jastadd/NameAnalysis.jrag:71
   */
  public void checkNames(PrintStream err, SymbolTable symbols) {
		if(!symbols.declare(getID())) {
            err.format("Error at line %d: symbol \'%s\' has not been declared before this use!", getLine(), getID());
            err.println();
        }
        symbols = symbols.push();
        for( int i = 0; i < getNumVar(); i++) {
            getVar(i).checkNames(err, symbols);
        }
        getBlock().checkNames(err, symbols);
    }
  /**
   * @declaredat ASTNode:1
   */
  public Function() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
    children = new ASTNode[2];
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"ID", "Var", "Block"},
    type = {"String", "List<Var>", "Block"},
    kind = {"Token", "List", "Child"}
  )
  public Function(String p0, List<Var> p1, Block p2) {
    setID(p0);
    setChild(p1, 0);
    setChild(p2, 1);
  }
  /**
   * @declaredat ASTNode:24
   */
  public Function(beaver.Symbol p0, List<Var> p1, Block p2) {
    setID(p0);
    setChild(p1, 0);
    setChild(p2, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:30
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:34
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public Function clone() throws CloneNotSupportedException {
    Function node = (Function) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:47
   */
  public Function copy() {
    try {
      Function node = (Function) clone();
      node.parent = null;
      if (children != null) {
        node.children = (ASTNode[]) children.clone();
      }
      return node;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " + getClass().getName());
    }
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:66
   */
  @Deprecated
  public Function fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:76
   */
  public Function treeCopyNoTransform() {
    Function tree = (Function) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) children[i];
        if (child != null) {
          child = child.treeCopyNoTransform();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:96
   */
  public Function treeCopy() {
    Function tree = (Function) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) getChild(i);
        if (child != null) {
          child = child.treeCopy();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:110
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node) && (tokenString_ID == ((Function) node).tokenString_ID);    
  }
  /**
   * Replaces the lexeme ID.
   * @param value The new value for the lexeme ID.
   * @apilevel high-level
   */
  public void setID(String value) {
    tokenString_ID = value;
  }
  /** @apilevel internal 
   */
  protected String tokenString_ID;
  /**
   */
  public int IDstart;
  /**
   */
  public int IDend;
  /**
   * JastAdd-internal setter for lexeme ID using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme ID
   * @apilevel internal
   */
  public void setID(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setID is only valid for String lexemes");
    tokenString_ID = (String)symbol.value;
    IDstart = symbol.getStart();
    IDend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme ID.
   * @return The value for the lexeme ID.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="ID")
  public String getID() {
    return tokenString_ID != null ? tokenString_ID : "";
  }
  /**
   * Replaces the Var list.
   * @param list The new list node to be used as the Var list.
   * @apilevel high-level
   */
  public void setVarList(List<Var> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the Var list.
   * @return Number of children in the Var list.
   * @apilevel high-level
   */
  public int getNumVar() {
    return getVarList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Var list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Var list.
   * @apilevel low-level
   */
  public int getNumVarNoTransform() {
    return getVarListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Var list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Var list.
   * @apilevel high-level
   */
  public Var getVar(int i) {
    return (Var) getVarList().getChild(i);
  }
  /**
   * Check whether the Var list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasVar() {
    return getVarList().getNumChild() != 0;
  }
  /**
   * Append an element to the Var list.
   * @param node The element to append to the Var list.
   * @apilevel high-level
   */
  public void addVar(Var node) {
    List<Var> list = (parent == null) ? getVarListNoTransform() : getVarList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addVarNoTransform(Var node) {
    List<Var> list = getVarListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Var list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setVar(Var node, int i) {
    List<Var> list = getVarList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Var list.
   * @return The node representing the Var list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Var")
  public List<Var> getVarList() {
    List<Var> list = (List<Var>) getChild(0);
    return list;
  }
  /**
   * Retrieves the Var list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Var list.
   * @apilevel low-level
   */
  public List<Var> getVarListNoTransform() {
    return (List<Var>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the Var list without
   * triggering rewrites.
   */
  public Var getVarNoTransform(int i) {
    return (Var) getVarListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Var list.
   * @return The node representing the Var list.
   * @apilevel high-level
   */
  public List<Var> getVars() {
    return getVarList();
  }
  /**
   * Retrieves the Var list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Var list.
   * @apilevel low-level
   */
  public List<Var> getVarsNoTransform() {
    return getVarListNoTransform();
  }
  /**
   * Replaces the Block child.
   * @param node The new node to replace the Block child.
   * @apilevel high-level
   */
  public void setBlock(Block node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Block child.
   * @return The current node used as the Block child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Block")
  public Block getBlock() {
    return (Block) getChild(1);
  }
  /**
   * Retrieves the Block child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Block child.
   * @apilevel low-level
   */
  public Block getBlockNoTransform() {
    return (Block) getChildNoTransform(1);
  }
}
