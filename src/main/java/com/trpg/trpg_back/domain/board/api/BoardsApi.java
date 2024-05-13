package com.trpg.trpg_back.domain.board.api;

import com.trpg.trpg_back.domain.board.dto.BoardsRequest;
import com.trpg.trpg_back.domain.board.dto.BoardsResponse;
import com.trpg.trpg_back.domain.board.entity.BoardsType;
import com.trpg.trpg_back.domain.board.serviceImpl.BoardsServiceImpl;
import com.trpg.trpg_back.global.comm.responseData.ResponseData;
import com.trpg.trpg_back.global.comm.responseData.ResponseDataCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
public class BoardsApi {

    private final BoardsServiceImpl boardsServiceImpl;

    @GetMapping("/board-type")
    public ResponseEntity<ResponseData<BoardsType[]>> BoardsTypeList(){
        //유저 entity 세팅
        BoardsType[] boardsTypes = boardsServiceImpl.boardsTypeList();
        ResponseData<BoardsType[]> responseDataDTO = new ResponseData<>();

        responseDataDTO.setCode(ResponseDataCode.SUCCESS.getCode());
        responseDataDTO.setMessage("게시글 조회 성공");
        responseDataDTO.setItem(boardsTypes);

        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @GetMapping({"/board-list/{boardId}", "/board-list"})
    public ResponseEntity<ResponseData<List<BoardsResponse>>> searchBoard(@PathVariable(value = "boardId", required = false) Long boardId){
        ResponseData<List<BoardsResponse>> responseDataDTO = new ResponseData<>();

        List<BoardsResponse> boards = boardsServiceImpl.searchBoards(boardId);

        if(boards.isEmpty()){
            responseDataDTO.setCode(ResponseDataCode.NOT_FOUND.getCode());
            responseDataDTO.setMessage("게시글이 존재하지 않습니다.");
            return new ResponseEntity<>(responseDataDTO, HttpStatus.NOT_FOUND);
        } else {
            responseDataDTO.setCode(ResponseDataCode.SUCCESS.getCode());
            responseDataDTO.setMessage("게시글 조회 성공");
            responseDataDTO.setItem(boards);
            return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
        }
    }

    @PostMapping("/create-board")
    public ResponseEntity<ResponseData<Long>> createBoard(@RequestBody BoardsRequest boardsRequest) {

        ResponseData<Long> responseDataDTO = new ResponseData<>();
        Long saveBoardId = boardsServiceImpl.saveBoards(boardsRequest);

        if (saveBoardId == null) {
            responseDataDTO.setCode(ResponseDataCode.SERVER_ERROR.getCode());
            responseDataDTO.setMessage("게시글 생성 실패");
            return new ResponseEntity<>(responseDataDTO, HttpStatus.BAD_REQUEST);
        }else {
            responseDataDTO.setCode(ResponseDataCode.SUCCESS.getCode());
            responseDataDTO.setMessage("게시글 생성 성공");
            responseDataDTO.setItem(saveBoardId);
        }


        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);

    }

    @PutMapping("/update-board")
    public ResponseEntity<ResponseData<List<BoardsResponse>>> updateBoard(@RequestBody BoardsRequest boardsRequest) {

        Long updateBoardId = boardsServiceImpl.updateBoard(boardsRequest);

        if (updateBoardId == null) {
            ResponseData<List<BoardsResponse>> responseDataDTO = new ResponseData<>();
            responseDataDTO.setCode(ResponseDataCode.SERVER_ERROR.getCode());
            responseDataDTO.setMessage("게시글 수정 실패");
            return new ResponseEntity<>(responseDataDTO, HttpStatus.BAD_REQUEST);
        } else {
            ResponseData<List<BoardsResponse>> responseDataDTO = new ResponseData<>();
            responseDataDTO.setCode(ResponseDataCode.SUCCESS.getCode());
            responseDataDTO.setMessage("게시글 수정 성공");
            return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
        }
    }
}
