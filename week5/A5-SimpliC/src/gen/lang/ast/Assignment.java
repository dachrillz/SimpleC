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
 * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/lang.ast:9
 * @astdecl Assignment : Statement ::= IdUse Expr;
 * @production Assignment : {@link Statement} ::= <span class="component">{@link IdUse}</span> <span class="component">{@link Expr}</span>;

 */
public class Assignment extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/PrettyPrint.jrag:43
   */
  public void prettyPrint(PrintStream out, String ind) {
            out.print(ind);
            getIdUse().prettyPrint(out, ind);
            out.print(" = ");
            getExpr().prettyPrint(out, ind);
            out.println(";");
        }
  /**
   * @aspect Interpreter
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/interpreter.jrag:64
   */
  public WrappedInteger eval(ActivationRecord actrec){
        IdDecl id = getIdUse().decl();
        String temp = getIdUse().decl().uniqueID();
        actrec.put(temp, getExpr().eval(actrec));

        return new WrappedInteger(0, false);
    }
  /**
   * @declaredat ASTNode:1
   */
  public Assignment() {
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
    name = {"IdUse", "Expr"},
    type = {"IdUse", "Expr"},
    kind = {"Child", "Child"}
  )
  public Assignment(IdUse p0, Expr p1) {
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
    compatibleTypes_reset();
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
  public Assignment clone() throws CloneNotSupportedException {
    Assignment node = (Assignment) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public Assignment copy() {
    try {
      Assignment node = (Assignment) clone();
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
  public Assignment fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public Assignment treeCopyNoTransform() {
    Assignment tree = (Assignment) copy();
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
  public Assignment treeCopy() {
    Assignment tree = (Assignment) copy();
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
   * Replaces the IdUse child.
   * @param node The new node to replace the IdUse child.
   * @apilevel high-level
   */
  public void setIdUse(IdUse node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the IdUse child.
   * @return The current node used as the IdUse child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="IdUse")
  public IdUse getIdUse() {
    return (IdUse) getChild(0);
  }
  /**
   * Retrieves the IdUse child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the IdUse child.
   * @apilevel low-level
   */
  public IdUse getIdUseNoTransform() {
    return (IdUse) getChildNoTransform(0);
  }
  /**
   * Replaces the Expr child.
   * @param node The new node to replace the Expr child.
   * @apilevel high-level
   */
  public void setExpr(Expr node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Expr child.
   * @return The current node used as the Expr child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Expr")
  public Expr getExpr() {
    return (Expr) getChild(1);
  }
  /**
   * Retrieves the Expr child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Expr child.
   * @apilevel low-level
   */
  public Expr getExprNoTransform() {
    return (Expr) getChildNoTransform(1);
  }
/** @apilevel internal */
protected boolean compatibleTypes_visited = false;
  /** @apilevel internal */
  private void compatibleTypes_reset() {
    compatibleTypes_computed = false;
    compatibleTypes_visited = false;
  }
  /** @apilevel internal */
  protected boolean compatibleTypes_computed = false;

  /** @apilevel internal */
  protected boolean compatibleTypes_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:143
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:143")
  public boolean compatibleTypes() {
    ASTState state = state();
    if (compatibleTypes_computed) {
      return compatibleTypes_value;
    }
    if (compatibleTypes_visited) {
      throw new RuntimeException("Circular definition of attribute Assignment.compatibleTypes().");
    }
    compatibleTypes_visited = true;
    state().enterLazyAttribute();
    compatibleTypes_value = getExpr().expectedType().compatibleType(getExpr().type());
    compatibleTypes_computed = true;
    state().leaveLazyAttribute();
    compatibleTypes_visited = false;
    return compatibleTypes_value;
  }
  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:165
   * @apilevel internal
   */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getExprNoTransform()) {
      // @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:166
      return intType();
    }
    else {
      return getParent().Define_expectedType(this, _callerNode);
    }
  }
  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:165
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute expectedType
   */
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/Errors.jrag:51
    if (!compatibleTypes()) {
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
    if (!compatibleTypes()) {
      collection.add(error(getIdUse().getID() + " is not compatible with IDType: " + getIdUse().type() + " and ExprType: " + getExpr().type()));
    }
  }
}
