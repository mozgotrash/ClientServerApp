import formats.*;

import java.lang.reflect.Field;

public class JsonTypeDetector {
    private static final String TYPE_STRING = "java.lang.String";
    private static final String TYPE_INT = "int";
    private static final String TYPE_OBJECT = "java.lang.Object";
    private static final String TYPE_Array = "[I";

    public static TypeFormat detectType(Field field) {
        switch(field.getType().getName()) {
            case TYPE_STRING :
                return new StringFormat();

            case TYPE_INT :
                return new IntFormat();
            case TYPE_OBJECT :
                return new ObjectFormat();
            case TYPE_Array :
                return new ArrayFormat();

            default:
                // идеи получше
                return null;
        }
    }
}
