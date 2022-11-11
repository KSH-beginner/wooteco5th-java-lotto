package lotto.view;


import java.util.List;

public class OutputView {

    private static final String PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    public void printPurchaseLottoCount(int purchaseLottoCount) {
        System.out.println(purchaseLottoCount + PURCHASE_LOTTO_COUNT_MESSAGE);
    }

    public void printIssuedLottoNumbers(List<Integer> issuedLottoNumbers) {
        System.out.println(issuedLottoNumbers.toString());
    }
}