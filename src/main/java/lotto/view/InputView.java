package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorConstants;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String LOTTO_WINNING_NUMBERS_SPLIT_DELIMITER = ",";
    private static final String LOTTO_WINNING_NUMBERS_REGEX = "[0-9]*[,]{0,1}[0-9]+";

    public int inputLottoPurchaseMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputLottoWinningNumbers() {
        String lottoWinningNumbers = Console.readLine();
        validateInputLottoWinningNumbers(lottoWinningNumbers);
        return splitLottoWinningNumbers(lottoWinningNumbers);
    }

    private List<Integer> splitLottoWinningNumbers(String lottoWinningNumbers) {
        return Arrays.stream(lottoWinningNumbers.split(LOTTO_WINNING_NUMBERS_SPLIT_DELIMITER))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private void validateInputLottoWinningNumbers(String inputLottoWinningNumbers) {
        if (isNumbersDelimiterNotComma(inputLottoWinningNumbers)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "로또 번호는 쉼표로 구분된 숫자여야합니다.");
        }
    }

    private boolean isNumbersDelimiterNotComma(String inputLottoWinningNumbers) {
        return !Pattern.compile(LOTTO_WINNING_NUMBERS_REGEX).matcher(inputLottoWinningNumbers).matches();
    }

    public int inputLottoBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
