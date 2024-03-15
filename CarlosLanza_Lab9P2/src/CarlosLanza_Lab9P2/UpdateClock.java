
package CarlosLanza_Lab9P2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateClock extends Thread {

    private javax.swing.JLabel horaLabel;
    private javax.swing.JLabel fechaLabel;

    public UpdateClock(javax.swing.JLabel horaLabel, javax.swing.JLabel fechaLabel) {
        this.horaLabel = horaLabel;
        this.fechaLabel = fechaLabel;
    }

    @Override
    public void run() {
        while (true) {
            actualizarHora();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void actualizarHora() {
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        String hora = formatoHora.format(new Date());

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = formatoFecha.format(new Date());

        horaLabel.setText(hora);
        fechaLabel.setText(fecha);
    }
}
