package lang.ast;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast class
 * @aspect NameAnalysis
 * @declaredat /home/chrille/compilers/week4/A4-SimpliC/src/jastadd/NameAnalysis.jrag:3
 */
 class MyDebugger extends java.lang.Object {
  
        public static final boolean DEBUG = true;

  
        public static void print(String s){
            if(DEBUG){
                System.out.println(s);
            }
        }


}
