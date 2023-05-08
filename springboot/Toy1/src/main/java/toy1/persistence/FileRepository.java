package toy1.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import toy1.domain.File;

public interface FileRepository extends JpaRepository<File, Long> {

}