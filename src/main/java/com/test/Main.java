package com.test;

import com.test.counter.CounterService;
import com.test.counter.CounterServiceImpl;
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
        final String directoryForSearch = "supportedDirectory1";
        final String wordToSearch = "test";

        FileCounterBusinessService businessService = dependencyInjection();
        // Business service call
        long result = businessService.calculate(directoryForSearch, wordToSearch);
        // Result
        System.out.println(result);
    }

    private static FileCounterBusinessService dependencyInjection() {
        RemoteFilesystemRepository repository = new RemoteFilesystemRepositoryImpl(Map.of(
                "supportedDirectory1", new LocalFileSystem("supportedDirectory1"),
                "supportedDirectory2", new LocalFileSystem("supportedDirectory2")
        ), FileType.searchable());
        FileProcessorService processorService = new FileProcessorFacade(Map.of(
                FileType.TXT, new TxtFileProcessor(),
                FileType.PDF, new PdfFileProcessor(),
                FileType.WORD, new WordFileProcessor()
        ));
        CounterService counterService = new CounterServiceImpl();
        // Injection
        return new FileCounterBusinessServiceImpl(repository, processorService, counterService);
    }
}
