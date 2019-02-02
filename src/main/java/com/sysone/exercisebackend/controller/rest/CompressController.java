package com.sysone.exercisebackend.controller.rest;

import com.sysone.exercisebackend.domain.Compressed;
import com.sysone.exercisebackend.domain.Value;
import com.sysone.exercisebackend.services.CompressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompressController {

    @Autowired
    private CompressService compressService;

    @PostMapping("/compress")
    public Compressed compress(@RequestBody Value value) {
        return compressService.compress(value);
    }

}
