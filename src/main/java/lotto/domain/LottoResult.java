package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Integer, Integer> lottoRankCountMap = new HashMap<>();
    private int winningAmountSum;

    public void generate(List<Lotto> issuedLottos, WinningLotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();
        for (Lotto issueLotto : issuedLottos) {
            LottoRank lottoRank = getLottoRank(winningNumbers, bonusNumber, issueLotto);
            if (lottoRank != LottoRank.NO_RANK) {
                putLottoRankCountMap(lottoRank);
            }
        }
    }

    private LottoRank getLottoRank(List<Integer> winningNumbers, int bonusNumber, Lotto issueLotto) {
        List<Integer> issuedNumbers = issueLotto.getNumbers();
        long matchNumberCount = issuedNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean isMatchBonusNumber = issuedNumbers.contains(bonusNumber);
        return LottoRank.getLottoRank(matchNumberCount, isMatchBonusNumber);
    }

    private void putLottoRankCountMap(LottoRank lottoRank) {
        int rank = lottoRank.getRank(lottoRank);
        lottoRankCountMap.put(rank, lottoRankCountMap.getOrDefault(rank, 0) + 1);
    }

    public Map<Integer, Integer> getLottoRankCountMap() {
        return Collections.unmodifiableMap(lottoRankCountMap);
    }

    public int getWinningAmountSum() {
        return winningAmountSum;
    }
}
