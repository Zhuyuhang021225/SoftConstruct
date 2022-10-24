package lession04;

import lession03.Exercise;
import org.junit.Test;

/**
 * @author Zhuyuhang
 */
public class FileDaoTest {
    @Test
    public void testFileWrite(){
        ExerciseFileDao exerciseFileDao = new ExerciseFileDao();
        Exercise exercise = new Exercise();
        exercise.generateExercise();
        exerciseFileDao.writeExerciseToFile(exercise, "D:\\exercise.txt");
    }

    @Test
    public void testFileRead(){
        ExerciseFileDao exerciseFileDao = new ExerciseFileDao();
        Exercise exercise = exerciseFileDao.readExerciseFromFile("D:\\exercise.txtObject");
        exercise.printExercise();
    }
}
