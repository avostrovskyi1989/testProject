package com.test.counter;

public interface CounterService {

    /**
     * Count number of words `wordToCount` in content `content`
     *
     * @param content     Content for counting
     * @param wordToCount Word to count
     * @return Counting result
     */
    long count(String content, String wordToCount);

}
