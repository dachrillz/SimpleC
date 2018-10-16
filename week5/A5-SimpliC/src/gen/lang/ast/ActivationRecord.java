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
 * @declaredat /home/chrille/compilers/week5/A5-SimpliC/src/jastadd/interpreter.jrag:195
 */
public class ActivationRecord extends java.lang.Object {
  
        private HashMap<String,Integer> map;

  

        public ActivationRecord(){
            map = new HashMap<String,Integer>();
        }

  

        int get(String name){
            return map.get(name);
        }

  
        void put(String name, int value){
            map.put(name,value);
        }


}
