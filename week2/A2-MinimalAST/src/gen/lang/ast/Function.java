/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/chrille/compilers/week2/A2-MinimalAST/src/jastadd/lang.ast:2
 * @astdecl Function : ASTNode ::= <ID:String> Statement*;
 * @production Function : {@link ASTNode} ::= <span class="component">&lt;ID:String&gt;</span> <span class="component">{@link Statement}*</span>;

 */
public class Function extends ASTNode<ASTNode> implements Cloneable {
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
    children = new ASTNode[1];
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"ID", "Statement"},
    type = {"String", "List<Statement>"},
    kind = {"Token", "List"}
  )
  public Function(String p0, List<Statement> p1) {
    setID(p0);
    setChild(p1, 0);
  }
  /**
   * @declaredat ASTNode:23
   */
  public Function(beaver.Symbol p0, List<Statement> p1) {
    setID(p0);
    setChild(p1, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:28
   */
  protected int numChildren() {
    return 1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:40
   */
  public Function clone() throws CloneNotSupportedException {
    Function node = (Function) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:45
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
   * @declaredat ASTNode:64
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
   * @declaredat ASTNode:74
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
   * @declaredat ASTNode:94
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
   * @declaredat ASTNode:108
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
   * Replaces the Statement list.
   * @param list The new list node to be used as the Statement list.
   * @apilevel high-level
   */
  public void setStatementList(List<Statement> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the Statement list.
   * @return Number of children in the Statement list.
   * @apilevel high-level
   */
  public int getNumStatement() {
    return getStatementList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Statement list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Statement list.
   * @apilevel low-level
   */
  public int getNumStatementNoTransform() {
    return getStatementListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Statement list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Statement list.
   * @apilevel high-level
   */
  public Statement getStatement(int i) {
    return (Statement) getStatementList().getChild(i);
  }
  /**
   * Check whether the Statement list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasStatement() {
    return getStatementList().getNumChild() != 0;
  }
  /**
   * Append an element to the Statement list.
   * @param node The element to append to the Statement list.
   * @apilevel high-level
   */
  public void addStatement(Statement node) {
    List<Statement> list = (parent == null) ? getStatementListNoTransform() : getStatementList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addStatementNoTransform(Statement node) {
    List<Statement> list = getStatementListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Statement list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setStatement(Statement node, int i) {
    List<Statement> list = getStatementList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Statement list.
   * @return The node representing the Statement list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Statement")
  public List<Statement> getStatementList() {
    List<Statement> list = (List<Statement>) getChild(0);
    return list;
  }
  /**
   * Retrieves the Statement list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Statement list.
   * @apilevel low-level
   */
  public List<Statement> getStatementListNoTransform() {
    return (List<Statement>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the Statement list without
   * triggering rewrites.
   */
  public Statement getStatementNoTransform(int i) {
    return (Statement) getStatementListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Statement list.
   * @return The node representing the Statement list.
   * @apilevel high-level
   */
  public List<Statement> getStatements() {
    return getStatementList();
  }
  /**
   * Retrieves the Statement list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Statement list.
   * @apilevel low-level
   */
  public List<Statement> getStatementsNoTransform() {
    return getStatementListNoTransform();
  }
}
