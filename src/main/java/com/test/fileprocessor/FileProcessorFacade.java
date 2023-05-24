package com.test.fileprocessor;

import com.test.filesystem.FileType;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class FileProcessorFacade implements FileProcessorService {

    @NonNull
    private final Map<FileType, FileProcessorService> processors;

    @Override
    public Optional<String> read(final byte[] content, final FileType type) {
        FileProcessorService service = processors.get(type);
        if (service == null) {
            throw new IllegalArgumentException("File type `" + type.name() + "` not supported");
        }
        return service.read(content, type);
    }
}
