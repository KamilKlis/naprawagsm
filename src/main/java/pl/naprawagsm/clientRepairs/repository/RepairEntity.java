package pl.naprawagsm.clientRepairs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairEntity extends CrudRepository<Repair, Long> {

}
