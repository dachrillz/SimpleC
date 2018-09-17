/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/chrille/compilers/week2/A2-MinimalAST/src/jastadd/lang.ast:12
 * @astdecl op : Expr ::= <VAL:String>;
 * @production op : {@link Expr} ::= <span class="component">&lt;VAL:String&gt;</span>;

 */
public class op extends Expr implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public op() {
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
  }
  /**
   * @declaredat ASTNode:12
   */
  @ASTNodeAnnotation.Constructor(
    name = {"VAL"},
    type = {"String"},
    kind = {"Token"}
  )
  public op(String p0) {
    setVAL(p0);
  }
  /**
   * @declaredat ASTNode:20
   */
  public op(beaver.Symbol p0) {
    setVAL(p0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 0;
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
  public op clone() throws CloneNotSupportedException {
    op node = (op) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public op copy() {
    try {
      op node = (op) clone();
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
  public op fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public op treeCopyNoTransform() {
    op tree = (op) copy();
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
  public op treeCopy() {
    op tree = (op) copy();
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
    return super.is$Equal(node) && (tokenString_VAL == ((op) node).tokenString_VAL);    
  }
  /**
   * Replaces the lexeme VAL.
   * @param value The new value for the lexeme VAL.
   * @apilevel high-level
   */
  public void setVAL(String value) {
    tokenString_VAL = value;
  }
  /** @apilevel internal 
   */
  protected String tokenString_VAL;
  /**
   */
  public int VALstart;
  /**
   */
  public int VALend;
  /**
   * JastAdd-internal setter for lexeme VAL using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme VAL
   * @apilevel internal
   */
  public void setVAL(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setVAL is only valid for String lexemes");
    tokenString_VAL = (String)symbol.value;
    VALstart = symbol.getStart();
    VALend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme VAL.
   * @return The value for the lexeme VAL.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="VAL")
  public String getVAL() {
    return tokenString_VAL != null ? tokenString_VAL : "";
  }
}
