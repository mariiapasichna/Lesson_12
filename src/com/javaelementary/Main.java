package com.javaelementary;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    /*1) Написать метод `String reverse(String s) {...}`.
Входящий параметр: s - строка которая состоит из слов через пробел
Метод должен вернуть слова в обратном порядке
Пример:
"man has dog" => "dog has man"*/

    public static void main(String[] args) {
        String s = "man has dog";
        Deque<String> deque = new LinkedList<>();
        deque.addAll(Arrays.asList(s.split(" ")));
        int size = deque.size();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(deque.getLast());
            deque.pollLast();
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.length());
    }
}