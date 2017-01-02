package com.cubesky.modules;

import com.cubesky.core.Stor;
import com.cubesky.core.View;
import com.cubesky.i.Module;

import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.cubesky.modules.Sort.doSort;

/**
 * Created by max_3 on 2017/1/2.
 */
public class Show implements Module {
    @Override
    public void run(String[] args) throws Exception {
        if(args==null){
            args=new String[]{"all"};
        }
        System.out.println("Sorting...");
        doSort();
        System.out.println("\n");
        if (args[0].equalsIgnoreCase("all")) {
            Stor.gfw.forEach(System.out::println);
        } else if (args[0].equalsIgnoreCase("allwithtag") || args[0].equalsIgnoreCase("awt") || args[0].equalsIgnoreCase("-awt")) {
            System.out.println(View.getTagView());
        } else if (args[0].equalsIgnoreCase("regex") || args[0].equalsIgnoreCase("-r")) {
            StringBuilder builder=new StringBuilder();
            Stream<String> stringStream=Stor.gfw.stream();
            builder.append("! Regex\n");
            stringStream.filter(s -> (!s.startsWith("|")&&(!s.startsWith("@@"))))
                    .forEach(s -> builder.append(s).append("\n"));
            System.out.println(builder.toString());
        } else if (args[0].equalsIgnoreCase("subdomain") || args[0].equalsIgnoreCase("-s")) {
            StringBuilder builder=new StringBuilder();
            Stream<String> stringStream=Stor.gfw.stream();
            builder.append("! Subdomain\n");
            stringStream.filter(s -> s.startsWith("|")&&(!s.startsWith("||")))
                    .forEach(s -> builder.append(s).append("\n"));
            System.out.println(builder.toString());
        } else if (args[0].equalsIgnoreCase("not") || args[0].equalsIgnoreCase("-n")) {
            StringBuilder builder=new StringBuilder();
            Stream<String> stringStream=Stor.gfw.stream();
            builder.append("! Not\n");
            stringStream.filter(s -> s.startsWith("@@"))
                    .forEach(s -> builder.append(s).append("\n"));
            System.out.println(builder.toString());
        } else {
            final String[] argsf=args;
            StringBuilder builder=new StringBuilder();
            Stream<String> stringStream=Stor.gfw.stream();
            builder.append("! ")
                    .append(Character.toString(args[0].charAt(0)).toUpperCase())
                    .append("\n");
            stringStream.filter(s -> Character.toString(s.charAt(2)).equalsIgnoreCase(argsf[0]))
                    .forEach(s -> builder.append(s).append("\n"));
            System.out.println(builder.toString());
        }

        System.out.println("Show Fininshed.");
    }
}
