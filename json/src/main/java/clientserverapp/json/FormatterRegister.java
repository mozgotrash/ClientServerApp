package clientserverapp.json;

import clientserverapp.json.formats.*;
import clientserverapp.library.IAddable;

import java.util.HashMap;
import java.util.Map;

interface IResolver<TKey, TValue> {
    TKey resolve(TValue type);
}



interface IRegister<TKey, TReturn> extends IResolver, IAddable {

}

public class FormatterRegister implements IResolver<TypeFormatter, Type> {
    private final Map<String, TypeFormatter> formatters = new HashMap<>();

    private static FormatterRegister register;

    private  FormatterRegister(){

    }

    private void fillFormatters() {
        formatters.put("STRING", new StringFormatter());
        formatters.put("NUMBER", new NumberFormatter());
        formatters.put("ARRAY", new ArrayFormatter());
        formatters.put("OBJECT", new ObjectFormatter());
    }

    public static FormatterRegister getInstance(){
        if(register == null) {
            register = new FormatterRegister();
            register.fillFormatters();
        }

        return register;
    }

    private TypeFormatter getFormat(String name){
        return formatters.get(name.toUpperCase());
    }

    @Override
    public TypeFormatter resolve(Type type) {
        return getFormat(type.toString().toUpperCase());
    }

}
