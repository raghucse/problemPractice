package Algorithms;

/**
 * Created by raghu on 2/16/2017.
 */
class TextInput {
    StringBuilder value = new StringBuilder();
    void add(char c){
        value.append(c);
    }
    String getValue(){
        return value.toString();
    }
}

class NumericInput extends TextInput {
    void add(char c){
        if(c >= 48 && c <=57)
        value.append(c);
    }
}

public class UserInput {
    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}