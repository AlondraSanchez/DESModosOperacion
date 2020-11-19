package practicades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Imagen {

    private final String ruta;

    public Imagen(String ruta) {
        this.ruta = ruta;
    }

    //Recibe un arreglo de bytes y una extension para distinguir el archivo. Genera una nueva imagen
    public void guardar(byte[] info, String ext) {
        try {
            FileOutputStream imagen = new FileOutputStream(ruta.replaceAll(".bmp", ext));
            imagen.write(info);
        } catch (IOException ex) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Lee los bytes de un archivo y los retorna en un arreglo.
    public byte[] abrir() {
        FileInputStream imagen = null;
        byte[] img = null;
        ArrayList<Byte> bytes = new ArrayList<>();
        try {
            imagen = new FileInputStream(ruta);
            int valor = imagen.read();
            while (valor != -1) {
                bytes.add((byte) valor);
                valor = imagen.read();
            }
            img = new byte[bytes.size()];
            for (int i = 0; i < bytes.size(); i++) {
                img[i] = bytes.get(i);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                imagen.close();
            } catch (IOException ex) {
                Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return img;
    }

}
