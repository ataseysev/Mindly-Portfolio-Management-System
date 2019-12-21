package com.mindly.crypto.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DynamicUpdate
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "portfolio_seq")
    @Column(updatable = false)
    public int id;

    public String currency;

    @Max(value = 999999999, message = "Invalid amount entered")
    @Positive(message = "You cannot enter negative number")
    private double amount;

    private String dateOfPurchase; //= PortfolioService.presentDate();

    @NotBlank(message = "Wallet location is required")
    private String WalletLocation;

    @Column(updatable = false)
    private BigDecimal valueEuro;
}

