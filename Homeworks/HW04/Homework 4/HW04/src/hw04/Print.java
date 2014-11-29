package hw04;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author said
 * @version 1.0
 * @created 31-Mar-2014 10:09:39 PM
 */
public class Print extends Operand implements Executable {

	private Operand operand;

	public Print(Operand op){
            this.operand = op;
	}
        
        public Print(){
            this.operand = null;
        }
        
        @Override
        public void setValue(Operand val) throws GITCompiler.UndefinedVariableException {
            this.operand = val;
        }
        
        @Override
	public double execute(){
            double val = 0;
            
            if(operand instanceof Variable){
                Variable var = (Variable)operand;
                val = var.returnValue();
            }else if(operand instanceof MyDouble)              
                val = operand.returnValue();
            else{
                try {
                    throw new GITCompiler.UnknownOperatorException("Unknown operator found");
                } catch (GITCompiler.UnknownOperatorException ex) {
                    Logger.getLogger(Print.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println(val);
            
            return val;
	}

        @Override
        public double returnValue(){
		return execute();
	}
}