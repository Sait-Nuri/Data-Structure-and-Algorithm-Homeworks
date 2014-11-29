/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw04;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author said
 */
public class Loop extends Operand implements Executable{

    private Variable counter;
    private List<Variable> localVarList;
    private List<Variable> UpperScopeVarList;
    private PostfixLineEval evalLines;
    
    public Loop(Variable cntr, List<Variable> upper) {
        UpperScopeVarList = upper;
        counter = cntr;
        localVarList = new LinkedList<>();
        evalLines = new PostfixLineEval();
    }
    
    @Override
    public double returnValue(){
        
        return execute();
    }
    
    @Override
    public double execute() {
        while(counter.returnValue() > 0){
            
            try {
                evalLines.executeLines();
                counter.setValue(counter.returnValue()-1); //counter--
            } catch (Exception ex) {
                Logger.getLogger(Loop.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return 0.0;
    }
    
    @Override
    public void setValue(Operand val) throws GITCompiler.UndefinedVariableException, GITCompiler.UnknownOperatorException {
        setCounter((Variable)val);
    }
    
    public void addNewLocalVar(Variable newVar) throws Exception{
        if(!IsVarAlready(newVar.getVarName()))
            getLocalVarList().add(newVar);
        else{
            throw new Exception(newVar.getVarName() + "already exist");
        }
    }

    private boolean IsVarAlready(String newVar) {
        if(localVarList.isEmpty())
            return false;
        
        ListIterator<Variable> iter = getLocalVarList().listIterator();
        
        while(iter.hasNext()){
            if(iter.next().getVarName().equals(newVar))
                return false;
        }
        
        return true;
    }

    /**
     * @return the localVarList
     */
    public List<Variable> getLocalVarList() {
        return localVarList;
    }

    /**
     * @return the UpperScopeVarList
     */
    public List<Variable> getUpperScopeVarList() {
        return UpperScopeVarList;
    }

    void addExecutableLine(List<Object> postfix) {
        evalLines.addLine(postfix);
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(Variable counter) {
        this.counter = counter;
    }
    
    public List<Variable> getAllVars(){
        LinkedList<Variable> all = new LinkedList<>();
        all.addAll(localVarList);
        all.addAll(UpperScopeVarList);
        return all;
    }
}
