package org.example.practiceproject3.dto;

import lombok.Getter;

@Getter
public class MemoResponseDto {
    private final Long id;
    private final String title;
    private final String content;

    public MemoResponseDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
