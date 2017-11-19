package clientserverapp.json.formats;

import clientserverapp.json.JsonCreator;
import clientserverapp.json.ObjectAnalyzer;
import clientserverapp.json.Type;
import clientserverapp.json.formats.TypeFormatter;

import java.util.Map;

public class ObjectFormatter  implements TypeFormatter {
//    @Override
//    public String format(Object value, Object obj) {
//        return null;
//    }
    JsonCreator jcc = new JsonCreator();
    ObjectAnalyzer oa = new ObjectAnalyzer();
    @Override
    public String format(Object value, Object obj) {
        Map<String, Type> data = oa.analyzeFields(value);
        return jcc.createJson(data, value);
    }

}
