package clientserverapp.json;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//1. Подправить схемку, внести туда clientserverapp.json.Type, добавить clientserverapp.json.FormatterRegister
//2. Сделать clientserverapp.json.TypeDetector, чтобы он работал, с тестами. 100% покрытие кода тестами.
//3. Сделать FormatterRegiter c aформаттерами, так же со 100% поек


public class TypeDetector {

    private final Map<String, Type> All_TYPES = new HashMap<>();

    public TypeDetector() {
        All_TYPES.put("class java.lang.String", Type.STRING);

        All_TYPES.put("byte", Type.NUMBER);
        All_TYPES.put("int", Type.NUMBER);
        All_TYPES.put("double", Type.NUMBER);
        All_TYPES.put("float", Type.NUMBER);
        All_TYPES.put("long", Type.NUMBER);

        All_TYPES.put("class java.lang.Byte", Type.NUMBER);
        All_TYPES.put("class java.lang.Integer", Type.NUMBER);
        All_TYPES.put("class java.lang.Double", Type.NUMBER);
        All_TYPES.put("class java.lang.Float", Type.NUMBER);
        All_TYPES.put("class java.lang.Long", Type.NUMBER);

        All_TYPES.put("Array", Type.ARRAY);
        All_TYPES.put("Object", Type.OBJECT);
    }

    public Type detectType(Field field) {

        Set<String> keySet = All_TYPES.keySet();
        for (String str : keySet) {
            if (field.getType().toString().equals(str)) {
                return All_TYPES.get(str);
            }
        }

        //field.getType().isArray()
        if(field.getType().getName().startsWith("[")){
            return All_TYPES.get("Array");

        }else{
            return All_TYPES.get("Object");
        }
    }
}

//        deletectType(new String()) => "String"
//                deletecType(int[]) => "[]"
//                detectType(String[]) => "[]"
//                detectType(new Innter()) => "Object"


