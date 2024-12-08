package com.cooba.controller;

import com.cooba.dto.Response;
import com.cooba.dto.Sample;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/inner")
public class InnerController {

    @GetMapping
    public Response<String> getInner(String uuid) {
        log.info("uuid: {}", uuid);

        Response<String> response = new Response<>();
        response.setId(uuid);
        response.setData("inner");
        return response;
    }

    @PostMapping
    public Response<Sample> sample(@RequestBody Sample sample) {
        log.info("sample: {}", sample);

        Response<Sample> response = new Response<>();
        response.setId(UUID.randomUUID().toString());
        response.setData(sample);
        return response;
    }
}
