package com.example.demo.repository;
import com.example.demo.domain.board.params.*;
import com.example.demo.domain.board.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRepository {
    List<BoardVo> getAllBoardList();

//    List<BoardVo> getPaginationBoardList(PaginationBoardParams payload);

    int getTotalCount();

    BoardVo getBoardItem(int boardId);

    void increaseViewCount(int boardId);

    int insertBoard(PostBoardParams payload);

    int softDeleteBoard(int boardId);

    int updateBoard(UpdateBoardParams payload);
}
