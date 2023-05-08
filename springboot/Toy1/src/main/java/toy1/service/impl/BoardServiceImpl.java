package toy1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toy1.domain.Board;
import toy1.domain.User;
import toy1.exception.BoardNotFoundException;
import toy1.persistence.BoardRepository;
import toy1.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
    
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<Board> getBoardsByUser(User user) {
        return boardRepository.findByUserOrderByCreatedAtDesc(user);
    }

    @Override
    public Board getBoardById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException(id));
    }

    @Override
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public Board updateBoard(Board board) {
        if (!boardRepository.existsById(board.getId())) {
            throw new BoardNotFoundException(board.getId());
        }
        return boardRepository.save(board);
    }

    @Override
    public void deleteBoard(Board board) {
        if (!boardRepository.existsById(board.getId())) {
            throw new BoardNotFoundException(board.getId());
        }
        boardRepository.delete(board);
    }
}