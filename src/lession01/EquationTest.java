package lession01;

import org.junit.Test;

/**
 * @author Zhuyuhang
 */
public class EquationTest {
    public void testIsFormatEquation(int left, int right, int result, char op, String expectStr, boolean expect){
        Equation equation = new Equation();
        equation.setLeft(left);
        equation.setOp(op);
        equation.setRight(right);
        equation.setResult(result);

        String getString = equation.toString();
        boolean actual = getString.equals(expectStr);

        if (actual == expect){
            System.out.println("测试成功");
        }else {
            System.out.println("测试失败"+equation);
        }
    }

    @Test
    public void testToString(){
        this.testIsFormatEquation(1,10,11,'+',"1 +10=11",true);
        this.testIsFormatEquation(20,30,50,'+',"20+10=50",true);
        this.testIsFormatEquation(22,3,25,'+',"22+ 3=25",true);
        this.testIsFormatEquation(100,10,90,'-',"100-10=90",true);
        this.testIsFormatEquation(0,10,10,'+',"0 +10=10",true);
    }

    @Test
    public void testGenerateExercise(){
        Equation equation = new Equation();

        for (int i = 0; i < 50; i++) {
            equation.generateEquation();
            System.out.print("("+(i+1)+") " + equation.toString() + ((((i+1)%5 == 0)) ? "\n" : "\t"));
        }
    }
}
