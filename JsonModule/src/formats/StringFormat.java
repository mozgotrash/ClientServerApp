package formats;

public class StringFormat extends TypeFormat{
    @Override
    public String formate(Object value) {
        StringBuilder result = new StringBuilder();
        result.append(" \"" + value + "\"" + ", ");
        return result.toString();
    }

}
