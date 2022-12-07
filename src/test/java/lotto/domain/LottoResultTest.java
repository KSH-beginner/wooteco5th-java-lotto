package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    private LottoResult lottoResult;

    private List<Lotto> issuedLottos = new ArrayList<>();
    private WinningLotto winningLotto;

    @BeforeEach
    void initLottoCondition() {
        winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        issuedLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // 1등
        issuedLottos.add(new Lotto(List.of(2, 3, 4, 5, 6, 7))); // 2등
        issuedLottos.add(new Lotto(List.of(2, 3, 4, 5, 6, 8))); // 3등
        issuedLottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10))); // 5등
        lottoResult = new LottoResult();
        lottoResult.generateLottoRankCountMap(issuedLottos, winningLotto);
    }

    @Test
    void 당첨_내역_생성_기능() {
        Map<LottoRank, Integer> lottoRankCountMap = lottoResult.getLottoRankCountMap();

        Integer firstCount = lottoRankCountMap.get(LottoRank.FIRST);
        Integer secondCount = lottoRankCountMap.get(LottoRank.SECOND);
        Integer thirdCount = lottoRankCountMap.get(LottoRank.THIRD);
        Integer fourthCount = lottoRankCountMap.get(LottoRank.FOURTH);
        Integer fifthCount = lottoRankCountMap.get(LottoRank.FIFTH);

        Assertions.assertThat(firstCount).isEqualTo(1);
        Assertions.assertThat(secondCount).isEqualTo(1);
        Assertions.assertThat(thirdCount).isEqualTo(1);
        Assertions.assertThat(fourthCount).isEqualTo(0);
        Assertions.assertThat(fifthCount).isEqualTo(1);
    }

    @Test
    void 수익률_구하는_기능() {
        int lottoPurchaseMoney = 4000;
        double yieldRate = lottoResult.getYieldRate(lottoPurchaseMoney);

        Assertions.assertThat(yieldRate).isEqualTo(50787625);
    }
}