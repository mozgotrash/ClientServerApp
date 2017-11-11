import java.lang.String;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ObjectAnalyzer {

    public  HashMap<String, String> analyzeFields(Object obj){

        HashMap<String, String> data = new HashMap<>();
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for(Field field : fields){
            TypeDetector td = new TypeDetector();
            data.put(td.detectType(field), field.getName());

        }
        System.out.println(data);
        return data;
    }
}




