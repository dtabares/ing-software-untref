Feature: PosicionarFigura

  Scenario: Posiciono un destructor en el tablero en una posicion que estaba libre
    Given la posicion (C,5) esta libre y la posicion (C,6) esta libre
    When jugador posiciona la figura "destructor" en la posicion (C,5) de forma "horizontal"
    Then la operacion se realiza correctamente

  Scenario: Posiciono un destructor en el tablero en una posicion que estaba ocupada
    Given la posicion (C,5) esta ocupada
    When jugador posiciona la figura "destructor" en la posicion (C,5) de forma "horizontal"
    Then no se puede posicionar un barco en una casilla ocupada
