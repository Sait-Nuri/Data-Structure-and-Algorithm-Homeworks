package hw04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * @author said
 * @version 1.0
 * @created 31-Mar-2014 10:09:39 PM
 */
public class GITCompiler implements Compilable {

    private BufferedReader reader;
    private FileReader sourceFile;
    PostfixLineEval evalLines;
    private int curLineNum;
    
    /** The operators */
    private static final String OPERATORS = "+-*/()=";
    
    /** The precedence of the operators, matches order of OPERATORS. */
    private static final int[] PRECEDENCE = {2, 2, 3, 3, 1, 1, 0};
  
    /** The operator stack */
    private Stack < Character > operatorStack;
  
    public GITCompiler(String filePath){
        try {
            this.sourceFile = new FileReader(filePath);
            this.reader = new BufferedReader( sourceFile );
            this.evalLines = new PostfixLineEval();
            this.curLineNum = 0;
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.err.println("Invalid path to source code");
            System.exit(1);
        }

    }

    @Override
    public void compileAndRun() {
        LinkedList<Object> postfix;
        LinkedList<Object> infix;
        String line;
        List<Variable> localVars = new LinkedList<>();
        double result;
        
        try {
            while ((line = reader.readLine()) != null) {

                curLineNum++;
                
                /* Burada infix hali var */
                infix = checkLine(line, localVars);                
              
                // Burada initialization yapılacak
                initializeValues(infix, localVars);
                
                //Burada postfixe çevrilip evoluate
                postfix = toPostfix(infix);
                
                //Postfixe çevrilmiş kod listeye eklendi
                evalLines.addLine(postfix);
                
            }
        } catch (IOException ex) {
            System.err.println("Input Error");
            ex.printStackTrace();
            System.exit(1);
        } catch (UnknownOperatorException | UndefinedVariableException ex) {
            ex.printStackTrace();
            System.exit(-1);
        } catch (LoopSyntaxErrorException ex) {
            Logger.getLogger(GITCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            //Burada hesaplama yapılıyor
            result = this.evalLines.executeLines();
        } catch (Exception ex) {
            Logger.getLogger(GITCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private LinkedList<Object> toPostfix(List<Object> infixCode) throws UnknownOperatorException {    
        LinkedList<Object> postfix = null;
        
        try {        
            postfix = convert(infixCode);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return postfix;
    }
    
    private LinkedList<Object> convert(List<Object> infixCode) throws UnknownOperatorException, Exception {
        this.operatorStack = new Stack<>();
        LinkedList<Object> postfix = new LinkedList<>();
        ListIterator<Object> iter = infixCode.listIterator();
        
        try {
            // infix kodunun tüm tokenlarını gez 
            while(iter.hasNext()){
                Object nextToken = iter.next();

                // Eğer operatorse
                if(nextToken instanceof String){
                    String Op = (String)nextToken;
                    if(IsOperator(Op))
                        processOperator(Op.charAt(0), postfix);
                    else
                        throw new UnknownOperatorException("Unknown Operator at" + getCurLineNum() +". line");
                }else{  // Eğer Operand ise
                    postfix.add(nextToken);
                }
            }          
            
            // Pop any remaining operators
            // and append them to postfix.
            while (!operatorStack.empty()) {
                char op = operatorStack.pop(); 
                // Any '(' on the stack is not matched.
                if (op == '(')
                    throw new Exception(
                        "Unmatched parenthesis at " + getCurLineNum() + ". line");
                // Burada stackte son kalan operatorleri ekliyoruz.
                postfix.add(String.valueOf(op));
                
            }
        }
        catch(EmptyStackException ex){
            throw new Exception("Missing operand at "+ getCurLineNum() +". line");
        }
        
        return postfix;
    }
    
    private void processOperator(char op, LinkedList<Object> postfix){
        if(operatorStack.empty() || op == '('){
            operatorStack.push(op);
        }else {
            // Peek the operator stack and
            // let topOp be the top operator.
            char topOp = operatorStack.peek();
            if (precedence(op) > precedence(topOp)) {
                operatorStack.push(op);
            }
            else {
                // Pop all stacked operators with equal
                // or higher precedence than op.
                while (!operatorStack.empty() 
                        && precedence(op) <= precedence(topOp)) {
                    operatorStack.pop();
                    
                    if (topOp == '(') {
                        // Matching '(' popped - exit loop.
                        break;
                    }
                    // Stackin üstteki elemanı postfixe ekliyoruz
                    postfix.add(String.valueOf(topOp));
                    
                    if (!operatorStack.empty()) {
                    // Reset topOp.
                        topOp = operatorStack.peek();
                    }
                }

                // assert: Operator stack is empty or
                //         current operator precedence >
                //         top of stack operator precedence.
                if (op != ')')
                  operatorStack.push(op);
            }
        }
    }

    /** Determine the precedence of an operator.
    @param op The operator
    @return the precedence
    */
    private int precedence(char op) {
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }
    
    private void initializeValues(List<Object> Code, List<Variable> varList) throws UnknownOperatorException, UndefinedVariableException {
        ListIterator<Object> iter = Code.listIterator();
        Object currentObj;
        Operand Curoper;
        
        while(iter.hasNext()){
            currentObj = iter.next();
               
            if(currentObj instanceof Executable){
                try{
                    Operand nextOp = (Operand) iter.next();  
                    if(nextOp instanceof Variable){
                        if(!( checkVariable( ((Variable)nextOp).getVarName(), varList )) ){
                            throw new UndefinedVariableException("There is no such a variable " + ((Variable)nextOp).getVarName());
                        }
                    }
                    Curoper = (Operand)currentObj;
                    Curoper.setValue(nextOp);
                    iter.remove();
                }catch (ClassCastException ex){
                    throw new UnknownOperatorException("Unknown Operator in "+ getCurLineNum() + ". line");
                }                
            }
            else if(currentObj instanceof Var){ 
                Operand nextOp2 = (Operand) iter.next();                    
                Curoper = (Operand)currentObj;
                varList.add((Variable) nextOp2);
                Curoper.setValue((Variable) nextOp2);
                iter.remove();
            }
            
        }
    }
    
    private LinkedList<Object> checkLine(String line, List<Variable> varList) throws UnknownOperatorException, UndefinedVariableException, LoopSyntaxErrorException{
        
        StringTokenizer tokenizer = new StringTokenizer(line);
        LinkedList<Object> gitFormat = new LinkedList<>();
        
        String nextExp;
        String before = "unusued";
        
        while(tokenizer.hasMoreTokens()){           
            nextExp = tokenizer.nextToken();
            if(nextExp.equals("var"))
                before = nextExp;
            
            if(IsOperator(nextExp)){
                gitFormat.add(nextExp);
            }else if(IsDouble(nextExp)){
                gitFormat.add(new MyDouble(Double.valueOf(nextExp)));
            }else if (IsInput(nextExp)) {
                gitFormat.add(new Input(null));
            }else if (IsPrint(nextExp)) {
                gitFormat.add(new Print(null));
            }else if (IsVar(nextExp)) {
                gitFormat.add(new Var(null));
            }else if(IsFunction(nextExp)){
                gitFormat.add(FuncToDouble(nextExp));
            }else if(Is_a_Variable(nextExp)){
                if(checkVariable(nextExp, varList)){
                    Variable var = findVar(nextExp, varList);
                    gitFormat.add(var);
                }else if(!checkVariable(nextExp, varList)){  
                    if(before.equals("var")){
                        Variable newVar = new Variable(nextExp, 0);
                        gitFormat.add(newVar); 
                    }else
                        throw new UndefinedVariableException(nextExp);                  
                    //varList.add(newVar);
                }else
                    throw new UndefinedVariableException(nextExp);
            }else if(IsLoop(nextExp)){
                Loop newLoop = null;
                String next = tokenizer.nextToken();
                Variable counter = null;              
                
                if(!IsVar(next)){
                    throw new UndefinedVariableException(next + "\nLoop counter must be a variable");
                }
  
                if(checkVariable(next, varList)){
                    counter = findVar(next, varList);
                    newLoop = new Loop(counter, varList);
                }
                
                int numberoflines = initializeLoop(newLoop, reader);
                
                curLineNum += numberoflines;
                
                gitFormat.add(newLoop);
                gitFormat.add(counter);
                
            }else
                throw new UnknownOperatorException("Unknown Operator Detected at " + getCurLineNum() + ". line"); 
        }       
            return gitFormat;
    }
    public Variable findVar(String varName, List<Variable> varList){
        ListIterator<Variable> iter = varList.listIterator();
        
        while(iter.hasNext()){
            Variable curVar = iter.next();
            if(curVar.getVarName().equals(varName))
                return curVar;
        }
        return null;
    }
    /**
     * @return the curLineNum
     */
    public int getCurLineNum() {
        return curLineNum;
    }

    private Operand FuncToDouble(String nextExp) {
        switch (nextExp) {
            case "sin":
                return new Sin(null);
            case "cos":
                return new Cos(null);
            case "sqrt":
                return new Sqrt(null);
            case "log" :
                return new Log(null);
            case "abs" :       
                return new Abs(null);
            case "tan" :     
                return new Tan(null);
            case "exp" : 
                return new Exp(null);
        }
        return null;
    }

    private boolean checkVariable(String nextExp, List<Variable> varList) {
        ListIterator<Variable> iter = varList.listIterator();
        
        while(iter.hasNext()){
            if(iter.next().getVarName().equals(nextExp))
                return true;
        }
        return false;
    }

    private boolean IsLoop(String nextExp) {
        return nextExp.equals("loop");
    }

    private int initializeLoop(Loop newLoop, BufferedReader reader) {
        LinkedList<Object> postfix;
        LinkedList<Object> infix;
        List<Variable> allVariables = new LinkedList<>();
        String line;
        int numberofreadlines = 0;
        
        allVariables.addAll(newLoop.getLocalVarList());
        allVariables.addAll(newLoop.getUpperScopeVarList());
  
        try {
            while( (line = reader.readLine()) != null ){
                if(line.equals("begin"))
                    break;
                numberofreadlines++;  
                LinkedList<Object> gitFormat = new LinkedList<>();
                StringTokenizer tokenizer = new StringTokenizer(line);
                
                while(tokenizer.hasMoreTokens()){
                    String next = tokenizer.nextToken();
                    
                    if (IsVar(next)) {
                        gitFormat.add(new Var(null));
                    }else if(Is_a_Variable(next)){
                        if(checkVariable(next, newLoop.getLocalVarList())){
                            Variable var = findVar(next, newLoop.getLocalVarList());
                            gitFormat.add(var);
                        }else if(!checkVariable(next, newLoop.getLocalVarList())){                   
                            Variable newVar = new Variable(next, 0);
                            newLoop.addNewLocalVar(newVar);
                            gitFormat.add(newVar);
                            //varList.add(newVar);
                        }else
                            throw new UndefinedVariableException(next);
                    }
                    
                }
                
                // Burada initialization yapılacak
                initializeValues(gitFormat, newLoop.getAllVars());

                //Burada postfixe çevrilip evoluate
                postfix = toPostfix(gitFormat);
            }            
        } catch (IOException | UnknownOperatorException | UndefinedVariableException ex) {
            Logger.getLogger(GITCompiler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(GITCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while ((line = reader.readLine()) != null){
                numberofreadlines++;
                
                if(line.equals("end"))
                    break;
                
                /* Burada infix hali var */
                infix = checkLine(line, newLoop.getAllVars());                
              
                // Burada initialization yapılacak
                initializeValues(infix, newLoop.getAllVars());
                
                //Burada postfixe çevrilip evoluate
                postfix = toPostfix(infix);
                
                newLoop.addExecutableLine(postfix);
                
            }
        } catch (IOException | UnknownOperatorException | UndefinedVariableException | LoopSyntaxErrorException ex) {
            Logger.getLogger(GITCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return numberofreadlines;
    }

    

    public static class UnknownOperatorException extends Exception {

        /** Construct a SyntaxErrorException with the specified
            message.
            @param message The message
         */
        UnknownOperatorException(String message) {
          super(message);
        }
    }
    
    public static class UndefinedVariableException extends Exception {

        /** Construct a SyntaxErrorException with the specified
            message.
            @param message The message
         */
        UndefinedVariableException(String varName) {
          super("There is no such a variable defined before: " + varName);
        }
    }

    public boolean IsVar(String expr){
        return expr.equals("var");
    }

    public boolean IsPrint(String expr){
        return expr.equals("print");
    }

    public boolean IsInput(String expr){
        return expr.equals("input");
    }

    public boolean IsDouble(String expr){

        try {
            Double.parseDouble(expr);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public boolean Is_a_Variable(String expr) throws UnknownOperatorException{

        if( (!IsFunction(expr)) && !(expr.charAt(0) > 47 && expr.charAt(0) < 58 ) && !expr.equals("loop") )
            return true;
        
        return false;
    }

    public boolean IsOperator(String expr){
        char ch = expr.charAt(0); 

        return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '=');
    }
    
    public boolean IsFunction(String expr){
        return (expr.equals("sin") || expr.equals("cos") || expr.equals("sqrt") 
                || expr.equals("log") || expr.equals("abs") || expr.equals("cos") 
                || expr.equals("tan") || expr.equals("exp"));
    }
    
}