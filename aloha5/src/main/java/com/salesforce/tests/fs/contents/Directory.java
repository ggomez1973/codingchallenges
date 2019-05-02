package com.salesforce.tests.fs.contents;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class Directory {

    private final String name;
    private final Directory parent;
    private final Set<File> subdirectories;
    private final Set<File> files;

    public Directory(String name, Directory parent, Set<File> subdirectories, Set<File> files) {
        this.name = name;
        this.parent = parent;
        this.subdirectories = (subdirectories != null) ? subdirectories : new HashSet<>();
        this.files = (files!=null)? files : new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Directory getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "[" + name + ']';
    }

    public Set<File> getSubdirectories() {
        return subdirectories;
    }

    public Set<File> getFiles() {
        return files;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Directory directory = (Directory) o;
        return Objects.equals(name, directory.name) &&
                Objects.equals(parent, directory.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parent);
    }
}
