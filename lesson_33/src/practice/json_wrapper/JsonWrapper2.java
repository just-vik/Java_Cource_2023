package practice.json_wrapper;
//Обычно используют буквы - T (type), E(entry), K(key), V(value)
public class JsonWrapper2 <T> {
    private T value;

    public JsonWrapper2(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{ Value: " + value + " }";
    }
}