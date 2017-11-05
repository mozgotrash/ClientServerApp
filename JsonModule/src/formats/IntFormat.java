package formats;

public class IntFormat extends TypeFormat{

    @Override
    public String formate(Object value) {
        StringBuilder result = new StringBuilder();
        result.append(" " + value + "," + " ");
        return result.toString();
    }

}