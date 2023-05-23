Feature:
  CoinMarketCapExample

  Scenario: CoinMarketcapExample
    Given I get CrytocurrencyMap information for "/cryptocurrency/map" by API Key "" with query parameters as
    |start|limit|
    |1    |50   |