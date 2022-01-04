package xguler03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUI implements ActionListener {

    Person person;
    List<Person> list = new ArrayList<Person>();

    private static JFrame cerceve;
    private static JPanel panel;
    private static JLabel baslik, parola, kullaniciAdi, baslik2, kullaniciAdi2, parola2, parola3, text, alert, buton3;
    private static JTextField kullaniciYazisi, kullaniciYazisi2;
    private static JPasswordField parolaYazisi, parolaYazisi2, parolaYazisi3;
    private static JButton buton, buton2;


    public static void main(String[] args) {

        cerceve = new JFrame();
        panel = new JPanel();
        cerceve.setSize(700, 250);
        cerceve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cerceve.setVisible(true);
        cerceve.add(panel);
        panel.setLayout(null);

        baslik = new JLabel("Login");
        baslik.setBounds(140, 5, 160, 30);
        baslik.setFont(new Font("Serif", Font.BOLD, 25));
        panel.add(baslik);

        kullaniciAdi = new JLabel("Username");
        kullaniciAdi.setBounds(10, 40, 160, 25);
        panel.add(kullaniciAdi);

        kullaniciYazisi = new JTextField();
        kullaniciYazisi.setBounds(100, 40, 160, 25);
        panel.add(kullaniciYazisi);

        parola = new JLabel("Password");
        parola.setBounds(10, 70, 160, 25);
        panel.add(parola);

        parolaYazisi = new JPasswordField();
        parolaYazisi.setBounds(100, 70, 160, 25);
        panel.add(parolaYazisi);

        buton = new JButton("Login");
        buton.setBounds(100, 120, 160, 25);
        buton.addActionListener(new GUI());
        panel.add(buton);

        baslik2 = new JLabel("Sign Up");
        baslik2.setBounds(490, 5, 160, 30);
        baslik2.setFont(new Font("Serif", Font.BOLD, 25));
        panel.add(baslik2);

        kullaniciAdi2 = new JLabel("Username");
        kullaniciAdi2.setBounds(350, 40, 160, 25);
        panel.add(kullaniciAdi2);

        kullaniciYazisi2 = new JTextField();
        kullaniciYazisi2.setBounds(450, 40, 160, 25);
        panel.add(kullaniciYazisi2);

        parola2 = new JLabel("Password");
        parola2.setBounds(350, 70, 160, 25);
        panel.add(parola2);

        parolaYazisi2 = new JPasswordField();
        parolaYazisi2.setBounds(450, 70, 160, 25);
        panel.add(parolaYazisi2);

        parola3 = new JLabel("Password again");
        parola3.setBounds(350, 120, 160, 25);
        panel.add(parola3);

        parolaYazisi3 = new JPasswordField();
        parolaYazisi3.setBounds(450, 120, 160, 25);
        panel.add(parolaYazisi3);

        buton2 = new JButton("Register");
        buton2.setBounds(450, 170, 160, 25);
        buton2.addActionListener(new GUI());
        panel.add(buton2);

        cerceve.setVisible(true);

    }

    public void ProgressBar(ActionEvent e ) {
        String str = parolaYazisi2.getText();

        text = new JLabel(" ");
        text.setBounds(350, 85, 150, 50);


        if (str.length() <= 4) {
            text.setText("Weak Password");
            text.setForeground(Color.red);
        }

        if (str.length() > 4 && str.length() <= 6) {
            text.setText("Moderate Password");
            text.setForeground(Color.orange);
        }

        if (str.length() > 6) {
            text.setText("Strong Password");
            text.setForeground(Color.green);
        }
        panel.add(text);
    }

    public void Register(ActionEvent e){

        alert = new JLabel("");
        alert.setBounds(495, 130, 160, 50);

        person = new Person(kullaniciYazisi2.getText(),parolaYazisi2.getText());
        boolean usernameCheck = list.stream().anyMatch(o -> o.username.equals(person.username));
        boolean passwordCheck = list.stream().anyMatch(o -> o.password.equals(person.password));
        if (usernameCheck &&passwordCheck) {
            alert.setText("User already exists");
            alert.setVisible(true);
        }
        else {
            if (parolaYazisi2.getText().equals(parolaYazisi3.getText()) && !(kullaniciYazisi2.getText().trim().isEmpty())) {
                list.add(person);
                alert.setText("User registered");
                alert.setVisible(true);
            }
        }
        panel.add(alert);
    }

    public void Login(ActionEvent a){
        buton3 = new JLabel("");
        buton3.setBounds(140, 140, 150, 50);

        boolean usernameCheck = list.stream().anyMatch(o -> o.username.equals(kullaniciYazisi.getText()));
        boolean passwordCheck = list.stream().anyMatch(o -> o.password.equals(parolaYazisi.getText()));
        if (usernameCheck && passwordCheck){
            buton3.setText("Successful login");
        }
        else{
            buton3.setText("Lofin failed");
        }
        panel.add(buton3);

    }

    @Override
    public void actionPerformed(ActionEvent a) {
        ProgressBar(a);
        Register(a);
        Login(a);
    }
}

