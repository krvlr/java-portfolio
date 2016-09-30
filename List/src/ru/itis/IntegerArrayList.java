package ru.itis;

/**
 * Created by KFU-user on 30.09.2016.
 */
public class IntegerArrayList {

    private static final int MAX_SIZE = 10;

    private int[] data;

    private int count;

    public IntegerArrayList() {
        this.count = 0;
        this.data = new int[MAX_SIZE];
    }

    public IntegerArrayList(int originalData[]) {
        this.data = new int[MAX_SIZE];
        this.count = originalData.length;
        if (originalData.length <= MAX_SIZE){
            for (int i = 0; i < originalData.length; i++){
                this.data[i] = originalData[i];
            }
        } else throw new IllegalArgumentException();
    }

    public void add(int element) {
        if (count < MAX_SIZE ){
            this.data[count] = element;
            this.count++;
        }
        else throw new IllegalArgumentException();
    }

    public void add(int element, int position) {
        if (position < this.count && this.count < MAX_SIZE) {
            shiftRight(position);
            this.data[position] = element;
        }
        else throw new IllegalArgumentException();
    }

    public boolean delete(int element){
        int position = find(element);
        if (position > 0){
            shiftLeft(position);
            return true;
        } else return false;
    }

    public boolean deleteByPosition(int position){
        if (position < this.count){
            shiftLeft(position);
            return true;
        }
        return false;
    }

    public int find(int element){
        for (int i = 0; i < this.count; i++){
            if (this.data[i] == element){
                return i;
            }
        }
        return -1;
    }

    public int get(int position){
        if (position < this.count){
            return this.data[position];
        } else throw new IllegalArgumentException();
    }

    private void shiftLeft(int position){
        for (int i = position; i < this.count; i++){
            this.data[i] = this.data[i+1];
        }
        this.count--;
    }

    private void shiftRight(int position){
        int lastShiftElement = 0;
        int shiftElement = 0;
        for (int i = position; i < this.count; i++){
            shiftElement = this.data[i];
            this.data[i] = lastShiftElement;
            lastShiftElement = shiftElement;
        }
        this.count++;
    }
}
