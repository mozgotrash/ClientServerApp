package mytest;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;

class Inner{
    String Innerstr;
    int Innerintik;
    double[] arrLong;

    public Inner(String str, int intik, double[] arr){

        Innerstr = str;
        Innerintik = intik;
        arrLong = arr;
    }
}
 jpa //   orm db <-> class

class SimpleTest {
    public static void main(String[] args) {
        Inner inner = new Inner("hello", 1, new double[]{1.0, 2.3});

        try {
            Field arrLong = inner.getClass().getDeclaredField("arrLong");
            Object realArray = arrLong.get(inner);
            System.out.println(java.lang.reflect.Array.get(realArray, 0));
            System.out.println(Array.getLength(realArray));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}