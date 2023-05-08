package toy1.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import toy1.domain.LikeDislike;

public interface LikeDislikeRepository extends JpaRepository<LikeDislike, Long> {

}