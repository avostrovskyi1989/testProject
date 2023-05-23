package com.test.fileprocessor;

import com.test.filesystem.FileType;
import lombok.NonNull;

public class PdfFileProcessor implements FileProcessorService {

    @Override
    public long count(final byte[] content, final FileType fileType, @NonNull final String word) {
        if (word.isBlank()) {
            return 0L;
        }
        if (content.length == 0) {
            return 0L;
        }
        // TODO: Perform some counting
        return 0;
    }
}
