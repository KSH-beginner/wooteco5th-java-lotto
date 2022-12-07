package lotto.domain;


import java.util.Arrays;

public enum LottoRank {

    NO_RANK(0, 0L, 0),
    FIRST(1, 6L, 2000000000),
    SECOND(2, 5L, 30000000),
    THIRD(3, 5L, 1500000),
    FOURTH(4, 4L, 50000),
    FIFTH(5, 3L, 5000);

    private static final long SECOND_OR_THIRD_MATCH_NUMBER = 5L;

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

    public int getRank(LottoRank lottoRank) {
        return lottoRank.rank;
    }

    public int getWinningAmount(LottoRank lottoRank) {
        return lottoRank.winningAmount;
    }
}
