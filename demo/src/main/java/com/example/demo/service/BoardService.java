package com.example.demo.service;

import com.example.demo.domain.board.PaginationInfo;
import com.example.demo.domain.board.dto.*;
import com.example.demo.domain.board.params.PaginationBoardParams;
import com.example.demo.domain.board.params.PostBoardParams;
import com.example.demo.domain.board.params.UpdateBoardParams;
import com.example.demo.domain.board.vo.BoardVo;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// BoardMapper를 주입받아, 데이터베이스로부터 게시물 목록을 가져오는 비즈니스 로직
@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    public List<GetBoardListResponse> getAllBoardList(){
        List<BoardVo> boardList = boardRepository.getAllBoardList();
        return boardList.stream()
                .map(GetBoardListResponse::new) // GetBoardListResponse 생성자 참조
                .collect(Collectors.toList());
    }

//    public List<GetBoardListResponse> getPaginationBoardList(GetPaginationBoardListRequest payload){
//        // 보드리스트 가져오기
//        PaginationBoardParams paginationParams = new PaginationBoardParams(payload);
//        List<BoardVo> boardList = boardRepository.getPaginationBoardList(paginationParams)
//
//        // 총 보드 개수
//        int totalBoardCnt = boardRepository.getTotalCount();
//
//        // 페이지네이션 정보
//        PaginationInfo paginationInfo = new PaginationInfo(payload.getSize(), payload.getCurrentPage(), totalBoardCnt);
//
//        // 리스펀스 만들기
//        GetBoardListResponse response = new GetPaginationBoardListResponse(boardList, paginationInfo)
//
//        return response;
//    }

    public GetBoardItemResponse getBoardItem(int boardId){
        // 조회수 증가
        boardRepository.increaseViewCount(boardId);

        BoardVo vo = boardRepository.getBoardItem(boardId);
        return new GetBoardItemResponse(vo);
    }

    public int insertBoard(PostBoardItemRequest board){
        PostBoardParams newBoardItem = new PostBoardParams(board);
        return boardRepository.insertBoard(newBoardItem);
    }

    public int softDeleteBoard(int boardId){
        return boardRepository.softDeleteBoard(boardId);
    }

    public int updateBoard(PostBoardItemUpdateRequest board) {
        UpdateBoardParams updateBoardItem = new UpdateBoardParams(board);
        return boardRepository.updateBoard(updateBoardItem);
    }
}
