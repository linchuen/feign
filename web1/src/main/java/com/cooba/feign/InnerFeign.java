package com.cooba.feign;

import com.cooba.dto.Response;
import com.cooba.dto.Sample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inner", url = "127.0.0.1:8081")
public interface InnerFeign {

    @PostMapping(value = "/inner")
    Response<Sample> postSample(Sample sample);

    @GetMapping(value = "/inner")
    Response<String> getInner(@RequestParam(name = "uuid") String uuid);

}
