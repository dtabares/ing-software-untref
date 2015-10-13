Feature: Disparar

  Scenario: Disparo en una posicion dentro del tablero pero vacia
    Given la posicion (C,5) del mapa esta libre
    When realizo un disparo a la posicion (C,5)
    Then el resultado es Agua
