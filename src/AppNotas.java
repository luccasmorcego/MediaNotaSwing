import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AppNotas {
    private JTextField insertNota;
    private JButton btnAddNota;
    private JTextArea showNota;
    private JButton btnMedia;
    private JPanel AplicativoNotas;

    ArrayList<String> notas = new ArrayList<>();


    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicativo de Notas");
        frame.setContentPane(new AppNotas().AplicativoNotas);
        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateNotas(ArrayList lista) {
        showNota.setText("");
        for (int i = 0; i < lista.size(); i++) {
            showNota.setText(showNota.getText() + " \n" + lista.get(i));
        }
    }

    public static double toNum(String x){
        return Double.parseDouble(x);
    }
    public AppNotas() {
        insertNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(toNum(insertNota.getText()));
                notas.add(insertNota.getText());
                updateNotas(notas);
                insertNota.setText("");
            }
        });
        btnMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double soma = 0;

                for (int i = 0; i < notas.size(); i++) {
                    soma += Double.parseDouble(notas.get(i));
                }

                double mediaFinal = soma / notas.size();

                if (mediaFinal >= 7){
                    showNota.setText("STATUS: APROVADO \n SOMA TOTAL: "+ soma + "\n MEDIA FINAL: " + mediaFinal);
                }else {
                    showNota.setText("STATUS: REPROVADO \n SOMA TOTAL: "+ soma + "\n MEDIA FINAL: " + mediaFinal);
                }
            }
        });
        btnAddNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notas.add(insertNota.getText());
                updateNotas(notas);
                insertNota.setText("");
            }
        });
    }
    }



