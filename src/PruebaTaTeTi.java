
import java.util.concurrent.TimeUnit;

public class PruebaTaTeTi {
    public static void main(String[] args) throws InterruptedException {
        TaTeTi jugar = new TaTeTi();
        jugar.mostrarPaginaInicial();
        jugar.crearYLlenarTablero();
        jugar.mostrarTablero();
        //La maxima cantidad de jugadas son 9. Asi que si ningún jugador gana,
        //y ya se hicieron 9 movimientos, habrá un empate.
        int contadorDeJugadas = 0;
        while(true) {
            jugar.mensajeTurnoJugador();
            jugar.movimientoJugador();
            jugar.mostrarTablero();
            contadorDeJugadas++;
            if(jugar.haGanado('o')) {
                jugar.mensajeGanador();
                break;
            } else {
                if(contadorDeJugadas == 9) {
                    jugar.mensajeDeEmpate();
                    break;
                }
            }
            jugar.mensajeTurnoComputadora();
            jugar.movimientoComputadora();
            contadorDeJugadas++;
            //Usamos sleep para que demore unos segundos la impresión del tablero cuando es el turno de la computadora
            TimeUnit.SECONDS.sleep(2);
            jugar.mostrarTablero();
            if(jugar.haGanado('x')) {
                jugar.mensajePerdedor();
                break;
            } else {
                if(contadorDeJugadas == 9) {
                    jugar.mensajeDeEmpate();
                    break;

                }
            }
        }
    }
}
