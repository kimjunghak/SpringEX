package com.practice.board.dto;

import com.practice.board.domain.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public BoardEntity toEntity(){
        BoardEntity build = BoardEntity.builder()
                .id(id)
                .title(title)
                .writer(writer)
                .content(content)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long id, String title, String writer, String content, LocalDateTime createdTime, LocalDateTime updatedTime){
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }
}
