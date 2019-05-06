package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.cache.CommandManager;
import com.salesforce.tests.fs.contents.Directory;
import com.salesforce.tests.fs.contents.Directory.DirectoryBuilder;

public final class MkdirCommand implements Command {
    public static final String CMD = "mkdir";
    private final Directory directory;

    public MkdirCommand(String dirName, Directory parent) {
        this.directory = new DirectoryBuilder(dirName, parent).build();
    }

    @Override
    public void run(CommandManager manager) {
        manager.getCurrentDirectory().getSubdirectories().add(directory);
    }
}
