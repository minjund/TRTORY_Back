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
    public ResponseEntity<?> BoardsTypeList(){
        //유저 entity 세팅
        ScenariosType[] scenariosTypes = scenariosServiceImpl.ScenarioTypeList();

        return new ResponseEntity<>(scenariosTypes, HttpStatus.OK);
    }

    @GetMapping({"/scenarios-list/{scenariosId}", "/scenarios-list"})
    public ResponseEntity<?> searchBoard(@PathVariable(value = "scenariosId", required = false) Long boardId){
        List<ScenariosResponse> boards = scenariosServiceImpl.searchScenario(boardId);

        return new ResponseEntity<>(boards, HttpStatus.OK);
    }

    @PostMapping("/create-board")
    public ResponseEntity<?> createBoard(@RequestBody ScenariosRequest scenariosRequest) {
        Long scenarioId = scenariosServiceImpl.saveScenario(scenariosRequest);

        return new ResponseEntity<>(scenarioId, HttpStatus.OK);
    }

    @PutMapping("/update-scenario")
    public ResponseEntity<?> updateBoard(@RequestBody ScenariosRequest scenariosRequest) {

        Long updateBoardId = scenariosServiceImpl.updateScenario(scenariosRequest);

        return new ResponseEntity<>(updateBoardId, HttpStatus.OK);
    }

    @PutMapping("/like-scenario")
    public ResponseEntity<?> updateLike(@RequestBody ScenariosRequest scenariosRequest) {

        Long updateBoardId = scenariosServiceImpl.updateLikeScenario(scenariosRequest);

        return new ResponseEntity<>(updateBoardId, HttpStatus.OK);
    }
}
