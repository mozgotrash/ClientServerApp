package clientserverapp.json;

import clientserverapp.json.formats.TypeFormatter;

import java.lang.reflect.Field;
import java.util.*;

public class JsonCreator {

    private FormatterRegister formatRegister = FormatterRegister.getInstance();

    public String createJson(Map<String, Type> data, Object obj) {


        StringBuilder sb = new StringBuilder();

        boolean firstField = true;
        sb.append("{ ");

        Set<String> names = data.keySet();

        for(String name : names){

            if(!firstField) {
                sb.append(", ");
            } else {
                firstField = false;
            }

            sb.append(addLineName(name));

            Type fieldType = data.get(name);

            Field field = toGetField(obj, name);
            sb.append(createLine(obj, field, fieldType));
        }
        sb.append(" }");

        return sb.toString();
    }

    private Field toGetField(Object obj, String name){
        Class clazz = obj.getClass();
        Field field = null;
        try {
             field = clazz.getDeclaredField(name);
        }catch (NoSuchFieldException ex){
            ex.printStackTrace();
        }
        return  field;
    }

    private String createLine(Object obj, Field field, Type type){
        TypeFormatter formatter = null;
        Object value = null;
        try {
             value = field.get(obj);
             formatter = formatRegister.resolve(type);
        }catch (IllegalAccessException ex){
            ex.printStackTrace();
        }

        return formatter.format(value, obj);
    }

    private String addLineName(String name){
        StringBuilder lineName = new StringBuilder();
        lineName.append("\"")
                .append(name)
                .append("\" : ");

        return lineName.toString();
    }

}





