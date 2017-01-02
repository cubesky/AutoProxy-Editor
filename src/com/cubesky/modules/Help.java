package com.cubesky.modules;

import com.cubesky.i.Module;

import static java.lang.System.out;

/**
 * Created by max_3 on 2017/1/2.
 */
public class Help implements Module {
    @Override
    public void run(String[] args) throws Exception {
        if(args==null){
            out.println("This tools can help you to edit AutoProxy file.");
            out.println("Use 'add' to add a domain.");
            out.println("Use 'remove' to remove a domain.");
            out.println("Use 'show' to show the list.");
            out.println("Use 'load' to load autoproxy file from disk.");
            out.println("Use 'save' to save autoproxy file to disk.");
            out.println("Use 'help' to show this help message.");
            out.println("You can use 'help [command]' to show help message for that command.");
            return;
        }
        if(args.length==1){
            args[0]=args[0].toLowerCase();
            switch (args[0]){
                case "add":
                    out.println("Add domain or url to the list.");
                    out.println("Usage: 'add [operate] <domain/url>'");
                    out.println(" operate: domain[d]/subdomain[s]/regex[r]");
                    out.println("Eg.");
                    out.println(" 'add ||bing.com' will directly add '||bing.com' to the list");
                    out.println(" 'add domain bing.com' or 'add d bing.com' will add '||bing.com' to the list");
                    out.println(" 'add subdomain https://bing.com' or 'add s https://bing.com' will add '|https://bing.com' to the list");
                    out.println(" 'add regex /.+edu.cn/' or 'add r /.+edu.cn/' will add '/.+edu.cn/' to the list");
                    break;
                case "remove":
                    out.println("Remove a domain or url from the list.");
                    out.println("Usage: 'remove <domain/url>'");
                    out.println("Eg.");
                    out.println(" 'remove ||bing.com' will remove '||bing.com' to the list");
                    break;
                case "show":
                    out.println("Show Sorted list.");
                    out.println("Usage: 'show [filter]'");
                    out.println(" filter: subdomain/regex/[A-Z]/[0-9]/all/allwithtag/awt");
                    out.println("Eg.");
                    out.println(" 'show subdomain' will show all subdomain from list.");
                    out.println(" 'show regex' will show all regex from list.");
                    out.println(" 'show z' will show domain start with latter 'Z' from list.");
                    out.println(" 'show all' will show all from list.");
                    out.println(" 'show allwithtag' or 'show awt' will show all from list with '! Tag'.");
                    break;
                case "load":
                    out.println("Load AutoProxy file from disk.");
                    out.println("Usage: 'load [file]'");
                    out.println("Eg.");
                    out.println(" 'load' will load default file named 'gfw_whitelist.txt'");
                    out.println(" 'load autoproxy.txt' will load file 'autoproxy.txt'");
                    break;
                case "save":
                    out.println("Save AutoProxy file to disk");
                    out.println("Usage: 'save [file]'");
                    out.println("Eg.");
                    out.println(" 'save' to save autoproxy list with default filename 'gfw_whitelist.txt'");
                    out.println(" 'save autoproxy.txt' to save autoproxy list with filename 'autoproxy.txt'");
                    break;
                default:
                    out.println("Can not found this help command.");
                    break;
            }
            return;
        }
        System.err.println("Not found.");
    }
}
