package com.memory.memoryshop.api.controller;

import com.memory.memoryshop.api.request.PostCreate;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class PostController {

    @PostMapping("/posts")
    public Map<String, String> post(@RequestBody @Valid PostCreate postCreate, BindingResult result) {

        /**
         * 데이터 검증 하는 이유
         * 1. client 개발자가 깜박할 수 있다. 실수로 값을 안보낼 수 있다.
         * 2. client bug로 값이 누락될 수 있다.
         * 3. 외부에 나쁜 사람이 값을 임의로 조작해서 보낼수 있다.
         * 4. DB에 값은 저장할 때 의도치 않은 오류가 발생할 수 있다.
         * 5. 서버 개발자의 편안함을 위해서
         */

        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            FieldError firstFieldError = fieldErrors.get(0);
            String fieldName = firstFieldError.getField(); // title
            String errorMessage = firstFieldError.getDefaultMessage(); //에러메세지

            Map<String, String> error = new HashMap<>();
            error.put(fieldName, errorMessage);
            return error;
        }

        log.info("title={}, content={}", postCreate.getTitle(), postCreate.getContent());
        return Map.of();
    }

}
