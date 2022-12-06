package lotto.domain;

import lotto.ErrorConstants;

import java.util.Collections;
import java.util.List;

public class WinningLotto {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        validateDuplicateBonusNumber(bonusNumber, numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(int bonusNumber, List<Integer> numbers) {
        if (isBonusNumberDuplicateNumbers(bonusNumber, numbers)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private boolean isBonusNumberDuplicateNumbers(int bonusNumber, List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
