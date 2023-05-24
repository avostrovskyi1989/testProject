package com.test.counter;

import lombok.NonNull;

public class CounterServiceImpl implements CounterService {

    @Override
    public long count(@NonNull final String content, @NonNull final String wordToCount) {
        if (content.isBlank() || wordToCount.isBlank()) {
            return 0L;
        }
        return 12345;
    }
}

