package main.controller;

import main.api.response.InitResponse;
import main.service.GlobalSettingsService;
import main.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiGeneralController {

    @Autowired
    private InitResponse initResponse;
    @Autowired
    private GlobalSettingsService settingsService;
    @Autowired
    private TagsService tagsService;

    @GetMapping("/init")
    public InitResponse init(){
        return initResponse;
    }

    @GetMapping("/settings")
    public ResponseEntity settings(){
        return ResponseEntity.ok(settingsService.getSettings());
    }

    @GetMapping("/tag")
    private ResponseEntity getTags(@RequestParam(required = false) String query){
        return ResponseEntity.ok(tagsService.getTags(query));
    }
}
