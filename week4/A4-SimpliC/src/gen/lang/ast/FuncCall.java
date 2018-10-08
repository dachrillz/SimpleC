/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/lang.ast:30
 * @astdecl FuncCall : Expr ::= IdUse Args:Expr*;
 * @production FuncCall : {@link Expr} ::= <span class="component">{@link IdUse}</span> <span class="component">Args:{@link Expr}*</span>;

 */
public class FuncCall extends Expr implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/PrettyPrint.jrag:61
   */
  public void prettyPrint(PrintStream out, String ind){
		getIdUse().prettyPrint(out,ind);
		out.print("(");
		if (hasArgs()){
			getArgs(0).prettyPrint(out,ind);
			for(int i = 1; i < getNumArgs(); i++){
				out.print(", ");
				getArgs(i).prettyPrint(out,ind); 
               }
           }
		out.print(")");

	}
  /**
   * @aspect Visitor
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/Visitor.jrag:117
   */
  public Object accept(Visitor visitor, Object data){
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public FuncCall() {
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
    name = {"IdUse", "Args"},
    type = {"IdUse", "List<Expr>"},
    kind = {"Child", "List"}
  )
  public FuncCall(IdUse p0, List<Expr> p1) {
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
  public FuncCall clone() throws CloneNotSupportedException {
    FuncCall node = (FuncCall) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public FuncCall copy() {
    try {
      FuncCall node = (FuncCall) clone();
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
  public FuncCall fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public FuncCall treeCopyNoTransform() {
    FuncCall tree = (FuncCall) copy();
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
  public FuncCall treeCopy() {
    FuncCall tree = (FuncCall) copy();
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
   * Replaces the Args list.
   * @param list The new list node to be used as the Args list.
   * @apilevel high-level
   */
  public void setArgsList(List<Expr> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the Args list.
   * @return Number of children in the Args list.
   * @apilevel high-level
   */
  public int getNumArgs() {
    return getArgsList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Args list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Args list.
   * @apilevel low-level
   */
  public int getNumArgsNoTransform() {
    return getArgsListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Args list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Args list.
   * @apilevel high-level
   */
  public Expr getArgs(int i) {
    return (Expr) getArgsList().getChild(i);
  }
  /**
   * Check whether the Args list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasArgs() {
    return getArgsList().getNumChild() != 0;
  }
  /**
   * Append an element to the Args list.
   * @param node The element to append to the Args list.
   * @apilevel high-level
   */
  public void addArgs(Expr node) {
    List<Expr> list = (parent == null) ? getArgsListNoTransform() : getArgsList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addArgsNoTransform(Expr node) {
    List<Expr> list = getArgsListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Args list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setArgs(Expr node, int i) {
    List<Expr> list = getArgsList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Args list.
   * @return The node representing the Args list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Args")
  public List<Expr> getArgsList() {
    List<Expr> list = (List<Expr>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Args list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Args list.
   * @apilevel low-level
   */
  public List<Expr> getArgsListNoTransform() {
    return (List<Expr>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the Args list without
   * triggering rewrites.
   */
  public Expr getArgsNoTransform(int i) {
    return (Expr) getArgsListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Args list.
   * @return The node representing the Args list.
   * @apilevel high-level
   */
  public List<Expr> getArgss() {
    return getArgsList();
  }
  /**
   * Retrieves the Args list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Args list.
   * @apilevel low-level
   */
  public List<Expr> getArgssNoTransform() {
    return getArgsListNoTransform();
  }
  /**
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/NameAnalysis.jrag:3
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getIdUseNoTransform()) {
      // @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/NameAnalysis.jrag:133
      {
              return functionDeclaration(name);
          }
    }
    else {
      return getParent().Define_lookup(this, _callerNode, name);
    }
  }
  /**
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/NameAnalysis.jrag:3
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute lookup
   */
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
}
