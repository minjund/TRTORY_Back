package com.trpg.trpg_back.domain.board.api;

import com.trpg.trpg_back.domain.board.dto.BoardsRequest;
import com.trpg.trpg_back.domain.board.dto.BoardsResponse;
import com.trpg.trpg_back.domain.board.serviceImpl.BoardsServiceImpl;
import com.trpg.trpg_back.global.comm.responseData.ResponseData;
import com.trpg.trpg_back.global.comm.responseData.ResponseDataCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
public class BoardsApi {

    private final BoardsServiceImpl boardsServiceImpl;

    @GetMapping("/search-board/{boardId}")
    public ResponseEntity<ResponseData<List<BoardsResponse>>> searchBoard(@PathVariable("boardId") Long boardId){

        ResponseData<List<BoardsResponse>> responseDataDTO = new ResponseData<>();

        List<BoardsResponse> boards = boardsServiceImpl.searchBoards(boardId);

        if(boards.isEmpty()){
            responseDataDTO.setCode(ResponseDataCode.NOT_FOUND.name());
            responseDataDTO.setMessage("게시글이 존재하지 않습니다.");
            return new ResponseEntity<>(responseDataDTO, HttpStatus.NOT_FOUND);
        } else {
            responseDataDTO.setCode(ResponseDataCode.SUCCESS.name());
            responseDataDTO.setMessage("게시글 조회 성공");
            responseDataDTO.setItem(boards);
            return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
        }
    }

    @PostMapping("/create-board")
    public void createBoard(@RequestBody BoardsRequest boardsRequest) {

        BoardsResponse saveBoardId = boardsServiceImpl.saveBoards(boardsRequest);

        System.out.println(saveBoardId.getBoard_id());

    }

    @PutMapping("/update-board")
    public void updateBoard(@RequestBody BoardsRequest boardsRequest) {

        BoardsResponse updateBoard = boardsServiceImpl.updateBoard(boardsRequest);

        System.out.println(updateBoard.getBoard_id());

    }


}
