import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectAnalyzerTest {
    @Test
    void analyzeField() {
        ObjectAnalyzer analyzer = new ObjectAnalyzer();
        TestCountry1 test = new TestCountry1("Russia", 100);
        Assert.assertEquals("{[Integer, pop]=100, [String, line]=Russia}", analyzer.analyzeFields(test).toString());
    }
}

class TestCountry1{
    String line;
    Integer pop;

    public TestCountry1(String line, Integer k){
        this.line = line;
        pop = k;
    }
}
