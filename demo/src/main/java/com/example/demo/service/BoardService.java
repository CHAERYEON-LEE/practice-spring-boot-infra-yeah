package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// BoardMapper를 주입받아, 데이터베이스로부터 게시물 목록을 가져오는 비즈니스 로직
@Service
public class BoardService {
//    private final BoardRepository boardRepository;

//    @Autowired
//    public BoardService(BoardRepository boardRepository) {
//        this.boardRepository = boardRepository;
//    }

    @Autowired
    BoardRepository boardRepository;

    public List<Board> getAllBoardList(){
        return boardRepository.getAllBoardList();
    }
    public Board getBoardItem(int boardId){
        return boardRepository.getBoardItem(boardId);
    }

    public int insertBoard(Board board){
        return boardRepository.insertBoard(board);
    }

    public int softDeleteBoard(int boardId){
        return boardRepository.softDeleteBoard(boardId);
    }
}
