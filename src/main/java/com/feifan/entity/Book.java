package com.feifan.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Getter//getter方法
@Setter//setter方法
@AllArgsConstructor//全参构造器
@NoArgsConstructor//无参构造器
@ToString//toString方法
@EqualsAndHashCode//equals 和 hashcode方法
public class Book implements Serializable {

    private Integer id;
    private String name;
    private List<String> authors;
    private Double price;
    private String detail;
    private String publisher;

    /**
     * List -> String
     * [a,b,c] -> a;b;c
     * @return
     */
    public static String authorsToString(List<String> authors){
        StringBuilder sb = new StringBuilder();
        for (String author:authors) {
            sb.append(author).append(";");
        }
        sb.deleteCharAt(sb.lastIndexOf(";"));
        return sb.toString();
    }

    /**
     * String -> List
     * a;b;c -> [a,b,c]
     * @return
     */
    public static List<String> authorsToList(String authorsStr){
        String[] aus = authorsStr.split(";");
        List<String> strings = Arrays.asList(aus);
        return strings;
    }

}
