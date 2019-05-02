package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.contents.Directory;

public final class TouchCommand implements Command {
    public static final String CMD = "touch";
    private final String fileName;
    private final Directory directory;

    public TouchCommand(String fileDir, Directory directory) {
        this.fileName = fileDir;
        this.directory = directory;
    }

    public String getFileName() {
        return fileName;
    }

    public Directory getDirectory() {
        return directory;
    }

    @Override
    public void run() {

    }
}
