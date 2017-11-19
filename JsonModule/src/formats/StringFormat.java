package formats;

<<<<<<< HEAD
public class StringFormat {
=======
public class StringFormat extends TypeFormat{
    @Override
    public String formate(Object value) {
        StringBuilder result = new StringBuilder();
        result.append(" \"" + value + "\"" + ", ");
        return result.toString();
    }

>>>>>>> parent of c13c834... massage
}
