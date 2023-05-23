package com.test.repository;

import com.test.filesystem.FileContent;
import com.test.filesystem.FileStat;
import com.test.filesystem.FileType;
import com.test.filesystem.RemoteFilesystem;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class RemoteFilesystemRepositoryImpl implements RemoteFilesystemRepository {
    @NonNull
    private final Map<String, RemoteFilesystem> supportedDirectories;

    @Override
    public Optional<FileContent> findLastFileInDirectory(
            @NonNull final String directoryName,
            @NonNull final FileType type
    ) {
        if (directoryName.isBlank()) {
            throw new IllegalArgumentException("Empty directory name");
        }
        RemoteFilesystem filesystem = supportedDirectories.get(directoryName);
        if (filesystem == null) {
            throw new IllegalArgumentException("Directory not supported");
        }
        Optional<FileStat> lastCreated = filesystem.listAll().stream().filter(stat -> stat.getType() == type)
                .max(Comparator.comparingLong(FileStat::getCreatedAt));
        // Read file content
        return lastCreated.map(fileStat -> filesystem.read(fileStat.getName()));
    }
}
