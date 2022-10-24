package lession03;

import java.io.Serializable;
import java.util.Random;

/**
 * @author Zhuyuhang
 */
public abstract class Equation implements Serializable {
    private int rangeMax= 100;
    private int rangeMin = 0;
    //private final int COUNT = 50;

    private int left, right, result;
    private char op;

    public int getRangeMin() {
        return rangeMin;
    }
    public void setRangeMin(int min) {
        this.rangeMin = min;
    }

    public int getRangeMax() {
        return rangeMax;
    }
    public void setRangeMax(int max) {
        this.rangeMax = max;
    }
    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }


    public Equation() {
        // TODO Auto-generated constructor stub
    }

    private int generateRandom() {
        Random r = new Random();
        return r.nextInt(rangeMax - rangeMin + 1) + rangeMin;
    }
    private boolean isBetween(int value) {
        return value >= rangeMin && value <= rangeMax;
    }

    protected abstract int calculate();

    public boolean isEqual(Equation e) {
        boolean flag = false;
        if(this.getOp() != e.getOp()) {
            flag = false;
        }
        else {
            if (this.getOp() == '+')
            {
                flag = (this.getLeft() == e.getLeft() && this.getRight() == e.getRight())
                        || (this.getLeft() == e.getRight() && this.getRight() == e.getLeft());
            }
            else
            {
                flag = this.getLeft() == e.getLeft() && this.getRight() == e.getRight();
            }
        }

        return flag;
    }

    public String allToString() {
        String tempLeft = format(this.getLeft());
        String tempRight = format(this.getRight());
        String tempResult = format(this.getResult());
        char tempOp = this.getOp();

        String s = tempLeft + tempOp + tempRight + "=" + tempResult;
        return s;
    }

    public String equationToString() {
        String tempLeft = format(this.getLeft());
        String tempRight = format(this.getRight());
        char tempOp = this.getOp();

        String s = tempLeft + tempOp + tempRight + "=";
        return s;
    }

    public String answerToString() {

        String tempResult = format(this.getResult());

        return tempResult;
    }

    //把字符串格式化，满足排版要求
    public String format(int data)
    {
        if (data < 10) {
            return "" + data + " ";
        }
        else
        {
            return ""+data;
        }
    }

    public void generateEquation(char op) {
        do {
            left = generateRandom();
            right = generateRandom();
            result = calculate();
        }while(!isBetween(result));
        this.setOp(op);
    }
}
