package ru.itis.generics;

import ru.itis.models.B;

/**
 * Created by admin on 05.10.2016.
 */
public class ListArrayOfBImpl<T extends B> implements ListOfB<T> {
    private static final int MAX_SIZE =  5;

    private Object data[];
    private int count;

    public ListArrayOfBImpl() {
        this.data = new Object[MAX_SIZE];
        this.count = 0;
    }
    @Override
    public void add(T element) {
        if (count < MAX_SIZE) {
            this.data[count] = element;
            count++;
        } else throw new IllegalArgumentException();
    }

    @Override
    public T get(int index) {
        if (index < count) {
            return (T)this.data[index];
        }  throw new IllegalArgumentException();
    }
}
