package com.sysone.exercisebackend.services;

import com.sysone.exercisebackend.domain.Candidate;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    public Candidate getCandidate() {
        return new Candidate("Luis Darío Tejerina");
    }
}
