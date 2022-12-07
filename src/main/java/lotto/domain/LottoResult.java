package lotto.domain;

import java.util.*;

public class LottoResult {

    private final Map<LottoRank, Integer> lottoRankCountMap = new LinkedHashMap<>();

    public LottoResult() {
        initLottoRankCountMap();
    }

    public void generateLottoRankCountMap(List<Lotto> issuedLottos, WinningLotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();
        for (Lotto issueLotto : issuedLottos) {
            LottoRank lottoRank = getLottoRank(winningNumbers, bonusNumber, issueLotto);
            if (lottoRank != LottoRank.NO_RANK) {
                putLottoRankCountMap(lottoRank);
            }
        }
    }

    private void initLottoRankCountMap() {
        lottoRankCountMap.put(LottoRank.FIRST, 0);
        lottoRankCountMap.put(LottoRank.SECOND, 0);
        lottoRankCountMap.put(LottoRank.THIRD, 0);
        lottoRankCountMap.put(LottoRank.FOURTH, 0);
        lottoRankCountMap.put(LottoRank.FIFTH, 0);
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
        lottoRankCountMap.put(lottoRank, lottoRankCountMap.get(lottoRank) + 1);
    }

    public double getYieldRate(int lottoPurchaseMoney) {
        int totalPrize = LottoRank.getTotalPrize(lottoRankCountMap);
        return ((double) totalPrize / lottoPurchaseMoney) * 100;
    }

    public Map<LottoRank, Integer> getLottoRankCountMap() {
        return Collections.unmodifiableMap(lottoRankCountMap);
    }
}
