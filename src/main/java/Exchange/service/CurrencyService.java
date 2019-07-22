package Exchange.service;

import Exchange.model.Currency;

import java.util.List;

public interface CurrencyService {

    Currency addCurrency(Currency currency);
    List<Currency> getLastWeek();
}
