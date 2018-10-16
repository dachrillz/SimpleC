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
 * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/lang.ast:32
 * @astdecl IdDecl : Expr ::= <ID:String>;
 * @production IdDecl : {@link Expr} ::= <span class="component">&lt;ID:String&gt;</span>;

 */
public class IdDecl extends Expr implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/PrettyPrint.jrag:51
   */
  public void prettyPrint(PrintStream out, String ind) {
        out.print(getID());
    }
  /**
   * @aspect Visitor
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/Visitor.jrag:190
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @aspect Interpreter
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/interpreter.jrag:190
   */
  public int eval(ActivationRecord actrec){
        throw new RuntimeException("IdDecl evaluation not implemented!"); 
    }
  /**
   * @declaredat ASTNode:1
   */
  public IdDecl() {
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
    name = {"ID"},
    type = {"String"},
    kind = {"Token"}
  )
  public IdDecl(String p0) {
    setID(p0);
  }
  /**
   * @declaredat ASTNode:20
   */
  public IdDecl(beaver.Symbol p0) {
    setID(p0);
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
    uniqueID_reset();
    type_reset();
    isVariableAndFunction_reset();
    equalsParameters_FuncCall_reset();
    isUnknown_reset();
    isMultiDeclared_reset();
    uniqueName_String_reset();
    isVariable_reset();
    isFunction_reset();
    function_reset();
    lookup_String_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:47
   */
  public IdDecl clone() throws CloneNotSupportedException {
    IdDecl node = (IdDecl) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:52
   */
  public IdDecl copy() {
    try {
      IdDecl node = (IdDecl) clone();
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
   * @declaredat ASTNode:71
   */
  @Deprecated
  public IdDecl fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:81
   */
  public IdDecl treeCopyNoTransform() {
    IdDecl tree = (IdDecl) copy();
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
   * @declaredat ASTNode:101
   */
  public IdDecl treeCopy() {
    IdDecl tree = (IdDecl) copy();
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
   * @declaredat ASTNode:115
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node) && (tokenString_ID == ((IdDecl) node).tokenString_ID);    
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
/** @apilevel internal */
protected boolean uniqueID_visited = false;
  /** @apilevel internal */
  private void uniqueID_reset() {
    uniqueID_computed = false;
    
    uniqueID_value = null;
    uniqueID_visited = false;
  }
  /** @apilevel internal */
  protected boolean uniqueID_computed = false;

  /** @apilevel internal */
  protected String uniqueID_value;

  /**
   * @attribute syn
   * @aspect UniqueNames
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/UniqueNames.jrag:11
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UniqueNames", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/UniqueNames.jrag:11")
  public String uniqueID() {
    ASTState state = state();
    if (uniqueID_computed) {
      return uniqueID_value;
    }
    if (uniqueID_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.uniqueID().");
    }
    uniqueID_visited = true;
    state().enterLazyAttribute();
    uniqueID_value = uniqueName(getID());
    uniqueID_computed = true;
    state().leaveLazyAttribute();
    uniqueID_visited = false;
    return uniqueID_value;
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
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:14
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:14")
  public Type type() {
    ASTState state = state();
    if (type_computed) {
      return type_value;
    }
    if (type_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.type().");
    }
    type_visited = true;
    state().enterLazyAttribute();
    type_value = intType();
    type_computed = true;
    state().leaveLazyAttribute();
    type_visited = false;
    return type_value;
  }
/** @apilevel internal */
protected boolean isVariableAndFunction_visited = false;
  /** @apilevel internal */
  private void isVariableAndFunction_reset() {
    isVariableAndFunction_computed = false;
    isVariableAndFunction_visited = false;
  }
  /** @apilevel internal */
  protected boolean isVariableAndFunction_computed = false;

  /** @apilevel internal */
  protected boolean isVariableAndFunction_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:187
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:187")
  public boolean isVariableAndFunction() {
    ASTState state = state();
    if (isVariableAndFunction_computed) {
      return isVariableAndFunction_value;
    }
    if (isVariableAndFunction_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isVariableAndFunction().");
    }
    isVariableAndFunction_visited = true;
    state().enterLazyAttribute();
    isVariableAndFunction_value = functionDeclaration(getID()).isFunction() && this.isVariable();
    isVariableAndFunction_computed = true;
    state().leaveLazyAttribute();
    isVariableAndFunction_visited = false;
    return isVariableAndFunction_value;
  }
/** @apilevel internal */
protected java.util.Set equalsParameters_FuncCall_visited;
  /** @apilevel internal */
  private void equalsParameters_FuncCall_reset() {
    equalsParameters_FuncCall_values = null;
    equalsParameters_FuncCall_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map equalsParameters_FuncCall_values;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:195
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:195")
  public boolean equalsParameters(FuncCall call) {
    Object _parameters = call;
    if (equalsParameters_FuncCall_visited == null) equalsParameters_FuncCall_visited = new java.util.HashSet(4);
    if (equalsParameters_FuncCall_values == null) equalsParameters_FuncCall_values = new java.util.HashMap(4);
    ASTState state = state();
    if (equalsParameters_FuncCall_values.containsKey(_parameters)) {
      return (Boolean) equalsParameters_FuncCall_values.get(_parameters);
    }
    if (equalsParameters_FuncCall_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute IdDecl.equalsParameters(FuncCall).");
    }
    equalsParameters_FuncCall_visited.add(_parameters);
    state().enterLazyAttribute();
    boolean equalsParameters_FuncCall_value = equalsParameters_compute(call);
    equalsParameters_FuncCall_values.put(_parameters, equalsParameters_FuncCall_value);
    state().leaveLazyAttribute();
    equalsParameters_FuncCall_visited.remove(_parameters);
    return equalsParameters_FuncCall_value;
  }
  /** @apilevel internal */
  private boolean equalsParameters_compute(FuncCall call) {
  	    if(function().getNumArguments() == call.getNumArgs()){
  	        return true;
  	    }
  	    else{
  	        return false;
  	    }
  	}
/** @apilevel internal */
protected boolean isUnknown_visited = false;
  /** @apilevel internal */
  private void isUnknown_reset() {
    isUnknown_computed = false;
    isUnknown_visited = false;
  }
  /** @apilevel internal */
  protected boolean isUnknown_computed = false;

  /** @apilevel internal */
  protected boolean isUnknown_value;

  /**
   * @attribute syn
   * @aspect UnknownDecl
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/UnknownDecl.jrag:7
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/UnknownDecl.jrag:7")
  public boolean isUnknown() {
    ASTState state = state();
    if (isUnknown_computed) {
      return isUnknown_value;
    }
    if (isUnknown_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isUnknown().");
    }
    isUnknown_visited = true;
    state().enterLazyAttribute();
    isUnknown_value = false;
    isUnknown_computed = true;
    state().leaveLazyAttribute();
    isUnknown_visited = false;
    return isUnknown_value;
  }
/** @apilevel internal */
protected boolean isMultiDeclared_visited = false;
  /** @apilevel internal */
  private void isMultiDeclared_reset() {
    isMultiDeclared_computed = false;
    isMultiDeclared_visited = false;
  }
  /** @apilevel internal */
  protected boolean isMultiDeclared_computed = false;

  /** @apilevel internal */
  protected boolean isMultiDeclared_value;

  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:102
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:102")
  public boolean isMultiDeclared() {
    ASTState state = state();
    if (isMultiDeclared_computed) {
      return isMultiDeclared_value;
    }
    if (isMultiDeclared_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isMultiDeclared().");
    }
    isMultiDeclared_visited = true;
    state().enterLazyAttribute();
    isMultiDeclared_value = isMultiDeclared_compute();
    isMultiDeclared_computed = true;
    state().leaveLazyAttribute();
    isMultiDeclared_visited = false;
    return isMultiDeclared_value;
  }
  /** @apilevel internal */
  private boolean isMultiDeclared_compute() {
          return isMulti(getID());
          /*
          {
              return true;
          }
          else{
              return false;
          }
          */
      }
  /**
   * @attribute inh
   * @aspect UniqueNames
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/UniqueNames.jrag:10
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="UniqueNames", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/UniqueNames.jrag:10")
  public String uniqueName(String name) {
    Object _parameters = name;
    if (uniqueName_String_visited == null) uniqueName_String_visited = new java.util.HashSet(4);
    if (uniqueName_String_values == null) uniqueName_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (uniqueName_String_values.containsKey(_parameters)) {
      return (String) uniqueName_String_values.get(_parameters);
    }
    if (uniqueName_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute IdDecl.uniqueName(String).");
    }
    uniqueName_String_visited.add(_parameters);
    state().enterLazyAttribute();
    String uniqueName_String_value = getParent().Define_uniqueName(this, null, name);
    uniqueName_String_values.put(_parameters, uniqueName_String_value);
    state().leaveLazyAttribute();
    uniqueName_String_visited.remove(_parameters);
    return uniqueName_String_value;
  }
/** @apilevel internal */
protected java.util.Set uniqueName_String_visited;
  /** @apilevel internal */
  private void uniqueName_String_reset() {
    uniqueName_String_values = null;
    uniqueName_String_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map uniqueName_String_values;

  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:174
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:174")
  public boolean isVariable() {
    ASTState state = state();
    if (isVariable_computed) {
      return isVariable_value;
    }
    if (isVariable_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isVariable().");
    }
    isVariable_visited = true;
    state().enterLazyAttribute();
    isVariable_value = getParent().Define_isVariable(this, null);
    isVariable_computed = true;
    state().leaveLazyAttribute();
    isVariable_visited = false;
    return isVariable_value;
  }
/** @apilevel internal */
protected boolean isVariable_visited = false;
  /** @apilevel internal */
  private void isVariable_reset() {
    isVariable_computed = false;
    isVariable_visited = false;
  }
  /** @apilevel internal */
  protected boolean isVariable_computed = false;

  /** @apilevel internal */
  protected boolean isVariable_value;

  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:175
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:175")
  public boolean isFunction() {
    ASTState state = state();
    if (isFunction_computed) {
      return isFunction_value;
    }
    if (isFunction_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isFunction().");
    }
    isFunction_visited = true;
    state().enterLazyAttribute();
    isFunction_value = getParent().Define_isFunction(this, null);
    isFunction_computed = true;
    state().leaveLazyAttribute();
    isFunction_visited = false;
    return isFunction_value;
  }
/** @apilevel internal */
protected boolean isFunction_visited = false;
  /** @apilevel internal */
  private void isFunction_reset() {
    isFunction_computed = false;
    isFunction_visited = false;
  }
  /** @apilevel internal */
  protected boolean isFunction_computed = false;

  /** @apilevel internal */
  protected boolean isFunction_value;

  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:190
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:190")
  public Function function() {
    ASTState state = state();
    if (function_computed) {
      return function_value;
    }
    if (function_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.function().");
    }
    function_visited = true;
    state().enterLazyAttribute();
    function_value = getParent().Define_function(this, null);
    function_computed = true;
    state().leaveLazyAttribute();
    function_visited = false;
    return function_value;
  }
/** @apilevel internal */
protected boolean function_visited = false;
  /** @apilevel internal */
  private void function_reset() {
    function_computed = false;
    
    function_value = null;
    function_visited = false;
  }
  /** @apilevel internal */
  protected boolean function_computed = false;

  /** @apilevel internal */
  protected Function function_value;

  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:49
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:49")
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_values == null) lookup_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (lookup_String_values.containsKey(_parameters)) {
      return (IdDecl) lookup_String_values.get(_parameters);
    }
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute IdDecl.lookup(String).");
    }
    lookup_String_visited.add(_parameters);
    state().enterLazyAttribute();
    IdDecl lookup_String_value = getParent().Define_lookup(this, null, name);
    lookup_String_values.put(_parameters, lookup_String_value);
    state().leaveLazyAttribute();
    lookup_String_visited.remove(_parameters);
    return lookup_String_value;
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

  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/Errors.jrag:75
    if (isVariableAndFunction()) {
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
    if (isVariableAndFunction()) {
      collection.add(error("The variable '" + getID() + "' is both a function and a variable."));
    }
  }
}
