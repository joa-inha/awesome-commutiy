package info.hitech.api;

import info.hitech.model.FreeBoardVO;
import info.hitech.model.UserVO;
import info.hitech.repository.FreeBoardRepository;
import info.hitech.repository.UserRepository;
import io.swagger.v3.oas.annotations.Parameter;
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
    public void join(@RequestBody FreeBoardVO freeBoardVO) {
        freeBoardRepository.registBoard(freeBoardVO);
    }

    @GetMapping(value = "/board/{idx}")
    public FreeBoardVO getBoard(@PathVariable("idx") int idx){
        FreeBoardVO getFreeBoard = freeBoardRepository.getBoardByIdx(idx);
        return getFreeBoard;
    }
}