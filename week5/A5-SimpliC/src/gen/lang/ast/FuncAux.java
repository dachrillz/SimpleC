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
public class FuncAux extends java.lang.Object implements Comparable<FuncAux> {
  

        protected FuncCall function;

  

		public FuncAux(FuncCall function) {
            this.function= function;
		}

  

		public int compareTo(FuncAux other) {
            return function.getIdUse().getID().compareTo(other.function.getIdUse().getID());
		}

  

		public FuncCall getIdUse(){
		    return function;
		}

  

		public String toString() {
		  return function.getIdUse().getID();
		}


}
