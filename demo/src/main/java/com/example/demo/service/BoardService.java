package com.example.demo.service;

import com.example.demo.domain.board.*;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// BoardMapper를 주입받아, 데이터베이스로부터 게시물 목록을 가져오는 비즈니스 로직
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<GetBoardListResponse> getAllBoardList(){
        return boardRepository.selectAllBoardList();
    }

//    public GetPaginationBoardListResponse getPaginationBoardList(GetPaginationBoardListRequest payload){
//        // 페이지네이션
//        int size = payload.getSize();
//        int currentPage = payload.getCurrentPage();
//        int totalCount = boardRepository.selectTotalCount();
//        // 전체 페이지개수
//
//        GetPaginationBoardListResponse response = new GetPaginationBoardListResponse();
//        response.setPaginationData(size, currentPage, totalCount);
//        response.setBoardList(boardRepository.getPaginationBoardList(payload));
//        return response;
//    }

    public GetBoardItemResponse selectBoardItem(int boardId){
        // 조회수 증가
        boardRepository.updateIncreaseViewCount(boardId);
        return boardRepository.selectBoardItem(boardId);
    }

    public int insertBoard(PostBoardItemRequest board){
        return boardRepository.insertBoard(board);
    }

    public int deleteBoard(int boardId){
        return boardRepository.deleteBoard(boardId);
    }

    public int updateBoard(PostBoardItemUpdateRequest board) { return boardRepository.updateBoard(board); }
}
