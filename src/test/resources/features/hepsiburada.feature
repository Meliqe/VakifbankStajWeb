Feature: Hepsiburada'da ilk Samsung telefonunu bulma
  @hepsiburada1
  Scenario: Elektronik kısmından Samsung telefonları bulma ve fiyatını alma
    Given Kullanıcı Hepsiburada sitesine gider
    When Kullanıcı "ELEKTRONIK_MENU" menüsüne gelir
    And Kullanıcı "TELEFON_AKSESUAR_MENU" kısmına gelir
    And Kullanıcı "SAMSUNG_CATEGORY" kategorisine tıklar
    Then Kullanıcı ilk "URUN_ADI" ve "URUN_FIYATI" ekrana yazdırır

  @hepsiburada2
  Scenario: Elektronik kısmından Samsung telefonları bulma ve fiyatını alma -2
    Given Kullanıcı Hepsiburada sitesine gider
    When Kullanıcı "ELEKTRONIK_MENU" menüsüne gelir
    And Kullanıcı "TELEFON_AKSESUAR_MENU" kısmına gelir
    And Kullanıcı "SAMSUNG_CATEGORY" kategorisine tıklar
    Then Kullanıcı ilk "URUN_ADI" ve "URUN_FIYATI" ekrana yazdırır











