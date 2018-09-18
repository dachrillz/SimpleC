/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/chrille/compilers/week2/A2-MinimalAST/src/jastadd/lang.ast:11
 * @astdecl If : Statement ::= Condition:Expr Then:Statement*;
 * @production If : {@link Statement} ::= <span class="component">Condition:{@link Expr}</span> <span class="component">Then:{@link Statement}*</span>;

 */
public class If extends Statement implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public If() {
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
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Condition", "Then"},
    type = {"Expr", "List<Statement>"},
    kind = {"Child", "List"}
  )
  public If(Expr p0, List<Statement> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 2;
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
  public If clone() throws CloneNotSupportedException {
    If node = (If) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public If copy() {
    try {
      If node = (If) clone();
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
  public If fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public If treeCopyNoTransform() {
    If tree = (If) copy();
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
  public If treeCopy() {
    If tree = (If) copy();
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
   * Replaces the Then list.
   * @param list The new list node to be used as the Then list.
   * @apilevel high-level
   */
  public void setThenList(List<Statement> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the Then list.
   * @return Number of children in the Then list.
   * @apilevel high-level
   */
  public int getNumThen() {
    return getThenList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Then list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Then list.
   * @apilevel low-level
   */
  public int getNumThenNoTransform() {
    return getThenListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Then list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Then list.
   * @apilevel high-level
   */
  public Statement getThen(int i) {
    return (Statement) getThenList().getChild(i);
  }
  /**
   * Check whether the Then list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasThen() {
    return getThenList().getNumChild() != 0;
  }
  /**
   * Append an element to the Then list.
   * @param node The element to append to the Then list.
   * @apilevel high-level
   */
  public void addThen(Statement node) {
    List<Statement> list = (parent == null) ? getThenListNoTransform() : getThenList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addThenNoTransform(Statement node) {
    List<Statement> list = getThenListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Then list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setThen(Statement node, int i) {
    List<Statement> list = getThenList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Then list.
   * @return The node representing the Then list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Then")
  public List<Statement> getThenList() {
    List<Statement> list = (List<Statement>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Then list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Then list.
   * @apilevel low-level
   */
  public List<Statement> getThenListNoTransform() {
    return (List<Statement>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the Then list without
   * triggering rewrites.
   */
  public Statement getThenNoTransform(int i) {
    return (Statement) getThenListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Then list.
   * @return The node representing the Then list.
   * @apilevel high-level
   */
  public List<Statement> getThens() {
    return getThenList();
  }
  /**
   * Retrieves the Then list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Then list.
   * @apilevel low-level
   */
  public List<Statement> getThensNoTransform() {
    return getThenListNoTransform();
  }
}
