package toy1.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import toy1.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}