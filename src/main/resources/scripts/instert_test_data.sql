INSERT INTO Currencies (code, full_name, sign)
VALUES ("USD", "US Dollar", "$"),
       ("EUR", "Euro", "€");

INSERT INTO ExchangeRates (base_currency_id, target_currency_id, rate)
VALUES (1, 2, 2),
       (2, 1, 4);