package lotto.domain;

public class LottoIssueCountCalculator {

    private static final int A_LOTTO_PRICE = 1000;

    public static int calculate(int lottoPurchaseMoney) {
        return lottoPurchaseMoney / A_LOTTO_PRICE;
    }
}
