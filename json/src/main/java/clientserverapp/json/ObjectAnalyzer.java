package clientserverapp.json;

import java.lang.String;

import java.lang.reflect.Field;
import java.util.HashMap;

public class ObjectAnalyzer {

    public  HashMap<String, Type> analyzeFields(Object obj){

        HashMap<String, Type> data = new HashMap<>();
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        TypeDetector td = new TypeDetector();

        for(Field field : fields){
            data.put(field.getName(), td.detectType(field));
        }
        System.out.println(data);
        return data;
    }
}





