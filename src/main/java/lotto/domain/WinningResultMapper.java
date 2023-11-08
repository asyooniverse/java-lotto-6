package lotto.domain;

import lotto.message.ProcessMessage;
import lotto.message.ResultMessage;

import java.util.List;
import java.util.Map;

public class WinningResultMapper {
    public List<String> drawWinningResultMap(Map<WinningGrade, Integer> winningResult) {
        return winningResult.entrySet().stream()
                .filter(this::isNotDefaultGrade)
                .map(this::applyFormattedWinningResult)
                .toList();
    }

    private boolean isNotDefaultGrade(Map.Entry<WinningGrade, Integer> entry) {
        return entry.getKey() != WinningGrade.DEFAULT;
    }

    private String applyFormattedWinningResult(Map.Entry<WinningGrade, Integer> grade) {
        String frame = selectGradeResultMap(grade.getKey());
        return formatFrameWithWinningData(frame, grade);
    }

    private String formatFrameWithWinningData(String frame, Map.Entry<WinningGrade, Integer> value) {
        WinningGrade grade = value.getKey();
        int winningCount = value.getValue();
        return String.format(frame, grade.getMatchCount(), grade.getPrizeMoney(), winningCount);
    }

    private String selectGradeResultMap(WinningGrade grade) {
        if (grade.isSecondGrade()) {
            return getSecondWinningResultMap();
        }
        return getOthersWinningResultMap();
    }

    private String getOthersWinningResultMap() {
        return ResultMessage.OTHERS_GRADE_PATTERN.toString();
    }

    private String getSecondWinningResultMap() {
        return ResultMessage.SECOND_GRADE_PATTERN.toString();
    }
}
