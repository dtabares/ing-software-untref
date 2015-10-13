Feature: PosicionarFigura

  Scenario: Posiciono satisfactoriamente un destructor en el tablero en una posicion que estaba libre
    Given la posicion (C,5) esta libre y la posicion (C,6) esta libre
    When jugador posiciona la figura "destructor" en la posicion (C,5) de forma "horizontal"
    Then la operacion se realiza correctamente

  Scenario: No se puede posicionar un destructor en el tablero si la posicion inicial esta ocupada
    Given la posicion (C,5) esta ocupada
    When jugador posiciona la figura "destructor" en la posicion (C,5) de forma "horizontal"
    Then no se puede posicionar un barco en una casilla ocupada

  Scenario: No se puede posicionar un destructor en el tablero si alguna posicion intermedia esta ocupada
    Given la posicion (C,5) esta ocupada
    When jugador posiciona la figura "destructor" en la posicion (B,5) de forma "horizontal"
    Then no se puede posicionar un barco en una casilla ocupada

  Scenario: No se puede posicionar un barco en una posición fuera del tablero
    Given el tablero es de 10 x 10
    When jugador posiciona la figura "destructor" en la posicion (C,11) de forma "horizontal"
    Then la posicion elegida no pertenece al tablero
