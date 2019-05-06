package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.cache.CommandManager;
import com.salesforce.tests.fs.contents.Directory;

import java.util.Set;

public class CdCommand implements Command{
    public static final String CMD = "cd";
    private String toDirectory;
    private Directory from;
    public CdCommand(String toDirectory, Directory from) {
        this.from = from;
        this.toDirectory = toDirectory;
    }

    @Override
    public void run(CommandManager manager) {
        if(!toDirectory.equals("...")) {
            Set<Directory> directories = from.getSubdirectories();
            for(Directory dir : directories) {
                if (dir.getName().equals(toDirectory)) {
                    manager.setCurrentDirectory(dir);
                    break;
                }
            }
        }
    }
}
