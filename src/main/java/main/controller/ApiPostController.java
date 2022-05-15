package main.controller;

import main.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiPostController {

    @Autowired
    private PostsService postsService;

    @GetMapping("/api/post")
    private ResponseEntity getPosts(@RequestParam(required = false, defaultValue = "0") int offset,
                                    @RequestParam(required = false, defaultValue = "10") int limit,
                                    @RequestParam(required = false, defaultValue = "recent") String mode){
        return ResponseEntity.ok(postsService.getPostsResponse(offset, limit, mode));
    }
}
