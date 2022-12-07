package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String LOTTO_WINNING_NUMBERS_SPLIT_DELIMITER = ",";

    private final InputValidator inputValidator;

    public InputView() {
        inputValidator = new InputValidator();
    }

    public int inputLottoPurchaseMoney() {
        String inputLottoPurchaseMoney = Console.readLine();
        inputValidator.validateLottoPurchaseMoney(inputLottoPurchaseMoney);
        return Integer.parseInt(inputLottoPurchaseMoney);
    }

    public List<Integer> inputLottoWinningNumbers() {
        String lottoWinningNumbers = Console.readLine();
        inputValidator.validateLottoWinningNumbers(lottoWinningNumbers);
        return splitLottoWinningNumbers(lottoWinningNumbers);
    }

    private List<Integer> splitLottoWinningNumbers(String lottoWinningNumbers) {
        return Arrays.stream(lottoWinningNumbers.split(LOTTO_WINNING_NUMBERS_SPLIT_DELIMITER))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        inputValidator.validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
