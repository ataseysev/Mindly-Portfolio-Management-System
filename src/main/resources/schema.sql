CREATE SEQUENCE IF NOT EXISTS portfolio_seq;

CREATE TABLE IF NOT EXISTS portfolio(

Id BIGINT NOT NULL DEFAULT nextval('portfolio_seq') PRIMARY KEY,
Currency VARCHAR(100) NOT NULL,
Amount VARCHAR(100) NOT NULL,
Date_Of_Purchase VARCHAR (100) NOT NULL,
Wallet_Location VARCHAR(100) NOT NULL,
Value_Euro DECIMAL

);

