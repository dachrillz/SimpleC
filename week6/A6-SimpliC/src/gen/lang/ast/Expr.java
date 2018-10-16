/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
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
 * @ast node
 * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/lang.ast:16
 * @astdecl Expr : ASTNode;
 * @production Expr : {@link ASTNode};

 */
public abstract class Expr extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/CodeGen.jrag:174
   */
  public abstract void genCode(PrintStream out);
  /**
   * @aspect Interpreter
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/interpreter.jrag:106
   */
  public abstract int eval(ActivationRecord actrec);
  /**
   * @declaredat ASTNode:1
   */
  public Expr() {
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
  /** @apilevel low-level 
   * @declaredat ASTNode:13
   */
  protected int numChildren() {
    return 0;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:17
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    jumpOp_reset();
    expectedType_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:23
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public Expr clone() throws CloneNotSupportedException {
    Expr node = (Expr) super.clone();
    return node;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:38
   */
  @Deprecated
  public abstract Expr fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:46
   */
  public abstract Expr treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:54
   */
  public abstract Expr treeCopy();
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:11
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/chrille/compilers/week6/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:11")
  public abstract Type type();
/** @apilevel internal */
protected boolean jumpOp_visited = false;
  /** @apilevel internal */
  private void jumpOp_reset() {
    jumpOp_computed = false;
    
    jumpOp_value = null;
    jumpOp_visited = false;
  }
  /** @apilevel internal */
  protected boolean jumpOp_computed = false;

  /** @apilevel internal */
  protected String jumpOp_value;

  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/CodeGen.jrag:279
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/home/chrille/compilers/week6/A6-SimpliC/src/jastadd/CodeGen.jrag:279")
  public String jumpOp() {
    ASTState state = state();
    if (jumpOp_computed) {
      return jumpOp_value;
    }
    if (jumpOp_visited) {
      throw new RuntimeException("Circular definition of attribute Expr.jumpOp().");
    }
    jumpOp_visited = true;
    state().enterLazyAttribute();
    jumpOp_value = jumpOp_compute();
    jumpOp_computed = true;
    state().leaveLazyAttribute();
    jumpOp_visited = false;
    return jumpOp_value;
  }
  /** @apilevel internal */
  private String jumpOp_compute() { throw new RuntimeException("No jump label available!"); }
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:165
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/chrille/compilers/week6/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:165")
  public Type expectedType() {
    ASTState state = state();
    if (expectedType_computed) {
      return expectedType_value;
    }
    if (expectedType_visited) {
      throw new RuntimeException("Circular definition of attribute Expr.expectedType().");
    }
    expectedType_visited = true;
    state().enterLazyAttribute();
    expectedType_value = getParent().Define_expectedType(this, null);
    expectedType_computed = true;
    state().leaveLazyAttribute();
    expectedType_visited = false;
    return expectedType_value;
  }
/** @apilevel internal */
protected boolean expectedType_visited = false;
  /** @apilevel internal */
  private void expectedType_reset() {
    expectedType_computed = false;
    
    expectedType_value = null;
    expectedType_visited = false;
  }
  /** @apilevel internal */
  protected boolean expectedType_computed = false;

  /** @apilevel internal */
  protected Type expectedType_value;

}
