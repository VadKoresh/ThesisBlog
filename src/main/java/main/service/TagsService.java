package main.service;

import main.DTO.TagsDto;
import main.api.response.tagsResponse.TagWishWeight;
import main.api.response.tagsResponse.TagsResponse;
import main.model.TagsEntity;
import main.repository.TagsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TagsService {

    @Autowired
    private TagsRepository tagsRepository;
    @Autowired
    private ModelMapper modelMapper;

    public TagsResponse getTags(String query) {
        List<TagsEntity> allTagsEntity = tagsRepository.findAll();
        ArrayList<TagsDto> tagsDtoArrayList = new ArrayList<>();
//        allTagsEntity.forEach(tagsEntity -> tagsDtoArrayList.add(modelMapper.map(tagsEntity, TagsDto.class)));
        for(TagsEntity tagsEntity : allTagsEntity){
            TagsDto map = modelMapper.map(tagsEntity, TagsDto.class);
            tagsDtoArrayList.add(map);
        }
        TagsResponse tagsResponse = new TagsResponse(new ArrayList<>());
        double indexMaxTags = getIndexMaxTags(tagsDtoArrayList);

        //Если парамет query пустой то готовим ответ на все теги
        if (query == null) {
            return getResponseAllTag(tagsDtoArrayList, tagsResponse, indexMaxTags);
        }

        //Находим нужный тэг
        TagsDto tagDto = tagsDtoArrayList.stream()
                .filter(tagsDto -> tagsDto.getName().contains(query))
                .findFirst()
                .orElse(null);

//      Если такой тэг не найдет - то готовим ответ на все теги;
//      иначе готовим ответ из одного тега
        if (tagDto == null) {
            return getResponseAllTag(tagsDtoArrayList, tagsResponse, indexMaxTags);
        } else {
            tagsResponse.getTags()
                    .add(new TagWishWeight(tagDto.getName()
                            , getDWeightTag(tagDto, tagsDtoArrayList.size()) * indexMaxTags));
        }
        return tagsResponse;
    }

    /**
     * Готов ответ на все тэги
     */
    private TagsResponse getResponseAllTag(ArrayList<TagsDto> tagsDtoArrayList,
                                           TagsResponse tagsResponse,
                                           double indexMaxTags) {
        for (TagsDto tagsDto : tagsDtoArrayList) {
            tagsResponse.getTags()
                    .add(new TagWishWeight(tagsDto.getName()
                            , getDWeightTag(tagsDto, tagsDtoArrayList.size()) * indexMaxTags));
        }
        return tagsResponse;
    }

    /**
     * Получаем ненормированный вес тэга
     */
    private double getDWeightTag(TagsDto tagsDto, int countAllTags) {
        return (double) tagsDto.getPostsEntityList().size() / countAllTags;
    }

    /**
     * ПОулчаем коэффициент используя популярный тэг
     */
    private double getIndexMaxTags(ArrayList<TagsDto> tagsDtos) {
        Comparator<TagsDto> comparatorTagDto = (o1, o2) ->
                Integer.valueOf(o1.getPostsEntityList().size())
                        .compareTo(Integer.valueOf(o2.getPostsEntityList().size()));
        TagsDto maxTag = tagsDtos.stream().max(comparatorTagDto)
                .orElse(null);
        return 1 / getDWeightTag(maxTag, tagsDtos.size());
    }

}
