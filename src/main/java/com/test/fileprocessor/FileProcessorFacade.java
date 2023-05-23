package com.test.fileprocessor;

import com.test.filesystem.FileType;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class FileProcessorFacade implements FileProcessorService {

    @NonNull
    private final Map<FileType, FileProcessorService> processors;

    @Override
    public long count(final byte[] content, final FileType type, final String word) {
        FileProcessorService service = processors.get(type);
        if (service == null) {
            throw new IllegalArgumentException("File type `" + type.name() + "` not supported");
        }
        return service.count(content, type, word);
    }
}
