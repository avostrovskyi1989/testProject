package com.test.filesystem;

public interface FileStat {
    /**
     * File type
     */
    FileType getType();

    /**
     * File name
     */
    String getName();

    /**
     * File size
     */
    long getSize();

    /**
     * Time in seconds
     */
    long getCreatedAt();
}
