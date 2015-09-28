Feature: PiedaPapelOTijera

  Scenario: Piedra vs Piedra
    Given jugador1 juega PIEDRA
    When jugador2 juega PIEDRA
    Then hay empate
