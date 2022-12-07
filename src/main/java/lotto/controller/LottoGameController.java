package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private WinningLotto winningLotto;
    private int purchaseLottoMoney;
    private final List<Lotto> issuedLottos = new ArrayList<>();

    public LottoGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        issueLottosStep();
        generateWinningLottoStep();
        printLottoResultStep();
    }

    private void issueLottosStep() {
        purchaseLottoMoney = inputLottoPurchaseMoney();
        int purchaseLottoCount = calculateLottoPurchaseCount(purchaseLottoMoney);
        outputView.printNumberOfPurchaseLotto(purchaseLottoCount);
        for (int lottoIssueIndex = 0; lottoIssueIndex < purchaseLottoCount; lottoIssueIndex++) {
            issuedLottos.add(new Lotto(LottoNumbersGenerator.generate()));
        }
        issuedLottos.forEach(lotto -> outputView.printIssuedLottoNumbers(lotto.getNumbers()));
    }

    private int inputLottoPurchaseMoney() {
        outputView.printInputLottoPurchaseMoneyMessage();
        return inputView.inputLottoPurchaseMoney();
    }

    private int calculateLottoPurchaseCount(int purchaseLottoMoney) {
        return LottoIssueCountCalculator.calculate(purchaseLottoMoney);
    }

    private void generateWinningLottoStep() {
        outputView.printInputLottoWinningNumbersMessage();
        List<Integer> lottoWinningNumbers = inputView.inputLottoWinningNumbers();
        outputView.printInputLottoBonusNumberMessage();
        int bonusNumber = inputView.inputBonusNumber();
        winningLotto = new WinningLotto(lottoWinningNumbers, bonusNumber);
    }

    private void printLottoResultStep() {
        LottoResult lottoResult = new LottoResult(issuedLottos, winningLotto);
        outputView.printWinningStatisticsMessage();
        outputView.printDelimiterLine();
        outputView.printLottoRank(lottoResult.getLottoRankCountMap());
        outputView.printYieldRate(lottoResult.getYieldRate(purchaseLottoMoney));
    }
}
