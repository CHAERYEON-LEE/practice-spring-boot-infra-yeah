package com.example.demo.repository;

import com.example.demo.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRepository {
    List<Board> getAllBoardList();

    Board getBoardItem(int boardId);

    int insertBoard(Board board);

    int softDeleteBoard(int boardId);
}
