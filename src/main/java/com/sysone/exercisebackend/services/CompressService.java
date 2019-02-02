package com.sysone.exercisebackend.services;

import com.sysone.exercisebackend.domain.Compressed;
import com.sysone.exercisebackend.domain.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CompressService {

    public Compressed compress(Value value) {
        validateValueIsNullOrLetter(value);
        String valueUpperCase = value.getValue().toUpperCase();
        return new Compressed(doCompress(valueUpperCase));
    }

    private void validateValueIsNullOrLetter(Value value) {
        Assert.notNull(value.getValue(), "value must not be null");
        Assert.isTrue(value.getValue().chars().allMatch(Character::isLetter), "value must contain only letters");
    }

    private String doCompress(String valueUpperCase) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 0; i < valueUpperCase.length(); i++) {
            while (i + 1 < valueUpperCase.length() && valueUpperCase.charAt(i) == valueUpperCase.charAt(i + 1)) {
                count++;
                i++;
            }
            stringBuilder.append(count).append(String.valueOf(valueUpperCase.charAt(i)));
            count = 1;
        }
        return stringBuilder.toString();
    }

}
