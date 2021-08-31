package info.hitech.repository;

import info.hitech.model.boardVO.FreeBoardVO;
import info.hitech.model.boardVO.InsertBoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FreeBoardRepository {
    private static final String MAPPER_NAME_SPACE="mapper.freeBoardMapper.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List getBoardAll(){
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE+ "selectBoardAll");
    }

    public void registBoard(InsertBoardVO insertBoardVO){
        sqlSessionTemplate.insert(MAPPER_NAME_SPACE+ "insertBoard", insertBoardVO);
    }

    public FreeBoardVO getBoardByIdx(int idx){
        Map<String,Object> params = new HashMap();
        params.put("idx", idx);

        return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE+ "getBoard", params);
    }
}
