package vista;

import general.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import logica.Convertidor;

public class Ventana extends Frame{
    
    //General
    
    Convertidor conv;

    //Elementos
    
    JLabel tituloLab;
    JLabel conversionLab;
    JLabel resultadoLab;
    
    JTextField inputBinarioTxt;
    JTextField inputDecimalTxt;
    
    JButton convertirBtn;
    
    JComboBox<String> tipoConversionCB;
    String[] tipoConversionList = new String[]{
        "Decimal a binario", "Binario a decimal"
    };
    
    public Ventana(){
        configElementos();
        agregarElementos();
    }
    
    private void configElementos(){
        
        //General
        this.setTitle("Convertidor");
        conv = new Convertidor();
        
        // JLabels
        tituloLab = new JLabel("Convertidor Decimal / Binario", SwingConstants.CENTER);
        tituloLab.setBounds(20, 20, 300, 30);
        
        conversionLab = new JLabel("Resultado");
        conversionLab.setBounds(130, 240, 190, 30);
        
        resultadoLab = new JLabel("Resultado:");
        resultadoLab.setBounds(20, 240, 100, 30);
        
        // Combo Box
        tipoConversionCB = new JComboBox<>(tipoConversionList);
        tipoConversionCB.setBounds(20, 70, 300, 30);
        tipoConversionCB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> combo = (JComboBox<String>) e.getSource();
                String selectedConversion = (String)combo.getSelectedItem();
                if(selectedConversion.equals("Decimal a binario")){
                    inputDecimalTxt.setVisible(true);
                    inputBinarioTxt.setVisible(false);
                } else if (selectedConversion.equals("Binario a decimal")){
                    inputDecimalTxt.setVisible(false);
                    inputBinarioTxt.setVisible(true);
                }
            }
            
        });
        
        //JTextField
        inputDecimalTxt = new JTextField();
        inputDecimalTxt.setBounds(20, 120, 300, 40);
        
        inputBinarioTxt = new JTextField();
        inputBinarioTxt.setBounds(20, 120, 300, 40);
        inputBinarioTxt.setVisible(false);
        
        //JButton
        convertirBtn = new JButton("Convertir");
        convertirBtn.setBounds(70, 180, 200, 40);
        convertirBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                try{
                    if(inputDecimalTxt.isVisible()){
                        int valor = Integer.parseInt(inputDecimalTxt.getText());
                        String resultado = conv.decimalABinario(valor);
                        conversionLab.setText(resultado);

                    } else if (inputBinarioTxt.isVisible()){
                        String binario = inputBinarioTxt.getText();
                        int resultado = conv.binarioADecimal(binario);
                        conversionLab.setText(String.valueOf(resultado));

                    }
                }catch(Exception er){
                    conversionLab.setText("No se puede convertir");
                }
            }
            
        });
    }
    
    private void agregarElementos() {
        this.add(tituloLab);
        this.add(conversionLab);
        this.add(resultadoLab);
        
        this.add(tipoConversionCB);
        
        this.add(inputDecimalTxt);
        this.add(inputBinarioTxt);
        
        this.add(convertirBtn);
        
        this.setVisible(true);
    }
}
