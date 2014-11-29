package hw04;

import java.util.Scanner;

/**
 * @author said
 * @version 1.0
 * @created 31-Mar-2014 10:09:39 PM
 */
public class Input extends Operand implements Executable {

	private Variable var;

	public Input(){

	}

        public Input(Variable newVar){
            var = newVar;
	}
        
        @Override
	public double execute(){
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter the value for varible " + var.getVarName() + ":");
            double input = sc.nextDouble();
            var.setValue(input);
            return var.returnValue();
	}

        @Override
	public double returnValue(){
            return execute();
	}
        
        @Override
        public void setValue(Operand val) throws GITCompiler.UndefinedVariableException {
            if(val instanceof Variable){
                this.var = (Variable)val;
            }
        }
}