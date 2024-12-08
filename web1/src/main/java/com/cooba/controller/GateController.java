package com.cooba.controller;

import com.cooba.dto.Response;
import com.cooba.dto.Sample;
import com.cooba.feign.InnerFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.instancio.Instancio;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/gate")
public class GateController {
    private final InnerFeign innerFeign;

    @GetMapping("/call")
    public Response<String> getInner(){
        return innerFeign.getInner(UUID.randomUUID().toString().replaceAll("-", ""));
    }

    @PostMapping("/call")
    public Response<Sample> postInner(){
        Sample sample = Instancio.create(Sample.class);
        return innerFeign.postSample(sample);
    }
}
