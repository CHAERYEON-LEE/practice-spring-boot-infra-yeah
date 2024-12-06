package com.example.demo.controller;

import com.example.demo.common.CommonResponse;
import com.example.demo.common.ResponseStatus;
import com.example.demo.domain.board.Board;
import com.example.demo.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@AllArgsConstructor
@RestController
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping(value = "/list")
    public CommonResponse<List<Board>>  getAllBoardList(){
        CommonResponse<List<Board>> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.getAllBoardList());
        return response;
    }

    @GetMapping("/detail")
    public CommonResponse<Board> getBoardItem(@RequestParam int boardId){
        CommonResponse<Board> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.getBoardItem(boardId));
        return response;
    }

    @PostMapping("/create")
    public CommonResponse<Integer> insertBoard(@RequestBody Board payload){
        CommonResponse<Integer> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.insertBoard(payload));
        return response;
    }

    @DeleteMapping("/delete")
    public CommonResponse<Integer> softDeleteBoard(@RequestParam int boardId){
        CommonResponse<Integer> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.softDeleteBoard(boardId));
        return response;
    }

    @PostMapping("/update")
    public CommonResponse<Integer> updateBoard(@RequestBody Board payload){
        CommonResponse<Integer> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.updateBoard(payload));
        return response;
    }
}
