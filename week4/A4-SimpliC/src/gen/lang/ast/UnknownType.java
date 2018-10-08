/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/lang.ast:41
 * @astdecl UnknownType : Type;
 * @production UnknownType : {@link Type};

 */
public class UnknownType extends Type implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public UnknownType() {
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
    toString_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:22
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:26
   */
  public UnknownType clone() throws CloneNotSupportedException {
    UnknownType node = (UnknownType) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:31
   */
  public UnknownType copy() {
    try {
      UnknownType node = (UnknownType) clone();
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
   * @declaredat ASTNode:50
   */
  @Deprecated
  public UnknownType fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:60
   */
  public UnknownType treeCopyNoTransform() {
    UnknownType tree = (UnknownType) copy();
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
   * @declaredat ASTNode:80
   */
  public UnknownType treeCopy() {
    UnknownType tree = (UnknownType) copy();
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
   * @declaredat ASTNode:94
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
/** @apilevel internal */
protected boolean toString_visited = false;
  /** @apilevel internal */
  private void toString_reset() {
    toString_computed = false;
    
    toString_value = null;
    toString_visited = false;
  }
  /** @apilevel internal */
  protected boolean toString_computed = false;

  /** @apilevel internal */
  protected String toString_value;

  /**
   * @attribute syn
   * @aspect UnknownType
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/types.jrag:35
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UnknownType", declaredAt="/home/chrille/compilers/week4/A4-SimpliC/src/jastadd/types.jrag:35")
  public String toString() {
    ASTState state = state();
    if (toString_computed) {
      return toString_value;
    }
    if (toString_visited) {
      throw new RuntimeException("Circular definition of attribute UnknownType.toString().");
    }
    toString_visited = true;
    state().enterLazyAttribute();
    toString_value = "Unknown Type";
    toString_computed = true;
    state().leaveLazyAttribute();
    toString_visited = false;
    return toString_value;
  }
}
