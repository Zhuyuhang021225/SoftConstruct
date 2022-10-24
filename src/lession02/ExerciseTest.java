package lession02;

import lession01.Equation;
import org.junit.Test;

/**
 * @author Zhuyuhang
 */
public class ExerciseTest {
    @Test
    public void testGenerateAddEquation(){
        Exercise exerciseTest = new Exercise();
        exerciseTest.generateExercise();
        Equation[] exercise = exerciseTest.getExercise();
        for (int i = 0; i < exercise.length; i++) {
            System.out.println(exercise[i]);
        }
    }

    @Test
    public void testPrintExercise(){
        Exercise exercise = new Exercise();
        exercise.generateExercise();
        System.out.println(exercise.formatIndex());
    }
}
