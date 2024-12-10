package com.example.demo.service;

import com.example.demo.domain.board.*;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// BoardMapper를 주입받아, 데이터베이스로부터 게시물 목록을 가져오는 비즈니스 로직
@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    public List<GetBoardListResponse> getAllBoardList(){
        return boardRepository.getAllBoardList();
    }

    public GetPaginationBoardListResponse getPaginationBoardList(GetPaginationBoardListRequest payload){
        // 페이지네이션
        int size = payload.getSize();
        int currentPage = payload.getCurrentPage();
        int totalCount = boardRepository.getTotalCount();
        // 전체 페이지개수

        GetPaginationBoardListResponse response = new GetPaginationBoardListResponse();
        response.setPaginationData(size, currentPage, totalCount);
        response.setBoardList(boardRepository.getPaginationBoardList(payload));
        return response;
    }

    public GetBoardItemResponse getBoardItem(int boardId){
        // 조회수 증가
        boardRepository.increaseViewCount(boardId);
        return boardRepository.getBoardItem(boardId);
    }

    public int insertBoard(PostBoardItemRequest board){
        return boardRepository.insertBoard(board);
    }

    public int softDeleteBoard(int boardId){
        return boardRepository.softDeleteBoard(boardId);
    }

    public int updateBoard(PostBoardItemUpdateRequest board) { return boardRepository.updateBoard(board); }
}
