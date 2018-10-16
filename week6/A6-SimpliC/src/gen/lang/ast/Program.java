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
 * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/lang.ast:1
 * @astdecl Program : ASTNode ::= Function*;
 * @production Program : {@link ASTNode} ::= <span class="component">{@link Function}*</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/CodeGen.jrag:4
   */
  public void genCode(PrintStream out) {
        out.println(".global _start");
        out.println(".data");
		out.println("ask_message: .ascii \"Please enter a number: \"");
		out.println("ask_msg_len: .quad 23");
		out.println("buf: .skip 1024");
		out.println();
        out.println(".text");
        out.println("_start:");
        // call main function
        //We want to place main first
        getMainFunction().genCode(out);
        for (Function decl: getFunctionListWithNoMain()) {
            decl.genCode(out);
        }
        // call sys_exit
        // helper procedures (print/read)
        out.println();
        generateBuiltinFunctions(out);
    }
  /**
   * @aspect CodeGen
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/CodeGen.jrag:25
   */
  private Function getMainFunction(){
        for(Function decl: getFunctionList()){
            if(decl.getName().getID().equals("main")){
                return decl;
            }
        }
        throw new RuntimeException("No main was found in the program");
    }
  /**
   * @aspect CodeGen
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/CodeGen.jrag:34
   */
  private ArrayList<Function> getFunctionListWithNoMain(){
        ArrayList<Function> temp = new ArrayList<Function>();
        for(Function decl: getFunctionList()){
            if(!decl.getName().getID().equals("main")){
                temp.add(decl); 
            }
        }
        return temp;
    }
  /**
   * @aspect BuiltIns
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/CodeGen.jrag:381
   */
  public void generateBuiltinFunctions(PrintStream out){
		genPrint(out);
		out.println();
		genRead(out);
	}
  /**
   * @aspect BuiltIns
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/CodeGen.jrag:387
   */
  public void genPrint(PrintStream out){
		out.println("# Procedure to print number to stdout.");
		out.println("# C signature: void print(long int)");
		out.println("print:");
		out.println("\tpushq %rbp");
		out.println("\tmovq %rsp, %rbp");
		out.println("        ### Convert integer to string (itoa).");
		out.println("\tmovq 16(%rbp), %rax");
		out.println("\tmovq $(buf+1023), %rsi  # RSI = write pointer (starts at end of buffer)");
		out.println("\tmovb $0x0A, (%rsi)      # insert newline");
		out.println("\tmovq $1, %rcx           # RCX = string length");
		out.println("\tcmpq $0, %rax");
		out.println("\tjge itoa_loop");
		out.println("\tnegq %rax               # negate to make RAX positive");
		out.println("itoa_loop:                      # do.. while (at least one iteration)");
		out.println("\tmovq $10, %rdi");
		out.println("\tmovq $0, %rdx");
		out.println("\tidivq %rdi              # divide RDX:RAX by 10");
		out.println("\taddb $0x30, %dl         # remainder + '0'");
		out.println("\tdecq %rsi               # move string pointer");
		out.println("\tmovb %dl, (%rsi)");
		out.println("\tincq %rcx               # increment string length");
		out.println("\tcmpq $0, %rax");
		out.println("\tjg itoa_loop            # produce more digits");
		out.println("itoa_done:");
		out.println("\tmovq 16(%rbp), %rax");
		out.println("\tcmpq $0, %rax");
		out.println("\tjge print_end");
		out.println("\tdecq %rsi");
		out.println("\tincq %rcx");
		out.println("\tmovb $0x2D, (%rsi)");
		out.println("print_end:");
		out.println("\tmovq $1, %rdi");
		out.println("\tmovq %rcx, %rdx");
		out.println("\tmovq $1, %rax");
		out.println("\tsyscall");
		out.println("\tpopq %rbp");
		out.println("\tret");
		out.println();
		out.println("print_string:");
		out.println("\tpushq %rbp");
		out.println("\tmovq %rsp, %rbp");
		out.println("\tmovq $1, %rdi");
		out.println("\tmovq 16(%rbp), %rsi");
		out.println("\tmovq 24(%rbp), %rdx");
		out.println("\tmovq $1, %rax");
		out.println("\tsyscall");
		out.println("\tpopq %rbp");
		out.println("\tret");
	}
  /**
   * @aspect BuiltIns
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/CodeGen.jrag:438
   */
  public void genRead(PrintStream out){
		// Helper procedures for input/output:
		out.println("# Procedure to read number from stdin.");
		out.println("# C signature: long int read(void)");
		out.println("read:");
		out.println("\tpushq %rbp");
		out.println("\tmovq %rsp, %rbp");

		//Prints initial message
		out.println("\tmovq $1, %rdi	#stdout file descriptor");
		out.println("\tmovq $ask_message, %rsi	#msg to print");
		out.println("\tmovq $23, %rdx		#msg length");
		out.println("\tmovq $1, %rax		#sys_write");
		out.println("\tsyscall");
		out.println("\tmovq $0, %rdi");
		out.println("\tmovq $buf, %rsi");
		out.println("\tmovq $1024, %rdx");
		out.println("\tmovq $0, %rax");
		out.println("\tsyscall                 # sys_read(0, buf, 1024)");
		out.println("\t### Convert string to integer (atoi).");
		out.println("\t### RAX = string length (nchar)");
		out.println("\t### RSI = string pointer");
		out.println("\tmovq $0, %rdx           # sum <- 0");
		out.println("\tcmpq $0, %rax           # if (nchar > 0)");
		out.println("\tjle atoi_done           # nchar <= 0");
		out.println("\tmovq %rsi, %rdi         # copy RSI to RDI for sign check later");
		out.println("\tmovb (%rsi), %ch        # look at first char");
		out.println("\tcmp $0x2D, %ch");
		out.println("\tjne atoi_loop");
		out.println("\tincq %rsi               # skip sign char");
		out.println("atoi_loop:");
		out.println("\tcmpq $0, %rax           # while (nchar > 0)");
		out.println("\tjle atoi_done           # leave loop if nchar <= 0");
		out.println("\tmovzbq (%rsi), %rcx     # move byte, zero extend to quad-word");
		out.println("\tcmpq $0x30, %rcx        # test if < '0'");
		out.println("\tjl atoi_done            # character is not numeric");
		out.println("\tcmpq $0x39, %rcx        # test if > '9'");
		out.println("\tjg atoi_done            # character is not numeric");
		out.println("\timulq $10, %rdx         # multiply sum by 10");
		out.println("\tsubq $0x30, %rcx        # value of character");
		out.println("\taddq %rcx, %rdx         # add to sum");
		out.println("\tincq %rsi               # step to next char");
		out.println("\tdecq %rax               # nchar--");
		out.println("\tjmp atoi_loop           # loop back");
		out.println("atoi_done:");
		out.println("\tmovq %rdx, %rax         # put result value in RAX");
		out.println("\tmovb (%rdi), %ch        # check sign char");
		out.println("\tcmp $0x2D, %ch");
		out.println("\tjne read_end");
		out.println("\tnegq %rax               # negate result due to sign char");
		out.println("read_end:");
		out.println("\tpopq %rbp");
		out.println("\tret");

	}
  /**
   * @aspect Visitor
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/Visitor.jrag:181
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @aspect Interpreter
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/interpreter.jrag:6
   */
  public void eval(){
        if(main() != null){
            main().eval(new ActivationRecord());
        }
        else{
        throw new RuntimeException("Main is not defined in program."); 
        }
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
    intType_reset();
    booleanType_reset();
    unknownType_reset();
    unknownDecl_reset();
    localIndex_reset();
    predefinedFunctions_reset();
    main_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Program_errors_visited = false;
    Program_errors_computed = false;
    
    Program_errors_value = null;
    contributorMap_Program_errors = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:47
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:52
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
   * @declaredat ASTNode:71
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
   * @declaredat ASTNode:81
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
   * @declaredat ASTNode:101
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
   * @declaredat ASTNode:115
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
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/Errors.jrag:26
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
   * @attribute syn
   * @aspect IntType
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/types.jrag:3
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="IntType", declaredAt="/home/chrille/compilers/week6/A6-SimpliC/src/jastadd/types.jrag:3")
  public IntType intType() {
    ASTState state = state();
    if (intType_computed) {
      return intType_value;
    }
    if (intType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.intType().");
    }
    intType_visited = true;
    state().enterLazyAttribute();
    intType_value = new IntType();
    intType_value.setParent(this);
    intType_computed = true;
    state().leaveLazyAttribute();
    intType_visited = false;
    return intType_value;
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
   * @attribute syn
   * @aspect BooleanType
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/types.jrag:15
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="BooleanType", declaredAt="/home/chrille/compilers/week6/A6-SimpliC/src/jastadd/types.jrag:15")
  public BooleanType booleanType() {
    ASTState state = state();
    if (booleanType_computed) {
      return booleanType_value;
    }
    if (booleanType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.booleanType().");
    }
    booleanType_visited = true;
    state().enterLazyAttribute();
    booleanType_value = new BooleanType();
    booleanType_value.setParent(this);
    booleanType_computed = true;
    state().leaveLazyAttribute();
    booleanType_visited = false;
    return booleanType_value;
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
   * @attribute syn
   * @aspect UnknownType
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/types.jrag:27
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownType", declaredAt="/home/chrille/compilers/week6/A6-SimpliC/src/jastadd/types.jrag:27")
  public UnknownType unknownType() {
    ASTState state = state();
    if (unknownType_computed) {
      return unknownType_value;
    }
    if (unknownType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownType().");
    }
    unknownType_visited = true;
    state().enterLazyAttribute();
    unknownType_value = new UnknownType();
    unknownType_value.setParent(this);
    unknownType_computed = true;
    state().leaveLazyAttribute();
    unknownType_visited = false;
    return unknownType_value;
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
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/UnknownDecl.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/home/chrille/compilers/week6/A6-SimpliC/src/jastadd/UnknownDecl.jrag:2")
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
protected boolean localIndex_visited = false;
  /** @apilevel internal */
  private void localIndex_reset() {
    localIndex_computed = false;
    localIndex_visited = false;
  }
  /** @apilevel internal */
  protected boolean localIndex_computed = false;

  /** @apilevel internal */
  protected int localIndex_value;

  /**
   * @attribute syn
   * @aspect AddressHandling
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/CodeGen.jrag:362
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="AddressHandling", declaredAt="/home/chrille/compilers/week6/A6-SimpliC/src/jastadd/CodeGen.jrag:361")
  public int localIndex() {
    ASTState state = state();
    if (localIndex_computed) {
      return localIndex_value;
    }
    if (localIndex_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.localIndex().");
    }
    localIndex_visited = true;
    state().enterLazyAttribute();
    localIndex_value = 0;
    localIndex_computed = true;
    state().leaveLazyAttribute();
    localIndex_visited = false;
    return localIndex_value;
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
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/NameAnalysis.jrag:141
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/chrille/compilers/week6/A6-SimpliC/src/jastadd/NameAnalysis.jrag:141")
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
          Function read = new Function(new IntType(), new IdDecl("read"), new List(), new Block());
          List<IdDecl> printArguments = new List<IdDecl>();
          printArguments.add(new IdDecl("printarg"));
          Function print = new Function(new IntType(), new IdDecl("print"), printArguments, new Block());
  
          list.add(read);
          list.add(print);
  
          return list;
      }
/** @apilevel internal */
protected boolean main_visited = false;
  /** @apilevel internal */
  private void main_reset() {
    main_computed = false;
    
    main_value = null;
    main_visited = false;
  }
  /** @apilevel internal */
  protected boolean main_computed = false;

  /** @apilevel internal */
  protected Function main_value;

  /**
   * @attribute syn
   * @aspect Interpreter
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/interpreter.jrag:230
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Interpreter", declaredAt="/home/chrille/compilers/week6/A6-SimpliC/src/jastadd/interpreter.jrag:230")
  public Function main() {
    ASTState state = state();
    if (main_computed) {
      return main_value;
    }
    if (main_visited) {
      throw new RuntimeException("Circular definition of attribute Program.main().");
    }
    main_visited = true;
    state().enterLazyAttribute();
    main_value = main_compute();
    main_computed = true;
    state().leaveLazyAttribute();
    main_visited = false;
    return main_value;
  }
  /** @apilevel internal */
  private Function main_compute() {
          for (Function f : getFunctionList()){
              if (f.getName().getID().equals("main")){
                  return (Function) f;
              }
          }
          return null;
      }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/types.jrag:5
   * @apilevel internal
   */
  public IntType Define_intType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return intType();
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/types.jrag:5
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute intType
   */
  protected boolean canDefine_intType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/types.jrag:17
   * @apilevel internal
   */
  public BooleanType Define_booleanType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return booleanType();
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/types.jrag:17
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute booleanType
   */
  protected boolean canDefine_booleanType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/types.jrag:29
   * @apilevel internal
   */
  public UnknownType Define_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownType();
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/types.jrag:29
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownType
   */
  protected boolean canDefine_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:174
   * @apilevel internal
   */
  public boolean Define_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:174
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isVariable
   */
  protected boolean canDefine_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:175
   * @apilevel internal
   */
  public boolean Define_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:175
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isFunction
   */
  protected boolean canDefine_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/UnknownDecl.jrag:4
   * @apilevel internal
   */
  public UnknownDecl Define_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownDecl();
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/UnknownDecl.jrag:4
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownDecl
   */
  protected boolean canDefine_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/NameAnalysis.jrag:4
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getFunctionListNoTransform()) {
      // @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/NameAnalysis.jrag:6
      int i = _callerNode.getIndexOfChild(_childNode);
      return unknownDecl();
    }
    else {
      return getParent().Define_lookup(this, _callerNode, name);
    }
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/NameAnalysis.jrag:4
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute lookup
   */
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/NameAnalysis.jrag:56
   * @apilevel internal
   */
  public boolean Define_isMulti(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getFunctionListNoTransform()) {
      // @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/NameAnalysis.jrag:59
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
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/NameAnalysis.jrag:56
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isMulti
   */
  protected boolean canDefine_isMulti(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/NameAnalysis.jrag:132
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
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/NameAnalysis.jrag:132
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute functionDeclaration
   */
  protected boolean canDefine_functionDeclaration(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/Errors.jrag:28
   * @apilevel internal
   */
  public Program Define_program(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return this;
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/Errors.jrag:28
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute program
   */
  protected boolean canDefine_program(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/interpreter.jrag:241
   * @apilevel internal
   */
  public Function Define_getFunctionAsJava(ASTNode _callerNode, ASTNode _childNode, String name) {
    int childIndex = this.getIndexOfChild(_callerNode);
    {
            for(Function func : getFunctionList()){
                if(func.getName().getID().equals(name)){
                    return func;
                }
            }
            return null; //Should never happen as all function definition are checked in the static analysis.
        }
  }
  /**
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/interpreter.jrag:241
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute getFunctionAsJava
   */
  protected boolean canDefine_getFunctionAsJava(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
/** @apilevel internal */
protected boolean Program_errors_visited = false;
  /**
   * @attribute coll
   * @aspect Errors
   * @declaredat /home/chrille/compilers/week6/A6-SimpliC/src/jastadd/Errors.jrag:26
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="Errors", declaredAt="/home/chrille/compilers/week6/A6-SimpliC/src/jastadd/Errors.jrag:26")
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
