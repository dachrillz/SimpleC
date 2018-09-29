/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.HashSet;
/**
 * @ast node
 * @declaredat /home/chrille/compilers/week3/A3-SimpliC/src/jastadd/lang.ast:16
 * @astdecl CallStatement : Statement ::= FuncCall;
 * @production CallStatement : {@link Statement} ::= <span class="component">{@link FuncCall}</span>;

 */
public class CallStatement extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/chrille/compilers/week3/A3-SimpliC/src/jastadd/PrettyPrint.jrag:64
   */
  public void prettyPrint(PrintStream out, String ind){
		out.print(ind);
		getFuncCall().prettyPrint(out, ind);
		out.println(";");
	}
  /**
   * @aspect Visitor
   * @declaredat /home/chrille/compilers/week3/A3-SimpliC/src/jastadd/Visitor.jrag:120
   */
  public Object accept(Visitor visitor, Object data){
		return visitor.visit(this, data);
	}
  /**
   * @aspect NameAnalysis
   * @declaredat /home/chrille/compilers/week3/A3-SimpliC/src/jastadd/NameAnalysis.jrag:126
   */
  public void checkNames(PrintStream err, SymbolTable symbols) {
		getFuncCall().checkNames(err, symbols); 
	}
  /**
   * @declaredat ASTNode:1
   */
  public CallStatement() {
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
    children = new ASTNode[1];
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"FuncCall"},
    type = {"FuncCall"},
    kind = {"Child"}
  )
  public CallStatement(FuncCall p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:22
   */
  protected int numChildren() {
    return 1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:26
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:30
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:34
   */
  public CallStatement clone() throws CloneNotSupportedException {
    CallStatement node = (CallStatement) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:39
   */
  public CallStatement copy() {
    try {
      CallStatement node = (CallStatement) clone();
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
   * @declaredat ASTNode:58
   */
  @Deprecated
  public CallStatement fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:68
   */
  public CallStatement treeCopyNoTransform() {
    CallStatement tree = (CallStatement) copy();
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
   * @declaredat ASTNode:88
   */
  public CallStatement treeCopy() {
    CallStatement tree = (CallStatement) copy();
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
   * @declaredat ASTNode:102
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the FuncCall child.
   * @param node The new node to replace the FuncCall child.
   * @apilevel high-level
   */
  public void setFuncCall(FuncCall node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the FuncCall child.
   * @return The current node used as the FuncCall child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="FuncCall")
  public FuncCall getFuncCall() {
    return (FuncCall) getChild(0);
  }
  /**
   * Retrieves the FuncCall child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the FuncCall child.
   * @apilevel low-level
   */
  public FuncCall getFuncCallNoTransform() {
    return (FuncCall) getChildNoTransform(0);
  }
}
