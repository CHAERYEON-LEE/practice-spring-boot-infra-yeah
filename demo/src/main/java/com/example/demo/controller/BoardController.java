package com.example.demo.controller;

import com.example.demo.common.CommonResponse;
import com.example.demo.domain.board.*;
import com.example.demo.service.BoardService;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping(value = "/list", produces = "application/json;utf-8")
    public CommonResponse<List<GetBoardListResponse>> getAllBoardList() {
        return boardService.getAllBoardList();
    }

    @GetMapping(value = "/pagination-list")
    public CommonResponse<GetPaginationBoardListResponse> getPaginationBoardList(@RequestParam int pageSize, @RequestParam int pageNum, @RequestParam(required = false) String keyword) {
        return boardService.selectPagingBoardList(pageSize, pageNum, keyword);
    }

    @GetMapping(value = "/infinite-pagination-list")
    public CommonResponse<GetInfinitePaginationBoardListResponse> getInfinitePaginationBoardList(@RequestParam int pageSize, @RequestParam(required = false) Long lastBoardId, @RequestParam(required = false) String keyword) {
        return boardService.selectInfinitePagingBoardList(pageSize, lastBoardId, keyword);
    }

    @GetMapping(value = "/detail/{boardId}", produces = "application/json;utf-8")
    public CommonResponse<GetBoardItemResponse> getBoardItem(@PathVariable("boardId") int boardId) {
        return boardService.selectBoardItem(boardId);
    }

    @PostMapping(value = "/create", produces = "application/json;utf-8")
    public CommonResponse<Integer> insertBoard(@RequestBody PostBoardItemRequest board) {
        return boardService.insertBoard(board);
    }

    @DeleteMapping(value = "/delete/{boardId}", produces = "application/json;utf-8")
    public CommonResponse<Integer> softDeleteBoard(@PathVariable("boardId") int boardId) {
        System.out.println(boardId);
        return boardService.deleteBoard(boardId);

    }

    @PostMapping(value = "/update", produces = "application/json;utf-8")
    public CommonResponse<Integer> updateBoard(@RequestBody @Valid PostBoardItemUpdateRequest board) {
        return boardService.updateBoard(board);
    }
}
