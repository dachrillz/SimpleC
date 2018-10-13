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
 * @astdecl ASTNode;
 * @production ASTNode;

 */
public class ASTNode<T extends ASTNode> extends beaver.Symbol implements Cloneable {
  /**
   * @aspect CallGraph
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/CallGraph.jrag:21
   */
  protected FuncHelper funcHelper(FuncCall usedFunc) {
		return new FuncHelper(usedFunc);
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/PrettyPrint.jrag:4
   */
  public void prettyPrint(PrintStream out) {
		prettyPrint(out, "");
		out.println();
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/PrettyPrint.jrag:9
   */
  public void prettyPrint(PrintStream out, String ind) {
		for (int i = 0; i < getNumChild(); ++i) {
			getChild(i).prettyPrint(out, ind);
		}
	}
  /**
   * @aspect DumpTree
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/DumpTree.jrag:9
   */
  private static final String DUMP_TREE_INDENT = "  ";
  /**
   * @aspect DumpTree
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/DumpTree.jrag:11
   */
  public String dumpTree() {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		dumpTree(new PrintStream(bytes));
		return bytes.toString();
	}
  /**
   * @aspect DumpTree
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/DumpTree.jrag:17
   */
  public void dumpTree(PrintStream out) {
		dumpTree(out, "");
		out.flush();
	}
  /**
   * @aspect DumpTree
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/DumpTree.jrag:22
   */
  public void dumpTree(PrintStream out, String indent) {
		out.print(indent + getClass().getSimpleName());
		out.println(getTokens());
		String childIndent = indent + DUMP_TREE_INDENT;
		for (ASTNode child : astChildren()) {
			if (child == null) {
				out.println(childIndent + "null");
			} else {
				child.dumpTree(out, childIndent);
			}
		}
	}
  /**
   * @aspect DumpTree
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/DumpTree.jrag:35
   */
  public String getTokens() {
		java.util.TreeSet<java.lang.reflect.Method> methods = new java.util.TreeSet<>(
				new java.util.Comparator<java.lang.reflect.Method>() {
					public int compare(java.lang.reflect.Method m1, java.lang.reflect.Method m2) {
						return m1.getName().compareTo(m2.getName());
					}
				});

		methods.addAll(java.util.Arrays.asList(getClass().getMethods()));

		String result = "";
		for (java.lang.reflect.Method method : methods) {
			ASTNodeAnnotation.Token token = method.getAnnotation(ASTNodeAnnotation.Token.class);
			if (token != null) {
				try {
					result += String.format(" %s=\"%s\"", token.name(), method.invoke(this));
				} catch (IllegalAccessException ignored) {
				} catch (InvocationTargetException ignored) {
				}
			}
		}
		return result;
	}
  /**
   * @aspect Visitor
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/Visitor.jrag:172
   */
  public Object accept(Visitor visitor, Object data) {
		throw new Error("Visitor: accept method not available for " + getClass().getName());
	}
  /**
   * @aspect Errors
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/Errors.jrag:22
   */
  protected ErrorMessage error(String message) {
		return new ErrorMessage(message, getLine(getStart()));
	}
  /**
   * @declaredat ASTNode:1
   */
  public ASTNode() {
    super();
    init$Children();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:11
   */
  public void init$Children() {
  }
  /**
   * Cached child index. Child indices are assumed to never change (AST should
   * not change after construction).
   * @apilevel internal
   * @declaredat ASTNode:18
   */
  private int childIndex = -1;
  /** @apilevel low-level 
   * @declaredat ASTNode:21
   */
  public int getIndexOfChild(ASTNode node) {
    if (node == null) {
      return -1;
    }
    if (node.childIndex >= 0) {
      return node.childIndex;
    }
    for (int i = 0; children != null && i < children.length; i++) {
      if (children[i] == node) {
        node.childIndex = i;
        return i;
      }
    }
    return -1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public static final boolean generatedWithCacheCycle = true;
  /** @apilevel low-level 
   * @declaredat ASTNode:41
   */
  protected ASTNode parent;
  /** @apilevel low-level 
   * @declaredat ASTNode:44
   */
  protected ASTNode[] children;
  /** @apilevel internal 
   * @declaredat ASTNode:48
   */
  private static ASTState state = new ASTState();
  /** @apilevel internal 
   * @declaredat ASTNode:51
   */
  public final ASTState state() {
    return state;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:56
   */
  public final static ASTState resetState() {
    return state = new ASTState();
  }
  /**
   * @return an iterator that can be used to iterate over the children of this node.
   * The iterator does not allow removing children.
   * @declaredat ASTNode:65
   */
  public java.util.Iterator<T> astChildIterator() {
    return new java.util.Iterator<T>() {
      private int index = 0;

      @Override
      public boolean hasNext() {
        return index < getNumChild();
      }

      @Override
      public T next() {
        return hasNext() ? (T) getChild(index++) : null;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
  /** @return an object that can be used to iterate over the children of this node 
   * @declaredat ASTNode:87
   */
  public Iterable<T> astChildren() {
    return new Iterable<T>() {
      @Override
      public java.util.Iterator<T> iterator() {
        return astChildIterator();
      }
    };
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:97
   */
  public T getChild(int i) {
    ASTNode child = getChildNoTransform(i);
    return (T) child;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:102
   */
  public void addChild(T node) {
    setChild(node, getNumChildNoTransform());
  }
  /**
   * Gets a child without triggering rewrites.
   * @apilevel low-level
   * @declaredat ASTNode:109
   */
  public T getChildNoTransform(int i) {
    if (children == null) {
      return null;
    }
    T child = (T) children[i];
    return child;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:117
   */
  protected int numChildren;
  /** @apilevel low-level 
   * @declaredat ASTNode:120
   */
  protected int numChildren() {
    return numChildren;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:125
   */
  public int getNumChild() {
    return numChildren();
  }
  /**
   * Behaves like getNumChild, but does not invoke AST transformations (rewrites).
   * @apilevel low-level
   * @declaredat ASTNode:133
   */
  public final int getNumChildNoTransform() {
    return numChildren();
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:137
   */
  public void setChild(ASTNode node, int i) {
    if (children == null) {
      children = new ASTNode[(i + 1 > 4 || !(this instanceof List)) ? i + 1 : 4];
    } else if (i >= children.length) {
      ASTNode c[] = new ASTNode[i << 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = node;
    if (i >= numChildren) {
      numChildren = i+1;
    }
    if (node != null) {
      node.setParent(this);
      node.childIndex = i;
    }
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:155
   */
  public void insertChild(ASTNode node, int i) {
    if (children == null) {
      children = new ASTNode[(i + 1 > 4 || !(this instanceof List)) ? i + 1 : 4];
      children[i] = node;
    } else {
      ASTNode c[] = new ASTNode[children.length + 1];
      System.arraycopy(children, 0, c, 0, i);
      c[i] = node;
      if (i < children.length) {
        System.arraycopy(children, i, c, i+1, children.length-i);
        for(int j = i+1; j < c.length; ++j) {
          if (c[j] != null) {
            c[j].childIndex = j;
          }
        }
      }
      children = c;
    }
    numChildren++;
    if (node != null) {
      node.setParent(this);
      node.childIndex = i;
    }
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:180
   */
  public void removeChild(int i) {
    if (children != null) {
      ASTNode child = (ASTNode) children[i];
      if (child != null) {
        child.parent = null;
        child.childIndex = -1;
      }
      // Adding a check of this instance to make sure its a List, a move of children doesn't make
      // any sense for a node unless its a list. Also, there is a problem if a child of a non-List node is removed
      // and siblings are moved one step to the right, with null at the end.
      if (this instanceof List || this instanceof Opt) {
        System.arraycopy(children, i+1, children, i, children.length-i-1);
        children[children.length-1] = null;
        numChildren--;
        // fix child indices
        for(int j = i; j < numChildren; ++j) {
          if (children[j] != null) {
            child = (ASTNode) children[j];
            child.childIndex = j;
          }
        }
      } else {
        children[i] = null;
      }
    }
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:207
   */
  public ASTNode getParent() {
    return (ASTNode) parent;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:211
   */
  public void setParent(ASTNode node) {
    parent = node;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:276
   */
  public void flushTreeCache() {
    flushCache();
    if (children != null) {
      for (int i = 0; i < children.length; i++) {
        if (children[i] != null) {
          ((ASTNode) children[i]).flushTreeCache();
        }
      }
    }
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:287
   */
  public void flushCache() {
    flushAttrAndCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:291
   */
  public void flushAttrAndCollectionCache() {
    flushAttrCache();
    flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:296
   */
  public void flushAttrCache() {
    intType_reset();
    booleanType_reset();
    unknownType_reset();
    unknownDecl_reset();
    enclosingFunction_reset();
    isMulti_String_reset();
    functionDeclaration_String_reset();
    program_reset();
    getFunctionAsJava_String_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:308
   */
  public void flushCollectionCache() {
  }
  /** @apilevel internal 
   * @declaredat ASTNode:311
   */
  public ASTNode<T> clone() throws CloneNotSupportedException {
    ASTNode node = (ASTNode) super.clone();
    node.flushAttrAndCollectionCache();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:317
   */
  public ASTNode<T> copy() {
    try {
      ASTNode node = (ASTNode) clone();
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
   * @declaredat ASTNode:336
   */
  @Deprecated
  public ASTNode<T> fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:346
   */
  public ASTNode<T> treeCopyNoTransform() {
    ASTNode tree = (ASTNode) copy();
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
   * @declaredat ASTNode:366
   */
  public ASTNode<T> treeCopy() {
    ASTNode tree = (ASTNode) copy();
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
  /**
   * Performs a full traversal of the tree using getChild to trigger rewrites
   * @apilevel low-level
   * @declaredat ASTNode:383
   */
  public void doFullTraversal() {
    for (int i = 0; i < getNumChild(); i++) {
      getChild(i).doFullTraversal();
    }
  }
  /** @apilevel internal 
   * @declaredat ASTNode:389
   */
  protected boolean is$Equal(ASTNode n1, ASTNode n2) {
    if (n1 == null && n2 == null) return true;
    if (n1 == null || n2 == null) return false;
    return n1.is$Equal(n2);
  }
  /** @apilevel internal 
   * @declaredat ASTNode:395
   */
  protected boolean is$Equal(ASTNode node) {
    if (getClass() != node.getClass()) {
      return false;
    }
    if (numChildren != node.numChildren) {
      return false;
    }
    for (int i = 0; i < numChildren; i++) {
      if (children[i] == null && node.children[i] != null) {
        return false;
      }
      if (!((ASTNode)children[i]).is$Equal(((ASTNode)node.children[i]))) {
        return false;
      }
    }
    return true;
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/Errors.jrag:26
   */
    /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    for (int i = 0; i < getNumChild(); i++) {
      getChild(i).collect_contributors_Program_errors(_root, _map);
    }
  }
  /** @apilevel internal */
  protected void contributeTo_Program_errors(Set<ErrorMessage> collection) {
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/CallGraph.jrag:26
   */
    /** @apilevel internal */
  protected void collect_contributors_Function_functionCalls(Function _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    for (int i = 0; i < getNumChild(); i++) {
      getChild(i).collect_contributors_Function_functionCalls(_root, _map);
    }
  }
  /** @apilevel internal */
  protected void contributeTo_Function_functionCalls(Set<FuncHelper> collection) {
  }

  /**
   * @attribute inh
   * @aspect IntType
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/types.jrag:5
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="IntType", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/types.jrag:5")
  public IntType intType() {
    ASTState state = state();
    if (intType_computed) {
      return intType_value;
    }
    if (intType_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.intType().");
    }
    intType_visited = true;
    state().enterLazyAttribute();
    intType_value = getParent().Define_intType(this, null);
    intType_computed = true;
    state().leaveLazyAttribute();
    intType_visited = false;
    return intType_value;
  }
/** @apilevel internal */
protected boolean intType_visited = false;
  /** @apilevel internal */
  private void intType_reset() {
    intType_computed = false;
    
    intType_value = null;
    intType_visited = false;
  }
  /** @apilevel internal */
  protected boolean intType_computed = false;

  /** @apilevel internal */
  protected IntType intType_value;

  /**
   * @attribute inh
   * @aspect BooleanType
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/types.jrag:17
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="BooleanType", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/types.jrag:17")
  public BooleanType booleanType() {
    ASTState state = state();
    if (booleanType_computed) {
      return booleanType_value;
    }
    if (booleanType_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.booleanType().");
    }
    booleanType_visited = true;
    state().enterLazyAttribute();
    booleanType_value = getParent().Define_booleanType(this, null);
    booleanType_computed = true;
    state().leaveLazyAttribute();
    booleanType_visited = false;
    return booleanType_value;
  }
/** @apilevel internal */
protected boolean booleanType_visited = false;
  /** @apilevel internal */
  private void booleanType_reset() {
    booleanType_computed = false;
    
    booleanType_value = null;
    booleanType_visited = false;
  }
  /** @apilevel internal */
  protected boolean booleanType_computed = false;

  /** @apilevel internal */
  protected BooleanType booleanType_value;

  /**
   * @attribute inh
   * @aspect UnknownType
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/types.jrag:29
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="UnknownType", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/types.jrag:29")
  public UnknownType unknownType() {
    ASTState state = state();
    if (unknownType_computed) {
      return unknownType_value;
    }
    if (unknownType_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.unknownType().");
    }
    unknownType_visited = true;
    state().enterLazyAttribute();
    unknownType_value = getParent().Define_unknownType(this, null);
    unknownType_computed = true;
    state().leaveLazyAttribute();
    unknownType_visited = false;
    return unknownType_value;
  }
/** @apilevel internal */
protected boolean unknownType_visited = false;
  /** @apilevel internal */
  private void unknownType_reset() {
    unknownType_computed = false;
    
    unknownType_value = null;
    unknownType_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownType_computed = false;

  /** @apilevel internal */
  protected UnknownType unknownType_value;

  /**
   * @attribute inh
   * @aspect UnknownDecl
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/UnknownDecl.jrag:4
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/UnknownDecl.jrag:4")
  public UnknownDecl unknownDecl() {
    ASTState state = state();
    if (unknownDecl_computed) {
      return unknownDecl_value;
    }
    if (unknownDecl_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.unknownDecl().");
    }
    unknownDecl_visited = true;
    state().enterLazyAttribute();
    unknownDecl_value = getParent().Define_unknownDecl(this, null);
    unknownDecl_computed = true;
    state().leaveLazyAttribute();
    unknownDecl_visited = false;
    return unknownDecl_value;
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
   * @attribute inh
   * @aspect CallGraph
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/CallGraph.jrag:29
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="CallGraph", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/CallGraph.jrag:29")
  public Function enclosingFunction() {
    ASTState state = state();
    if (enclosingFunction_computed) {
      return enclosingFunction_value;
    }
    if (enclosingFunction_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.enclosingFunction().");
    }
    enclosingFunction_visited = true;
    state().enterLazyAttribute();
    enclosingFunction_value = getParent().Define_enclosingFunction(this, null);
    enclosingFunction_computed = true;
    state().leaveLazyAttribute();
    enclosingFunction_visited = false;
    return enclosingFunction_value;
  }
/** @apilevel internal */
protected boolean enclosingFunction_visited = false;
  /** @apilevel internal */
  private void enclosingFunction_reset() {
    enclosingFunction_computed = false;
    
    enclosingFunction_value = null;
    enclosingFunction_visited = false;
  }
  /** @apilevel internal */
  protected boolean enclosingFunction_computed = false;

  /** @apilevel internal */
  protected Function enclosingFunction_value;

  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:56
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:56")
  public boolean isMulti(String name) {
    Object _parameters = name;
    if (isMulti_String_visited == null) isMulti_String_visited = new java.util.HashSet(4);
    if (isMulti_String_values == null) isMulti_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (isMulti_String_values.containsKey(_parameters)) {
      return (Boolean) isMulti_String_values.get(_parameters);
    }
    if (isMulti_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute ASTNode.isMulti(String).");
    }
    isMulti_String_visited.add(_parameters);
    state().enterLazyAttribute();
    boolean isMulti_String_value = getParent().Define_isMulti(this, null, name);
    isMulti_String_values.put(_parameters, isMulti_String_value);
    state().leaveLazyAttribute();
    isMulti_String_visited.remove(_parameters);
    return isMulti_String_value;
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
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:132
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:132")
  public IdDecl functionDeclaration(String name) {
    Object _parameters = name;
    if (functionDeclaration_String_visited == null) functionDeclaration_String_visited = new java.util.HashSet(4);
    if (functionDeclaration_String_values == null) functionDeclaration_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (functionDeclaration_String_values.containsKey(_parameters)) {
      return (IdDecl) functionDeclaration_String_values.get(_parameters);
    }
    if (functionDeclaration_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute ASTNode.functionDeclaration(String).");
    }
    functionDeclaration_String_visited.add(_parameters);
    state().enterLazyAttribute();
    IdDecl functionDeclaration_String_value = getParent().Define_functionDeclaration(this, null, name);
    functionDeclaration_String_values.put(_parameters, functionDeclaration_String_value);
    state().leaveLazyAttribute();
    functionDeclaration_String_visited.remove(_parameters);
    return functionDeclaration_String_value;
  }
/** @apilevel internal */
protected java.util.Set functionDeclaration_String_visited;
  /** @apilevel internal */
  private void functionDeclaration_String_reset() {
    functionDeclaration_String_values = null;
    functionDeclaration_String_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map functionDeclaration_String_values;

  /**
   * @attribute inh
   * @aspect Errors
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/Errors.jrag:28
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="Errors", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/Errors.jrag:28")
  public Program program() {
    ASTState state = state();
    if (program_computed) {
      return program_value;
    }
    if (program_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.program().");
    }
    program_visited = true;
    state().enterLazyAttribute();
    program_value = getParent().Define_program(this, null);
    program_computed = true;
    state().leaveLazyAttribute();
    program_visited = false;
    return program_value;
  }
/** @apilevel internal */
protected boolean program_visited = false;
  /** @apilevel internal */
  private void program_reset() {
    program_computed = false;
    
    program_value = null;
    program_visited = false;
  }
  /** @apilevel internal */
  protected boolean program_computed = false;

  /** @apilevel internal */
  protected Program program_value;

  /**
   * @attribute inh
   * @aspect Interpreter
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/interpreter.jrag:239
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="Interpreter", declaredAt="/home/chrille/compilers/week5/A5-SimpliC/src/jastadd/interpreter.jrag:239")
  public Function getFunctionAsJava(String name) {
    Object _parameters = name;
    if (getFunctionAsJava_String_visited == null) getFunctionAsJava_String_visited = new java.util.HashSet(4);
    if (getFunctionAsJava_String_values == null) getFunctionAsJava_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (getFunctionAsJava_String_values.containsKey(_parameters)) {
      return (Function) getFunctionAsJava_String_values.get(_parameters);
    }
    if (getFunctionAsJava_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute ASTNode.getFunctionAsJava(String).");
    }
    getFunctionAsJava_String_visited.add(_parameters);
    state().enterLazyAttribute();
    Function getFunctionAsJava_String_value = getParent().Define_getFunctionAsJava(this, null, name);
    getFunctionAsJava_String_values.put(_parameters, getFunctionAsJava_String_value);
    state().leaveLazyAttribute();
    getFunctionAsJava_String_visited.remove(_parameters);
    return getFunctionAsJava_String_value;
  }
/** @apilevel internal */
protected java.util.Set getFunctionAsJava_String_visited;
  /** @apilevel internal */
  private void getFunctionAsJava_String_reset() {
    getFunctionAsJava_String_values = null;
    getFunctionAsJava_String_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map getFunctionAsJava_String_values;

  /** @apilevel internal */
  public IntType Define_intType(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_intType(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_intType(self, _callerNode);
  }

  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/types.jrag:6
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute intType
   */
  protected boolean canDefine_intType(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public BooleanType Define_booleanType(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_booleanType(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_booleanType(self, _callerNode);
  }

  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/types.jrag:18
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute booleanType
   */
  protected boolean canDefine_booleanType(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public UnknownType Define_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_unknownType(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_unknownType(self, _callerNode);
  }

  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/types.jrag:30
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownType
   */
  protected boolean canDefine_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public boolean Define_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_isVariable(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_isVariable(self, _callerNode);
  }

  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:178
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isVariable
   */
  protected boolean canDefine_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public boolean Define_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_isFunction(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_isFunction(self, _callerNode);
  }

  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:185
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isFunction
   */
  protected boolean canDefine_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public UnknownDecl Define_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_unknownDecl(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_unknownDecl(self, _callerNode);
  }

  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/UnknownDecl.jrag:5
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownDecl
   */
  protected boolean canDefine_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_lookup(self, _callerNode, name)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_lookup(self, _callerNode, name);
  }

  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:133
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute lookup
   */
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return false;
  }
  /** @apilevel internal */
  public boolean Define_isMulti(ASTNode _callerNode, ASTNode _childNode, String name) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_isMulti(self, _callerNode, name)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_isMulti(self, _callerNode, name);
  }

  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:83
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isMulti
   */
  protected boolean canDefine_isMulti(ASTNode _callerNode, ASTNode _childNode, String name) {
    return false;
  }
  /** @apilevel internal */
  public IdDecl Define_functionDeclaration(ASTNode _callerNode, ASTNode _childNode, String name) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_functionDeclaration(self, _callerNode, name)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_functionDeclaration(self, _callerNode, name);
  }

  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/NameAnalysis.jrag:117
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute functionDeclaration
   */
  protected boolean canDefine_functionDeclaration(ASTNode _callerNode, ASTNode _childNode, String name) {
    return false;
  }
  /** @apilevel internal */
  public Program Define_program(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_program(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_program(self, _callerNode);
  }

  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/Errors.jrag:29
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute program
   */
  protected boolean canDefine_program(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public Function Define_getFunctionAsJava(ASTNode _callerNode, ASTNode _childNode, String name) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_getFunctionAsJava(self, _callerNode, name)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_getFunctionAsJava(self, _callerNode, name);
  }

  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/interpreter.jrag:241
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute getFunctionAsJava
   */
  protected boolean canDefine_getFunctionAsJava(ASTNode _callerNode, ASTNode _childNode, String name) {
    return false;
  }
  /** @apilevel internal */
  public String Define_uniqueName(ASTNode _callerNode, ASTNode _childNode, String name) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_uniqueName(self, _callerNode, name)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_uniqueName(self, _callerNode, name);
  }

  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/UniqueNames.jrag:8
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute uniqueName
   */
  protected boolean canDefine_uniqueName(ASTNode _callerNode, ASTNode _childNode, String name) {
    return false;
  }
  /** @apilevel internal */
  public Function Define_function(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_function(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_function(self, _callerNode);
  }

  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:191
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute function
   */
  protected boolean canDefine_function(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public Function Define_enclosingFunction(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_enclosingFunction(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_enclosingFunction(self, _callerNode);
  }

  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/CallGraph.jrag:30
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute enclosingFunction
   */
  protected boolean canDefine_enclosingFunction(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_expectedType(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_expectedType(self, _callerNode);
  }

  /**
   * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:168
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute expectedType
   */
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
public ASTNode rewrittenNode() { throw new Error("rewrittenNode is undefined for ASTNode"); }
}
