Feature: PiedaPapelOTijera

  Scenario: Piedra vs Piedra
    Given jugador1 juega PIEDRA
    When jugador2 juega PIEDRA
    Then hay empate

  Scenario: PAPEL vs PAPEL
    Given jugador1 juega PAPEL
    When jugador2 juega PAPEL
    Then hay empate

  Scenario: Piedra vs Papel
    Given jugador1 juega PIEDRA
    When jugador2 juega PAPEL
    Then gana jugador2

  Scenario: Piedra vs Tijera
    Given jugador1 juega PIEDRA
    When jugador2 juega TIJERA
    Then gana jugador1

  Scenario: Papel vs Piedra
    Given jugador1 juega PAPEL
    When jugador2 juega PIEDRA
    Then gana jugador1
