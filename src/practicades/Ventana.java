package practicades;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Ventana extends javax.swing.JFrame {
    byte[] iv = {1, 2, 3, 4, 5, 6, 7, 8};
    String ruta;
    BufferedImage img;

    public Ventana() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpCifDescif = new javax.swing.ButtonGroup();
        btnAbrir = new javax.swing.JButton();
        lblRuta = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JPanel();
        lblOpcion = new javax.swing.JLabel();
        radCifrar = new javax.swing.JRadioButton();
        radDecifrar = new javax.swing.JRadioButton();
        lblModoOperacion = new javax.swing.JLabel();
        comboModoOperacion = new javax.swing.JComboBox<>();
        panelCampos = new javax.swing.JPanel();
        txtiv0 = new javax.swing.JTextField();
        txtiv3 = new javax.swing.JTextField();
        txtiv5 = new javax.swing.JTextField();
        txtiv6 = new javax.swing.JTextField();
        txtiv7 = new javax.swing.JTextField();
        lblC0 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        lblClave = new javax.swing.JLabel();
        txtiv4 = new javax.swing.JTextField();
        txtiv2 = new javax.swing.JTextField();
        txtiv1 = new javax.swing.JTextField();
        panelBoton = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        panelImagenes = new javax.swing.JPanel();
        lblIMGOriginal = new javax.swing.JLabel();
        lblFlecha = new javax.swing.JLabel();
        lblIMGNueva = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnAbrir.setText("Seleccionar imagen...");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        lblRuta.setText("Ningún archivo seleciconado...");

        lblOpcion.setText("Selecicona una opción");

        grpCifDescif.add(radCifrar);
        radCifrar.setSelected(true);
        radCifrar.setText("Cifrar");
        radCifrar.setToolTipText("");

        grpCifDescif.add(radDecifrar);
        radDecifrar.setText("Descifrar");

        lblModoOperacion.setText("Selecciona un modo de operación");

        comboModoOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ECB (Electronic Codebook)", "CBC (Cipher Block Chaining)", "CFB (Cipher Feedback)", "OFB (Output Feedback)" }));
        comboModoOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboModoOperacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radDecifrar)
                    .addComponent(radCifrar)
                    .addComponent(lblOpcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblModoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboModoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addComponent(lblOpcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radCifrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radDecifrar))
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addComponent(lblModoOperacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboModoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtiv0.setEditable(false);
        txtiv0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtiv0ActionPerformed(evt);
            }
        });
        txtiv0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtiv0KeyTyped(evt);
            }
        });

        txtiv3.setEditable(false);
        txtiv3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtiv3KeyTyped(evt);
            }
        });

        txtiv5.setEditable(false);
        txtiv5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtiv5KeyTyped(evt);
            }
        });

        txtiv6.setEditable(false);
        txtiv6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtiv6ActionPerformed(evt);
            }
        });
        txtiv6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtiv6KeyTyped(evt);
            }
        });

        txtiv7.setEditable(false);
        txtiv7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtiv7KeyTyped(evt);
            }
        });

        lblC0.setText("C0:");

        lblClave.setText("Clave (8 caractéres mínimo)");

        txtiv4.setEditable(false);
        txtiv4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtiv4KeyTyped(evt);
            }
        });

        txtiv2.setEditable(false);
        txtiv2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtiv2ActionPerformed(evt);
            }
        });
        txtiv2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtiv2KeyTyped(evt);
            }
        });

        txtiv1.setEditable(false);
        txtiv1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtiv1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelCamposLayout = new javax.swing.GroupLayout(panelCampos);
        panelCampos.setLayout(panelCamposLayout);
        panelCamposLayout.setHorizontalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtClave)
                    .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblC0)
                        .addComponent(lblClave)
                        .addGroup(panelCamposLayout.createSequentialGroup()
                            .addComponent(txtiv0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtiv1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtiv2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtiv3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtiv4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtiv5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtiv6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtiv7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelCamposLayout.setVerticalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblC0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtiv0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtiv3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtiv5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtiv6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtiv7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtiv4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtiv2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtiv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonLayout = new javax.swing.GroupLayout(panelBoton);
        panelBoton.setLayout(panelBotonLayout);
        panelBotonLayout.setHorizontalGroup(
            panelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonLayout.createSequentialGroup()
                .addGap(435, 435, 435)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(436, Short.MAX_VALUE))
        );
        panelBotonLayout.setVerticalGroup(
            panelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelImagenes.setMinimumSize(new java.awt.Dimension(300, 900));
        panelImagenes.setLayout(new java.awt.GridLayout(1, 0));
        panelImagenes.add(lblIMGOriginal);

        lblFlecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelImagenes.add(lblFlecha);
        panelImagenes.add(lblIMGNueva);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAbrir)
                        .addGap(18, 18, 18)
                        .addComponent(lblRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelBoton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(panelImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir)
                    .addComponent(lblRuta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        img = null;
        abrirArchivo();
        lblClave.setText("Clave (8 caractéres mínimo)");
        if (ruta != null) {
            try {
                lblRuta.setText(ruta);
                img = ImageIO.read(new File(ruta));
                lblIMGOriginal.setIcon(new ImageIcon(img.getScaledInstance(300, 300, img.SCALE_SMOOTH)));
                lblFlecha.setText("\t-------------------------->\t");
            } catch (IOException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Archivo no válido");
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void comboModoOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboModoOperacionActionPerformed
        if (comboModoOperacion.getSelectedIndex() == 0) {
            txtiv0.setEditable(false);
            txtiv1.setEditable(false);
            txtiv2.setEditable(false);
            txtiv3.setEditable(false);
            txtiv4.setEditable(false);
            txtiv5.setEditable(false);
            txtiv6.setEditable(false);
            txtiv7.setEditable(false);
        } else {
            txtiv0.setEditable(true);
            txtiv1.setEditable(true);
            txtiv2.setEditable(true);
            txtiv3.setEditable(true);
            txtiv4.setEditable(true);
            txtiv5.setEditable(true);
            txtiv6.setEditable(true);
            txtiv7.setEditable(true);
        }
    }//GEN-LAST:event_comboModoOperacionActionPerformed

    private void txtiv6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtiv6ActionPerformed
    }//GEN-LAST:event_txtiv6ActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        try {
            Imagen archivo = new Imagen(ruta);
            ModosOperacion modo = new ModosOperacion(archivo.abrir());
            String ext = "";
            byte[] resultado = null;
            boolean banderaClave = true;
            //Se genera una llave aleatoria por si el usuario no ingreso una
            KeyGenerator generadorDES = KeyGenerator.getInstance("DES");
            generadorDES.init(56);//tamaño de la clave des=56
            SecretKey clave = generadorDES.generateKey();
            String llave = Base64.getEncoder().encodeToString(clave.getEncoded());
            //Paso1: Verificar clave para cifrar
            if (radCifrar.isSelected()) {
                if (txtClave.getText().equals("") || txtClave.getText().length() < 8) {
                    lblClave.setText("Clave generada aleatoriamente:");
                    txtClave.setText(llave);
                } else {
                    llave = txtClave.getText();
                }
            } else {
                if (txtClave.getText().length() < 8) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa una clave válida");
                    banderaClave = false;
                } else {
                    llave = txtClave.getText();
                }
            }

            //Paso 2 verificar Iv cuando sea necesario
            if (comboModoOperacion.getSelectedIndex() != 0) { //modo seleccionado no es ecb
                if (!(txtiv0.getText().equals("") && txtiv1.getText().equals("") && txtiv2.getText().equals("")
                        && txtiv3.getText().equals("") && txtiv4.getText().equals("") && txtiv5.getText().equals("")
                        && txtiv6.getText().equals("") && txtiv7.getText().equals(""))) {
                    iv[0] = (byte) Integer.parseInt(txtiv0.getText());
                    iv[1] = (byte) Integer.parseInt(txtiv1.getText());
                    iv[2] = (byte) Integer.parseInt(txtiv2.getText());
                    iv[3] = (byte) Integer.parseInt(txtiv3.getText());
                    iv[4] = (byte) Integer.parseInt(txtiv4.getText());
                    iv[5] = (byte) Integer.parseInt(txtiv5.getText());
                    iv[6] = (byte) Integer.parseInt(txtiv6.getText());
                    iv[7] = (byte) Integer.parseInt(txtiv7.getText());
                }
            }
            //Paso 3: Cifrar/Descifrar
            if (banderaClave) {
                switch (comboModoOperacion.getSelectedIndex()) {
                    case 0: //ecb
                        resultado = modo.obtenerECB(radCifrar.isSelected(), llave);
                        ext = "_ECB.bmp";
                        break;
                    case 1: // cbc
                        resultado = modo.obtenerCBC(radCifrar.isSelected(), llave, iv);
                        ext = "_CBC.bmp";
                        break;
                    case 2: //cfb
                        resultado = modo.obtenerCFB(radCifrar.isSelected(), llave, iv);
                        ext = "_CFB.bmp";
                        break;
                    case 3://ofb
                        resultado = modo.obtenerOFB(radCifrar.isSelected(), llave, iv);
                        ext = "_OFB.bmp";
                        break;
                }
                archivo.guardar(resultado, ext);
                img = ImageIO.read(new File(ruta.replaceAll(".bmp", ext)));
                lblIMGNueva.setIcon(new ImageIcon(img.getScaledInstance(300, 300, img.SCALE_SMOOTH)));

            }

        } catch (NoSuchAlgorithmException | IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnOKActionPerformed

    private void txtiv0KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtiv0KeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtiv0KeyTyped

    private void txtiv0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtiv0ActionPerformed
    }//GEN-LAST:event_txtiv0ActionPerformed

    private void txtiv1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtiv1KeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtiv1KeyTyped

    private void txtiv2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtiv2KeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtiv2KeyTyped

    private void txtiv3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtiv3KeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtiv3KeyTyped

    private void txtiv4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtiv4KeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtiv4KeyTyped

    private void txtiv2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtiv2ActionPerformed
    }//GEN-LAST:event_txtiv2ActionPerformed

    private void txtiv5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtiv5KeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtiv5KeyTyped

    private void txtiv6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtiv6KeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtiv6KeyTyped

    private void txtiv7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtiv7KeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtiv7KeyTyped

    private void abrirArchivo() {
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(this);
        File abre = file.getSelectedFile();
        if (abre != null) {
            ruta = abre.getAbsolutePath();
        } else {
            ruta = null;
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox<String> comboModoOperacion;
    private javax.swing.ButtonGroup grpCifDescif;
    private javax.swing.JLabel lblC0;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblFlecha;
    private javax.swing.JLabel lblIMGNueva;
    private javax.swing.JLabel lblIMGOriginal;
    private javax.swing.JLabel lblModoOperacion;
    private javax.swing.JLabel lblOpcion;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JPanel panelBoton;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JPanel panelImagenes;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JRadioButton radCifrar;
    private javax.swing.JRadioButton radDecifrar;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtiv0;
    private javax.swing.JTextField txtiv1;
    private javax.swing.JTextField txtiv2;
    private javax.swing.JTextField txtiv3;
    private javax.swing.JTextField txtiv4;
    private javax.swing.JTextField txtiv5;
    private javax.swing.JTextField txtiv6;
    private javax.swing.JTextField txtiv7;
    // End of variables declaration//GEN-END:variables
}
