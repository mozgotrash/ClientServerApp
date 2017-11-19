<<<<<<< HEAD
package PACKAGE_NAME;

public class JsonEditor {
=======
public class JsonEditor {
    private JsonCreator jc;

    public JsonEditor() {
        jc = new JsonCreator();

    }

    public void addField(String fieldName) {
        jc.add('"');
        jc.add(fieldName);
        jc.add('"');
        jc.add(' ');
        jc.add(':');
    }

    public void addValue(String fieldValue) {
        jc.add(fieldValue);
    }

    public void endingAdditions() {


        jc.add(' ');
        jc.add('}');
    }

    public String getJson() {
        return jc.getSB().toString();
    }
>>>>>>> parent of c13c834... massage
}
