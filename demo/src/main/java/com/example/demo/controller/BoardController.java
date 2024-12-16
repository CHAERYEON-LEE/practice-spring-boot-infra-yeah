package com.example.demo.controller;

import com.example.demo.common.CommonResponse;
import com.example.demo.common.ResponseStatus;
import com.example.demo.domain.board.*;
import com.example.demo.service.BoardService;
import com.github.pagehelper.PageInfo;
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
        List<GetBoardListResponse> boardResponse = boardService.getAllBoardList();
        return new CommonResponse<>(ResponseStatus.SUCCESS, boardResponse);
    }

    @GetMapping(value ="/pagination-list")
    public CommonResponse<GetPaginationBoardListResponse> getPaginationBoardList(@RequestParam int pageSize, @RequestParam int pageNum){
        GetPaginationBoardListResponse paginationBoardResponse = boardService.selectPagingBoardList(pageSize, pageNum);
        return new CommonResponse<>(ResponseStatus.SUCCESS, paginationBoardResponse);
    }

    @GetMapping(value ="/detail/{boardId}", produces = "application/json;utf-8")
    public CommonResponse<GetBoardItemResponse> getBoardItem(@PathVariable("boardId") int boardId){
        GetBoardItemResponse itemReponse = boardService.selectBoardItem(boardId);
        return new CommonResponse<>(ResponseStatus.SUCCESS, itemReponse);
    }

    @PostMapping(value ="/create", produces = "application/json;utf-8")
    public CommonResponse<Integer> insertBoard(@RequestBody PostBoardItemRequest board){
        int result = boardService.insertBoard(board);
        return new CommonResponse<>(ResponseStatus.SUCCESS, result);
    }

    @DeleteMapping(value ="/delete", produces = "application/json;utf-8")
    public CommonResponse<Integer> softDeleteBoard(@PathVariable("boardId") int boardId){
        int result = boardService.deleteBoard(boardId);
        return new CommonResponse<>(ResponseStatus.SUCCESS, result);

    }

    @PostMapping(value ="/update", produces = "application/json;utf-8")
    public CommonResponse<Integer> updateBoard(@RequestBody @Valid PostBoardItemUpdateRequest board){
        CommonResponse<Integer> response = new CommonResponse<>(ResponseStatus.SUCCESS, boardService.updateBoard(board));
        return response;
    }
}
