package hw04;

/**
 * @author said
 * @version 1.0
 * @created 31-Mar-2014 10:09:39 PM
 */
public class MyDouble extends Operand {

        private double value;
        
	public MyDouble(){
            this.value = 0;
	}

        public MyDouble(double val){
            this.value = val;
	}
        
        @Override
        public double returnValue(){
            
            return value;            
        }

}