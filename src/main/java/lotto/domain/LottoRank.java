package lotto.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum LottoRank {

    NO_RANK(0, 0L, 0),
    FIRST(1, 6L, 2000000000),
    SECOND(2, 5L, 30000000),
    THIRD(3, 5L, 1500000),
    FOURTH(4, 4L, 50000),
    FIFTH(5, 3L, 5000);

    private static final long SECOND_OR_THIRD_MATCH_NUMBER = 5L;
    private static final int FIRST_RANK_COUNT_INDEX = 0;
    private static final int SECOND_RANK_COUNT_INDEX = 1;
    private static final int THIRD_RANK_COUNT_INDEX = 2;
    private static final int FOURTH_RANK_COUNT_INDEX = 3;
    private static final int FIFTH_RANK_COUNT_INDEX = 4;

    private final int rank;
    private final long matchNumberCount;
    private final int winningAmount;

    LottoRank(int rank, long matchNumberCount, int winningAmount) {
        this.rank = rank;
        this.matchNumberCount = matchNumberCount;
        this.winningAmount = winningAmount;
    }

    public static LottoRank getLottoRank(long matchNumberCount, boolean isMatchBonusNumber) {
        if (matchNumberCount == SECOND_OR_THIRD_MATCH_NUMBER) {
            return getSecondOrThirdRank(isMatchBonusNumber);
        }

        return Arrays.stream(values())
                .filter(rank -> rank.matchNumberCount == matchNumberCount)
                .findAny()
                .orElse(NO_RANK);
    }

    private static LottoRank getSecondOrThirdRank(boolean isMatchBonusNumber) {
        if (isMatchBonusNumber) {
            return SECOND;
        }
        return THIRD;
    }

    public static int getTotalPrize(Map<LottoRank, Integer> lottoRankCountMap) {
        List<Integer> lottoRankCounts = new ArrayList<>(lottoRankCountMap.values());
        int totalFirstPrize = LottoRank.FIRST.winningAmount * lottoRankCounts.get(FIRST_RANK_COUNT_INDEX);
        int totalSecondPrize = LottoRank.SECOND.winningAmount * lottoRankCounts.get(SECOND_RANK_COUNT_INDEX);
        int totalThirdPrize = LottoRank.THIRD.winningAmount * lottoRankCounts.get(THIRD_RANK_COUNT_INDEX);
        int totalFourthPrize = LottoRank.FOURTH.winningAmount * lottoRankCounts.get(FOURTH_RANK_COUNT_INDEX);
        int totalFifthPrize = LottoRank.FIFTH.winningAmount * lottoRankCounts.get(FIFTH_RANK_COUNT_INDEX);

        return totalFirstPrize + totalSecondPrize + totalThirdPrize + totalFourthPrize + totalFifthPrize;
    }

    public static int getRank(LottoRank lottoRank) {
        return lottoRank.rank;
    }

    public static int getWinningAmount(LottoRank lottoRank) {
        return lottoRank.winningAmount;
    }
}
