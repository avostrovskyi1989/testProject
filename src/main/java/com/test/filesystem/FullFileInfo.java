package com.test.filesystem;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public interface FullFileInfo {

    FileStat getMeta();

    FileContent getContent();

    static FullFileInfo of(final FileStat meta, final FileContent content) {
        return new Impl(meta, content);
    }

    @RequiredArgsConstructor
    @EqualsAndHashCode
    class Impl implements FullFileInfo {
        @NonNull
        @Getter
        private final FileStat meta;
        @NonNull
        @Getter
        private final FileContent content;
    }
}
