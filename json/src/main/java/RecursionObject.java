import java.lang.reflect.Field;
import java.util.Arrays;

public class RecursionObject {

    StringBuilder sb = new StringBuilder();


    public void analyze(Object obj) {
        boolean firstField = true;
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        sb.append("{ ");

        for (Field field : fields) {
            if(!firstField) {
                sb.append(", ");
            } else {
                firstField = false;
            }

            sb.append("\"").append(field.getName()).append("\" : ");

            if (field.getType().equals(String.class)) {
                try {
                    sb.append("\"");
                    sb.append(field.get(obj).toString());
                    sb.append("\"");
                    continue;
                } catch (IllegalAccessException ex) {
                    System.out.println("строка");
                }
            }

            if (field.getType().equals(Integer.class)) {
                try {
                    sb.append(field.get(obj).toString());

                    continue;
                } catch (IllegalAccessException ex) {
                    System.out.println("Int");
                }
            }



            if (field.getType() instanceof Object) {
                try {
                    analyze(field.get(obj));


                } catch (IllegalAccessException ex) {
                    //ex.printStackTrace();
                    System.out.println("ошибка obj");
                }
            }

        }

        sb.append(" }");
        //return sb.toString();
    }


    public static void main(String[] str){
//        Outer out = new Outer("Hello", 10, new Inner("Inner here", 11), 15);
//        RecursionObject recursionObject = new RecursionObject();
//        recursionObject.analyze(out);
//        System.out.println(recursionObject.sb.toString());
        Inner[] ar = {new Inner("hi", 1), new Inner("hello", 2)};
        Outer outer = new Outer();
        outer.array = ar;

        Field[] declaredFields = outer.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            try {
                Object array = field.get(outer);
                if(array.getClass().getName().startsWith("[")) {
                    System.out.println("It's an array");
                    Object[] castArray = (Object[]) array;
                    for (Object o : castArray) {
                        System.out.print("element: ");
                        System.out.println(o);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

class Outer{
    public Inner[] array;

    public Outer(){

    }
}

class Inner{
    public String Innerstr;
    public Integer Innerintik;
    public Inner(String str, Integer intik){
        Innerstr = str;
        Innerintik = intik;
    }
}


