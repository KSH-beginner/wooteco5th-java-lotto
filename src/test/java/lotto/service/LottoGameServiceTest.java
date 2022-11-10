package lotto.service;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoGameServiceTest {

    LottoGameService lottoGameService;

    @BeforeEach
    void generateLottoGameService() {
        lottoGameService = new LottoGameService();
    }
    @ParameterizedTest
    @ValueSource(strings = {"10000", "20000", "35000", "1000"})
    void 로또_발행_개수_반환(String lottoPurchaseAmount) {
        int lottoIssueCount = lottoGameService.getLottoIssueCount(lottoPurchaseAmount);

        assertThat(lottoIssueCount).isEqualTo(Integer.parseInt(lottoPurchaseAmount) / 1000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"500", "1500", "1750", "10002"})
    void 로또_구입_금액이_1000으로_나누어_떨어지지_않으면_예외_발생(String lottoPurchaseAmount) {
        assertThatThrownBy(() -> lottoGameService.getLottoIssueCount(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 1,000원으로 나누어 떨어져야합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "", "abc", "a123", "AAA"})
    void 로또_구입_금액이_숫자가_아니면_예외_발생(String lottoPurchaseAmount) {
        assertThatThrownBy(() -> lottoGameService.getLottoIssueCount(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 숫자여야합니다.");
    }

    @Test
    void 구매한_로또_번호와_당첨_번호_0개_일치() {
        List<Integer> lottoWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> purchaseLottoNumbers = List.of(7, 8, 9, 10, 11, 12);
        long purchaseNumbersMatchWinningNumbersCount
                = lottoGameService.getPurchaseNumbersMatchWinningNumbersCount(purchaseLottoNumbers, lottoWinningNumbers);

        assertThat(purchaseNumbersMatchWinningNumbersCount).isEqualTo(0);
    }

    @Test
    void 구매한_로또_번호와_당첨_번호_1개_일치() {
        List<Integer> lottoWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> purchaseLottoNumbers = List.of(1, 8, 9, 10, 11, 12);
        long purchaseNumbersMatchWinningNumbersCount
                = lottoGameService.getPurchaseNumbersMatchWinningNumbersCount(purchaseLottoNumbers, lottoWinningNumbers);

        assertThat(purchaseNumbersMatchWinningNumbersCount).isEqualTo(1);
    }

    @Test
    void 구매한_로또_번호와_당첨_번호_2개_일치() {
        List<Integer> lottoWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> purchaseLottoNumbers = List.of(1, 2, 9, 10, 11, 12);
        long purchaseNumbersMatchWinningNumbersCount
                = lottoGameService.getPurchaseNumbersMatchWinningNumbersCount(purchaseLottoNumbers, lottoWinningNumbers);

        assertThat(purchaseNumbersMatchWinningNumbersCount).isEqualTo(2);
    }

    @Test
    void 구매한_로또_번호와_당첨_번호_3개_일치() {
        List<Integer> lottoWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> purchaseLottoNumbers = List.of(1, 2, 3, 10, 11, 12);
        long purchaseNumbersMatchWinningNumbersCount
                = lottoGameService.getPurchaseNumbersMatchWinningNumbersCount(purchaseLottoNumbers, lottoWinningNumbers);

        assertThat(purchaseNumbersMatchWinningNumbersCount).isEqualTo(3);
    }

    @Test
    void 구매한_로또_번호와_당첨_번호_4개_일치() {
        List<Integer> lottoWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> purchaseLottoNumbers = List.of(1, 2, 3, 4, 11, 12);
        long purchaseNumbersMatchWinningNumbersCount
                = lottoGameService.getPurchaseNumbersMatchWinningNumbersCount(purchaseLottoNumbers, lottoWinningNumbers);

        assertThat(purchaseNumbersMatchWinningNumbersCount).isEqualTo(4);
    }

    @Test
    void 구매한_로또_번호와_당첨_번호_5개_일치() {
        List<Integer> lottoWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> purchaseLottoNumbers = List.of(1, 2, 3, 4, 5, 12);
        long purchaseNumbersMatchWinningNumbersCount
                = lottoGameService.getPurchaseNumbersMatchWinningNumbersCount(purchaseLottoNumbers, lottoWinningNumbers);

        assertThat(purchaseNumbersMatchWinningNumbersCount).isEqualTo(5);
    }

    @Test
    void 구매한_로또_번호와_당첨_번호_6개_일치() {
        List<Integer> lottoWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> purchaseLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        long purchaseNumbersMatchWinningNumbersCount
                = lottoGameService.getPurchaseNumbersMatchWinningNumbersCount(purchaseLottoNumbers, lottoWinningNumbers);

        assertThat(purchaseNumbersMatchWinningNumbersCount).isEqualTo(6);
    }

    @Test
    void 구매한_로또_번호와_보너스_번호_일치() {
        List<Integer> purchaseLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 1;
        boolean isPurchaseNumbersMatchBonusNumber
                = lottoGameService.isPurchaseNumbersMatchBonusNumber(purchaseLottoNumbers, bonusNumber);

        assertThat(isPurchaseNumbersMatchBonusNumber).isTrue();
    }

    @Test
    void 구매한_로또_번호와_보너스_번호_불일치() {
        List<Integer> purchaseLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        boolean isPurchaseNumbersMatchBonusNumber
                = lottoGameService.isPurchaseNumbersMatchBonusNumber(purchaseLottoNumbers, bonusNumber);

        assertThat(isPurchaseNumbersMatchBonusNumber).isFalse();
    }

    @Test
    void 당첨_번호의_개수가_6개가_아니면_예외_발생() {
        List<String> lottoWinningNumbers = List.of("1", "2", "3", "4", "5", "6", "7");
        assertThatThrownBy(() -> lottoGameService.validateLottoWinningNumbers(lottoWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 당첨 번호의 개수는 6개여야합니다.");
    }
}