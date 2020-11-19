/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicades;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user1
 */
public class ModosOperacion { //Cn = Ek(Pn)

    private final byte[] imagenBytes;
    private byte[] cabecera;
    private ArrayList<byte[]> split;

    public ModosOperacion(byte[] imagen) {
        this.imagenBytes = imagen;
        cabecera = new byte[54];
        split = new ArrayList<>();
        dividirBytes();
    }

    private void dividirBytes() {
        for (int i = 0; i < 54; i++) {
            cabecera[i] = imagenBytes[i];
        }
        byte[] bloque;
        for (int i = 54; i < imagenBytes.length; i += 8) {
            bloque = new byte[8];
            for (int j = 0; j < 8; j++) {
                if ((i + j) < imagenBytes.length) {
                    bloque[j] = imagenBytes[i + j];
                    // System.out.println(imagenBytes[i + j]);
                } else {
                    bloque[j] = 0;
                }
            }
            split.add(bloque);
        }
    }

    public byte[] obtenerECB(boolean modoCifrador, String clave) {
        try {
            ArrayList<Byte> imgCif = new ArrayList<>();
            byte[] bloqueCifrado = null;
            DES des = new DES(clave, modoCifrador);
            for (byte b : cabecera) {
                imgCif.add(b);
            }
            for (int i = 0; i < split.size() - 1; i++) {
                bloqueCifrado = des.hacerDES(split.get(i));
                for (byte b : bloqueCifrado) {
                    imgCif.add(b);
                }
            }

            bloqueCifrado = des.finalizar(split.get(split.size() - 1));
            for (byte b : bloqueCifrado) {
                imgCif.add(b);
            }

            byte[] imagen = new byte[imgCif.size()];

            for (int i = 0; i < imgCif.size(); i++) {
                imagen[i] = imgCif.get(i);
            }
            return imagen;

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ModosOperacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public byte[] xor(byte[] a, byte[] b) {
        byte[] resultado = new byte[a.length];
        int i = 0;
        for (byte c : a) {
            resultado[i] = (byte) (c ^ b[i++]);
        }
        return resultado;
    }

    public byte[] obtenerCBC(boolean modoCifrador, String clave, byte[] iv) {
        try {
            ArrayList<Byte> imgCif = new ArrayList<>();
            byte[] bloqueCifrado = iv;
            byte[] aux = null;
            DES des = new DES(clave, modoCifrador);
            for (byte b : cabecera) {
                imgCif.add(b);
            }
            if (modoCifrador) {
                for (int i = 0; i < split.size() - 1; i++) {
                    aux = xor(bloqueCifrado, split.get(i));
                    bloqueCifrado = des.hacerDES(aux);
                    for (byte b : bloqueCifrado) {
                        imgCif.add(b);
                    }
                }
                aux = xor(bloqueCifrado, split.get(split.size() - 1));
                bloqueCifrado = des.finalizar(aux);
                for (byte b : bloqueCifrado) {
                    imgCif.add(b);
                }
            } else {
                split.add(0, iv);
                for (int i = 1; i < split.size() - 1; i++) {
                    des.hacerDES(split.get(i));
                    bloqueCifrado = des.hacerDES(split.get(i));
                    aux = xor(split.get(i - 1), bloqueCifrado);
                    for (byte b : aux) {
                        imgCif.add(b);
                    }
                }
                bloqueCifrado = des.finalizar(split.get(split.size() - 1));
                aux = xor(split.get(split.size() - 2), bloqueCifrado);
                for (byte b : aux) {
                    imgCif.add(b);
                }

            }
            byte[] imagen = new byte[imgCif.size()];

            for (int i = 0; i < imgCif.size(); i++) {
                imagen[i] = imgCif.get(i);
            }
            return imagen;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ModosOperacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public byte[] obtenerCFB(boolean modoCifrador, String clave, byte[] iv) {
        try {
            ArrayList<Byte> imgCif = new ArrayList<>();
            byte[] bloqueCifrado = iv;
            byte[] ultimobloque = {0, 0, 0, 0, 0, 0, 0, 0};
            byte[] aux = null;
            DES des = new DES(clave, true);
            for (byte b : cabecera) {
                imgCif.add(b);
            }
            if (modoCifrador) {
                for (int i = 0; i < split.size() - 1; i++) {
                    aux = des.hacerDES(bloqueCifrado);
                    bloqueCifrado = xor(aux, split.get(i));
                    for (byte b : bloqueCifrado) {
                        imgCif.add(b);
                    }
                }
                aux = des.finalizar(bloqueCifrado);

                System.arraycopy(aux, 0, ultimobloque, 0, 8);
                bloqueCifrado = xor(ultimobloque, split.get(split.size() - 1));
                System.arraycopy(bloqueCifrado, 0, aux, 0, 8);
                for (byte b : aux) {
                    imgCif.add(b);
                }
            } else {
                split.add(0, iv);
                for (int i = 0; i < split.size() - 1; i++) {
                    aux = des.hacerDES(split.get(i));
                    bloqueCifrado = xor(aux, split.get(i + 1));
                    for (byte b : bloqueCifrado) {
                        imgCif.add(b);
                    }
                }
                aux = des.finalizar(split.get(split.size() - 2));
                System.arraycopy(aux, 0, ultimobloque, 0, 8);
                bloqueCifrado = xor(ultimobloque, split.get(split.size() - 1));
                System.arraycopy(bloqueCifrado, 0, aux, 0, 8);
                for (byte b : aux) {
                    imgCif.add(b);
                }
            }
            byte[] imagen = new byte[imgCif.size()];

            for (int i = 0; i < imgCif.size(); i++) {
                imagen[i] = imgCif.get(i);
            }
            return imagen;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ModosOperacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public byte[] obtenerOFB(boolean modoCifrador, String clave, byte[] iv) {
        try {
            ArrayList<Byte> imgCif = new ArrayList<>();
            byte[] bloqueCifrado = null;
            byte[] aux = iv;
            byte[] ultimobloque = {0, 0, 0, 0, 0, 0, 0, 0};
            DES des = new DES(clave, true);
            for (byte b : cabecera) {
                imgCif.add(b);
            }
            for (int i = 0; i < split.size() - 1; i++) {
                aux = des.hacerDES(aux);
                bloqueCifrado = xor(aux, split.get(i));
                for (byte b : bloqueCifrado) {
                    imgCif.add(b);
                }
            }

            aux = des.finalizar(aux);
            System.arraycopy(aux, 0, ultimobloque, 0, 8);
            bloqueCifrado = xor(ultimobloque, split.get(split.size() - 1));
            System.arraycopy(bloqueCifrado, 0, aux, 0, 8);
            for (byte b : bloqueCifrado) {
                imgCif.add(b);
            }

            byte[] imagen = new byte[imgCif.size()];

            for (int i = 0; i < imgCif.size(); i++) {
                imagen[i] = imgCif.get(i);
            }
            return imagen;

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ModosOperacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
