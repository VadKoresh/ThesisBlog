package main.service;

import main.api.response.checkAuth.AuthCheckResponse;
import main.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostsService postsService;
    @Autowired
    private ModelMapper modelMapper;

    public AuthCheckResponse getAuthCheck(){
        AuthCheckResponse authCheckResponse = new AuthCheckResponse();
        authCheckResponse.setResult(false);
        /**
         * TODO:
         * Необходимо реализовать авторизацию
         */
        /*
        Optional<UserEntity> byId = userRepository.findById(2);
        UserDto userDto = modelMapper.map(byId.get(), UserDto.class);

        UserResponse userResponse = new UserResponse();
        userResponse.setId(userDto.getId());
        userResponse.setName(userDto.getName());
        userResponse.setEmail(userDto.getEmail());
        userResponse.setPhoto(userDto.getPhoto());
        userResponse.setSettings(true);
        if (userDto.getIsModerator() == 0){
            userResponse.setModeration(true);
            userResponse.setModerationCount(postsService.getCountAllPostWithStatus(ModerationStatus.NEW));
        }
        authCheckResponse.setUser(userResponse);
        authCheckResponse.setResult(true);
         */
        return authCheckResponse;
    }
}
