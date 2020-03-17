package com.javaelementary;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {

    /*1) Написать метод `String reverse(String s) {...}`.
Входящий параметр: s - строка которая состоит из слов через пробел
Метод должен вернуть слова в обратном порядке
Пример:
"man has dog" => "dog has man"*/

    public static void main(String[] args) {
        String s = "man has dog";
        s = reverse(s);
        System.out.println(s);
    }

    private static String reverse(String s) {
        String[] arr = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder(s.length());
        for (int i = arr.length - 1; i > 0; i--) {
            stringBuilder.append(arr[i]).append(" ");
        }
        return stringBuilder.append(arr[0]).toString();
    }
}