package com.test;

import com.test.fileprocessor.FileProcessorFacade;
import com.test.fileprocessor.FileProcessorService;
import com.test.fileprocessor.PdfFileProcessor;
import com.test.fileprocessor.TxtFileProcessor;
import com.test.fileprocessor.WordFileProcessor;
import com.test.filesystem.FileType;
import com.test.filesystem.LocalFileSystem;
import com.test.repository.RemoteFilesystemRepository;
import com.test.repository.RemoteFilesystemRepositoryImpl;
import com.test.service.FileCounterBusinessService;
import com.test.service.FileCounterBusinessServiceImpl;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        final String directoryForSearch = "test";
        final String wordToSearch = "test";

        FileCounterBusinessService businessService = dependencyInjection();
        // Business service call
        businessService.calculate(directoryForSearch, wordToSearch, FileType.PDF);
    }

    private static FileCounterBusinessService dependencyInjection() {
        RemoteFilesystemRepository repository = new RemoteFilesystemRepositoryImpl(Map.of(
                "supportedDirectory1", new LocalFileSystem("supportedDirectory1"),
                "supportedDirectory2", new LocalFileSystem("supportedDirectory2")
        ));
        FileProcessorService processorService = new FileProcessorFacade(Map.of(
                FileType.TXT, new TxtFileProcessor(),
                FileType.PDF, new PdfFileProcessor(),
                FileType.WORD, new WordFileProcessor()
        ));
        return new FileCounterBusinessServiceImpl(repository, processorService);
    }
}
