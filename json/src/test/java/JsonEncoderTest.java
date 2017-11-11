//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class JsonEncoderTest {
//    @Test
//    void encoderJson() {
//        TestCountry2 test = new TestCountry2("Russia", 100);
//        JsonEncoder je = new JsonEncoder();
//        String result = je.encoderJson(test);
//        Assert.assertEquals("{ \"pop\" : 100 , \"line\" : \"Russia\" }", result);
//    }
//}
//
//class TestCountry2{
//
//    String line;
//    Integer pop;
//
//    public TestCountry2(String line, Integer k){
//        this.line = line;
//        pop = k;
//    }
//}
