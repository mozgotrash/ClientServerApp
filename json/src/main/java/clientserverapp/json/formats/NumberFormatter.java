package clientserverapp.json.formats;

public class NumberFormatter implements TypeFormatter {

    @Override
    public String format(Object value, Object obj) {

        StringBuilder sb = new StringBuilder();
        sb.append(value.toString());

        return sb.toString();

    }
}
