import java.util.Scanner;

public class TaTeTi {
    private char[][] tablero;

    //Generamos un tablero de 3x3, luego lo recorremos y en cada posición le ingresamos el guión
    //que va a representar a nuestro tablero con posiciones libres.
    void crearYLlenarTablero() {
        tablero = new char[3][3];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    //Recorremos cada posición del tablero y lo imprimimos comenzando con una barra, el valor y otra barra.
    void mostrarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print("|" + tablero[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
    }

    //Pedimos al usuario que ingrese la posición de la matriz, verificamos que esté ocupada,
    //En caso de que no esté ocupada, ingresamos el valor, si está ocupada, avisamos con un mensaje,
    //En caso de ingresar un valor fuera de la matriz, atrapamos el error con un try-catch.
    void movimientoJugador() {
        Scanner in = new Scanner(System.in);
        boolean valorIngresado = false;
        while (!valorIngresado) {
            System.out.println("Ingrese una fila entre 1 y 3");
            int fila = in.nextInt();
            in.nextLine();
            System.out.println("Ingrese una columna entre 1 y 3");
            int columna = in.nextInt();

            try {
                if (tablero[fila - 1][columna - 1] == '-') {
                    tablero[fila - 1][columna - 1] = 'o';
                    valorIngresado = true;
                } else if (tablero[fila - 1][columna - 1] == 'o' || tablero[fila - 1][columna - 1] == 'x') {
                    System.out.println("Esa posición ya esta ocupada. Intente con otra");
                }
            } catch (Exception e) {
                System.out.println("Esa posición no existe en el tablero. Intente con otra");
            }
        }
    }

    //Generamos un número aleatorio que entre dentro del tamaño de la matriz.
    //Luego verificamos que el campo esté vacio para asignarle el valor a la matriz.
    void movimientoComputadora() {
        boolean valorIngresadoMaquina = false;
        while (!valorIngresadoMaquina) {
            int fila = (int) (Math.random() * (3 - 1 + 1) + 1);
            int columna = (int) (Math.random() * (3 - 1 + 1) + 1);

            if (tablero[fila - 1][columna - 1] == '-') {
                tablero[fila - 1][columna - 1] = 'x';
                valorIngresadoMaquina = true;
            }
        }
    }

    //Verificamos si hay un ganador o no, y en el caso de que lo haya, retornamos TRUE
    boolean haGanado(char quienJuega) {
        boolean ganador = false;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][0] != '-' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                ganador = true;
                break;
            } else if (tablero[0][i] != '-' && tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]) {
                ganador = true;
                break;
            }
        }
        if (!ganador) {
            if (tablero[0][0] != '-' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] ||
                    tablero[0][2] != '-' && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
                ganador = true;
            }
        }

        if (ganador && quienJuega == 'o') {
            return true;
        } else if (ganador && quienJuega == 'x') {
            return true;
        } else {
            return false;
        }
    }

    void mostrarPaginaInicial() {
        System.out.println("--------------     --      --------------  ----------  --------------  ----");
        System.out.println("--------------    -----    --------------  ----------  --------------  ----");
        System.out.println("     ----        --   --        ----       ----             ----           ");
        System.out.println("     ----      ----------       ----       ----             ----       ----");
        System.out.println("     ----    ---------------    ----       ----------       ----       ----");
        System.out.println("     ----   ----         ----   ----       ----------       ----       ----");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("PRESIONE ENTER PARA COMENZAR A JUGAR...");
        Scanner in = new Scanner(System.in);
        in.nextLine();
    }

    void mensajeGanador() {
        System.out.println("\nFelicitaciones! Has ganado!");
        System.out.println("-----------------------------");
        System.out.println("FIN DEL JUEGO");
    }

    void mensajePerdedor() {
        System.out.println("\nOh. Has perdido! Vuelve a intentarlo.");
        System.out.println("---------------------------------------");
        System.out.println("FIN DEL JUEGO");
    }

    void mensajeDeEmpate() {
        System.out.println("\nOh. Has empatado. Casi lo logras! Vuelve a intentarlo.");
        System.out.println("--------------------------------------------------------");
        System.out.println("FIN DEL JUEGO");
    }

    void mensajeTurnoJugador() {
        System.out.println("\nEs tu turno...");
    }

    void mensajeTurnoComputadora() {
        System.out.println("\nMovimiento de la computadora...");
    }
}