package com.test.service;

import com.test.counter.CounterService;
import com.test.fileprocessor.FileProcessorService;
import com.test.filesystem.FileContent;
import com.test.filesystem.FileStat;
import com.test.filesystem.FullFileInfo;
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
    @NonNull
    private final CounterService counterService;

    @Override
    public long calculate(
            @NonNull final String directory,
            @NonNull final String word
    ) {
        Optional<FullFileInfo> foundFileOpt = repository.findLastFileInDirectory(directory);
        if (foundFileOpt.isEmpty()) {
            return 0L;// Or throw Exception
        }
        FileContent fileContent = foundFileOpt.get().getContent();
        FileStat fileMetaInfo = foundFileOpt.get().getMeta();
        // Read file content from byte array
        Optional<String> fileContentString = fileProcessor.read(fileContent.getContent(), fileMetaInfo.getType());

        return fileContentString.map(s -> counterService.count(s, word)).orElse(0L);
    }
}
