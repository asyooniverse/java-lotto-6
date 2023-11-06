package lotto.controller;

import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        buy();
        setWinning();
    }

    private void buy() {
        outputView.printInputPurchaseAmountMessage();
        Money money = inputView.readPurchaseAmount();
        lottoService.buyLotto(money);
        outputView.printPurchasedLottoCount(money.convertMoneyToCount());
        outputView.printLottos(lottoService.findLottos());
    }

    private void setWinning() {
        outputView.printInputWinningNumbersMessage();
    }
}
