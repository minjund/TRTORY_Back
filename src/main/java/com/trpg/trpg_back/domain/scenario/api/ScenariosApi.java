package com.trpg.trpg_back.domain.scenario.api;

import com.trpg.trpg_back.domain.scenario.dto.ScenariosRequest;
import com.trpg.trpg_back.domain.scenario.dto.ScenariosResponse;
import com.trpg.trpg_back.domain.scenario.serviceImpl.ScenariosType;
import com.trpg.trpg_back.domain.scenario.serviceImpl.ScenariosServiceImpl;
import com.trpg.trpg_back.global.comm.responseData.ResponseData;
import com.trpg.trpg_back.global.comm.responseData.ResponseDataCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/scenarios")
public class ScenariosApi {

    private final ScenariosServiceImpl scenariosServiceImpl;
    
    @GetMapping("/scenario-type")
    public ResponseEntity<ResponseData<ScenariosType[]>> BoardsTypeList(){
        //유저 entity 세팅
        ScenariosType[] scenariosTypes = scenariosServiceImpl.ScenarioTypeList();
        ResponseData<ScenariosType[]> responseDataDTO = new ResponseData<>();

        responseDataDTO.setCode(ResponseDataCode.SUCCESS.getCode());
        responseDataDTO.setMessage("게시글 조회 성공");
        responseDataDTO.setItem(scenariosTypes);

        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @GetMapping({"/scenarios-list/{scenariosId}", "/scenarios-list"})
    public ResponseEntity<ResponseData<List<ScenariosResponse>>> searchBoard(@PathVariable(value = "scenariosId", required = false) Long boardId){
        ResponseData<List<ScenariosResponse>> responseDataDTO = new ResponseData<>();

        List<ScenariosResponse> boards = scenariosServiceImpl.searchScenario(boardId);

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
    public ResponseEntity<ResponseData<Long>> createBoard(@RequestBody ScenariosRequest scenariosRequest) {

        ResponseData<Long> responseDataDTO = new ResponseData<>();
        Long saveBoardId = scenariosServiceImpl.saveScenario(scenariosRequest);

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

    @PutMapping("/update-scenario")
    public ResponseEntity<ResponseData<List<ScenariosResponse>>> updateBoard(@RequestBody ScenariosRequest scenariosRequest) {

        Long updateBoardId = scenariosServiceImpl.updateScenario(scenariosRequest);

        if (updateBoardId == null) {
            ResponseData<List<ScenariosResponse>> responseDataDTO = new ResponseData<>();
            responseDataDTO.setCode(ResponseDataCode.SERVER_ERROR.getCode());
            responseDataDTO.setMessage("게시글 수정 실패");
            return new ResponseEntity<>(responseDataDTO, HttpStatus.BAD_REQUEST);
        } else {
            ResponseData<List<ScenariosResponse>> responseDataDTO = new ResponseData<>();
            responseDataDTO.setCode(ResponseDataCode.SUCCESS.getCode());
            responseDataDTO.setMessage("게시글 수정 성공");
            return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
        }
    }
}
