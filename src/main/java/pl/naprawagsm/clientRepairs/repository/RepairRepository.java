package pl.naprawagsm.clientRepairs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRepository extends CrudRepository<Repair, Long> {
	List<Repair> findAllByUser_id(Long userId);
	boolean existsById(Long id);
}
