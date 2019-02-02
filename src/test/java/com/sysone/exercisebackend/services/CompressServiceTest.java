package com.sysone.exercisebackend.services;

import com.sysone.exercisebackend.domain.Compressed;
import com.sysone.exercisebackend.domain.Value;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import org.junit.Test;

public class CompressServiceTest {

    private final CompressService compressService = new CompressService();

    @Test
    public void compress_conStringVariosCaracteres_retornaStringComprimido() {
        assertThat(compressService.compress(new Value("AAABBAAAAABBBCCCCCCCCAAAAA"))).isEqualToComparingFieldByField(new Compressed("3A2B5A3B8C5A"));
    }

    @Test
    public void compress_conStringConMinusculas_retornaStringComprimido() {
        assertThat(compressService.compress(new Value("AAABBAAAaaBBBCCCCCcccAAAaa"))).isEqualToComparingFieldByField(new Compressed("3A2B5A3B8C5A"));
    }

    @Test
    public void compress_conStringUnSoloCaracter_retornaStringComprimido() {
        assertThat(compressService.compress(new Value("A"))).isEqualToComparingFieldByField(new Compressed("1A"));
    }

    @Test
    public void compress_conStringVacio_retornaStringVacio() {
        assertThat(compressService.compress(new Value(""))).isEqualToComparingFieldByField(new Compressed(""));
    }

    @Test
    public void compress_conNulo_lanzaIllegalArgumentException() {
        assertThatThrownBy(() -> compressService.compress(new Value(null)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("value must not be null");
    }

    @Test
    public void compress_conNumeros_lanzaIllegalArgumentException() {
        assertThatThrownBy(() -> compressService.compress(new Value("1254AAAAA")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("value must contain only letters");
    }

}
