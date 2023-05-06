package day06_annotation_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C03_Assertion {


    //Normaly when we use if-else statements to test something JUnit framework can not understand if it is passed or
    //failed
    // For JUnit we should use Assert methods

    // Assert.assertTrue : we expect from statement to be true
    // Assert.assertFalse : we expect from statement to be False
    // Assert.assertEquals : we expect two values to be equal
    // Assert.assertNotEquals : we expect two values to be  not equal


    // test retirement

    int P1age = 66;
    int P2age= 70;
    int P3age =77;
    //retirement age is 70;

    @Test
    public void test01(){
        // retirement age is 70
        // test that third person can retire

        Assert.assertTrue(P3age>70);

    }

    @Test
    public void test02(){
        // retirement age is 70
        // test that first person can not retire
        Assert.assertFalse(P1age>70);

    }

    @Test
    public void test03(){

        Assert.assertEquals(14,14);
        Assert.assertNotEquals(14,95);

    }
}
