package com.mindly.crypto.controllers;


import com.mindly.crypto.entities.Portfolio;
import com.mindly.crypto.repositories.PortfolioRepository;
import com.mindly.crypto.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class PortfolioController implements org.springframework.boot.web.servlet.error.ErrorController{

    @Autowired
    PortfolioRepository portfolioRepository;

    @Autowired
    PortfolioService portfolioService;

    @GetMapping("/")
    public String displayPortfolio(Model model) throws Exception {
        Portfolio aPortfolio = new Portfolio();
        model.addAttribute("portfolio", aPortfolio);
        Iterable<Portfolio> portfolios = portfolioRepository.findAll();
        model.addAttribute("portfoliosList", portfolios);
        portfolioService.updateMarketValue();
        aPortfolio.setDateOfPurchase(portfolioService.presentDate());
        return "portfolio";
    }

    @PostMapping("/save")
    public String createPortfolio(Portfolio portfolio) throws Exception {
        portfolioService.addNewCrypto(portfolio);
        portfolioRepository.save(portfolio);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePortfolio(@PathVariable(name = "id") Integer id) {
        portfolioService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/error")
    public String handleError() {
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}



