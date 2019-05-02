package com.salesforce.tests.fs;

import com.salesforce.tests.fs.cache.CommandManager;

/**
 * The entry point for the Test program
 */
public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        CommandManager manager = new CommandManager();
        manager.execute("pwd"); //  /home
        manager.execute("ls"); // ...
//        manager.execute("mkdir yerbas"); // nada
//        manager.execute("cd yerbas"); // nada
//        manager.execute("ls"); // yerbas
//        manager.execute("pwd"); // home/yerbas
//        manager.execute("touch playadito.txt");
//        manager.execute("ls");
//        manager.execute("pwd");
//        manager.execute("quit");
    }
}
