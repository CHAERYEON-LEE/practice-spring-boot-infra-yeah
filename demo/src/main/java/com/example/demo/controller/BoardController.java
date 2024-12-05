package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@AllArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public List<Board> getAllBoardList(){
        return boardService.getAllBoardList();
    }

    @GetMapping("/detail")
    public Board getBoardItem(@RequestParam int boardId){ return boardService.getBoardItem(boardId);}

    @PostMapping("/create")
    public int insertBoard(@RequestBody Board payload){
//        System.out.println("Received payload: " + payload.toString());
        return boardService.insertBoard(payload);
    }

    @DeleteMapping("/delete")
    public int softDeleteBoard(@RequestParam int boardId){
        return boardService.softDeleteBoard(boardId);
    }
}
