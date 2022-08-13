package dataStructure;

import java.util.Objects;

public class Stack extends Vector{
    private final String[] stack = new String[3];
    private int count;
    private boolean isEmpty = true;

    @Override
    public boolean isEmpty(){
        return isEmpty;
    }
    public void push(String item){
        stack[count] = item;
        isEmpty = false;
        count++;
    }
    @Override
    public int size(){
        return count;
    }
    @Override
    public String get(int id){
        return stack[id];
    }
    @Override
    public void set(int id, String item){
        stack[id] = item;
    }
    public String pop(){
        count--;
        return stack[stack.length - 1];
    }
    public String peek(){
        return stack[stack.length - 1];
    }
    public int search(String element){
        for (int itemNumber = 0; itemNumber < stack.length; itemNumber--){
            if (Objects.equals(stack[itemNumber], element)){
                return stack.length - itemNumber;
            }
        }
        return -1;
    }
}
