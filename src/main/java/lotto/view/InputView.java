package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String LOTTO_WINNING_NUMBERS_SPLIT_DELIMITER = ",";

    public String inputLottoPurchaseMoney() {
        return Console.readLine();
    }

    public List<Integer> inputLottoWinningNumbers() {
        String lottoWinningNumbers = Console.readLine();
        return Arrays.stream(lottoWinningNumbers.split(LOTTO_WINNING_NUMBERS_SPLIT_DELIMITER))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
