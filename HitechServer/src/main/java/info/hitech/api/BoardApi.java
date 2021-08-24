package info.hitech.api;

import info.hitech.model.UserVO;
import info.hitech.repository.FreeBoardRepository;
import info.hitech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/apis/boards/")
public class BoardApi {
    @Autowired
    UserRepository userRepository;

    @Autowired
    FreeBoardRepository freeBoardRepository;

    @GetMapping(value = "/")
    public List allUsers() {
        return userRepository.getUserInfoAll();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/join")
    public void join(@RequestBody UserVO userVO) {
        userRepository.adduserInfo(userVO);
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody UserVO userVO){
        return "token";
    }
}
