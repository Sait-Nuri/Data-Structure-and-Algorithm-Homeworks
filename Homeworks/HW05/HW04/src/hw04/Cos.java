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
public class Cos extends MathFunc{

    public Cos(MyDouble radian) {
        super(radian);
    }

    @Override
    public double execute() {
        return Math.cos(value.returnValue());
    }
    
    @Override
    public void setValue(Operand val) throws GITCompiler.UndefinedVariableException, GITCompiler.UnknownOperatorException {
        if((val instanceof MyDouble)){
           this.value = (MyDouble)val; 
        }else if((val instanceof Var)){
            this.value = new MyDouble(val.returnValue());
        }else{
            throw new GITCompiler.UnknownOperatorException("Undifined variable");
        }
    }
}
