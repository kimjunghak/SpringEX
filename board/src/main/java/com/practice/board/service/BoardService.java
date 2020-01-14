package com.practice.board.service;

import com.practice.board.domain.repository.BoardRepository;
import com.practice.board.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoardService {

    private BoardRepository boardRepository;

    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}
