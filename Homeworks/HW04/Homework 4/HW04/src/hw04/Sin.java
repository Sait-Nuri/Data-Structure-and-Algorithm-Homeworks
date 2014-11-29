/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw04;

/**
 *
 * @author said
 */
public class Sin extends MathFunc{
    
    public Sin( MyDouble radian) {
        super(radian);
    }

    @Override
    public void setValue(Operand val) throws GITCompiler.UndefinedVariableException, GITCompiler.UnknownOperatorException {
        if((val instanceof MyDouble)){
           this.value = (MyDouble)val; 
        }else if((val instanceof Variable)){
            this.value = new MyDouble(val.returnValue());
        }else{
            throw new GITCompiler.UnknownOperatorException("Undifined variable");
        }
    }
    
    @Override
    public double execute() {
        return Math.sin(value.returnValue());
    }
    
}
