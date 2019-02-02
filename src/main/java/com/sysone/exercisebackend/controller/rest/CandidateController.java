package com.sysone.exercisebackend.controller.rest;

import com.sysone.exercisebackend.services.Candidate;
import com.sysone.exercisebackend.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateController {

    @Autowired
    private CandidateService nameService;

    @GetMapping("/candidate")
    public Candidate getCandidate() {
        return nameService.getCandidate();
    }

}
