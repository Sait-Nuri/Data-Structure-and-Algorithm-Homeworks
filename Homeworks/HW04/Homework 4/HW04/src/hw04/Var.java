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
public class Var extends Operand{
    
    private Variable var;
    
    public Var(Variable newVar) {
        this.var = newVar;
    }
    
    @Override
    public void setValue(Operand val) throws GITCompiler.UndefinedVariableException {
        if(val instanceof Variable)
            this.var = (Variable) val;
        else
            throw new GITCompiler.UndefinedVariableException("");
    }
    
    
}
