package com.example.demo.service;

import com.example.demo.common.CommonResponse;
import com.example.demo.common.ResponseStatus;
import com.example.demo.domain.board.*;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public CommonResponse<List<GetBoardListResponse>> getAllBoardList() {
        List<GetBoardListResponse> boardResponse = boardRepository.selectAllBoardList();
        return new CommonResponse<>(ResponseStatus.SUCCESS, boardResponse);
    }

    public CommonResponse<GetPaginationBoardListResponse> selectPagingBoardList(int pageSize, int pageNum, String keyword) {
        List<GetBoardListResponse> boardList = boardRepository.selectPagingBoardList(pageSize, pageNum * pageSize, keyword);
        GetPaginationBoardListResponse paginationBoardResponse = GetPaginationBoardListResponse.builder()
                .boardList(boardList)
                .pageNum(pageNum)
                .pageSize(pageSize)
                .totalCnt(boardRepository.selectTotalCount(keyword))
                .build();

        return new CommonResponse<>(ResponseStatus.SUCCESS, paginationBoardResponse);
    }

    public CommonResponse<GetInfinitePaginationBoardListResponse> selectInfinitePagingBoardList(int pageSize, Long lastBoardId, String keyword) {
        List<GetBoardListResponse> boardList = boardRepository.selectInfinitePagingBoardList(pageSize, lastBoardId, keyword);
        GetInfinitePaginationBoardListResponse infinitePaginationBoardResponse = GetInfinitePaginationBoardListResponse.builder()
                .boardList(boardList)
                .pageSize(pageSize)
                .hasMore(boardList.size() < pageSize ? 0 : 1)
                .totalCnt(boardRepository.selectTotalCount(keyword))
                .build();

        return new CommonResponse<>(ResponseStatus.SUCCESS, infinitePaginationBoardResponse);
    }

    public CommonResponse<GetBoardItemResponse> selectBoardItem(int boardId) {
        boardRepository.updateIncreaseViewCount(boardId);
        GetBoardItemResponse itemReponse = boardRepository.selectBoardItem(boardId);
        return new CommonResponse<>(ResponseStatus.SUCCESS, itemReponse);
    }

    public CommonResponse<Integer> insertBoard(PostBoardItemRequest board) {
        int result = boardRepository.insertBoard(board);
        return new CommonResponse<>(ResponseStatus.SUCCESS, result);
    }

    public CommonResponse<Integer> deleteBoard(int boardId) {
        int result = boardRepository.deleteBoard(boardId);
        return new CommonResponse<>(ResponseStatus.SUCCESS, result);
    }

    public CommonResponse<Integer> updateBoard(PostBoardItemUpdateRequest board) {
        int result = boardRepository.updateBoard(board);
        return new CommonResponse<>(ResponseStatus.SUCCESS, result);
    }
}
