package lession01;

import org.junit.Test;

import java.util.Random;

/**
 * @author Zhuyuhang
 */
public class Equation {

    private int left, right, result;
    private char op;

    private int rangeMin= 0;
    private int rangeMax = 100;


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


    public int getRangeMin() {
        return rangeMin;
    }

    public void setRangeMin(int rangeMin) {
        this.rangeMin = rangeMin;
    }

    public int getRangeMax() {
        return rangeMax;
    }

    public void setRangeMax(int rangeMax) {
        this.rangeMax = rangeMax;
    }

    // 产生随机整数
    private int generateRandom(){
        Random random = new Random();

        return random.nextInt(rangeMax)%(rangeMax - rangeMin + 1) + rangeMin;
    }

    // 判断值是否在值域内
    private boolean isBetween(int value){
        if (value >= rangeMin && value <= rangeMax){
            return true;
        }else {
            return false;
        }
    }

    // 产生加法结果
    private int calculateAddEquation(int left, int right){
        return left + right;
    }

    // 产生减法结果
    private int calculateSubEquation(int left, int right){
        return left - right;
    }

    // 产生加法算式
    public void generateAddEquation(){
        int left,right,result;
        while(true){
            left = generateRandom();
            right = generateRandom();
            result = calculateAddEquation(left, right);

            if (isBetween(result)){
                this.setLeft(left);
                this.setOp('+');
                this.setRight(right);
                this.setResult(result);
                break;
            }
        }
    }

    // 产生减法算式
    public void generateSubEquation(){
        int left,right,result;
        while(true){
            left = generateRandom();
            right = generateRandom();
            result = calculateSubEquation(left, right);

            if (isBetween(result)){
                this.setLeft(left);
                this.setOp('-');
                this.setRight(right);
                this.setResult(result);
                break;
            }
        }
    }

    // 产生混合算式
    public void generateEquation(){
        int left,right,result;
        char op;
        while(true){
            left = generateRandom();
            right = generateRandom();
            int ops = new Random().nextInt(2);
            if (ops == 1){
                op = '+';
                result = calculateAddEquation(left, right);
            }else {
                op = '-';
                result = calculateSubEquation(left, right);
            }


            if (isBetween(result)){
                this.setLeft(left);
                this.setOp(op);
                this.setRight(right);
                this.setResult(result);
                break;
            }
        }
    }

    // 算式转换成字符串
    public String toString(){
        this.setResult((op=='+' ? calculateAddEquation(left, right) : calculateSubEquation(left, right)));
        return "" + format(left) + op + format(right) + "=" + format(result);
    }

    // 格式化小于10的数
    public String format(int data){
        if (data < 10){
            return "" + data + " ";
        }else {
            return "" + data;
        }
    }

    // 判断生成算式是否相等
    public boolean isEqual(Equation equation){
        boolean flag = false;
        if (this.op != equation.op){
            flag = false;
        }else if(this.op == '+'){
            flag = (this.left == equation.left && this.right == equation.right) || (this.right == equation.left && this.left == equation.right);
        }else {
            flag = (this.left == equation.left && this.right == equation.right);
        }
        return flag;
    }

}
