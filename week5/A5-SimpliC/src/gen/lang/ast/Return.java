/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Scanner;
/**
 * @ast node
 * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/lang.ast:13
 * @astdecl Return : Statement ::= Expr;
 * @production Return : {@link Statement} ::= <span class="component">{@link Expr}</span>;

 */
public class Return extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/PrettyPrint.jrag:201
   */
  public void prettyPrint(PrintStream out, String ind) {
		out.print(ind + "return ");
		getExpr().prettyPrint(out, ind);
		out.println(";");
	}
  /**
   * @aspect Visitor
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/Visitor.jrag:120
   */
  public Object accept(Visitor visitor, Object data){
		return visitor.visit(this, data);
	}
  /**
   * @aspect Interpreter
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/interpreter.jrag:42
   */
  public WrappedInteger eval(ActivationRecord actrec){
        int temp = getExpr().eval(actrec);
        return new WrappedInteger(temp, false);
    }
  /**
   * @declaredat ASTNode:1
   */
  public Return() {
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
    name = {"Expr"},
    type = {"Expr"},
    kind = {"Child"}
  )
  public Return(Expr p0) {
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
  public Return clone() throws CloneNotSupportedException {
    Return node = (Return) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:39
   */
  public Return copy() {
    try {
      Return node = (Return) clone();
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
  public Return fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:68
   */
  public Return treeCopyNoTransform() {
    Return tree = (Return) copy();
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
  public Return treeCopy() {
    Return tree = (Return) copy();
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
   * Replaces the Expr child.
   * @param node The new node to replace the Expr child.
   * @apilevel high-level
   */
  public void setExpr(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Expr child.
   * @return The current node used as the Expr child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Expr")
  public Expr getExpr() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the Expr child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Expr child.
   * @apilevel low-level
   */
  public Expr getExprNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/Errors.jrag:55
    if (getExpr().type() != intType()) {
      {
        Program target = (Program) (program());
        java.util.Set<ASTNode> contributors = _map.get(target);
        if (contributors == null) {
          contributors = new java.util.LinkedHashSet<ASTNode>();
          _map.put((ASTNode) target, contributors);
        }
        contributors.add(this);
      }
    }
    super.collect_contributors_Program_errors(_root, _map);
  }
  /** @apilevel internal */
  protected void contributeTo_Program_errors(Set<ErrorMessage> collection) {
    super.contributeTo_Program_errors(collection);
    if (getExpr().type() != intType()) {
      collection.add(error("The return value is of the type: " + getExpr().type() + " , but was expected to be " + intType()));
    }
  }
}
