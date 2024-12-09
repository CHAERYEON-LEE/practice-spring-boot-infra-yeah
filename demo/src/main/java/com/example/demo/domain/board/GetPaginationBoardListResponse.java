package com.example.demo.domain.board;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetPaginationBoardListResponse {
    private String size; // 한 페이지에서 보여줄 아이템 개수
    private String currentPage; // 현재 요청 페이지
    private String totalCount; // 아이템 총 개수
    private long board_id; // 게시물 id
    private String title; // 제목
    private String content; // 내용
    private long views; // 조회수
    private String tags; // 태그이름
    private LocalDateTime created_at; // 작성일자
    private LocalDateTime updated_at; // 수정일자
    private String delete_yn; // 삭제여부 Y, N
}
