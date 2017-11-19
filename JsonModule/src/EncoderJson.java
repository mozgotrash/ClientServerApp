<<<<<<< HEAD
package PACKAGE_NAME;

public class EncoderJson {
}
=======
import formats.ObjectFormat;
import formats.TypeFormat;

import java.lang.reflect.Field;

public class EncoderJson {
    JsonEditor je = new JsonEditor();

    public void encodeJson(Class<? extends Object> clazz, Object obj) {

        Field[] fields = clazz.getDeclaredFields();


        for (Field field : fields) {
            String fieldName = field.getName();
            je.addField(fieldName);

            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                Object value = field.get(obj);

                TypeFormat type = JsonTypeDetector.detectType(field);
                if (type instanceof ObjectFormat) {
                    encodeJson(value.getClass(), value);
                }
                String result = type.formate(value);
                je.addValue(result);

            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }

        je.endingAdditions();
        System.out.println(je.getJson());
    }

    public static void main(String[] str) {

        Country country1 = new Country("USA", 354);
//		System.out.println(country1.getClass());
        new EncoderJson().encodeJson(Country.class, country1);
    }
}


class Country{
    public String name;
    public int population;


    public Country(String name, int pop) {
        this.name = name;
        population = pop;

    }
}


class Inner{
    public int number;
    public String str;

    public Inner(int c, String str) {
        number = c;
        this.str = str;
    }
}
>>>>>>> parent of c13c834... massage
