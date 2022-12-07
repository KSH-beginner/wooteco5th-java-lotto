package lotto.view;

import lotto.ErrorConstants;
import lotto.domain.LottoRank;

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
    private static final String YIELD_RATE_DECIMAL_FORMAT = "###,##0.0";
    private static final String BLANK_LINE = "";

    public void printInputLottoPurchaseMoneyMessage() {
        printMessage(INPUT_LOTTO_PURCHASE_MONEY_MESSAGE);
    }

    public void printNumberOfPurchaseLotto(int numberOfPurchaseLotto) {
        printBlankLine();
        printMessage(numberOfPurchaseLotto + NUMBER_OF_PURCHASE_LOTTO_MESSAGE);
    }

    public void printIssuedLottoNumbers(List<Integer> issuedLottoNumbers) {
        printMessage(issuedLottoNumbers.toString());
    }

    public void printInputLottoWinningNumbersMessage() {
        printBlankLine();
        printMessage(INPUT_LOTTO_WINNING_NUMBERS_MESSAGE);
    }

    public void printInputLottoBonusNumberMessage() {
        printBlankLine();
        printMessage(INPUT_LOTTO_BONUS_NUMBER_MESSAGE);
    }

    public void printWinningStatisticsMessage() {
        printBlankLine();
        printMessage(WINNING_STATISTICS_MESSAGE);
    }

    public void printDelimiterLine() {
        printMessage(DELIMITER_LINE);
    }

    public void printLottoRank(Map<LottoRank, Integer> lottoRankCountMap) {
        printMessage("3개 일치 (5,000원) - " + lottoRankCountMap.get(LottoRank.FIFTH) + "개");
        printMessage("4개 일치 (50,000원) - " + lottoRankCountMap.get(LottoRank.FOURTH) + "개");
        printMessage("5개 일치 (1,500,000원) - " + lottoRankCountMap.get(LottoRank.THIRD) + "개");
        printMessage("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoRankCountMap.get(LottoRank.SECOND) + "개");
        printMessage("6개 일치 (2,000,000,000원) - " + lottoRankCountMap.get(LottoRank.FIRST) + "개");
    }

    public void printYieldRate(double yieldRate) {
        DecimalFormat yieldRateFormat = new DecimalFormat(YIELD_RATE_DECIMAL_FORMAT);
        String formattedYieldRate = yieldRateFormat.format(yieldRate);
        printMessage("총 수익률은 " + formattedYieldRate + "%입니다.");
    }

    public void printBlankLine() {
        System.out.println(BLANK_LINE);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
