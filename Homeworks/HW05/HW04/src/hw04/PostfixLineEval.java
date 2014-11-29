/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw04;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
/**
 *
 * @author said
 */
public class PostfixLineEval {
      
    private List<List<Object>> postfixLines;
    private Stack < Operand > operandStack;

    public PostfixLineEval() {
        postfixLines = new LinkedList<>();
    }
      
    public void addLine(List<Object> codeline){
        postfixLines.add(codeline);
    }
    
    public double executeLines() throws Exception{
        return eval();
    }
    
    private double eval() throws Exception {
        
        ListIterator allCodeIter = postfixLines.listIterator();       
        double answer = 0;
        
        while(allCodeIter.hasNext()){           
           operandStack = new Stack<>();
           
           LinkedList<Object> current = (LinkedList<Object>) allCodeIter.next();
           ListIterator iter = current.listIterator();        
        
            while(iter.hasNext()){
                Object obj = iter.next();

                if(obj instanceof String){
                    String op = (String)obj;
                    if(IsOperator(op)){
                        double res = evalOp(op.charAt(0));
                        operandStack.push(new MyDouble(res));
                    }

                }else if(obj instanceof Operand){
                    Operand op = (Operand)obj;
                    operandStack.push(op);
                }
            }
            
            Object obj  = operandStack.pop();
            if((obj instanceof Var) || (obj instanceof Print) || (obj instanceof Input) || (obj instanceof Loop)){
                answer = ((Operand)obj).returnValue();
            }else if(obj instanceof MyDouble){
                answer = ((MyDouble)obj).returnValue();               
            }else{
                throw new Exception("Syntax Error: Unknown token");
            } 
        }
        return answer;       
    }
    
    private double evalOp(char op) {
        Operand rhs = operandStack.pop();
        Operand lhs = operandStack.pop();       
        double result = 0.0;
        
        switch(op){
            case '+':
                result = lhs.returnValue() + rhs.returnValue();
                break;
            case '-':
                result = lhs.returnValue() - rhs.returnValue();
                break;
            case '/':
                result = lhs.returnValue() / rhs.returnValue();
                break;
            case '*':
                result = lhs.returnValue() * rhs.returnValue();
                break;
            case '=':
                Variable v = (Variable)lhs;
                v.setValue(rhs.returnValue());
                result = v.returnValue();
        }
    
        return result;
    }
    
    public boolean IsOperator(String expr){
        char ch = expr.charAt(0); 

        return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '=');
    }
}
