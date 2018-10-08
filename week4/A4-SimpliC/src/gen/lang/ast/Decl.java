/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/lang.ast:8
 * @astdecl Decl : Statement ::= IdDecl [Expr];
 * @production Decl : {@link Statement} ::= <span class="component">{@link IdDecl}</span> <span class="component">[{@link Expr}]</span>;

 */
public class Decl extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/PrettyPrint.jrag:241
   */
  public void prettyPrint(PrintStream out, String ind) {
        out.print(ind+"int ");
        getIdDecl().prettyPrint(out, ind);
        if(hasExpr()){
                out.print(" = ");
                getExpr().prettyPrint(out, ind);
            }
            out.println(";");
        }
  /**
   * @aspect Visitor
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/Visitor.jrag:89
   */
  public Object accept(Visitor visitor, Object data){
	    return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public Decl() {
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
    setChild(new Opt(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"IdDecl", "Expr"},
    type = {"IdDecl", "Opt<Expr>"},
    kind = {"Child", "Opt"}
  )
  public Decl(IdDecl p0, Opt<Expr> p1) {
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
    lookup_String_reset();
    isMulti_String_reset();
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
  public Decl clone() throws CloneNotSupportedException {
    Decl node = (Decl) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public Decl copy() {
    try {
      Decl node = (Decl) clone();
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
  public Decl fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public Decl treeCopyNoTransform() {
    Decl tree = (Decl) copy();
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
  public Decl treeCopy() {
    Decl tree = (Decl) copy();
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
   * Replaces the IdDecl child.
   * @param node The new node to replace the IdDecl child.
   * @apilevel high-level
   */
  public void setIdDecl(IdDecl node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the IdDecl child.
   * @return The current node used as the IdDecl child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="IdDecl")
  public IdDecl getIdDecl() {
    return (IdDecl) getChild(0);
  }
  /**
   * Retrieves the IdDecl child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the IdDecl child.
   * @apilevel low-level
   */
  public IdDecl getIdDeclNoTransform() {
    return (IdDecl) getChildNoTransform(0);
  }
  /**
   * Replaces the optional node for the Expr child. This is the <code>Opt</code>
   * node containing the child Expr, not the actual child!
   * @param opt The new node to be used as the optional node for the Expr child.
   * @apilevel low-level
   */
  public void setExprOpt(Opt<Expr> opt) {
    setChild(opt, 1);
  }
  /**
   * Replaces the (optional) Expr child.
   * @param node The new node to be used as the Expr child.
   * @apilevel high-level
   */
  public void setExpr(Expr node) {
    getExprOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional Expr child exists.
   * @return {@code true} if the optional Expr child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasExpr() {
    return getExprOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) Expr child.
   * @return The Expr child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public Expr getExpr() {
    return (Expr) getExprOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the Expr child. This is the <code>Opt</code> node containing the child Expr, not the actual child!
   * @return The optional node for child the Expr child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="Expr")
  public Opt<Expr> getExprOpt() {
    return (Opt<Expr>) getChild(1);
  }
  /**
   * Retrieves the optional node for child Expr. This is the <code>Opt</code> node containing the child Expr, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child Expr.
   * @apilevel low-level
   */
  public Opt<Expr> getExprOptNoTransform() {
    return (Opt<Expr>) getChildNoTransform(1);
  }
/** @apilevel internal */
protected java.util.Set lookup_String_visited;
  /** @apilevel internal */
  private void lookup_String_reset() {
    lookup_String_values = null;
    lookup_String_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map lookup_String_values;

  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/NameAnalysis.jrag:44
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/chrille/compilers/week4/A4-SimpliC/src/jastadd/NameAnalysis.jrag:44")
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_values == null) lookup_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (lookup_String_values.containsKey(_parameters)) {
      return (IdDecl) lookup_String_values.get(_parameters);
    }
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Decl.lookup(String).");
    }
    lookup_String_visited.add(_parameters);
    state().enterLazyAttribute();
    IdDecl lookup_String_value = lookup_compute(name);
    lookup_String_values.put(_parameters, lookup_String_value);
    state().leaveLazyAttribute();
    lookup_String_visited.remove(_parameters);
    return lookup_String_value;
  }
  /** @apilevel internal */
  private IdDecl lookup_compute(String name) {
         IdDecl id = getIdDecl();
         return id.getID().equals(name) ? id : null;
      }
/** @apilevel internal */
protected java.util.Set isMulti_String_visited;
  /** @apilevel internal */
  private void isMulti_String_reset() {
    isMulti_String_values = null;
    isMulti_String_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map isMulti_String_values;

  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/NameAnalysis.jrag:98
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/chrille/compilers/week4/A4-SimpliC/src/jastadd/NameAnalysis.jrag:98")
  public boolean isMulti(String name) {
    Object _parameters = name;
    if (isMulti_String_visited == null) isMulti_String_visited = new java.util.HashSet(4);
    if (isMulti_String_values == null) isMulti_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (isMulti_String_values.containsKey(_parameters)) {
      return (Boolean) isMulti_String_values.get(_parameters);
    }
    if (isMulti_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Decl.isMulti(String).");
    }
    isMulti_String_visited.add(_parameters);
    state().enterLazyAttribute();
    boolean isMulti_String_value = isMulti_compute(name);
    isMulti_String_values.put(_parameters, isMulti_String_value);
    state().leaveLazyAttribute();
    isMulti_String_visited.remove(_parameters);
    return isMulti_String_value;
  }
  /** @apilevel internal */
  private boolean isMulti_compute(String name) {
          return getIdDecl().getID().equals(name);
      }
  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/Errors.jrag:38
    if (getIdDecl().isMultiDeclared()) {
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
    if (getIdDecl().isMultiDeclared()) {
      collection.add(error("symbol '" + getIdDecl().getID() + "' is already declared"));
    }
  }
}
