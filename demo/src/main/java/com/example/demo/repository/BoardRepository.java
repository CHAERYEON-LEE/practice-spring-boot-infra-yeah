package com.example.demo.repository;
import com.example.demo.domain.board.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRepository {
    List<GetBoardListResponse> selectAllBoardList();

//    List<GetPaginationBoardListResponse.Board> getPaginationBoardList(GetPaginationBoardListRequest payload);

    int selectTotalCount();

    GetBoardItemResponse selectBoardItem(int boardId);

    void updateIncreaseViewCount(int boardId);

    int insertBoard(PostBoardItemRequest board);

    int deleteBoard(int boardId);

    int updateBoard(PostBoardItemUpdateRequest board);
}
