package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumbersGenerator {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int GENERATE_NUMBER_COUNT = 6;

    public static List<Integer> generate() {
        List<Integer> generatedLottoNumbers = Randoms.pickUniqueNumbersInRange(
                START_INCLUSIVE, END_INCLUSIVE, GENERATE_NUMBER_COUNT);
        Collections.sort(generatedLottoNumbers);
        return generatedLottoNumbers;
    }
}
