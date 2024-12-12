package com.example.demo.repository;
import com.example.demo.domain.board.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRepository {
    List<GetBoardListResponse> getAllBoardList();

    List<GetPaginationBoardListResponse.Board> getPaginationBoardList(GetPaginationBoardListRequest payload);

    int getTotalCount();

    GetBoardItemResponse getBoardItem(int boardId);

    void increaseViewCount(int boardId);

    int insertBoard(PostBoardItemRequest board);

    int softDeleteBoard(int boardId);

    int updateBoard(PostBoardItemUpdateRequest board);
}
