CREATE TABLE Currencies
(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    code TEXT NOT NULL UNIQUE CHECK (length(3)),
    full_name TEXT NOT NULL UNIQUE CHECK ( length(100) ),
    sign TEXT NOT NULL UNIQUE CHECK ( length(10) )
);

CREATE TABLE ExchangeRates
(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    base_currency_id INTEGER NOT NULL ,
    target_currency_id INTEGER NOT NULL,
    rate REAL NOT NULL,
    UNIQUE (base_currency_id, target_currency_id),
    FOREIGN KEY (base_currency_id) REFERENCES Currencies (id) ON DELETE CASCADE,
    FOREIGN KEY (target_currency_id) REFERENCES Currencies (id) ON DELETE CASCADE
);
