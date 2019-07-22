package rest2.service;

import org.springframework.beans.factory.annotation.Autowired;
import rest2.model.Currency;
import rest2.repository.CurrencyRepository;

public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public Currency addCurrency(Currency currency) {
        return currencyRepository.saveAndFlush(currency);
    }
}
