/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/chrille/compilers/week2/A2-MinimalAST/src/jastadd/lang.ast:8
 * @astdecl While : Statement ::= Condition:Expr Do:Statement*;
 * @production While : {@link Statement} ::= <span class="component">Condition:{@link Expr}</span> <span class="component">Do:{@link Statement}*</span>;

 */
public class While extends Statement implements Cloneable {
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
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Condition", "Do"},
    type = {"Expr", "List<Statement>"},
    kind = {"Child", "List"}
  )
  public While(Expr p0, List<Statement> p1) {
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
  public While clone() throws CloneNotSupportedException {
    While node = (While) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
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
   * @declaredat ASTNode:60
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
   * @declaredat ASTNode:70
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
   * @declaredat ASTNode:90
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
   * Replaces the Do list.
   * @param list The new list node to be used as the Do list.
   * @apilevel high-level
   */
  public void setDoList(List<Statement> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the Do list.
   * @return Number of children in the Do list.
   * @apilevel high-level
   */
  public int getNumDo() {
    return getDoList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Do list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Do list.
   * @apilevel low-level
   */
  public int getNumDoNoTransform() {
    return getDoListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Do list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Do list.
   * @apilevel high-level
   */
  public Statement getDo(int i) {
    return (Statement) getDoList().getChild(i);
  }
  /**
   * Check whether the Do list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasDo() {
    return getDoList().getNumChild() != 0;
  }
  /**
   * Append an element to the Do list.
   * @param node The element to append to the Do list.
   * @apilevel high-level
   */
  public void addDo(Statement node) {
    List<Statement> list = (parent == null) ? getDoListNoTransform() : getDoList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addDoNoTransform(Statement node) {
    List<Statement> list = getDoListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Do list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setDo(Statement node, int i) {
    List<Statement> list = getDoList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Do list.
   * @return The node representing the Do list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Do")
  public List<Statement> getDoList() {
    List<Statement> list = (List<Statement>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Do list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Do list.
   * @apilevel low-level
   */
  public List<Statement> getDoListNoTransform() {
    return (List<Statement>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the Do list without
   * triggering rewrites.
   */
  public Statement getDoNoTransform(int i) {
    return (Statement) getDoListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Do list.
   * @return The node representing the Do list.
   * @apilevel high-level
   */
  public List<Statement> getDos() {
    return getDoList();
  }
  /**
   * Retrieves the Do list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Do list.
   * @apilevel low-level
   */
  public List<Statement> getDosNoTransform() {
    return getDoListNoTransform();
  }
}
