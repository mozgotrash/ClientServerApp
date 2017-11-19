package clientserverapp.library;

import clientserverapp.json.Type;

public interface IAddable<TKey, TValue> {
    void add(TValue type, TKey value);
}
