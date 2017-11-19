package clientserverapp.json;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.LinkedList;


public class TypeDetectorTest {
    @Test
    void detectType() {
        Type[] allTypesOfTestClass = {
                Type.STRING, Type.NUMBER, Type.NUMBER, Type.NUMBER, Type.NUMBER, Type.NUMBER,
                Type.NUMBER, Type.NUMBER, Type.NUMBER, Type.NUMBER, Type.ARRAY };


        LinkedList<Type> realTypesOfTestClass = new LinkedList<>();
        TypeDetector detector = new TypeDetector();
        Field[] fields = TestClass.class.getDeclaredFields();

        for(Field field : fields){
            realTypesOfTestClass.add(detector.detectType(field));
        }
//        System.out.println(realTypesOfTestClass);
//        System.out.println(Arrays.asList(allTypesOfTestClass));

        Assert.assertArrayEquals(allTypesOfTestClass, realTypesOfTestClass.toArray());
    }

    public static class TestClass {
        String line;

        int i;
        double d;
        float f;
        long l;

        Byte B;
        Integer I;
        Double D;
        Float F;
        Long L;

        int[] arrInt;


        public TestClass(String line, byte b, int i, double d, float f, long l, Byte b1,
                         Integer i1, Double d1, Float f1, Long l1, int[] arrInt) {
            this.line = line;

            this.i = i;
            this.d = d;
            this.f = f;
            this.l = l;
            B = b1;
            I = i1;
            D = d1;
            F = f1;
            L = l1;
            this.arrInt = arrInt;
        }
    }
}









