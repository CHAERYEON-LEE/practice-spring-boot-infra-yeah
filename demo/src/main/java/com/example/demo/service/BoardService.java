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

    public List<GetPaginationBoardListResponse> getPaginationBoardList(GetPaginationBoardListRequest payload){
        return boardRepository.getPaginationBoardList(payload);
    }

    public GetBoardItemResponse getBoardItem(int boardId){
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
