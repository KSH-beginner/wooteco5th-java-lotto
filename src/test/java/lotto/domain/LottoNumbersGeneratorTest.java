package lotto.domain;

import lotto.domain.LottoNumbersGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LottoNumbersGeneratorTest {

    @Test
    void 발행된_로또_번호는_오름차순으로_정렬된_번호이다() {
        List<Integer> generatedLottoNumbers = LottoNumbersGenerator.generate();
        List<Integer> copyLottoNumbers = new ArrayList<>();
        for (Integer lottoNumber : generatedLottoNumbers) {
            copyLottoNumbers.add(lottoNumber);
        }
        Collections.sort(generatedLottoNumbers);

        Assertions.assertThat(copyLottoNumbers.equals(generatedLottoNumbers)).isTrue();
    }
}