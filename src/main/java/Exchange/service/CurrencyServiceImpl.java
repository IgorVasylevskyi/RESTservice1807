package Exchange.service;

import Exchange.model.Currency;
import Exchange.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService{

    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public Currency addCurrency(Currency currency) {
        return currencyRepository.saveAndFlush(currency);
    }

    @Override
    public List<Currency> getLastWeek() {
        LocalDate dateWeekAgo = LocalDate.now().minusDays(7);
        Date date = java.sql.Date.valueOf(dateWeekAgo);
        return currencyRepository.findByDateIsAfter(date);
    }
}
