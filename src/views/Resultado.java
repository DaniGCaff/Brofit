package views;

import javax.persistence.EntityManager;

import org.jgap.Gene;
import org.jgap.IChromosome;

import algorithm.BroFitnessParams;
import genes.EjercicioGene;
import model.Ejercicio;

/**
 *
 * @author borja
 */
public class Resultado extends javax.swing.JFrame {

	
	public Resultado(IChromosome solucion, BroFitnessParams params, EntityManager em) {
		initComponents();
		this.insertarDatosSolucion(solucion, params, em);
		this.setVisible(true);
	}
	public Resultado() {
		initComponents();
		this.jLabel1.setText("Calculando");
		this.setVisible(true);
	}



	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        volver = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("jLabel1");
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); 
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); 
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); 
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);


        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jLabel3.setText("jLabel3");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(volver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salir)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volver)
                    .addComponent(salir))
                .addGap(7, 7, 7))
        );

        pack();
    }
	
	private void volverActionPerformed(java.awt.event.ActionEvent evt) {                                       
    	Formulario formulario = new Formulario();
    	formulario.main(null);
    	this.setVisible(false);
    }                                      

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {                                      
    	System.exit(0);
    }                                     

	/**
	 * @param args the command line arguments
	 */
	public  void main(IChromosome solucion, BroFitnessParams params, EntityManager em) {
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
        		new Resultado( solucion, params, em).setVisible(true);
            }
        });

			
	}
	public  void main() {
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
        		new Resultado().setVisible(true);
            }
        });

			
	}
	
	public void insertarDatosSolucion( IChromosome solucion, BroFitnessParams params, EntityManager em){
		
		String text ; 
		String text1;
		String text2;
		text1 = "<html><body> Fitness de la mejor solucion: " + solucion.getFitnessValue();
		text1 = text1 + "<br>Fitness objetivo: " + params.getEstresObjetivo();
		text1 = text1 + "<br>Edad de la solucion: " + solucion.getAge();
		text1 = text1 + "<br>Ejercicio aerobico (diario): " + params.getFrecuenciaCardiacaFinal() + " pulsaciones a " + params.getMinutosAerobica() + "minutos";
		Gene[] genes = solucion.getGenes();
		int diatxt=0;
		text = "<html><body>";
		text2="<html><body>";
		for(int g = 0; g < (solucion.size()/2); g++) {
			int diaRutina = ((EjercicioGene)genes[g + (solucion.size()/2)]).getDiaRutina();
			
			if (diaRutina%2==1){
				if(diaRutina>diatxt){
					text=text+ "<br><br>Día #" + diaRutina;
					diatxt = diaRutina;
				}
				Ejercicio ejercicio = (Ejercicio) em.find(Ejercicio.class, genes[g + (solucion.size()/2)].getAllele());
				text = text + "<br>" +  ejercicio.getNombre() + " - " + genes[g].getAllele() + " repeticiones.";
			}
			else {
				if(diaRutina>diatxt){
					text2=text2+ "<br><br>Día #" + diaRutina;
					diatxt = diaRutina;
				}
				Ejercicio ejercicio = (Ejercicio) em.find(Ejercicio.class, genes[g + (solucion.size()/2)].getAllele());
				text2 = text2 + "<br>" +   ejercicio.getNombre() + " - " + genes[g].getAllele() + " repeticiones.";
			}
			
		}
		text = text+"<body></html>";
		text1 = text1+"<body></html>";
		text2 = text2+"<body></html>";
		
		jLabel1.setText(text);
		jLabel3.setText(text1);
		jLabel2.setText(text2);
	}

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton salir;
    private javax.swing.JButton volver;
}
