package com.mindly.crypto.services;


import com.mindly.crypto.entities.Portfolio;
import com.mindly.crypto.repositories.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
@Transactional
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    public void addNewCrypto(Portfolio portfolio) throws IOException {
        ApiAccess api = new ApiAccess();
        portfolio.setValueEuro(BigDecimal.valueOf(portfolio.getAmount() * api.convertToEur(portfolio.getCurrency())));
    }

    public void delete(int id) {
        portfolioRepository.deleteById(id);
    }

    public void updateMarketValue() throws Exception {
        ApiAccess apiAccess = new ApiAccess();

        for (Portfolio portfolio : portfolioRepository.findAll()) {
            BigDecimal value = BigDecimal.valueOf(portfolio.getAmount() * apiAccess.convertToEur(portfolio.getCurrency()));
            portfolio.setValueEuro(value);
        }
    }

    public String presentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }
}


