package com.sysone.exercisebackend.services;

import com.sysone.exercisebackend.domain.Candidate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.Test;

public class CandidateServiceTest {

    @Test
    public void getCandidate_retornaNombre() {
        CandidateService candidateService = new CandidateService();
        assertThat(candidateService.getCandidate()).isEqualTo(new Candidate("Luis Darío Tejerina"));
    }

}
