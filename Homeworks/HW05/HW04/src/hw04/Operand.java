package hw04;

/**
 * @author said
 * @version 1.0
 * @created 31-Mar-2014 10:09:39 PM
 */
public class Operand {

	public Operand(){

	}

	public double returnValue(){
            return 0.0;
	}
        
        public void setValue(Operand val) throws GITCompiler.UndefinedVariableException, GITCompiler.UnknownOperatorException{
            throw new UnsupportedOperationException("Current class must override the setValue()");
        }
        
        
}