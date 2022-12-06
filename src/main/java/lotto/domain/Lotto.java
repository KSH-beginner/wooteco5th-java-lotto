package lotto.domain;

import lotto.ErrorConstants;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int CORRECT_NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isNumbersSizeNotSix(numbers)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "로또 번호는 6개여야합니다.");
        }
        if (isNumbersDuplicate(numbers)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "로또 번호는 중복되면 안됩니다.");
        }
    }

    private boolean isNumbersSizeNotSix(List<Integer> numbers) {
        return numbers.size() != CORRECT_NUMBERS_SIZE;
    }

    private boolean isNumbersDuplicate(List<Integer> numbers) {
        Set<Integer> convertedNumbers = new HashSet<>(numbers);
        return convertedNumbers.size() != CORRECT_NUMBERS_SIZE;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
