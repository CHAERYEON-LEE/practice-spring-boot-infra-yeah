package com.example.demo.controller;

import com.example.demo.common.CommonResponse;
import com.example.demo.common.ResponseStatus;
import com.example.demo.domain.board.dto.*;
import com.example.demo.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@AllArgsConstructor
@RestController
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping(value = "/list")
    public CommonResponse<List<GetBoardListResponse>> getAllBoardList() {
        List<GetBoardListResponse> response = boardService.getAllBoardList();
        return new CommonResponse<>(ResponseStatus.SUCCESS, response);
    }

//    @GetMapping(value ="/pagination-list")
//    public CommonResponse<GetPaginationBoardListResponse> getPaginationBoardList(@RequestParam GetPaginationBoardListRequest payload){
//
//        GetPaginationBoardListResponse response = boardService.getPaginationBoardList(payload);
//        return new CommonResponse<>(ResponseStatus.SUCCESS, response);
//    }

    @GetMapping(value ="/detail")
    public CommonResponse<GetBoardItemResponse> getBoardItem(@RequestParam int boardId){
        GetBoardItemResponse response = boardService.getBoardItem(boardId);
        return new CommonResponse<>(ResponseStatus.SUCCESS, response);
    }

    @PostMapping(value ="/create")
    public CommonResponse<Integer> insertBoard(@RequestBody PostBoardItemRequest board){
        int response = boardService.insertBoard(board);
        return new CommonResponse<>(ResponseStatus.SUCCESS, response);
    }

    @DeleteMapping(value ="/delete")
    public CommonResponse<Integer> softDeleteBoard(@RequestParam int boardId){
        int response = boardService.softDeleteBoard(boardId);
        return new CommonResponse<>(ResponseStatus.SUCCESS, response);
    }

    @PostMapping(value ="/update")
    public CommonResponse<Integer> updateBoard(@RequestBody PostBoardItemUpdateRequest board){
        int response = boardService.updateBoard(board);
        return new CommonResponse<>(ResponseStatus.SUCCESS, response);
    }
}
