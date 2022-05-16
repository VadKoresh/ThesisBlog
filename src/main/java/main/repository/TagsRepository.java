package main.repository;

import main.model.TagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagsRepository extends JpaRepository<TagsEntity, Integer> {
    List<TagsEntity> findAll();
}
