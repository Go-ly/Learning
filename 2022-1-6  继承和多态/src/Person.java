public class Person implements Cloneable {
    public String name;
    public int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
