
package views;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import controller.MainController;
import model.Cliente;
import model.ClientesHasLesion;
import model.Lesion;
import model.Objetivo;
import model.ObjetivosHasEjercicio;

public class Formulario extends javax.swing.JFrame {
    
	// Variables declaration

 
	private MainController mainController ; 
    private javax.swing.JTextField altura;
    private javax.swing.JTextField apellidos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton continuar;
    private javax.swing.JComboBox dias;
    private javax.swing.JComboBox co_progreso;
    private javax.swing.JTextField dni;
    private javax.swing.JTextField edad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lesiones1;
    private javax.swing.JList lesiones2;
    private javax.swing.JTextField nombre;
    private javax.swing.JComboBox objetivo;
    private javax.swing.JTextField peso;
    private javax.swing.JTextField pulsaciones;
    private javax.swing.JComboBox r_aerobica;
    private javax.swing.JComboBox r_anaerobica_inf;
    private javax.swing.JComboBox r_anaerobica_sup;
    private javax.swing.JComboBox r_anaerobica_ab;
	private DefaultListModel model2 ;
	private DefaultListModel model1 ;
	private float IMC ;
	private JPanel jPanel1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JLabel jLabel10;
	private JLabel jLabel11;
	private JLabel jLabel12;
	private JLabel jLabel13;
	private JLabel jLabel14;
	private JLabel jLabel15;
	private JLabel jLabel16;
	private JLabel jLabel17;
	private JLabel jLabel7;
	

    
    public Formulario() {
        initComponents();
		this.introducirLesiones();
    }
    
	
	private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        apellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        peso = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        altura = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        objetivo = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        pulsaciones = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lesiones1 = new javax.swing.JList();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        dias = new javax.swing.JComboBox();
        co_progreso = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        r_aerobica = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        r_anaerobica_sup = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        r_anaerobica_ab = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        r_anaerobica_inf = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lesiones2 = new javax.swing.JList();
        cancelar = new javax.swing.JButton();
        continuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BroFit");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos usuario"));

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellidos");

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        jLabel3.setText("Edad:");

        edad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edadActionPerformed(evt);
            }
        });

        jLabel4.setText("DNI:");

        dni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniActionPerformed(evt);
            }
        });

        jLabel6.setText("Peso");

        peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesoActionPerformed(evt);
            }
        });

        jLabel7.setText("Altura");

        altura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alturaActionPerformed(evt);
            }
        });

        jLabel8.setText("Kg");

        jLabel9.setText("m");

        jLabel5.setText("Objetivo");

        objetivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tonificacion", "Hipertrofia", "Perdida de peso", "Mantenimiento" }));
        objetivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objetivoActionPerformed(evt);
            }
        });

        jLabel10.setText("Pulsaciones en reposo");

        pulsaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsacionesActionPerformed(evt);
            }
        });

        lesiones1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lesiones1);

        jLabel11.setText("Lesiones");

        jButton1.setText("(Grave) -->");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLesionGrave(evt);
            }
        });

        jButton2.setText("<--");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel12.setText("Días de entrenamiento/semana");

        dias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        dias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diasActionPerformed(evt);
            }
        });
        
        jLabel17.setText("Coeficiente de progreso");

        co_progreso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5","6","7","8","9","10" }));
        co_progreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coProgresoActionPerformed(evt);
            }
        });


        jLabel13.setText("Resultado prueba aerÃ³bica");

        r_aerobica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Muy mala", "Mala", "Regular", "Buena", "Muy Buena" }));
        r_aerobica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_aerobicaActionPerformed(evt);
            }
        });

        jLabel14.setText("Resultado prueba anaerÃ³bica sup.");

        r_anaerobica_sup.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Muy mala", "Mala", "Regular", "Buena", "Muy Buena" }));
        r_anaerobica_sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_anaerobica_supActionPerformed(evt);
            }
        });

        jLabel15.setText("Resultado prueba anaerÃ³bica inf.");

        r_anaerobica_inf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Muy mala", "Mala", "Regular", "Buena", "Muy Buena" }));
        r_anaerobica_inf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_anaerobica_infActionPerformed(evt);
            }
        });
        
        jLabel16.setText("Resultado prueba anaeróbica Ab.");

        r_anaerobica_ab.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Muy mala", "Mala", "Regular", "Buena", "Muy Buena" }));
        r_anaerobica_ab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_anaerobica_abActionPerformed(evt);
            }
        });


        jButton3.setText("(Leve) -->");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLesionLeve(evt);
            }
        });

        lesiones2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(lesiones2);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(objetivo,  GroupLayout.PREFERRED_SIZE, 139,  GroupLayout.PREFERRED_SIZE))
                                            .addGroup( GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(peso,  GroupLayout.PREFERRED_SIZE, 44,  GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel7)
                                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(altura,  GroupLayout.PREFERRED_SIZE, 40,  GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)))
                                .addGap(62, 62, 62))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1,  GroupLayout.PREFERRED_SIZE, 135,  GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jButton2))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12,  GroupLayout.PREFERRED_SIZE, 150,  GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dias,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel17,  GroupLayout.PREFERRED_SIZE, 150,  GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(co_progreso,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                            .addComponent(edad,  GroupLayout.PREFERRED_SIZE, 44,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre,  GroupLayout.PREFERRED_SIZE, 206,  GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2,  GroupLayout.PREFERRED_SIZE, 224,  GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(30, 30, 30)
                            .addComponent(r_aerobica, 0,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4))
                                    .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                                        .addComponent(apellidos,  GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                        .addComponent(dni)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addComponent(pulsaciones,  GroupLayout.PREFERRED_SIZE, 44,  GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel15)
                                .addComponent(jLabel16))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                                .addComponent(r_anaerobica_inf,  GroupLayout.PREFERRED_SIZE, 92,  GroupLayout.PREFERRED_SIZE)
                                .addComponent(r_anaerobica_sup,  GroupLayout.PREFERRED_SIZE, 92,  GroupLayout.PREFERRED_SIZE)
                                .addComponent(r_anaerobica_ab,  GroupLayout.PREFERRED_SIZE, 92,  GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(apellidos,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dni,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(edad,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(peso,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(pulsaciones,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(altura,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(objetivo,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(r_aerobica,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(r_anaerobica_sup,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(r_anaerobica_inf,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(r_anaerobica_ab,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(dias,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(co_progreso,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(8, 8, 8)))
                .addGroup(jPanel1Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1,  GroupLayout.PREFERRED_SIZE, 109,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2,  GroupLayout.PREFERRED_SIZE, 109,  GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton3)
                        .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        cancelar.setText("Cancel");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        continuar.setText("OK");
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarActionPerformed(evt);
            }
        });

        GroupLayout layout = new  GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap( GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(continuar)
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelar)
                .addContainerGap())
            .addComponent(jPanel1,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(new java.awt.Component[] {cancelar, continuar});

        layout.setVerticalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(continuar))
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("usuario");

        pack();
    }

    private void r_anaerobica_infActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_anaerobica_infActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_anaerobica_infActionPerformed
    private void r_anaerobica_abActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_anaerobica_infActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_anaerobica_infActionPerformed

    private void r_anaerobica_supActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_anaerobica_supActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_anaerobica_supActionPerformed

    private void r_aerobicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_aerobicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_aerobicaActionPerformed

    private void pulsacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pulsacionesActionPerformed

    private void objetivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objetivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objetivoActionPerformed

    private void alturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alturaActionPerformed

    private void pesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesoActionPerformed

    private void dniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniActionPerformed

    private void edadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edadActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    
    
    private void diasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diasActionPerformed
    private void coProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diasActionPerformed

    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed

		if(this.camposCompletos()){
			try{
				this.calcularIMC();
			}catch(Exception e ){
				JOptionPane.showMessageDialog(this,"datos erroneos");
				return;}
			System.out.println(IMC);
			if(objetivo.getSelectedItem().equals("Hipertrofia")&& dias.getSelectedIndex()+1<3){
				JOptionPane.showMessageDialog(this,"No se pueden seleccionar menos de 3 días con el objetivo de Hipertrofia"+dias.getSelectedIndex());
			}
			else if(!(objetivo.getSelectedItem().equals("Hipertrofia"))&& IMC<18.5){
				JOptionPane.showMessageDialog(this,"IMC MENOR DE 18.5 , IMC ="+IMC);
			}
			else{
				this.ejecutarSystema();
			}
		}else{
			JOptionPane.showMessageDialog(this,"Datos incompletos");
		}

    }

    private void calcularIMC() {
		IMC = Float.parseFloat(peso.getText()) / (Float.parseFloat(altura.getText())*Float.parseFloat(altura.getText()));
	}


	private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
    }
    
    
    public static void main(String args[]) {
      
        try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels=javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx=0; idx<installedLookAndFeels.length; idx++)
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }
    
    

	
	private void removeLesion(int index,boolean derecha) {
		if(derecha){
			model1.remove(index);
		}
		else model2.remove(index);
	}

	private boolean camposCompletos() {

		boolean result = true;
		
		if(nombre.getText().isEmpty()) result=false;
		else if(apellidos.getText().isEmpty()) result=false;
		else if (edad.getText().isEmpty())result=false;
		else if (dni.getText().isEmpty())result=false;
		else if (peso.getText().isEmpty())result=false;
		else if (altura.getText().isEmpty())result=false;
		else if (pulsaciones.getText().isEmpty())result=false;
		
		return result;
	
	}

	private void ejecutarSystema() {
		
		Cliente cliente = new Cliente();
		if(setCliente(cliente)){
			
			if(this.insertarLesiones(cliente)){
				
				

				int index = objetivo.getSelectedIndex()+1;
				try{
					
					Objetivo objetive = new Objetivo();
					objetive = objetive.findObjetive(index);
					mainController = new MainController(cliente,objetive).run();
					Resultado resultado = new Resultado();
					resultado.main(null);
					
				}catch(NullPointerException ex ){System.out.println("nulo");}
			}
			
		}
		else{
			//TODO: fallo al introducir datos
		}
		
	}

	private boolean insertarLesiones(Cliente cliente) {
		boolean result = true;
		//TODO 0 = LEVE , 1 = GRAVE
		try{
			if(model2.getSize() >0){cliente.setClientesHasLesiones(new ArrayList<ClientesHasLesion>());}
			for(int i =0; i<model2.getSize();i++){
				ClientesHasLesion clientesHasLesion = new ClientesHasLesion();
				clientesHasLesion.setCliente(cliente);
				String aux = model2.getElementAt(i).toString();
				String lesion = aux.substring(0,aux.indexOf("("));
				String gravedad= aux.substring(aux.indexOf("("),aux.length());
				if(gravedad=="(Grave)"){
					clientesHasLesion.setGravedadLesion(1);
				}
				else{
					clientesHasLesion.setGravedadLesion(0);
				}
				//TODO NO SE COMO SELECCIONAR LA LESION
				clientesHasLesion.setLesione(new Lesion());
				
				cliente.addClientesHasLesione(clientesHasLesion);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			result = false;
		}
		
		return result;
	}


	private boolean setCliente(Cliente cliente) {
		cliente.setIdCliente(1);//TODO: hallar id cliente al insertar el cliente
		try{
			cliente.setEdad(Integer.valueOf(edad.getText()));
			cliente.setAerobica(r_aerobica.getSelectedIndex()+1);
			cliente.setAltura(Integer.valueOf(altura.getText()));
			cliente.setPeso(Integer.valueOf(peso.getText()));
			cliente.setDiasSemana(dias.getSelectedIndex()+1);
			cliente.getFr();
			cliente.setAnaerobicaA(r_anaerobica_ab.getSelectedIndex()+1);
			cliente.setAnaerobicaI(r_anaerobica_inf.getSelectedIndex()+1);
			cliente.setAnaerobicaS(r_anaerobica_sup.getSelectedIndex()+1);
			cliente.setCoeficienteProgreso(Float.valueOf(co_progreso.getSelectedIndex()+1)*0.1f);
						
		}catch(Exception ex ){
			ex.printStackTrace();
			JOptionPane.showConfirmDialog(this,"datos con formato incorrecto");
			return false;
		}
		return true;
				
	}


	private void addLesionLeve(java.awt.event.ActionEvent evt) {
        
		int index = lesiones1.getSelectedIndex();
		if(	!this.LesionSelect(model1.getElementAt(index).toString())){
			model2.add(model2.getSize(), model1.getElementAt(index).toString()+"(Leve)");
			this.removeLesion(index,true);
		}
    }

    private void addLesionGrave(java.awt.event.ActionEvent evt) {

		try{
			int index = lesiones1.getSelectedIndex();
			if(	!this.LesionSelect(model1.getElementAt(index).toString())){
				model2.add(model2.getSize(), model1.getElementAt(index).toString()+"(Grave)");
				this.removeLesion(index,true);
			}
		}catch(java.lang.ArrayIndexOutOfBoundsException ex){
			ex.printStackTrace();
		}
		
    }//GEN-LAST:event_addLesionGrave
    private void introducirLesiones() {
		model1= new DefaultListModel();
		model1.addElement("Pubalgia");
		model1.addElement("Sobrecarga piramidal");
		model1.addElement("Pubalgia1");
		model1.addElement("Pubalgia2");
		model2 = new DefaultListModel();
		lesiones2.setModel(model2);
		lesiones1.setModel(model1);
		
		this.cargarDatos();

	}
	private boolean LesionSelect(String valor){
		boolean result = false;
		for(int i =0 ; i<model2.getSize();i++){
			
			if(model2.get(i).toString().equals(valor+"(Grave)")||model2.get(i).toString().equals(valor+"(Leve)")){
				result=true;
			}
		}
		
		return result;
	}
	private void addLessionGrave(java.awt.event.ActionEvent evt){
		try{

			int index = lesiones1.getSelectedIndex();
			if(	!this.LesionSelect(model1.getElementAt(index).toString())){
				model2.add(model2.getSize(), model1.getElementAt(index).toString()+"(Grave)");
				this.removeLesion(index,true);
			}
		}catch( java.lang.ArrayIndexOutOfBoundsException ex){
			ex.printStackTrace();
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

		try{
			int index = lesiones2.getSelectedIndex();
			if(	!this.LesionSelect(model1.getElementAt(index).toString())){
				String aux = model2.getElementAt(index).toString();
				String lesion = aux.substring(0,aux.indexOf("("));
				model1.add(model1.getSize(), lesion);
				this.removeLesion(index,false);
			}
		}catch(java.lang.ArrayIndexOutOfBoundsException ex){ex.printStackTrace();}
    }
	
	private void calcularEstresglobal(){
		//calcular extreses con las tablas inventadas por diego
		int estres_an_inf=0;
		int estres_an_sup=0;
		int estres_an_ab=0;
		int estres_ae=0;
		
		int estres_global = (estres_an_inf+estres_an_sup+estres_an_ab+estres_ae)*(co_progreso.getSelectedIndex()+1);
		
	}
	
	private void cargarDatos(){
		
		nombre.setText("dsasad");
		apellidos.setText("jdaskl");
		edad.setText("12");
		dni.setText("jasld");
		peso.setText("78");
		altura.setText("1");
		pulsaciones.setText("45");
	}

}
