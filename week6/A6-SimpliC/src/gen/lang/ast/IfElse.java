/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Scanner;
/**
 * @ast node
 * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/lang.ast:11
 * @astdecl IfElse : Statement ::= Condition:Expr Then:Block Else:Block;
 * @production IfElse : {@link Statement} ::= <span class="component">Condition:{@link Expr}</span> <span class="component">Then:{@link Block}</span> <span class="component">Else:{@link Block}</span>;

 */
public class IfElse extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/PrettyPrint.jrag:225
   */
  public void prettyPrint(PrintStream out, String ind) {
		
		out.print(ind + "if(");
		getCondition().prettyPrint(out, ind);
		out.print(") ");
		out.println("{");
		getThen().prettyPrint(out, ind + "    ");
		out.println(ind + "}");

		out.print(ind + "else");
		out.println("{");
		getElse().prettyPrint(out, ind + "    ");
		out.println(ind + "}");  

	}
  /**
   * @aspect CodeGen
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/CodeGen.jrag:74
   */
  public void genCode(PrintStream out){
        String funcName = enclosingFunction().getName().getID() + "_" + controlIndex() + "_";
        String startLabel = funcName + "if_start";
        String endLabel = funcName + "if_end";
        String elseLabel = funcName + "if_else";
        getCondition().genCode(out);
        String jumpOp = getCondition().jumpOp();

        //Else part
        out.println("\t" + jumpOp + " " + elseLabel);
        //End of else part

        out.println(startLabel + ":");
        getThen().genCode(out);

        //Else part
        out.println("\tjmp " + endLabel);
        out.println(elseLabel + ":");
        getElse().genCode(out);
        //End of else part
        
        //End
        out.println(endLabel + ":");
    }
  /**
   * @aspect Visitor
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/Visitor.jrag:112
   */
  public Object accept(Visitor visitor, Object data){
		return visitor.visit(this, data);
	}
  /**
   * @aspect Interpreter
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/interpreter.jrag:93
   */
  public WrappedInteger eval(ActivationRecord actrec){
        if(getCondition().eval(actrec) == 1){
           return getThen().eval(actrec); 
        }
        else{
            return getElse().eval(actrec);
        }
    }
  /**
   * @declaredat ASTNode:1
   */
  public IfElse() {
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
    children = new ASTNode[3];
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Condition", "Then", "Else"},
    type = {"Expr", "Block", "Block"},
    kind = {"Child", "Child", "Child"}
  )
  public IfElse(Expr p0, Block p1, Block p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 3;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:28
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    compatibleTypes_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:33
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public IfElse clone() throws CloneNotSupportedException {
    IfElse node = (IfElse) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public IfElse copy() {
    try {
      IfElse node = (IfElse) clone();
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
   * @declaredat ASTNode:61
   */
  @Deprecated
  public IfElse fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:71
   */
  public IfElse treeCopyNoTransform() {
    IfElse tree = (IfElse) copy();
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
   * @declaredat ASTNode:91
   */
  public IfElse treeCopy() {
    IfElse tree = (IfElse) copy();
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
   * @declaredat ASTNode:105
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Condition child.
   * @param node The new node to replace the Condition child.
   * @apilevel high-level
   */
  public void setCondition(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Condition child.
   * @return The current node used as the Condition child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Condition")
  public Expr getCondition() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the Condition child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Condition child.
   * @apilevel low-level
   */
  public Expr getConditionNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * Replaces the Then child.
   * @param node The new node to replace the Then child.
   * @apilevel high-level
   */
  public void setThen(Block node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Then child.
   * @return The current node used as the Then child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Then")
  public Block getThen() {
    return (Block) getChild(1);
  }
  /**
   * Retrieves the Then child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Then child.
   * @apilevel low-level
   */
  public Block getThenNoTransform() {
    return (Block) getChildNoTransform(1);
  }
  /**
   * Replaces the Else child.
   * @param node The new node to replace the Else child.
   * @apilevel high-level
   */
  public void setElse(Block node) {
    setChild(node, 2);
  }
  /**
   * Retrieves the Else child.
   * @return The current node used as the Else child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Else")
  public Block getElse() {
    return (Block) getChild(2);
  }
  /**
   * Retrieves the Else child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Else child.
   * @apilevel low-level
   */
  public Block getElseNoTransform() {
    return (Block) getChildNoTransform(2);
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
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:156
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/chrille/compilers/week6/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:156")
  public boolean compatibleTypes() {
    ASTState state = state();
    if (compatibleTypes_computed) {
      return compatibleTypes_value;
    }
    if (compatibleTypes_visited) {
      throw new RuntimeException("Circular definition of attribute IfElse.compatibleTypes().");
    }
    compatibleTypes_visited = true;
    state().enterLazyAttribute();
    compatibleTypes_value = compatibleTypes_compute();
    compatibleTypes_computed = true;
    state().leaveLazyAttribute();
    compatibleTypes_visited = false;
    return compatibleTypes_value;
  }
  /** @apilevel internal */
  private boolean compatibleTypes_compute() {
  	    return getCondition().expectedType().compatibleType(getCondition().type());
  	}
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:165
   * @apilevel internal
   */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getConditionNoTransform()) {
      // @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:169
      return booleanType();
    }
    else {
      return getParent().Define_expectedType(this, _callerNode);
    }
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:165
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute expectedType
   */
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/Errors.jrag:66
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
      collection.add(error("Must have boolean expression in IfElse. Got: " + getCondition().type()));
    }
  }
}
