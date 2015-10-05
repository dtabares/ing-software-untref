Feature: Arriesgo una letra jugando al Ahorcado

  Scenario: Arriesgo una letra y acierto
    Given la palabra secreta es "auto"
    When arriesgo "a"
    Then estado es "a***"
    And me quedan 7 vidas

  Scenario: Arriesgo una Mayuscula letra y acierto
    Given la palabra secreta es "auto"
    When arriesgo "A"
    Then estado es "a***"
    And me quedan 7 vidas

  Scenario: Arriesgo una letra y no acierto
    Given la palabra secreta es "auto"
    When arriesgo "x"
    Then estado es "****"
    And me quedan 6 vidas

  Scenario: Arriesgo una letra acierto y gano el juego
    Given la palabra secreta es "auto"
    When arriesgo "A"
    Then estado es "a***"
    When arriesgo "U"
    Then estado es "au**"
    When arriesgo "T"
    Then estado es "aut*"
    When arriesgo "O"
    Then estado es "Ganaste"
    And me quedan 7 vidas
