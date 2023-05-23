package com.test.service;

import com.test.filesystem.FileType;

public interface FileCounterBusinessService {

    /**
     * Calculate number of words `word` in the latest file in directory with name `directory`
     *
     * @param directory Directory name
     * @param word      Word to count
     * @param fileType  File type to search
     * @return Count of word in latest file
     */
    long calculate(String directory, String word, FileType fileType);
}
