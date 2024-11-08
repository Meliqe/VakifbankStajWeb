Feature: Hepsiburada'da ilk Samsung telefonunu bulma
  @hepsiburada1
  Scenario: Elektronik kısmından Samsung telefonları bulma ve fiyatını alma
    Given Kullanıcı Hepsiburada sitesine gider
    When Kullanıcı Elektronik menüsüne gelir
    And Kullanıcı Telefon & Telefon Aksesuarları kısmına gelir
    And Kullanıcı Samsung kategorisine tıklar
    Then Kullanıcı ilk ürünü ve fiyatını ekrana yazdırır

  @hepsiburada2
  Scenario: Elektronik kısmından Samsung telefonları bulma ve fiyatını alma -2
    Given Kullanıcı Hepsiburada sitesine gider
    When Kullanıcı Elektronik menüsüne gelir
    And Kullanıcı Telefon & Telefon Aksesuarları kısmına gelir
    And Kullanıcı Samsung kategorisine tıklar
    Then Kullanıcı ilk ürünü ve fiyatını ekrana yazdırır











