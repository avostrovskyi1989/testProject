package com.test.service;

import com.test.fileprocessor.FileProcessorService;
import com.test.filesystem.FileContent;
import com.test.filesystem.FileType;
import com.test.repository.RemoteFilesystemRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class FileCounterBusinessServiceImpl implements FileCounterBusinessService {
    @NonNull
    private final RemoteFilesystemRepository repository;
    @NonNull
    private final FileProcessorService fileProcessor;

    @Override
    public long calculate(
            @NonNull final String directory,
            @NonNull final String word,
            @NonNull final FileType fileType
    ) {
        Optional<FileContent> foundFileOpt = repository.findLastFileInDirectory(directory, fileType);
        if (foundFileOpt.isEmpty()) {
            return 0L;// Or throw Exception
        }
        FileContent fileContent = foundFileOpt.get();
        return fileProcessor.count(fileContent.getContent(), fileType, word);
    }
}
