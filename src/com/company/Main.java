package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main extends JFrame {
    int userValue= 0;
    int result = 0;
    String textResult;
    public Main(){
    initComponents();
}

    public void initComponents() {
         pack();
         Container kontener = this.getContentPane();
         JPanel Panel = new JPanel();
         JLabel Text1 = new JLabel("Podaj temperature w stopniach Celsjusza: ");
         TextField data = new TextField();
         JRadioButton Fahr = new JRadioButton("Fahrenheit");
         JRadioButton Kelw = new JRadioButton("Kelwin");
         ButtonGroup tempButtons = new ButtonGroup();
         JLabel value = new JLabel("Wynik to:");
         JTextArea numerValue = new JTextArea();
         JButton execute = new JButton("Wykonaj");
         JButton exit = new JButton("Zakończ");

         numerValue.setEditable(false);

        this.setTitle("Przelicznik temperatur");
        this.setBounds(300, 300, 500, 175);
        this.setDefaultCloseOperation(3);

        // ustawienie layout'u
        GroupLayout layout = new GroupLayout(Panel);
        Panel.setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup()
                                .addComponent(Text1)
                                .addComponent(Fahr)
                                .addComponent(value)
                                .addComponent(execute))
                        .addGroup(layout.createParallelGroup()
                                .addComponent(data)
                                .addComponent(Kelw)
                                .addComponent(numerValue)
                                .addComponent(exit)));
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(Text1)
                                        .addComponent(data))
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(Fahr)
                                        .addComponent(Kelw))
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(value)
                                        .addComponent(numerValue)
                        )
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(execute)
                                        .addComponent(exit)
                        ));

        Panel.add(Text1);
        Panel.add(data);
        Panel.add(Fahr);
        Panel.add(Kelw);
        Panel.add(value);
        Panel.add(numerValue);
        Panel.add(execute);
        Panel.add(exit);

        tempButtons.add(Fahr);
        tempButtons.add(Kelw);
        kontener.add(Panel);


        data.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                //Wpisywanie tylko cyfr do pola "data"
                if (!isNumeric(e.getKeyChar())) e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //blokada wklejania wartości do pola data
                if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_V){
                  e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        execute.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (data.getText().isBlank()) {
                    numerValue.setText("Nie podałeś wartości temperatury");
                } else {
                    userValue = Integer.parseInt(data.getText());
                    if (Fahr.isSelected()) {
                        result = toFahrenhait(userValue);
                        print(result, numerValue);

                    } else if (Kelw.isSelected()) {
                        result = toKelvin(userValue);
                        print(result, numerValue);

                    } else {
                        numerValue.setText("Nie wybrałeś skali");
                    }
                }
            }
                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
        });
    }



    boolean isNumeric(char c){
    if(c>='0' && c<='9') return true;
    return false;
    }
    void print(int a,JTextArea fa){
        textResult = Integer.toString(a);
        fa.setText(textResult);
    }
    public int toFahrenhait(int value){return value*9/5+32;}
    public int toKelvin(int value){return value+273;}


    public static void main(String[] args) {
	new Main().setVisible(true);
    }
}
