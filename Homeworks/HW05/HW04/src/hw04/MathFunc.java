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
public abstract class MathFunc extends Operand implements Executable{

    protected MyDouble value;

    public MathFunc(MyDouble val) {
        this.value = val;
    }

    @Override
    public double returnValue(){
        return execute();
    }
    
    /**
     * @return the radian
     */
    public MyDouble getRadian() {
        return value;
    }

}
