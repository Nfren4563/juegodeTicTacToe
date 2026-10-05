package TicTacToe;

public class logica {

    private String[][] tablero = new String[3][3];
    private boolean turnoX = true;

    public logica() {
        reiniciar();
    }

    public boolean turnoX() {
        return turnoX;
    }

    public boolean hacerMovimiento(int fila, int col) {
        if (tablero[fila][col].equals("")) {
            tablero[fila][col] = turnoX ? "X" : "O";
            turnoX = !turnoX;
            return true;
        }
        return false;
    }

    public String getValor(int fila, int col) {
        return tablero[fila][col];
    }

    public String verificarGanador() {
        for (int i = 0; i < 3; i++) {
            if (!tablero[i][0].equals("")
                    && tablero[i][0].equals(tablero[i][1])
                    && tablero[i][1].equals(tablero[i][2])) {
                return tablero[i][0];
            }
            if (!tablero[0][i].equals("")
                    && tablero[0][i].equals(tablero[1][i])
                    && tablero[1][i].equals(tablero[2][i])) {
                return tablero[0][i];
            }
        }

        if (!tablero[0][0].equals("")
                && tablero[0][0].equals(tablero[1][1])
                && tablero[1][1].equals(tablero[2][2])) {
            return tablero[0][0];
        }
        if (!tablero[0][2].equals("")
                && tablero[0][2].equals(tablero[1][1])
                && tablero[1][1].equals(tablero[2][0])) {
            return tablero[0][2];
        }

        if (empate()) {
            return "Empate";
        }
        return null;
    }

    private boolean empate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j].equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void reiniciar() {
        turnoX = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = "";
            }
        }
    }
}
