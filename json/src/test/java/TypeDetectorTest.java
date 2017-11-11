import org.junit.Assert;

import java.lang.reflect.Field;



class TypeDetectorTest {



    @org.junit.jupiter.api.Test
    void detectType() {
        TypeDetector td = new TypeDetector();
        TestCountry0 tc = new TestCountry0("Russia", 10);
        Class clazz = tc.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(int i = 0; i < 2; i++){
            if(i == 0) {
                Assert.assertEquals("String", td.detectType(fields[i]));
            }
            if(i == 1){
                Assert.assertEquals("Integer", td.detectType(fields[i]));
            }

        }
    }


}

class TestCountry0{

    String line;
    Integer pop;

    public TestCountry0(String line, Integer k){
        this.line = line;
        pop = k;
    }
}