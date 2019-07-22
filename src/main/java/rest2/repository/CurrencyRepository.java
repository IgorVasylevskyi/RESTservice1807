package rest2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest2.model.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
