package algo;

import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App1 {

    public static void main(String[] args){
    };

    public static int parser(String input){
        int output = 0;
        int currentValue=0;
        if (input.length() == 0 || input == null) {return -1;}
        if (!Pattern.matches("^M*(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$", input)) {return -1;}
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        char[] arr = input.toCharArray();

        //commented lines are correctness checks made during algorithm execution, utilization of regex pattern above
        //made them redundant

        for(int i = 0; i<arr.length; i++){
            //if (map.getOrDefault(arr[i], -1) == -1) return -1;
            if (map.get(arr[i]) > currentValue && currentValue != 0){
                //if (currentValue==3*map.get(arr[i-1])) return -1;
                output+=map.get(arr[i])-currentValue;
                currentValue = 0;
            } else if (currentValue > 3*map.get(arr[i]) ) {
                output+=currentValue;
                currentValue=map.get(arr[i]);
            } else {
                //    if (currentValue==3*map.get(arr[i])) return -1;
                currentValue+=map.get(arr[i]);
            };
        };
        output+=currentValue;
        return output;
    };
};
