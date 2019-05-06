package com.salesforce.tests.fs.contents;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Directory {

    private final String name;
    private final Directory parent;
    private final Set<Directory> subdirectories;
    private final Set<File> files;

    private Directory(DirectoryBuilder builder) {
        this.name = builder.name;
        this.parent = builder.parent;
        this.subdirectories = builder.subdirectories;
        this.files = builder.files; 
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

    public Set<Directory> getSubdirectories() {
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

    public static class DirectoryBuilder {
        private String name; // requerido
        private Directory parent;
        private Set<Directory> subdirectories;
        private Set<File> files;

        public DirectoryBuilder(String name, Directory parent){
            this.name = name;
            this.parent = parent;
            this.subdirectories = new HashSet<>();
            this.files = new HashSet<>();
        }
    
        public DirectoryBuilder withSubDiretories(Set<Directory> directories){
            this.subdirectories = (directories != null) ? directories : new HashSet<>();
            return this;
        }

        public DirectoryBuilder withFiles(Set<File> files){
            this.files = (files!=null)? files : new HashSet<>();
            return this;
        }

        public DirectoryBuilder withParent(Directory parent){
            this.parent = parent;
            return this;
        }
    
        public Directory build() {
            return new Directory(this);
        }
    }
}
