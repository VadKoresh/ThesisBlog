package main.service;

import main.DTO.PostsDto;
import main.api.response.postResponse.PostDetailsResponse;
import main.api.response.postResponse.PostResponse;
import main.api.response.postResponse.UserResponse4PostDetails;
import main.model.ModerationStatus;
import main.model.PostsEntity;
import main.repository.PostsRepository;
import org.jsoup.Jsoup;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class PostsService {

    private final String MODE_RECENT = "recent";
    private final String MODE_POPULAR = "popular";
    private final String MODE_BEST = "best";
    private final String MODE_EARLY = "early";

    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private ModelMapper modelMapper;

    public int getCountAllPostWithStatus(ModerationStatus status){
        List<PostsEntity> allByModerationStatus = postsRepository.findAllByModerationStatus(status);
        return allByModerationStatus.size();
    }

    public PostResponse getPostsResponse(int offset, int limit, String mode) {
        List<PostsDto> allByIsActiveAndModerationStatus =
                postsRepository.findAllPostDto(modelMapper, (byte) 1, ModerationStatus.ACCEPTED);

        PostResponse postResponse = new PostResponse(allByIsActiveAndModerationStatus.size());
        if (postResponse.getCount() == 0){
            return postResponse;
        }

        List<PostDetailsResponse> postDetailsResponses = getListPostDetails(allByIsActiveAndModerationStatus, mode);

        if (offset + limit > allByIsActiveAndModerationStatus.size()){
            postResponse.setPosts(postDetailsResponses.subList(offset, postDetailsResponses.size()));
        } else {
            postResponse.setPosts(postDetailsResponses.subList(offset, offset + limit));
        }

        return postResponse;
    }

    private String getTextWithoutHTML(String text) {
        String textWithoutHTML = Jsoup.parse(text).text();
        if (textWithoutHTML.length() > 150) {
            return textWithoutHTML.substring(0, 150).concat("...");
        }else {
            return textWithoutHTML;
        }
    }

    private List<PostDetailsResponse> getListPostDetails(List<PostsDto> allPostEntity, String mode){
        List<PostDetailsResponse> postDetailsResponseList = new ArrayList<>();

        //Наполняем лист Post
        for (PostsDto postsDto : allPostEntity){
            PostDetailsResponse postDetailsResponse = new PostDetailsResponse();
            postDetailsResponse.setId(postsDto.getId());
            postDetailsResponse.setTimestamp(postsDto.getTime().getTime() / 1000);
            UserResponse4PostDetails userResponse4PostDetails =
                    new UserResponse4PostDetails(
                            postsDto.getUserId().getId(),
                            postsDto.getUserId().getName()
                    );
            postDetailsResponse.setUser(userResponse4PostDetails);
            postDetailsResponse.setTitle(postsDto.getTitle());
            postDetailsResponse.setAnnounce(getTextWithoutHTML(postsDto.getText()));
            if (postsDto.getPostVotesEntityList().isEmpty()){
                postDetailsResponse.setLikeCount(0);
                postDetailsResponse.setDislikeCount(0);
            }else {
                postDetailsResponse.setLikeCount((int) postsDto.getPostVotesEntityList()
                        .stream()
                        .filter(postVotesEntity -> postVotesEntity.getValue() == 1)
                        .count());
                postDetailsResponse.setDislikeCount((int) postsDto.getPostVotesEntityList()
                        .stream()
                        .filter(postVotesEntity -> postVotesEntity.getValue() == -1)
                        .count());
            }
            postDetailsResponse.setCommentCount(postsDto.getCommentsEntityList().size());
            postDetailsResponse.setViewCount(postsDto.getViewCount());
            postDetailsResponseList.add(postDetailsResponse);
        }

        //Производим сортировку постов
        switch (mode){
            case MODE_RECENT:
                postDetailsResponseList.sort(Comparator.comparing(PostDetailsResponse::getTimestamp).reversed());
                break;
            case MODE_EARLY:
                postDetailsResponseList.sort(Comparator.comparing(PostDetailsResponse::getTimestamp));
                break;
            case MODE_POPULAR:
                postDetailsResponseList.sort(Comparator.comparing(PostDetailsResponse::getCommentCount).reversed());
                break;
            case MODE_BEST:
                postDetailsResponseList.sort(Comparator.comparing(PostDetailsResponse::getLikeCount).reversed());
                break;
        }

        return postDetailsResponseList;
    }
}
