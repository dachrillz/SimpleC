/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/lang.ast:11
 * @astdecl IfElse : Statement ::= Condition:Expr Then:Block Else:Block;
 * @production IfElse : {@link Statement} ::= <span class="component">Condition:{@link Expr}</span> <span class="component">Then:{@link Block}</span> <span class="component">Else:{@link Block}</span>;

 */
public class IfElse extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/PrettyPrint.jrag:229
   */
  public void prettyPrint(PrintStream out, String ind) {
		
		out.print(ind + "if(");
		getCondition().prettyPrint(out, ind);
		out.print(") ");
		out.println("{");
		getThen().prettyPrint(out, ind + "    ");
		out.println(ind + "}");

		out.print(ind + "else");
		out.println("{");
		getElse().prettyPrint(out, ind + "    ");
		out.println(ind + "}");  

	}
  /**
   * @aspect Visitor
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/Visitor.jrag:102
   */
  public Object accept(Visitor visitor, Object data){
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public IfElse() {
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
    children = new ASTNode[3];
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Condition", "Then", "Else"},
    type = {"Expr", "Block", "Block"},
    kind = {"Child", "Child", "Child"}
  )
  public IfElse(Expr p0, Block p1, Block p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 3;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:28
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public IfElse clone() throws CloneNotSupportedException {
    IfElse node = (IfElse) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public IfElse copy() {
    try {
      IfElse node = (IfElse) clone();
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
   * @declaredat ASTNode:60
   */
  @Deprecated
  public IfElse fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public IfElse treeCopyNoTransform() {
    IfElse tree = (IfElse) copy();
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
   * @declaredat ASTNode:90
   */
  public IfElse treeCopy() {
    IfElse tree = (IfElse) copy();
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
   * @declaredat ASTNode:104
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
   * Replaces the Then child.
   * @param node The new node to replace the Then child.
   * @apilevel high-level
   */
  public void setThen(Block node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Then child.
   * @return The current node used as the Then child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Then")
  public Block getThen() {
    return (Block) getChild(1);
  }
  /**
   * Retrieves the Then child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Then child.
   * @apilevel low-level
   */
  public Block getThenNoTransform() {
    return (Block) getChildNoTransform(1);
  }
  /**
   * Replaces the Else child.
   * @param node The new node to replace the Else child.
   * @apilevel high-level
   */
  public void setElse(Block node) {
    setChild(node, 2);
  }
  /**
   * Retrieves the Else child.
   * @return The current node used as the Else child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Else")
  public Block getElse() {
    return (Block) getChild(2);
  }
  /**
   * Retrieves the Else child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Else child.
   * @apilevel low-level
   */
  public Block getElseNoTransform() {
    return (Block) getChildNoTransform(2);
  }
}
