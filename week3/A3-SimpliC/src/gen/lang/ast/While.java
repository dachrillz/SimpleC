/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.HashSet;
/**
 * @ast node
 * @declaredat /home/chrille/compilers/week3/A3-SimpliC/src/jastadd/lang.ast:12
 * @astdecl While : Statement ::= Condition:Expr Do:Block;
 * @production While : {@link Statement} ::= <span class="component">Condition:{@link Expr}</span> <span class="component">Do:{@link Block}</span>;

 */
public class While extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/chrille/compilers/week3/A3-SimpliC/src/jastadd/PrettyPrint.jrag:224
   */
  public void prettyPrint(PrintStream out, String ind) {
		out.print(ind + "while(");
		getCondition().prettyPrint(out, ind);
		out.print(")");
		out.println("{");
		getDo().prettyPrint(out, ind + "    ");
		out.println(ind + "}");  
	}
  /**
   * @aspect Visitor
   * @declaredat /home/chrille/compilers/week3/A3-SimpliC/src/jastadd/Visitor.jrag:104
   */
  public Object accept(Visitor visitor, Object data){
		return visitor.visit(this, data);
	}
  /**
   * @aspect NameAnalysis
   * @declaredat /home/chrille/compilers/week3/A3-SimpliC/src/jastadd/NameAnalysis.jrag:156
   */
  public void checkNames(PrintStream err, SymbolTable symbols) {
        getCondition().checkNames(err, symbols);
		getDo().checkNames(err, symbols.push());
    }
  /**
   * @declaredat ASTNode:1
   */
  public While() {
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
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Condition", "Do"},
    type = {"Expr", "Block"},
    kind = {"Child", "Child"}
  )
  public While(Expr p0, Block p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:31
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:35
   */
  public While clone() throws CloneNotSupportedException {
    While node = (While) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:40
   */
  public While copy() {
    try {
      While node = (While) clone();
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
   * @declaredat ASTNode:59
   */
  @Deprecated
  public While fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:69
   */
  public While treeCopyNoTransform() {
    While tree = (While) copy();
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
   * @declaredat ASTNode:89
   */
  public While treeCopy() {
    While tree = (While) copy();
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
   * @declaredat ASTNode:103
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Condition child.
   * @param node The new node to replace the Condition child.
   * @apilevel high-level
   */
  public void setCondition(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Condition child.
   * @return The current node used as the Condition child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Condition")
  public Expr getCondition() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the Condition child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Condition child.
   * @apilevel low-level
   */
  public Expr getConditionNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * Replaces the Do child.
   * @param node The new node to replace the Do child.
   * @apilevel high-level
   */
  public void setDo(Block node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Do child.
   * @return The current node used as the Do child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Do")
  public Block getDo() {
    return (Block) getChild(1);
  }
  /**
   * Retrieves the Do child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Do child.
   * @apilevel low-level
   */
  public Block getDoNoTransform() {
    return (Block) getChildNoTransform(1);
  }
}
