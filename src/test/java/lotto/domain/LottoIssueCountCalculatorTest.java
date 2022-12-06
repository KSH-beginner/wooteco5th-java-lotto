package lotto.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoIssueCountCalculatorTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 14000, 150000})
    void 구매_개수를_구하는_기능(int lottoPurchaseMoney) {
        int lottoIssueCount = lottoPurchaseMoney / 1000;
        int lottoIssueCountToAssert = LottoIssueCountCalculator.calculate(lottoPurchaseMoney);

        Assertions.assertThat(lottoIssueCountToAssert).isEqualTo(lottoIssueCount);
    }
}