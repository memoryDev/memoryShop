package com.memory.memoryshop.api.controller;

import com.memory.memoryshop.api.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PostController {

    @PostMapping("/posts")
    public String post(@RequestBody PostCreate postCreate) {

        log.info("title={}, content={}", postCreate.getTitle(), postCreate.getContent());
        return "Hello World!";
    }
}
