package com.test.repository;

import com.test.filesystem.FileContent;
import com.test.filesystem.FileStat;
import com.test.filesystem.FileType;
import com.test.filesystem.FullFileInfo;
import com.test.filesystem.RemoteFilesystem;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class RemoteFilesystemRepositoryImpl implements RemoteFilesystemRepository {
    @NonNull
    private final Map<String, RemoteFilesystem> supportedDirectories;
    @NonNull
    private final Collection<FileType> supportedFileTypes;

    @Override
    public Optional<FullFileInfo> findLastFileInDirectory(@NonNull final String directoryName) {
        if (directoryName.isBlank()) {
            throw new IllegalArgumentException("Empty directory name");
        }
        RemoteFilesystem filesystem = supportedDirectories.get(directoryName);
        if (filesystem == null) {
            throw new IllegalArgumentException("Directory not supported");
        }
        Optional<FileStat> lastCreated = filesystem.listAll().stream()
                .filter(stat -> supportedFileTypes.contains(stat.getType()))
                .max(Comparator.comparingLong(FileStat::getCreatedAt));
        // Read file content
        if (lastCreated.isEmpty()) {
            return Optional.empty();
        }
        FileContent content = filesystem.read(lastCreated.get().getName());

        return Optional.of(FullFileInfo.of(lastCreated.get(), content));
    }
}
