package com.cubesky.core;

import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by max_3 on 2017/1/2.
 */
public class View {
    public static String getTagView(){
        String linesplit=(System.getProperty("os.name").toLowerCase().contains("windows") ?"\r\n":"\n");
        StringBuilder builder=new StringBuilder();
        Supplier<Stream<String>> stringStream = () -> Stor.gfw.stream();
        builder.append("! Regex")
                .append(linesplit);
        stringStream.get()
                .filter(s -> (!s.startsWith("|")&&(!s.startsWith("@@"))))
                .forEach(s -> builder.append(s).append(linesplit));
        builder.append(linesplit)
                .append("! Subdomain")
                .append(linesplit);
        stringStream.get()
                .filter(s -> s.startsWith("|")&&(!s.startsWith("||")))
                .forEach(s -> builder.append(s).append(linesplit));
        for(int i=0;i<=9;i++){
            builder.append(linesplit)
                    .append("! ")
                    .append(String.valueOf(i))
                    .append(linesplit);
            final int fi=i;
            stringStream.get()
                    .filter(s -> (s.startsWith("||"))&&Character.toString(s.charAt(2)).equalsIgnoreCase(String.valueOf(fi)))
                    .forEach(s -> builder.append(s).append(linesplit));
        }
        for(int i=(int)'A';i<(int)'A'+26;i++){
            builder.append(linesplit)
                    .append("! ")
                    .append(Character.toString((char)i))
                    .append(linesplit);
            final int fi=i;
            stringStream.get()
                    .filter(s -> (s.startsWith("||"))&&(Character.toString(s.charAt(2)).equalsIgnoreCase(String.valueOf(Character.toString((char)fi)))))
                    .forEach(s -> builder.append(s).append(linesplit));
        }
        return builder.toString();
    }
}
