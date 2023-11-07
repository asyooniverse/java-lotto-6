package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoCompare {
    private final Map<WinningGrade, Integer> winningMap = new EnumMap<>(WinningGrade.class);

    public LottoCompare() {
        init();
    }

    private void init() {
        Arrays.stream(WinningGrade.values())
                .forEach(value -> winningMap.put(value, 0));
    }

    public void compareAllLottoToWinning(List<List<Integer>> lottos, WinningNumbers winningNumbers) {
        lottos.forEach(lotto -> compareLottoToWinning(lotto, winningNumbers));
    }

    public Map<WinningGrade, Integer> getWinningResult() {
        return new EnumMap<>(winningMap);
    }

    private void compareLottoToWinning(List<Integer> lotto, WinningNumbers winningNumbers) {
        int matchCount = getMatchCount(lotto, winningNumbers);
        boolean bonusIncluded = hasBonusNumber(lotto, winningNumbers);
        findWinningGrade(matchCount, bonusIncluded);
    }

    private void findWinningGrade(int matchCount, boolean bonusIncluded) {
        WinningGrade grade = WinningGrade.findGrade(matchCount, bonusIncluded);
        addWinningGradeResult(grade);
    }

    private void addWinningGradeResult(WinningGrade grade) {
        int plusCount = winningMap.get(grade) + 1;
        winningMap.put(grade, plusCount);
    }

    private boolean hasBonusNumber(List<Integer> lotto, WinningNumbers winningNumbers) {
        return winningNumbers.hasBonusNumber(lotto);
    }

    private int getMatchCount(List<Integer> lotto, WinningNumbers winningNumbers) {
        return (int) lotto.stream().filter(winningNumbers::contains).count();
    }
}
