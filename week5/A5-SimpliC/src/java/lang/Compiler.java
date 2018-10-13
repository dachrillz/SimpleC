package lang;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import beaver.Parser.Exception;

import lang.ast.Program;
import lang.ast.LangParser;
import lang.ast.LangScanner;

import lang.ast.Function;
import lang.ast.IdDecl;
import lang.ast.FuncHelper;

/**
 * Computes the maximum statement nesting depth for a Calc program.
 */
public class Compiler {
		public static Object DrAST_root_node; // Enable debugging with DrAST.
        public static final boolean printExtraStuff = true;
	
		public static void main(String[] args) {
		try {
			if (args.length != 1) {
				System.err.println(
						"You must specify a source file on the command line!");
				printUsage();
				System.exit(1);
				return;
			}

			String filename = args[0];
			LangScanner scanner = new LangScanner(new FileReader(filename));
			LangParser parser = new LangParser();
			Program program = (Program) parser.parse(scanner);
            if(program.errors().isEmpty()){
                if(printExtraStuff){
                    System.out.println("Call Graph! ");
                    for(Function f: program.getFunctionList()){
                        for(FuncHelper fu : f.functionCalls()){
                            System.out.println(f.getName().getID() + "-->" + fu);
                        } 
                    }
                    System.out.println("\nReachable Functions! ");
                    for(Function f : program.getFunctionList()){
                        System.out.println(f.getName().getID() + "{");
                        for(FuncHelper fu : f.functionCalls()){
                            System.out.println(fu.getIdUse().getIdUse().getID() + ", ");
                        }
                        System.out.println("}");
                    }
                    System.out.println("\n");
                }
                program.eval();
            }
			//program.prettyPrint(System.out);
			DrAST_root_node = program; // Enable debugging with DrAST.
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printUsage() {
		System.err.println("Usage: Compiler FILE");
		System.err.println("    where FILE is the file to be compiled");
	}
}

