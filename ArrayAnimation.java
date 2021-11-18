package lottery;

/**
 *
 * @author maksymkalinichenko
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ArrayAnimation extends JApplet {

    public ArrayListAnimation arrayListAnimation = new ArrayListAnimation();//new ArrarListAnimation
    public ArrayList<Integer> list = new ArrayList<>();//new arrayList

    public JTextField E_Value = new JTextField(5);//create editText
    public JTextField E_Index = new JTextField(5);//create editText

    public int val = -1;
    public int sizeblock = 4;//size

    class ArrayListAnimation extends JPanel {

        @Override
        protected void paintComponent(Graphics wr) {
            int size = 30;//size
            String str = (list.isEmpty() ? "list is empty" : "array list") + "\t\t\tsize = " + list.size() + " and capacity = " + sizeblock;//text line
            wr.drawString(str, size, size);//write line
            for (int i = 0; i < sizeblock; i++) {
                wr.drawRect(size + (i * size), 2 * size, size, size);//squre
                if (i >= list.size()) {
                    wr.drawLine(2 * size + (i * size), 2 * size, size + (i * size), 3 * size);//draw line /
                } else {
                    if (i == val) {
                        wr.setColor(Color.RED);//color for found number
                    }
                    wr.drawString(list.get(i) + "", size + (i * size) + 10, (int) (2.7 * size));//position for number
                    if (i == val) {
                        wr.setColor(Color.BLACK);//color
                    }
                }
            }
        }
    }

    public ArrayAnimation() {
        add(arrayListAnimation, BorderLayout.CENTER);
        JPanel line = new JPanel();//create a container

        line.add(new JLabel("Enter a value: "));//Value = Number
        line.add(E_Value);

        line.add(new JLabel("Enter an index: "));//Index
        line.add(E_Index);

        JButton Search = new JButton("Search");//Search btn
        line.add(Search);

        JButton Insert = new JButton("Insert");//Insert btn
        line.add(Insert);

        JButton Delete = new JButton("Delete");//Delete btn
        line.add(Delete);

        JButton Trim = new JButton("TrimToSize");//Trim btn
        line.add(Trim);

        add(line, BorderLayout.SOUTH);

        Insert.addActionListener((ActionEvent e) -> {//Action for Insert btn
            try {
                int value = Integer.parseInt(E_Value.getText());
                if (E_Index.getText().equals("")) {
                    list.add(value);
                    if (list.size() > sizeblock) {
                        sizeblock = sizeblock * 2;
                    }
                } else {
                    int index = Integer.parseInt(E_Index.getText());
                    index--;//index - 1 = since array starts from zero and user counts from 1
                    list.add(index, value);
                    if (list.size() > sizeblock) {//if we dont have space, space *2
                        sizeblock = sizeblock * 2;
                    }
                    E_Index.setText("");
                }
                arrayListAnimation.repaint();
                E_Value.setText("");
                val = -1;
                E_Value.requestFocus();
            } catch (NumberFormatException | IndexOutOfBoundsException e2) {
            }
        });

        Delete.addActionListener((ActionEvent e) -> {//Action for Delete btn
            try {
                var value = Integer.parseInt(E_Value.getText());
                list.remove(new Integer(value));
                val = -1;
                arrayListAnimation.repaint();
                E_Value.setText("");
                E_Value.requestFocus();
            } catch (NumberFormatException e2) {
            }
        });

        Search.addActionListener((ActionEvent e) -> {//Action for Search btn
            try {
                int value = Integer.parseInt(E_Value.getText());
                val = list.indexOf(value);
                arrayListAnimation.repaint();
                E_Value.requestFocus();
            } catch (NumberFormatException e2) {
            }
        });

        Trim.addActionListener((ActionEvent e) -> {//Action for Trim btn
            sizeblock = list.size();
            if (sizeblock == 0) {
                sizeblock = 1;
            }
            arrayListAnimation.repaint();
        });
    }

    public static void main(String[] args) {
        JFrame fr = new JFrame("Array List Animation");//create window

        ArrayAnimation array = new ArrayAnimation();//create array
        fr.add(array);
        fr.setSize(800, 300);//size for window
        fr.setVisible(true);
    }

}
