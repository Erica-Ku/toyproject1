package toy1.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import toy1.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailAndPassword(String email, String password);
	boolean existsByEmail(String email);
}