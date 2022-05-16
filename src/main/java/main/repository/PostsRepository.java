package main.repository;

import main.DTO.PostsDto;
import main.model.ModerationStatus;
import main.model.PostsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<PostsEntity, Integer> {

    List<PostsEntity> findAllByModerationStatus(@NotNull ModerationStatus moderationStatus);
    List<PostsEntity> findAllByIsActiveAndModerationStatus (@NotNull byte isActive, @NotNull ModerationStatus moderationStatus);

    default List<PostsDto> findAllPostDto(ModelMapper modelMapper,
                                          @NotNull byte isActive,
                                          @NotNull ModerationStatus moderationStatus){

        List<PostsDto> allDto = new ArrayList<>();
        for(PostsEntity postsEntity : findAllByIsActiveAndModerationStatus(isActive, moderationStatus)){
            allDto.add(modelMapper.map(postsEntity, PostsDto.class));
        }
        return allDto;
    }
}
