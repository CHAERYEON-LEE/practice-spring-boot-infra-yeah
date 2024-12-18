package com.example.demo.repository;
import com.example.demo.domain.board.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRepository {
    List<GetBoardListResponse> selectAllBoardList();

    List<GetBoardListResponse> selectPagingBoardList(int pageSize, int pageNum, String keyword);

    List<GetBoardListResponse> selectInfinitePagingBoardList(int pageSize, Long lastBoardId, String keyword);

    int selectTotalCount(String keyword);

    int selectTotalCount();

    GetBoardItemResponse selectBoardItem(int boardId);

    void updateIncreaseViewCount(int boardId);

    int insertBoard(PostBoardItemRequest board);

    int deleteBoard(int boardId);

    int updateBoard(PostBoardItemUpdateRequest board);
}
