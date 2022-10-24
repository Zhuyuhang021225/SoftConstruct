package lession03;

import java.io.Serializable;

/**
 * @author Zhuyuhang
 */
public class AddEquation extends Equation implements Serializable {
    public AddEquation() {
        // TODO Auto-generated constructor stub
        generateEquation('+');
    }

    public AddEquation(String s) {
        int index = s.indexOf("+");
        int length = s.length();
        this.setLeft(Integer.parseInt(s.substring(0,index)));
        this.setRight(Integer.parseInt(s.substring(index+1,length)));
        this.setOp(s.charAt(index));
        //this.setOp('+');
        this.setResult(calculate());
    }

    @Override
    protected int calculate() {
        // TODO Auto-generated method stub
        return this.getLeft() + this.getRight();
    }
}
