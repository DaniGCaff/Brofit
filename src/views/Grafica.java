
package views;



import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
 

/**
 *
 * @author borja
 */
public class Grafica extends javax.swing.JFrame {

	
	public Grafica() {
	}
	public Grafica(int[] numeroEvolucion, int[] mediasEvolucion, int MAX_ALLOWED_EVOLUTIONS) {
			
	
		this.numeroEvolucion=numeroEvolucion;
		this.mediasEvolucion=mediasEvolucion;
		this.MAX_ALLOWED_EVOLUTIONS=MAX_ALLOWED_EVOLUTIONS;
		this.pintarGrafica();
		
		for(int i =0;i<numeroEvolucion.length;i++){
			System.out.println(numeroEvolucion[i]+"----"+mediasEvolucion[i]);
		}
	}

    
    private void pintarGrafica(){
      
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Charts");

                frame.setSize(600, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                XYDataset ds = createDataset();
                JFreeChart chart = ChartFactory.createXYLineChart("Gráfico media fitness/generación",
                        "Número de generación", "Fitness medio", ds, PlotOrientation.VERTICAL, true, true,
                        false);
                ChartPanel cp = new ChartPanel(chart);
                frame.getContentPane().add(cp);
            }
        });
        
    }
    
    private XYDataset createDataset() {

        DefaultXYDataset ds = new DefaultXYDataset();
        
        double[][] data = new double[2][300] ;
        for(int i =0; i<this.MAX_ALLOWED_EVOLUTIONS;i++){
        	data[0][i]= this.numeroEvolucion[i];
        	data[1][i]=this.mediasEvolucion[i];
        }
        ds.addSeries("Media", data);

        return ds;
    }
    

    private int[] numeroEvolucion;
    private int[] mediasEvolucion;
    private int MAX_ALLOWED_EVOLUTIONS;
}
