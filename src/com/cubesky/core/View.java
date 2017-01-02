package com.cubesky.core;

import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by max_3 on 2017/1/2.
 */
public class View {
    public static String getTagView(){
        StringBuilder builder=new StringBuilder();
        Supplier<Stream<String>> stringStream=() -> ((TreeSet<String>)Stor.stor.get("gfw")).stream();
        builder.append("! Regex").append("\n");
        stringStream.get()
                .filter(s -> (!s.startsWith("|")&&(!s.startsWith("@@"))))
                .forEach(s -> builder.append(s).append("\n"));
        builder.append("\n")
                .append("! Subdomain")
                .append("\n");
        stringStream.get()
                .filter(s -> s.startsWith("|")&&(!s.startsWith("||")))
                .forEach(s -> builder.append(s).append("\n"));
        for(int i=0;i<=9;i++){
            builder.append("\n")
                    .append("! ")
                    .append(String.valueOf(i))
                    .append("\n");
            final int fi=i;
            stringStream.get()
                    .filter(s -> (s.startsWith("||"))&&Character.toString(s.charAt(2)).equalsIgnoreCase(String.valueOf(fi)))
                    .forEach(s -> builder.append(s).append("\n"));
        }
        for(int i=(int)'A';i<(int)'A'+26;i++){
            builder.append("\n")
                    .append("! ")
                    .append(Character.toString((char)i))
                    .append("\n");
            final int fi=i;
            stringStream.get()
                    .filter(s -> (s.startsWith("||"))&&(Character.toString(s.charAt(2)).equalsIgnoreCase(String.valueOf(Character.toString((char)fi)))))
                    .forEach(s -> builder.append(s).append("\n"));
        }
        return builder.toString();
    }
}
