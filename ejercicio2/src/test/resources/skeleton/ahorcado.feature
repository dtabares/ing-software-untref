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
