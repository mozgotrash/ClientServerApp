import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

enum Type {
    NUMBER,
    STRING,
    ARRAY,
    OBJECT
}

1. Подправить схемку, внести туда Type, добавить FormatterRegister
2. Сделать TypeDetector, чтобы он работал, с тестами. 100% покрытие кода тестами.
3. Сделать FormatterRegiter c aформаттерами, так же со 100% покрытием тестами.

public class TypeDetector {

    private final  HashMap<String, Type> All_TYPES = new HashMap<>();

    public TypeDetector(){
        All_TYPES.put("String", "String");
        All_TYPES.put("int", Type.NUMBER);
        All_TYPES.put("Integer", Type.NUMBER);
        All_TYPES.put("Double", Type.NUMBER);
        All_TYPES.put("[I", "int[]");

    }

    public String detectType(Field field) {
        Set<String> keySet = All_TYPES.keySet();
        for(String str : keySet){
            if (field.getType().getName().equals(str)){
                return All_TYPES.get(str);
            }
        }
        return field.getType().toString();

        deletectType(new String()) => "String"
                deletecType(int[]) => "[]"
                detectType(String[]) => "[]"
                detectType(new Innter()) => "Object"
    }
}
