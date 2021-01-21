package com.coding;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiFibonacci implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JButton button;
    private static JLabel inputLabel;
    private static JLabel resultLabel;
    private static JComboBox<Long> resultCombo;
    private static JTextField userInput;
    private static JRadioButton iterative;
    private static JRadioButton recursive;
    private static ArrayList<Long> resultNumbers;



    private static void GuiFibonacci(){

        frame = new JFrame("GUI Fibonacci");
        panel = new JPanel();
        button = new JButton("Calculate");
        inputLabel = new JLabel("Number");
        resultLabel = new JLabel("Result");
        userInput = new JTextField(10);
        resultCombo = new JComboBox<>();
        recursive = new JRadioButton ("Recursive Mode");
        iterative = new JRadioButton("Iterative Mode");
        resultNumbers = new ArrayList<>();

        ButtonGroup mode = new ButtonGroup();
        mode.add(recursive);
        mode.add(iterative);

        inputLabel.setBounds(10,20,80,25);
        userInput.setBounds(100,20,120,25);
        resultLabel.setBounds(10,60,80,25);
        resultCombo.setBounds(100,60,145,25);
        button.setBounds(140,120,100,25);
        iterative.setBounds(250,15,120,25);
        recursive.setBounds(250,35,120,25);

        button.addActionListener(new GuiFibonacci());

        panel.setLayout(null);
        panel.add(userInput);
        panel.add(inputLabel);
        panel.add(resultLabel);
        panel.add(resultCombo);
        panel.add(button);
        panel.add(iterative);
        panel.add(recursive);
        frame.add(panel);
        frame.pack();

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        GuiFibonacci();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        resultCombo.removeAllItems();
        resultNumbers.clear();

        if(iterative.isSelected()){
            runIteractive();
        } else if (recursive.isSelected()){
            for (int i = 0; i <= Integer.parseInt(userInput.getText()); i++) {
                resultNumbers.add(runRecursive(i));
            }
        }

        populateComboBox();
    }

    private long runRecursive(long n) {

        if (n < 2){
            return n;
        } else {
            return runRecursive(n - 1) + runRecursive(n - 2);
        }
    }

    private void runIteractive() {

        long n1 = 1;
        long n2 = 0;

        int n = Integer.parseInt(userInput.getText());

        resultNumbers.add((long) n2 );
        resultNumbers.add((long) n1 );

        for (int i = 2; i <= n; i++){
            n1 = n1 + n2;
            n2 = n1 - n2;
            resultNumbers.add((long) n1 );
        }

    }

    private void populateComboBox(){
        for(Long l : resultNumbers){
            resultCombo.addItem(l);
        }
    }

}
