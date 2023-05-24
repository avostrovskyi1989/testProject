package com.test.fileprocessor;

import com.test.filesystem.FileType;

import java.util.Optional;

public class WordFileProcessor implements FileProcessorService {

    @Override
    public Optional<String> read(final byte[] content, final FileType fileType) {
        if (content.length == 0) {
            return Optional.empty();
        }
        return Optional.of("test word file");
    }
}
