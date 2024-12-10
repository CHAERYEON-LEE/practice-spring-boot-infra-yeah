package com.example.demo.controller;

import com.example.demo.common.CommonResponse;
import com.example.demo.common.ResponseStatus;
import com.example.demo.domain.board.*;
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
    public CommonResponse<List<GetBoardListResponse>>  getAllBoardList(){
        CommonResponse<List<GetBoardListResponse>> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.getAllBoardList());
        return response;
    }

    @GetMapping(value ="/pagination-list")
    public CommonResponse<GetPaginationBoardListResponse> getPaginationBoardList(@RequestParam(name = "size", required = true) int size,
                                                                                 @RequestParam(name = "currentPage", required = true) int currentPage){

        GetPaginationBoardListRequest payload = new GetPaginationBoardListRequest();
        payload.setPayload(size, currentPage);
        CommonResponse<GetPaginationBoardListResponse> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.getPaginationBoardList(payload));
        return response;
    }

    @GetMapping(value ="/detail")
    public CommonResponse<GetBoardItemResponse> getBoardItem(@RequestParam int boardId){
        CommonResponse<GetBoardItemResponse> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.getBoardItem(boardId));
        return response;
    }

    @PostMapping(value ="/create")
    public CommonResponse<Integer> insertBoard(@RequestBody PostBoardItemRequest board){
        CommonResponse<Integer> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.insertBoard(board));
        return response;
    }

    @DeleteMapping(value ="/delete")
    public CommonResponse<Integer> softDeleteBoard(@RequestParam int boardId){
        CommonResponse<Integer> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.softDeleteBoard(boardId));
        return response;
    }

    @PostMapping(value ="/update")
    public CommonResponse<Integer> updateBoard(@RequestBody PostBoardItemUpdateRequest board){
        CommonResponse<Integer> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.updateBoard(board));
        return response;
    }
}
