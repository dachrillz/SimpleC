package lang.ast;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Scanner;
/**
 * @ast class
 * @aspect CallGraph
 * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/CallGraph.jrag:2
 */
public class FuncHelper extends java.lang.Object implements Comparable<FuncHelper> {
  

        protected FuncCall func;

  

		public FuncHelper(FuncCall usedFunc) {
            this.func = usedFunc;
		}

  
		public int compareTo(FuncHelper other) {
            return func.getIdUse().getID().compareTo(other.func.getIdUse().getID());
		}

  
		public String toString() {
		  return func.getIdUse().getID();
		}

  

		public FuncCall getIdUse(){
		    return func;
		}


}
