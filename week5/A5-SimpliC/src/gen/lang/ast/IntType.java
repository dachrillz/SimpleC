/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;
/**
 * @ast node
 * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/lang.ast:39
 * @astdecl IntType : Type;
 * @production IntType : {@link Type};

 */
public class IntType extends Type implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/Visitor.jrag:83
   */
  public Object accept(Visitor visitor, Object data){
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public IntType() {
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
    isIntType_reset();
    toString_reset();
    isBooleanType_reset();
    isUnknownType_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:25
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:29
   */
  public IntType clone() throws CloneNotSupportedException {
    IntType node = (IntType) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:34
   */
  public IntType copy() {
    try {
      IntType node = (IntType) clone();
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
   * @declaredat ASTNode:53
   */
  @Deprecated
  public IntType fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:63
   */
  public IntType treeCopyNoTransform() {
    IntType tree = (IntType) copy();
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
   * @declaredat ASTNode:83
   */
  public IntType treeCopy() {
    IntType tree = (IntType) copy();
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
   * @declaredat ASTNode:97
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
/** @apilevel internal */
protected boolean isIntType_visited = false;
  /** @apilevel internal */
  private void isIntType_reset() {
    isIntType_computed = false;
    isIntType_visited = false;
  }
  /** @apilevel internal */
  protected boolean isIntType_computed = false;

  /** @apilevel internal */
  protected boolean isIntType_value;

  /**
   * @attribute syn
   * @aspect IntType
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/types.jrag:9
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="IntType", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/types.jrag:8")
  public boolean isIntType() {
    ASTState state = state();
    if (isIntType_computed) {
      return isIntType_value;
    }
    if (isIntType_visited) {
      throw new RuntimeException("Circular definition of attribute Type.isIntType().");
    }
    isIntType_visited = true;
    state().enterLazyAttribute();
    isIntType_value = true;
    isIntType_computed = true;
    state().leaveLazyAttribute();
    isIntType_visited = false;
    return isIntType_value;
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
   * @aspect IntType
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/types.jrag:11
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="IntType", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/types.jrag:11")
  public String toString() {
    ASTState state = state();
    if (toString_computed) {
      return toString_value;
    }
    if (toString_visited) {
      throw new RuntimeException("Circular definition of attribute IntType.toString().");
    }
    toString_visited = true;
    state().enterLazyAttribute();
    toString_value = "int";
    toString_computed = true;
    state().leaveLazyAttribute();
    toString_visited = false;
    return toString_value;
  }
/** @apilevel internal */
protected boolean isBooleanType_visited = false;
  /** @apilevel internal */
  private void isBooleanType_reset() {
    isBooleanType_computed = false;
    isBooleanType_visited = false;
  }
  /** @apilevel internal */
  protected boolean isBooleanType_computed = false;

  /** @apilevel internal */
  protected boolean isBooleanType_value;

  /**
   * @attribute syn
   * @aspect BooleanType
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/types.jrag:21
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="BooleanType", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/types.jrag:20")
  public boolean isBooleanType() {
    ASTState state = state();
    if (isBooleanType_computed) {
      return isBooleanType_value;
    }
    if (isBooleanType_visited) {
      throw new RuntimeException("Circular definition of attribute Type.isBooleanType().");
    }
    isBooleanType_visited = true;
    state().enterLazyAttribute();
    isBooleanType_value = true;
    isBooleanType_computed = true;
    state().leaveLazyAttribute();
    isBooleanType_visited = false;
    return isBooleanType_value;
  }
/** @apilevel internal */
protected boolean isUnknownType_visited = false;
  /** @apilevel internal */
  private void isUnknownType_reset() {
    isUnknownType_computed = false;
    isUnknownType_visited = false;
  }
  /** @apilevel internal */
  protected boolean isUnknownType_computed = false;

  /** @apilevel internal */
  protected boolean isUnknownType_value;

  /**
   * @attribute syn
   * @aspect UnknownType
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/types.jrag:33
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UnknownType", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/types.jrag:32")
  public boolean isUnknownType() {
    ASTState state = state();
    if (isUnknownType_computed) {
      return isUnknownType_value;
    }
    if (isUnknownType_visited) {
      throw new RuntimeException("Circular definition of attribute Type.isUnknownType().");
    }
    isUnknownType_visited = true;
    state().enterLazyAttribute();
    isUnknownType_value = true;
    isUnknownType_computed = true;
    state().leaveLazyAttribute();
    isUnknownType_visited = false;
    return isUnknownType_value;
  }
}
