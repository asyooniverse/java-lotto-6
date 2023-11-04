package lotto.message;

public enum ExceptionMessage {
    IS_NOT_DIGIT("로또 구입 금액은 숫자만 입력 가능합니다."),
    IS_NOT_DIVISIBLE_BY_1000("로또 구입 금액은 1000원 단위만 입력 가능합니다."),
    IS_NOT_SEPARATED_BY_COMMA("당첨 번호는 콤마로 구분되어야 합니다."),
    IS_NOT_6_LENGTH_OF_LOTTO("로또 번호의 길이는 6이여야 합니다."),
    IS_NOT_6_LENGTH_OF_WINNING("보너스 번호를 제외한 당첨 번호의 길이는 6이여야 합니다."),
    IS_DUPLICATED("당첨 번호는 중복이 없어야 합니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }
}
