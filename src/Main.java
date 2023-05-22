import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private JLabel[] labels;
    private JTextField[] inputs;

    public static void main(String[] args) {


        new Main();
    }

    public Main() {
        this.setVisible(true);
        this.setSize(580, 260);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Box volume & area");

        // label setting
        labels = new JLabel[3];
        for (int i = 0; i < 3; i++) {
            labels[i] = new JLabel();
            this.add(labels[i]);
        }
        labels[0] = setLabel(labels[0], 20, 30, 80, 50, "Width: ");
        labels[1] = setLabel(labels[1], 20, 90, 80, 50, "Height: ");
        labels[2] = setLabel(labels[2], 20, 150, 80, 50, "Length: ");

        // JtextField setting 
        inputs = new JTextField[3];
        for (int i = 0; i < 3; i++) {
            inputs[i] = new JTextField();
            this.add(inputs[i]);
        }
        inputs[0] = setInput(inputs[0], 170, 30, 180, 50, "Width: ");
        inputs[1] = setInput(inputs[1], 170, 90, 180, 50, "Height: ");
        inputs[2] = setInput(inputs[2], 170, 150, 180, 50, "Length: ");

        // button setting
        JButton button = new JButton("Calculate ");
        button.setBounds(30, 193, 100, 40);
        this.add(button);
        repaint();

        // labels outputs
        Font f1 = new Font("Ariel", Font.ITALIC, 18);
        JLabel volume = new JLabel("Volume = ");
        volume.setBounds(150, 193, 130, 40);
        volume.setFont(f1);
        this.add(volume);

        JLabel area = new JLabel("Area = ");
        area.setBounds(300, 193, 130, 40);
        area.setFont(f1);
        this.add(area);
        repaint();

        button.addActionListener((e -> {
            if (isNumber(inputs[0].getText()) && isNumber(inputs[1].getText()) && isNumber(inputs[2].getText())) {
                volume.setText(String.valueOf(Integer.valueOf(inputs[0].getText()) * Integer.valueOf(inputs[1].getText()) * Integer.valueOf(inputs[2].getText())));
                area.setText(String.valueOf((Integer.valueOf(inputs[0].getText()) * Integer.valueOf(inputs[1].getText()) * 2)
                        + (Integer.valueOf(inputs[0].getText()) * Integer.valueOf(inputs[2].getText()) * 2))
                        + (Integer.valueOf(inputs[1].getText()) * Integer.valueOf(inputs[2].getText()) * 2));
            }
        }));

    }


    public static JTextField setInput(JTextField input, int x, int y, int width, int height, String name) {
        Font f1 = new Font("Ariel", Font.ITALIC, 18);
        input.setFont(f1);
        input.setBounds(x, y, width, height);
        input.setText(name);

        return input;
    }

    public static JLabel setLabel(JLabel label, int x, int y, int width, int height, String name) {
        Font f1 = new Font("Ariel", Font.BOLD, 18);
        label.setFont(f1);
        label.setBounds(x, y, width, height);
        label.setText(name);
        return label;
    }

    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9'))
                return false;
        }
        return true;
    }
}