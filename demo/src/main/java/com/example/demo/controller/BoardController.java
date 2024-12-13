package com.example.demo.controller;

import com.example.demo.common.CommonResponse;
import com.example.demo.common.ResponseStatus;
import com.example.demo.domain.board.*;
import com.example.demo.service.BoardService;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시물 컨트롤러
 */
@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping(value = "/list", produces = "application/json;utf-8")
    public CommonResponse<List<GetBoardListResponse>>  getAllBoardList(){
        CommonResponse<List<GetBoardListResponse>> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.getAllBoardList());
        return response;
    }

//    @GetMapping(value ="/pagination-list")
//    public CommonResponse<GetPaginationBoardListResponse> getPaginationBoardList(@RequestParam int size, @RequestParam int currentPage){
//
//        GetPaginationBoardListRequest payload = new GetPaginationBoardListRequest();
//        payload.setPayload(size, currentPage);
//        CommonResponse<GetPaginationBoardListResponse> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.getPaginationBoardList(payload));
//        return response;
//    }

    @GetMapping(value ="/detail/{boardId}", produces = "application/json;utf-8")
    public CommonResponse<GetBoardItemResponse> getBoardItem(@PathVariable("boardId") int boardId){
        CommonResponse<GetBoardItemResponse> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.selectBoardItem(boardId));
        return response;
    }

    @PostMapping(value ="/create", produces = "application/json;utf-8")
    public CommonResponse<Integer> insertBoard(@RequestBody PostBoardItemRequest board){
        CommonResponse<Integer> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.insertBoard(board));
        return response;
    }

    @DeleteMapping(value ="/delete", produces = "application/json;utf-8")
    public CommonResponse<Integer> softDeleteBoard(@PathVariable("boardId") int boardId){
        CommonResponse<Integer> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.deleteBoard(boardId));
        return response;
    }

    @PostMapping(value ="/update", produces = "application/json;utf-8")
    public CommonResponse<Integer> updateBoard(@RequestBody @Valid PostBoardItemUpdateRequest board){
        CommonResponse<Integer> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.updateBoard(board));
        return response;
    }
}
