package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.cache.CommandManager;
import com.salesforce.tests.fs.contents.Directory;

import java.util.concurrent.atomic.AtomicBoolean;

public final class ListCommand implements Command {
    public static final String CMD = "ls";
    private Directory currentDir;
    private final AtomicBoolean recursive = new AtomicBoolean(false); // Default

    public ListCommand(Directory currentDir, boolean recursive) {
        this.currentDir = currentDir;
        this.recursive.set(recursive);
    }

    @Override
    public void run(CommandManager manager) {
        if(!recursive.get()){
            System.out.println("...");
            currentDir.getSubdirectories().forEach(System.out::println);
            currentDir.getFiles().forEach(System.out::println);
        
        }
    }
}
