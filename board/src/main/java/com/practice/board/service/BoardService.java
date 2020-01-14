package com.practice.board.service;

import com.practice.board.domain.entity.BoardEntity;
import com.practice.board.domain.repository.BoardRepository;
import com.practice.board.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {

    private BoardRepository boardRepository;

    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    public List<BoardDto> getBoardList() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();

        List<BoardDto> boardDtoList = new ArrayList<>();

        for(BoardEntity boardEntity : boardEntityList){
            BoardDto boardDto = BoardDto.builder()
                    .id(boardEntity.getId())
                    .title(boardEntity.getTitle())
                    .writer(boardEntity.getWriter())
                    .content(boardEntity.getContent())
                    .createdTime(boardEntity.getCreatedTime())
                    .build();

            boardDtoList.add(boardDto);
        }

        return boardDtoList;
    }
}
