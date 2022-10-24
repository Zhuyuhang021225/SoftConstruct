package lession03;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Zhuyuhang
 */
public class Exercise implements Serializable {
    //定义一套习题有多少算式组成
    private int equationCount = 50;
    //算式的在习题中的下标，当没有算式时，下标为-1
    private int index = 0;

    private ArrayList<Equation> exercise = null;

    public int getCount() {
        return equationCount;
    }
    public void setCount(int count) {
        this.equationCount = count;
    }

    public ArrayList<Equation> getExercise() {
        return exercise;
    }

    public void setExercise(ArrayList<Equation> exercise) {
        this.exercise = exercise;
    }

    //设置和得到算式下标
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    //返回index对应的算式
    //public Equation getEquationByIndex(int i){return exercise.get(i);}

    //构造函数
    public Exercise() {
        // TODO Auto-generated constructor stub
        index = 0;
        exercise = new ArrayList<Equation>();
    }
    //带算式数量的构造函数
    public Exercise(int count) {
        this.setCount(count);
        index = 0;
        exercise = new ArrayList<Equation>();
    }

    public void generateExercise() {
        int i = 0;
        Random r = new Random();
        while(i < equationCount) {
            //上转型对象，定义变量，不赋值，采用子类对象赋值
            Equation e;
            if(r.nextInt(2) == 1) {
                e = new AddEquation();
            }
            else {
                e = new SubEquation();
            }
            if(!exercise.contains(e)) {
                exercise.add(e);
                i++;
            }
        }
    }

    public void generateAddExercise() {
        int i = 0;
        while(i < equationCount) {
            Equation e = new AddEquation();
            if(!exercise.contains(e)) {
                exercise.add(e);
                i++;
            }
        }
    }

    public void generateSubExercise() {
        int i = 0;
        while(i < equationCount) {
            Equation e = new SubEquation();
            if(!exercise.contains(e)) {
                exercise.add(e);
                i++;
            }
        }
    }

    //格式化习题编号
    public String formatIndex(int index)
    {
        String s;
        //编号小于9，则前面加0；编号大于9，则正常输出
        if (index < 9)
        {
            s = "(" + 0 + (index+1) + ")";
        }
        else
        {
            s = "("  + (index+1) + ")";
        }
        return s;
    }

    //构造输出习题的方法：注意输出习题的格式，特别是算式的编号，并且一行5列的输出格式
    public void printExercise() {

        for(int i = 0; i < equationCount; i++) {

            //格式化输出算式，加个tab制表符
            String s= formatIndex(i) + exercise.get(i).equationToString() + '\t';
            System.out.print(s );

            //一行输出5个算式
            if((i+1) % 5 == 0) {
                System.out.println();
            }
        }
    }

    @Override
    public String toString() {
        String formatStr = "";
        for(int i = 0; i < equationCount; i++) {

            //格式化输出算式，加个tab制表符
            String s= formatIndex(i) + exercise.get(i).equationToString() + '\t';
            formatStr = formatStr + s;

            //一行输出5个算式
            if((i+1) % 5 == 0) {
                formatStr = formatStr + "\n";
            }
        }
        return formatStr;
    }

    public boolean add(Equation e) {
        if(size() < equationCount) {
            exercise.add(e);
            index++;
            return true;
        }
        else {
            return false;
        }
    }
    //判断习题中是否还有下一个算式
    public boolean hasNext() {
        return index < exercise.size();
    }

    //找到习题中下一个算式，并把下标赋值为下一个算式的下标
    public Equation next() {
        if(index < exercise.size()) {
            return exercise.get(index++);
        }
        else {
            return null;
        }
    }
    //得到下标对应的算式
    public Equation get(int i) {
        if(i < size()) {
            return exercise.get(i);
        }
        else {
            return null;
        }
    }

    public int size() {
        return exercise.size();
    }
}
