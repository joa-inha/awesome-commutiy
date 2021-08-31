package info.hitech.api;

import info.hitech.model.boardVO.FreeBoardVO;
import info.hitech.model.boardVO.InsertBoardVO;
import info.hitech.repository.FreeBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/apis/boards/")
public class BoardApi {
    @Autowired
    FreeBoardRepository freeBoardRepository;

    @GetMapping(value = "/")
    public List allBoard() {
        return freeBoardRepository.getBoardAll();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/post")
    public InsertBoardVO join(@RequestBody InsertBoardVO insertBoardVO) {
        freeBoardRepository.registBoard(insertBoardVO);
        return insertBoardVO;
    }

    @GetMapping(value = "/board/{idx}")
    public FreeBoardVO getBoard(@PathVariable("idx") int idx){
        FreeBoardVO getFreeBoard = freeBoardRepository.getBoardByIdx(idx);
        return getFreeBoard;
    }
}