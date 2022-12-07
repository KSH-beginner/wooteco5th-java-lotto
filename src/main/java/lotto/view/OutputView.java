package lotto.view;

import lotto.ErrorConstants;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String INPUT_LOTTO_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_PURCHASE_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String INPUT_LOTTO_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DELIMITER_LINE = "---";
    private static final int FIRST_RANK_COUNT_KEY = 1;
    private static final int SECOND_RANK_COUNT_KEY = 2;
    private static final int THIRD_RANK_COUNT_KEY = 3;
    private static final int FOURTH_RANK_COUNT_KEY = 4;
    private static final int FIFTH_RANK_COUNT_KEY = 5;

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

    public void printLottoRank(Map<Integer, Integer> lottoRankCountMap) {
        printMessage("3개 일치 (5,000원) - " + lottoRankCountMap.get(FIRST_RANK_COUNT_KEY) + "개");
        printMessage("4개 일치 (50,000원) - " + lottoRankCountMap.get(SECOND_RANK_COUNT_KEY) + "개");
        printMessage("5개 일치 (1,500,000원) - " + lottoRankCountMap.get(THIRD_RANK_COUNT_KEY) + "개");
        printMessage("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoRankCountMap.get(FOURTH_RANK_COUNT_KEY) + "개");
        printMessage("6개 일치 (2,000,000,000원) - " + lottoRankCountMap.get(FIFTH_RANK_COUNT_KEY) + "개");
    }

    public void printYieldRate(double yieldRate) {
        DecimalFormat yieldRateFormat = new DecimalFormat("###,###.0");
        String formattedYieldRate = yieldRateFormat.format(yieldRate);
        printMessage("총 수익률은 " + formattedYieldRate + "%입니다.");
    }

    public void printError(String errorMessage) {
        System.out.println(ErrorConstants.ERROR_PREFIX + errorMessage);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
