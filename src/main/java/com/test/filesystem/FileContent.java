package com.test.filesystem;

public interface FileContent {

    FileContent EMPTY = () -> new byte[0];

    byte[] getContent();
}
