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
        builder.append("! Regex").append(System.getProperty("line.separator"));
        stringStream.get().filter(s -> (!s.startsWith("|")&&(!s.startsWith("@@")))).forEach(s -> builder.append(s).append(System.getProperty("line.separator")));
        builder.append(System.getProperty("line.separator")).append("! Subdomain").append(System.getProperty("line.separator"));
        stringStream.get().filter(s -> s.startsWith("|")&&(!s.startsWith("||"))).forEach(s -> builder.append(s).append(System.getProperty("line.separator")));
        for(int i=0;i<=9;i++){
            builder.append(System.getProperty("line.separator")).append("! ").append(String.valueOf(i)).append(System.getProperty("line.separator"));
            final int fi=i;
            stringStream.get().filter(s -> (s.startsWith("||"))&&Character.toString(s.charAt(2)).equalsIgnoreCase(String.valueOf(fi))).forEach(s -> builder.append(s).append(System.getProperty("line.separator")));
        }
        for(int i=(int)'A';i<(int)'A'+26;i++){
            builder.append(System.getProperty("line.separator")).append("! ").append(Character.toString((char)i)).append(System.getProperty("line.separator"));
            final int fi=i;
            stringStream.get().filter(s -> (s.startsWith("||"))&&(Character.toString(s.charAt(2)).equalsIgnoreCase(String.valueOf(Character.toString((char)fi))))).forEach(s -> builder.append(s).append(System.getProperty("line.separator")));
        }
        return builder.toString();
    }
}
