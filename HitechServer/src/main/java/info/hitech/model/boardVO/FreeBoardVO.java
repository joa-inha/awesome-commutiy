package info.hitech.model.boardVO;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class FreeBoardVO extends BoardVO {
    private String userName;
    private int boardId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date wdate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBoardId() {
        return boardId;
    }
    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public Date getWdate() {
        return wdate;
    }

    public void setWdate(Date wdate) {
        this.wdate = wdate;
    }
}
