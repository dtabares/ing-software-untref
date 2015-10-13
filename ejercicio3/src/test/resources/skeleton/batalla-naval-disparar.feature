Feature: Disparar

  Scenario: Disparo en una posicion dentro del tablero pero vacia
    Given la posicion (C,5) del mapa esta libre
    When realizo un disparo a la posicion (C,5)
    Then el resultado es Agua

  Scenario: Disparo en una posicion fuera del tablero
    Given el tablero es de 10 x 10
    When realizo un disparo a la posicion (C,15)
    Then el resultado es Disparo Fuera del Tablero No permitido

  Scenario: Disparo en una posicion con un barco pero no lo hundo
    Given la posicion (C,5) del mapa tiene un acorazado
    When realizo un disparo a la posicion (C,5)
    Then el resultado es Tocado
