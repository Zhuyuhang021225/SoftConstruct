package lession04;

import lession03.Exercise;

import java.io.*;

/**
 * @author Zhuyuhang
 */
public class ExerciseFileDao {

    //写习题文件方法
    public void writeExerciseToFile(Exercise exercise, String fileName) {

        BufferedWriter bufferedWriter = null;
        ObjectOutputStream objectOutputStream = null;

        File file = new File(fileName);
        File fileObject = new File(fileName + "Object");

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(exercise.toString());
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileObject));
            objectOutputStream.writeObject(exercise);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 读习题方法
    public Exercise readExerciseFromFile(String fileName){

        ObjectInputStream objectInputStream = null;

        File file = new File(fileName);
        Exercise exercise = null;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            exercise = (Exercise) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return exercise;
    }

}
