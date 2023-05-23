package com.test.fileprocessor;

import com.test.filesystem.FileType;

public interface FileProcessorService {

    /**
     * Count number of word for content
     *
     * @param content Content for counting
     * @param word    Word to count
     * @return Word count
     */
    long count(byte[] content, FileType fileType, String word);
}
