package hw04;

/**
 * @author said
 * @version 1.0
 * @created 31-Mar-2014 10:09:39 PM
 */
public class Variable extends Operand {

    private double value;
    private String varName;

    public Variable(String name, double value){
        this.varName = name;
        this.value = value;
    }
    
    public Variable(String name){
        this.varName = name;
        this.value = 0.0;
    }
    @Override
    public double returnValue(){
        return value;
    }
    /**
     * @return the value
     */

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @return the varName
     */
    public String getVarName() {
        return varName;
    }

    /**
     * @param varName the varName to set
     */
    public void setVarName(String varName) {
        this.varName = varName;
    }

        
}