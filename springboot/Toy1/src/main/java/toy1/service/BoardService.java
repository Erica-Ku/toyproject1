package toy1.service;

import java.util.List;

import toy1.domain.Board;
import toy1.domain.User;

public interface BoardService {
    List<Board> getBoardsByUser(User user);
    Board getBoardById(Long id);
    Board createBoard(Board board);
    Board updateBoard(Board board);
    void deleteBoard(Board board);
}