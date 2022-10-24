package lession03;

import java.util.Scanner;

/**
 * @author Zhuyuhang
 */
public class Student {
    private Exercise exercise;	//ch4
    //private int columns = 5;
    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    private Scanner sc;
    /**
     *
     */
    public Student() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Student s = new Student();
        s.exercise = new Exercise();
        s.exercise.generateExercise();
        s.exercise.printExercise();
        s.printExercise();
    }

    /**
     * comments
     * @param
     * @return
     */
    private void printExercise() {
        int i = 0;
        //设置习题中第一个算式之前的下标
        exercise.setIndex(0);
        //依次输出所有算式
        while (exercise.hasNext())
        {
            //格式化输出算式，加个tab制表符
            String s= exercise.formatIndex(i) + exercise.next().equationToString() + '\t';
            System.out.print(s );

            //一行输出5个算式
            if((i+1) % 5 == 0) {
                System.out.println();
            }

            i++;

        }


    }

}
