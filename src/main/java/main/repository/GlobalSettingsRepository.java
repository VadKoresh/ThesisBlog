package main.repository;

import main.model.GlobalSettingsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalSettingsRepository extends CrudRepository<GlobalSettingsEntity, Integer> {

//    List<GlobalSettingsEntity> findAllList() ;
}
