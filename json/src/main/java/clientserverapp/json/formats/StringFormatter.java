package clientserverapp.json.formats;

public class StringFormatter implements TypeFormatter {

    @Override
    public String format(Object value, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("\"")
                .append(value.toString())
                .append("\"");

        return sb.toString();
    }
}
