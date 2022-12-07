package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void 번호가_3개_일치하면_5등_보너스_번호_일치_여부는_상관없음(boolean isMatchBonusNumber) {
        long matchNumberCount = 3;
        LottoRank lottoRank = LottoRank.getLottoRank(matchNumberCount, isMatchBonusNumber);

        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void 번호가_4개_일치하면_4등_보너스_번호_일치_여부는_상관없음(boolean isMatchBonusNumber) {
        long matchNumberCount = 4;
        LottoRank lottoRank = LottoRank.getLottoRank(matchNumberCount, isMatchBonusNumber);

        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void 번호가_5개_일치하고_보너스_번호가_불일치하면_3등() {
        long matchNumberCount = 5;
        boolean isMatchBonusNumber = false;
        LottoRank lottoRank = LottoRank.getLottoRank(matchNumberCount, isMatchBonusNumber);

        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void 번호가_5개_일치하고_보너스_번호가_일치하면_2등() {
        long matchNumberCount = 5;
        boolean isMatchBonusNumber = true;
        LottoRank lottoRank = LottoRank.getLottoRank(matchNumberCount, isMatchBonusNumber);

        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void 번호가_6개_일치하면_1등() {
        long matchNumberCount = 6;
        boolean isMatchBonusNumber = false;
        LottoRank lottoRank = LottoRank.getLottoRank(matchNumberCount, isMatchBonusNumber);

        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }
}