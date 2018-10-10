/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/lang.ast:30
 * @astdecl FuncCall : Expr ::= IdUse Args:Expr*;
 * @production FuncCall : {@link Expr} ::= <span class="component">{@link IdUse}</span> <span class="component">Args:{@link Expr}*</span>;

 */
public class FuncCall extends Expr implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/PrettyPrint.jrag:61
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
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/Visitor.jrag:128
   */
  public Object accept(Visitor visitor, Object data){
		return visitor.visit(this, data);
	}
  /**
   * @aspect Interpreter
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/interpreter.jrag:96
   */
  public int eval(ActivationRecord actrec){
        if(getIdUse().getID().equals("print")){
            for(Expr expr: getArgsList()){
                int temp = expr.eval(actrec);
                System.out.println(temp);
            }
        }
        else if(getIdUse().getID().equals("read")){
            throw new RuntimeException("read evaluation not implemented!"); 
        }
        else{
            throw new RuntimeException("Function calls not implemented!"); 
        }
        return 0;
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
    type_reset();
    hasAllParameters_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:34
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public FuncCall clone() throws CloneNotSupportedException {
    FuncCall node = (FuncCall) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
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
   * @declaredat ASTNode:62
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
   * @declaredat ASTNode:72
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
   * @declaredat ASTNode:92
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
   * @declaredat ASTNode:106
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
/** @apilevel internal */
protected boolean type_visited = false;
  /** @apilevel internal */
  private void type_reset() {
    type_computed = false;
    
    type_value = null;
    type_visited = false;
  }
  /** @apilevel internal */
  protected boolean type_computed = false;

  /** @apilevel internal */
  protected Type type_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:15
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:11")
  public Type type() {
    ASTState state = state();
    if (type_computed) {
      return type_value;
    }
    if (type_visited) {
      throw new RuntimeException("Circular definition of attribute Expr.type().");
    }
    type_visited = true;
    state().enterLazyAttribute();
    type_value = getIdUse().type();
    type_computed = true;
    state().leaveLazyAttribute();
    type_visited = false;
    return type_value;
  }
/** @apilevel internal */
protected boolean hasAllParameters_visited = false;
  /** @apilevel internal */
  private void hasAllParameters_reset() {
    hasAllParameters_computed = false;
    hasAllParameters_visited = false;
  }
  /** @apilevel internal */
  protected boolean hasAllParameters_computed = false;

  /** @apilevel internal */
  protected boolean hasAllParameters_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:193
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:193")
  public boolean hasAllParameters() {
    ASTState state = state();
    if (hasAllParameters_computed) {
      return hasAllParameters_value;
    }
    if (hasAllParameters_visited) {
      throw new RuntimeException("Circular definition of attribute FuncCall.hasAllParameters().");
    }
    hasAllParameters_visited = true;
    state().enterLazyAttribute();
    hasAllParameters_value = getIdUse().decl().equalsParameters(this);
    hasAllParameters_computed = true;
    state().leaveLazyAttribute();
    hasAllParameters_visited = false;
    return hasAllParameters_value;
  }
  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:175
   * @apilevel internal
   */
  public boolean Define_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getIdUseNoTransform()) {
      // @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:185
      return true;
    }
    else {
      return getParent().Define_isFunction(this, _callerNode);
    }
  }
  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:175
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isFunction
   */
  protected boolean canDefine_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:4
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getIdUseNoTransform()) {
      // @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:133
      {
              return functionDeclaration(name);
          }
    }
    else {
      return getParent().Define_lookup(this, _callerNode, name);
    }
  }
  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:4
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute lookup
   */
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/Errors.jrag:80
    if (!getIdUse().decl().isUnknown() && !hasAllParameters()) {
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
    if (!getIdUse().decl().isUnknown() && !hasAllParameters()) {
      collection.add(error("The function " + getIdUse().getID() + " takes " +
                                  getIdUse().decl().function().getNumArguments() +
                                  " number of  arguments, but " + getNumArgs() + " were given."));
    }
  }
}
