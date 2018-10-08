/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/lang.ast:1
 * @astdecl Program : ASTNode ::= Function*;
 * @production Program : {@link ASTNode} ::= <span class="component">{@link Function}*</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/Visitor.jrag:170
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public Program() {
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
    name = {"Function"},
    type = {"List<Function>"},
    kind = {"List"}
  )
  public Program(List<Function> p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    unknownDecl_reset();
    predefinedFunctions_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:33
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Program_errors_visited = false;
    Program_errors_computed = false;
    
    Program_errors_value = null;
    contributorMap_Program_errors = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:47
   */
  public Program copy() {
    try {
      Program node = (Program) clone();
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
   * @declaredat ASTNode:66
   */
  @Deprecated
  public Program fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:76
   */
  public Program treeCopyNoTransform() {
    Program tree = (Program) copy();
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
   * @declaredat ASTNode:96
   */
  public Program treeCopy() {
    Program tree = (Program) copy();
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
   * @declaredat ASTNode:110
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Function list.
   * @param list The new list node to be used as the Function list.
   * @apilevel high-level
   */
  public void setFunctionList(List<Function> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the Function list.
   * @return Number of children in the Function list.
   * @apilevel high-level
   */
  public int getNumFunction() {
    return getFunctionList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Function list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Function list.
   * @apilevel low-level
   */
  public int getNumFunctionNoTransform() {
    return getFunctionListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Function list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Function list.
   * @apilevel high-level
   */
  public Function getFunction(int i) {
    return (Function) getFunctionList().getChild(i);
  }
  /**
   * Check whether the Function list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasFunction() {
    return getFunctionList().getNumChild() != 0;
  }
  /**
   * Append an element to the Function list.
   * @param node The element to append to the Function list.
   * @apilevel high-level
   */
  public void addFunction(Function node) {
    List<Function> list = (parent == null) ? getFunctionListNoTransform() : getFunctionList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addFunctionNoTransform(Function node) {
    List<Function> list = getFunctionListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Function list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setFunction(Function node, int i) {
    List<Function> list = getFunctionList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Function list.
   * @return The node representing the Function list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Function")
  public List<Function> getFunctionList() {
    List<Function> list = (List<Function>) getChild(0);
    return list;
  }
  /**
   * Retrieves the Function list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Function list.
   * @apilevel low-level
   */
  public List<Function> getFunctionListNoTransform() {
    return (List<Function>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the Function list without
   * triggering rewrites.
   */
  public Function getFunctionNoTransform(int i) {
    return (Function) getFunctionListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Function list.
   * @return The node representing the Function list.
   * @apilevel high-level
   */
  public List<Function> getFunctions() {
    return getFunctionList();
  }
  /**
   * Retrieves the Function list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Function list.
   * @apilevel low-level
   */
  public List<Function> getFunctionsNoTransform() {
    return getFunctionListNoTransform();
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/Errors.jrag:26
   */
  /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_Program_errors = null;

  /** @apilevel internal */
  protected void survey_Program_errors() {
    if (contributorMap_Program_errors == null) {
      contributorMap_Program_errors = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_Program_errors(this, contributorMap_Program_errors);
    }
  }

/** @apilevel internal */
protected boolean unknownDecl_visited = false;
  /** @apilevel internal */
  private void unknownDecl_reset() {
    unknownDecl_computed = false;
    
    unknownDecl_value = null;
    unknownDecl_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownDecl_computed = false;

  /** @apilevel internal */
  protected UnknownDecl unknownDecl_value;

  /**
   * @attribute syn
   * @aspect UnknownDecl
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/UnknownDecl.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/home/chrille/compilers/week4/A4-SimpliC/src/jastadd/UnknownDecl.jrag:2")
  public UnknownDecl unknownDecl() {
    ASTState state = state();
    if (unknownDecl_computed) {
      return unknownDecl_value;
    }
    if (unknownDecl_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownDecl().");
    }
    unknownDecl_visited = true;
    state().enterLazyAttribute();
    unknownDecl_value = new UnknownDecl("<unknown>");
    unknownDecl_value.setParent(this);
    unknownDecl_computed = true;
    state().leaveLazyAttribute();
    unknownDecl_visited = false;
    return unknownDecl_value;
  }
/** @apilevel internal */
protected boolean predefinedFunctions_visited = false;
  /** @apilevel internal */
  private void predefinedFunctions_reset() {
    predefinedFunctions_computed = false;
    
    predefinedFunctions_value = null;
    predefinedFunctions_visited = false;
  }
  /** @apilevel internal */
  protected boolean predefinedFunctions_computed = false;

  /** @apilevel internal */
  protected List<Function> predefinedFunctions_value;

  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/NameAnalysis.jrag:141
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/chrille/compilers/week4/A4-SimpliC/src/jastadd/NameAnalysis.jrag:141")
  public List<Function> predefinedFunctions() {
    ASTState state = state();
    if (predefinedFunctions_computed) {
      return predefinedFunctions_value;
    }
    if (predefinedFunctions_visited) {
      throw new RuntimeException("Circular definition of attribute Program.predefinedFunctions().");
    }
    predefinedFunctions_visited = true;
    state().enterLazyAttribute();
    predefinedFunctions_value = predefinedFunctions_compute();
    predefinedFunctions_value.setParent(this);
    predefinedFunctions_computed = true;
    state().leaveLazyAttribute();
    predefinedFunctions_visited = false;
    return predefinedFunctions_value;
  }
  /** @apilevel internal */
  private List<Function> predefinedFunctions_compute() {
          List<Function> list = new List<Function>();
  
          // Create objects of type FunctionDecl and add them to the list
          Function read = new Function(new IdDecl("read"), new List(), new Block());
          List<IdDecl> printArguments = new List<IdDecl>();
          printArguments.add(new IdDecl("printarg"));
          Function print = new Function(new IdDecl("print"), printArguments, new Block());
  
          list.add(read);
          list.add(print);
  
          return list;
      }
  /**
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/UnknownDecl.jrag:4
   * @apilevel internal
   */
  public UnknownDecl Define_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownDecl();
  }
  /**
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/UnknownDecl.jrag:4
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownDecl
   */
  protected boolean canDefine_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/NameAnalysis.jrag:3
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getFunctionListNoTransform()) {
      // @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/NameAnalysis.jrag:5
      int i = _callerNode.getIndexOfChild(_childNode);
      return unknownDecl();
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
  /**
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/NameAnalysis.jrag:56
   * @apilevel internal
   */
  public boolean Define_isMulti(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getFunctionListNoTransform()) {
      // @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/NameAnalysis.jrag:59
      int i = _callerNode.getIndexOfChild(_childNode);
      {
              for(Function func : predefinedFunctions()){
                  if(func.getName().getID().equals(name)){
                      return true;
                  }
              }
              for(int k = 0; k < i; k++){
                  if(getFunction(k).getName().getID().equals(name)) {
                      return true;
                  }
              }
              //if no match
              return false;
          }
    }
    else {
      int childIndex = this.getIndexOfChild(_callerNode);
      {
              return false;
          }
    }
  }
  /**
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/NameAnalysis.jrag:56
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isMulti
   */
  protected boolean canDefine_isMulti(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/NameAnalysis.jrag:132
   * @apilevel internal
   */
  public IdDecl Define_functionDeclaration(ASTNode _callerNode, ASTNode _childNode, String name) {
    int childIndex = this.getIndexOfChild(_callerNode);
    {
            for(Function func : predefinedFunctions()){
                if(func.getName().getID().equals(name)){
                    return func.getName();
                }
            }
            for(Function func : getFunctionList()){
                IdDecl id = func.getName();
                if(id.getID().equals(name)){
                    return id;
                }
            }
            return unknownDecl();
        }
  }
  /**
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/NameAnalysis.jrag:132
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute functionDeclaration
   */
  protected boolean canDefine_functionDeclaration(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/Errors.jrag:28
   * @apilevel internal
   */
  public Program Define_program(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return this;
  }
  /**
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/Errors.jrag:28
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute program
   */
  protected boolean canDefine_program(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
/** @apilevel internal */
protected boolean Program_errors_visited = false;
  /**
   * @attribute coll
   * @aspect Errors
   * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/Errors.jrag:26
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="Errors", declaredAt="/home/chrille/compilers/week4/A4-SimpliC/src/jastadd/Errors.jrag:26")
  public Set<ErrorMessage> errors() {
    ASTState state = state();
    if (Program_errors_computed) {
      return Program_errors_value;
    }
    if (Program_errors_visited) {
      throw new RuntimeException("Circular definition of attribute Program.errors().");
    }
    Program_errors_visited = true;
    state().enterLazyAttribute();
    Program_errors_value = errors_compute();
    Program_errors_computed = true;
    state().leaveLazyAttribute();
    Program_errors_visited = false;
    return Program_errors_value;
  }
  /** @apilevel internal */
  private Set<ErrorMessage> errors_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof Program)) {
      node = node.getParent();
    }
    Program root = (Program) node;
    root.survey_Program_errors();
    Set<ErrorMessage> _computedValue = new TreeSet<ErrorMessage>();
    if (root.contributorMap_Program_errors.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_Program_errors.get(this)) {
        contributor.contributeTo_Program_errors(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean Program_errors_computed = false;

  /** @apilevel internal */
  protected Set<ErrorMessage> Program_errors_value;

}
