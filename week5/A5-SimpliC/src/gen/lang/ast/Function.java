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
 * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/lang.ast:2
 * @astdecl Function : ASTNode ::= Type Name:IdDecl Arguments:IdDecl* Block;
 * @production Function : {@link ASTNode} ::= <span class="component">{@link Type}</span> <span class="component">Name:{@link IdDecl}</span> <span class="component">Arguments:{@link IdDecl}*</span> <span class="component">{@link Block}</span>;

 */
public class Function extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/PrettyPrint.jrag:15
   */
  public void prettyPrint(PrintStream out, String ind){
		//a function always starts with int in simpliC
		out.print(ind + "int ");
		out.print(getName().getID());
		out.print("(");
		if(hasArguments()){
                out.print("int ");
                getArguments(0).prettyPrint(out, ind);
                for (int i = 1; i < getNumArguments(); i++){
                    out.print(", int ");
                    getArguments(i).prettyPrint(out, ind);
                }
            }
            out.print(")");
            out.println(ind+"{");
            getBlock().prettyPrint(out, ind+"    ");
            out.println(ind+"}");
			out.println("");
	}
  /**
   * @aspect Visitor
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/Visitor.jrag:91
   */
  public Object accept(Visitor visitor, Object data){
		return visitor.visit(this, data);
	}
  /**
   * @aspect Interpreter
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/interpreter.jrag:15
   */
  public int eval(ActivationRecord actrec){
        Block block = getBlock();
        return block.eval(actrec).getInt();
    }
  /**
   * @declaredat ASTNode:1
   */
  public Function() {
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
    children = new ASTNode[4];
    setChild(new List(), 2);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Type", "Name", "Arguments", "Block"},
    type = {"Type", "IdDecl", "List<IdDecl>", "Block"},
    kind = {"Child", "Child", "List", "Child"}
  )
  public Function(Type p0, IdDecl p1, List<IdDecl> p2, Block p3) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
    setChild(p3, 3);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:26
   */
  protected int numChildren() {
    return 4;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:30
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    reachable_reset();
    localLookup_String_reset();
    lookup_String_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Function_functionCalls_visited = false;
    Function_functionCalls_computed = false;
    
    Function_functionCalls_value = null;
    contributorMap_Function_functionCalls = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:46
   */
  public Function clone() throws CloneNotSupportedException {
    Function node = (Function) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:51
   */
  public Function copy() {
    try {
      Function node = (Function) clone();
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
   * @declaredat ASTNode:70
   */
  @Deprecated
  public Function fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:80
   */
  public Function treeCopyNoTransform() {
    Function tree = (Function) copy();
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
   * @declaredat ASTNode:100
   */
  public Function treeCopy() {
    Function tree = (Function) copy();
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
   * @declaredat ASTNode:114
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Type child.
   * @param node The new node to replace the Type child.
   * @apilevel high-level
   */
  public void setType(Type node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Type child.
   * @return The current node used as the Type child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Type")
  public Type getType() {
    return (Type) getChild(0);
  }
  /**
   * Retrieves the Type child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Type child.
   * @apilevel low-level
   */
  public Type getTypeNoTransform() {
    return (Type) getChildNoTransform(0);
  }
  /**
   * Replaces the Name child.
   * @param node The new node to replace the Name child.
   * @apilevel high-level
   */
  public void setName(IdDecl node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Name child.
   * @return The current node used as the Name child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Name")
  public IdDecl getName() {
    return (IdDecl) getChild(1);
  }
  /**
   * Retrieves the Name child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Name child.
   * @apilevel low-level
   */
  public IdDecl getNameNoTransform() {
    return (IdDecl) getChildNoTransform(1);
  }
  /**
   * Replaces the Arguments list.
   * @param list The new list node to be used as the Arguments list.
   * @apilevel high-level
   */
  public void setArgumentsList(List<IdDecl> list) {
    setChild(list, 2);
  }
  /**
   * Retrieves the number of children in the Arguments list.
   * @return Number of children in the Arguments list.
   * @apilevel high-level
   */
  public int getNumArguments() {
    return getArgumentsList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Arguments list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Arguments list.
   * @apilevel low-level
   */
  public int getNumArgumentsNoTransform() {
    return getArgumentsListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Arguments list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Arguments list.
   * @apilevel high-level
   */
  public IdDecl getArguments(int i) {
    return (IdDecl) getArgumentsList().getChild(i);
  }
  /**
   * Check whether the Arguments list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasArguments() {
    return getArgumentsList().getNumChild() != 0;
  }
  /**
   * Append an element to the Arguments list.
   * @param node The element to append to the Arguments list.
   * @apilevel high-level
   */
  public void addArguments(IdDecl node) {
    List<IdDecl> list = (parent == null) ? getArgumentsListNoTransform() : getArgumentsList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addArgumentsNoTransform(IdDecl node) {
    List<IdDecl> list = getArgumentsListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Arguments list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setArguments(IdDecl node, int i) {
    List<IdDecl> list = getArgumentsList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Arguments list.
   * @return The node representing the Arguments list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Arguments")
  public List<IdDecl> getArgumentsList() {
    List<IdDecl> list = (List<IdDecl>) getChild(2);
    return list;
  }
  /**
   * Retrieves the Arguments list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Arguments list.
   * @apilevel low-level
   */
  public List<IdDecl> getArgumentsListNoTransform() {
    return (List<IdDecl>) getChildNoTransform(2);
  }
  /**
   * @return the element at index {@code i} in the Arguments list without
   * triggering rewrites.
   */
  public IdDecl getArgumentsNoTransform(int i) {
    return (IdDecl) getArgumentsListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Arguments list.
   * @return The node representing the Arguments list.
   * @apilevel high-level
   */
  public List<IdDecl> getArgumentss() {
    return getArgumentsList();
  }
  /**
   * Retrieves the Arguments list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Arguments list.
   * @apilevel low-level
   */
  public List<IdDecl> getArgumentssNoTransform() {
    return getArgumentsListNoTransform();
  }
  /**
   * Replaces the Block child.
   * @param node The new node to replace the Block child.
   * @apilevel high-level
   */
  public void setBlock(Block node) {
    setChild(node, 3);
  }
  /**
   * Retrieves the Block child.
   * @return The current node used as the Block child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Block")
  public Block getBlock() {
    return (Block) getChild(3);
  }
  /**
   * Retrieves the Block child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Block child.
   * @apilevel low-level
   */
  public Block getBlockNoTransform() {
    return (Block) getChildNoTransform(3);
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/CallGraph.jrag:28
   */
  /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_Function_functionCalls = null;

  /** @apilevel internal */
  protected void survey_Function_functionCalls() {
    if (contributorMap_Function_functionCalls == null) {
      contributorMap_Function_functionCalls = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_Function_functionCalls(this, contributorMap_Function_functionCalls);
    }
  }

/** @apilevel internal */
protected ASTState.Cycle reachable_cycle = null;
  /** @apilevel internal */
  private void reachable_reset() {
    reachable_computed = false;
    reachable_initialized = false;
    reachable_value = null;
    reachable_cycle = null;
  }
  /** @apilevel internal */
  protected boolean reachable_computed = false;

  /** @apilevel internal */
  protected Set<FuncAux> reachable_value;
  /** @apilevel internal */
  protected boolean reachable_initialized = false;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="Reachability", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/Reachability.jrag:3")
  public Set<FuncAux> reachable() {
    if (reachable_computed) {
      return reachable_value;
    }
    ASTState state = state();
    if (!reachable_initialized) {
      reachable_initialized = true;
      reachable_value = new TreeSet<FuncAux>();
    }
    if (!state.inCircle() || state.calledByLazyAttribute()) {
      state.enterCircle();
      do {
        reachable_cycle = state.nextCycle();
        Set<FuncAux> new_reachable_value = reachable_compute();
        if (!AttributeValue.equals(reachable_value, new_reachable_value)) {
          state.setChangeInCycle();
        }
        reachable_value = new_reachable_value;
      } while (state.testAndClearChangeInCycle());
      reachable_computed = true;
      state.startLastCycle();
      Set<FuncAux> $tmp = reachable_compute();

      state.leaveCircle();
    } else if (reachable_cycle != state.cycle()) {
      reachable_cycle = state.cycle();
      if (state.lastCycle()) {
        reachable_computed = true;
        Set<FuncAux> new_reachable_value = reachable_compute();
        return new_reachable_value;
      }
      Set<FuncAux> new_reachable_value = reachable_compute();
      if (!AttributeValue.equals(reachable_value, new_reachable_value)) {
        state.setChangeInCycle();
      }
      reachable_value = new_reachable_value;
    } else {
    }
    return reachable_value;
  }
  /** @apilevel internal */
  private Set<FuncAux> reachable_compute() {
          Set<FuncAux> mySet = new TreeSet<>();
          for(FuncAux f : functionCalls()){
              mySet.add(f);
              System.out.println(f);
              mySet.addAll(f.getIdUse().getIdUse().decl().enclosingFunction().reachable());
          }
          return mySet;
      }
/** @apilevel internal */
protected java.util.Set localLookup_String_visited;
  /** @apilevel internal */
  private void localLookup_String_reset() {
    localLookup_String_values = null;
    localLookup_String_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map localLookup_String_values;

  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:14
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:14")
  public IdDecl localLookup(String name) {
    Object _parameters = name;
    if (localLookup_String_visited == null) localLookup_String_visited = new java.util.HashSet(4);
    if (localLookup_String_values == null) localLookup_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (localLookup_String_values.containsKey(_parameters)) {
      return (IdDecl) localLookup_String_values.get(_parameters);
    }
    if (localLookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Function.localLookup(String).");
    }
    localLookup_String_visited.add(_parameters);
    state().enterLazyAttribute();
    IdDecl localLookup_String_value = localLookup_compute(name);
    localLookup_String_values.put(_parameters, localLookup_String_value);
    state().leaveLazyAttribute();
    localLookup_String_visited.remove(_parameters);
    return localLookup_String_value;
  }
  /** @apilevel internal */
  private IdDecl localLookup_compute(String name) {
          for(IdDecl id : getArgumentss()){ //omg did the extra s take a long time to find...
              if(id.getID().equals(name)){
                  return id;
              }
          }
          return unknownDecl();
      }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:7
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:7")
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_values == null) lookup_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (lookup_String_values.containsKey(_parameters)) {
      return (IdDecl) lookup_String_values.get(_parameters);
    }
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Function.lookup(String).");
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

  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/UniqueNames.jrag:10
   * @apilevel internal
   */
  public String Define_uniqueName(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getBlockNoTransform()) {
      // @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/UniqueNames.jrag:4
      return name;
    }
    else if (_callerNode == getArgumentsListNoTransform()) {
      // @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/UniqueNames.jrag:3
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return name;
    }
    else {
      return getParent().Define_uniqueName(this, _callerNode, name);
    }
  }
  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/UniqueNames.jrag:10
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute uniqueName
   */
  protected boolean canDefine_uniqueName(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:175
   * @apilevel internal
   */
  public boolean Define_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getNameNoTransform()) {
      // @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:182
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
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:190
   * @apilevel internal
   */
  public Function Define_function(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getNameNoTransform()) {
      // @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:191
      return this;
    }
    else {
      return getParent().Define_function(this, _callerNode);
    }
  }
  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:190
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute function
   */
  protected boolean canDefine_function(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/CallGraph.jrag:31
   * @apilevel internal
   */
  public Function Define_enclosingFunction(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return this;
  }
  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/CallGraph.jrag:31
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute enclosingFunction
   */
  protected boolean canDefine_enclosingFunction(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:4
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getBlockNoTransform()) {
      // @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:9
      {
              IdDecl loc = localLookup(name);
              return loc.isUnknown() ? lookup(name) : loc;
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
  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:56
   * @apilevel internal
   */
  public boolean Define_isMulti(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getBlockNoTransform()) {
      // @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:74
      {
              for(IdDecl id : getArgumentss()){
                  if(id.getID().equals(name)){
                      return true;
                  }
              }
              return false;
          }
    }
    else {
      return getParent().Define_isMulti(this, _callerNode, name);
    }
  }
  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:56
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isMulti
   */
  protected boolean canDefine_isMulti(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
/** @apilevel internal */
protected boolean Function_functionCalls_visited = false;
  /**
   * @attribute coll
   * @aspect CallGraph
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/CallGraph.jrag:28
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="CallGraph", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/CallGraph.jrag:28")
  public Set<FuncAux> functionCalls() {
    ASTState state = state();
    if (Function_functionCalls_computed) {
      return Function_functionCalls_value;
    }
    if (Function_functionCalls_visited) {
      throw new RuntimeException("Circular definition of attribute Function.functionCalls().");
    }
    Function_functionCalls_visited = true;
    state().enterLazyAttribute();
    Function_functionCalls_value = functionCalls_compute();
    Function_functionCalls_computed = true;
    state().leaveLazyAttribute();
    Function_functionCalls_visited = false;
    return Function_functionCalls_value;
  }
  /** @apilevel internal */
  private Set<FuncAux> functionCalls_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof Function)) {
      node = node.getParent();
    }
    Function root = (Function) node;
    root.survey_Function_functionCalls();
    Set<FuncAux> _computedValue = new TreeSet<FuncAux>();
    if (root.contributorMap_Function_functionCalls.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_Function_functionCalls.get(this)) {
        contributor.contributeTo_Function_functionCalls(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean Function_functionCalls_computed = false;

  /** @apilevel internal */
  protected Set<FuncAux> Function_functionCalls_value;

  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/Errors.jrag:42
    if (getName().isMultiDeclared()) {
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
    if (getName().isMultiDeclared()) {
      collection.add(error("Symbol '" + getName().getID() + "' is already declared"));
    }
  }
}
