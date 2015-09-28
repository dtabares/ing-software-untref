Feature: PiedaPapelOTijera

  Scenario: Piedra vs Piedra
    Given jugador1 juega PIEDRA
    When jugador2 juega PIEDRA
    Then hay empate

  Scenario: PAPEL vs PAPEL
    Given jugador1 juega PAPEL
    When jugador2 juega PAPEL
    Then hay empate
