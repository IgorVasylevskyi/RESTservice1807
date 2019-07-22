package Exchange.controller;

import Exchange.model.Currency;
import Exchange.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyController {

    @Autowired
    public CurrencyService currencyService;

    @RequestMapping(method = RequestMethod.POST)
    public Currency addCurrency(@RequestBody Currency currency){
        return currencyService.addCurrency(currency);
    }

    @RequestMapping(value = "/lastweek", method = RequestMethod.GET)
    public List<Currency> getLastWeek(){
        return currencyService.getLastWeek();
    }
}
