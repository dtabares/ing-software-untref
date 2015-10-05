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

  Scenario: Arriesgo una letra no acierto y pierdo el juego
    Given la palabra secreta es "auto"
    When arriesgo "F"
    Then estado es "****"
    And me quedan 6 vidas
    When arriesgo "z"
    Then estado es "****"
    And me quedan 5 vidas
    When arriesgo "h"
    Then estado es "****"
    And me quedan 4 vidas
    When arriesgo "e"
    Then estado es "****"
    And me quedan 3 vidas
    When arriesgo "i"
    Then estado es "****"
    And me quedan 2 vidas
    When arriesgo "r"
    Then estado es "****"
    And me quedan 1 vidas
    When arriesgo "P"
    Then estado es "Ahorcado"
    And me quedan 0 vidas
