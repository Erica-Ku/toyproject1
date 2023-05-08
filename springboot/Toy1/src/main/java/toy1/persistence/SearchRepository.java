package toy1.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import toy1.domain.Search;

public interface SearchRepository extends JpaRepository<Search, Long> {

}