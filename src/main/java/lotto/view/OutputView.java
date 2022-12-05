package lotto.view;

import java.util.List;

public class OutputView {

    private static final String INPUT_LOTTO_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_PURCHASE_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String INPUT_LOTTO_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DELIMITER_LINE = "---";
    private static final String ERROR_PREFIX = "[ERROR] "

    public void printInputLottoPurchaseMoneyMessage() {
        printMessage(INPUT_LOTTO_PURCHASE_MONEY_MESSAGE);
    }

    public void printNumberOfPurchaseLotto(int numberOfPurchaseLotto) {
        printMessage(numberOfPurchaseLotto + NUMBER_OF_PURCHASE_LOTTO_MESSAGE);
    }

    public void printIssuedLottoNumbers(List<Integer> issuedLottoNumbers) {
        printMessage(issuedLottoNumbers.toString());
    }

    public void printInputLottoWinningNumbersMessage() {
        printMessage(INPUT_LOTTO_WINNING_NUMBERS_MESSAGE);
    }

    public void printInputLottoBonusNumberMessage() {
        printMessage(INPUT_LOTTO_BONUS_NUMBER_MESSAGE);
    }

    public void printWinningStatisticsMessage() {
        printMessage(WINNING_STATISTICS_MESSAGE);
    }

    public void printDelimiterLine() {
        printMessage(DELIMITER_LINE);
    }

    public void printError(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
