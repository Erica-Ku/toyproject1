package toy1.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import toy1.domain.Board;
import toy1.domain.User;

public interface BoardRepository extends JpaRepository<Board, Long> {

	List<Board> findByUserOrderByCreatedAtDesc(User user);
}