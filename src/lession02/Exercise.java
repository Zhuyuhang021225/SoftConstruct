package lession02;

import lession01.Equation;

/**
 * @author Zhuyuhang
 */
public class Exercise {

    //定义每套习题有50个算式
    private int equationCount = 50;
    //定义习题的数据结构
    // 定义习题类变量：算式数组
    private Equation[] exercise = new Equation[equationCount];


    public int getEquationCount() {
        return equationCount;
    }

    public void setEquationCount(int equationCount) {
        this.equationCount = equationCount;
    }

    public Equation[] getExercise() {
        return exercise;
    }

    public void setExercise(Equation[] exercise) {
        this.exercise = exercise;
    }

    //判断算式是否在习题里
    public boolean occursIn(Equation equation){
        boolean flag = false;
        for (int i = 0; i < exercise.length; i++) {
            if (exercise[i].isEqual(equation)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    //产生加法习题
    public void generateAddExercise(){

        for (int i = 0; i < equationCount; i++) {
            Equation equation = new Equation();
            equation.generateAddEquation();
            exercise[i] = equation;
        }
    }

    //产生减法习题
    public void generateSubExercise(){

        for (int i = 0; i < equationCount; i++) {
            Equation equation = new Equation();
            equation.generateSubEquation();
            exercise[i] = equation;
        }
    }

    //产生随机习题
    public void generateExercise(){

        for (int i = 0; i < equationCount; i++) {
            Equation equation = new Equation();
            equation.generateEquation();
            exercise[i] = equation;
        }
    }

    //输出习题
    public void printExercise(){
        for (int i = 0; i < exercise.length; i++) {
            System.out.print("("+(i+1)+")"+exercise[i]+(((i + 1) % 5 == 0) ? "\n" : "\t"));
        }
    }

    //格式化习题输出格式
    public String formatIndex(){
        String formatStr = "";

        for (int i = 0; i < exercise.length; i++) {
            String Str = "("+ (i+1) + ") " + exercise[i].toString() + "\t";
            formatStr = formatStr + Str;
        }
        return formatStr;
    }
}
