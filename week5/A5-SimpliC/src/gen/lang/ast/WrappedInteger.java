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
 * @aspect Interpreter
 * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/interpreter.jrag:208
 */
public class WrappedInteger extends java.lang.Object {
  
        
        int a;

  
        boolean ret;

  
    
        public WrappedInteger(int a, boolean ret){
            this.a = a;
            this.ret = ret;
        }

  

        public int getInt(){
            return this.a;
        }

  

        public boolean getReturn(){
            return this.ret;
        }


}
