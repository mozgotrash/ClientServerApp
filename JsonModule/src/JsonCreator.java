<<<<<<< HEAD
package PACKAGE_NAME;

public class JsonCreator {
=======
public class JsonCreator {
    private StringBuilder sb;

    public JsonCreator() {
        sb = new StringBuilder();
        sb.append('{');
        sb.append(' ');
    }

    public void add(String str) {
        sb.append(str);
    }

    public void add(int i) {
        sb.append(i);
    }

    public void add(Object obj) {
        sb.append(obj);
    }

    public void add(char chr) {
        sb.append(chr);
    }

    public StringBuilder getSB() {
        return sb;
    }
>>>>>>> parent of c13c834... massage
}
