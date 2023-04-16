import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Trojuhelnik extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button2;
    private JButton button1;
    private JPanel panel;
    private JMenuBar bar = new JMenuBar();
    private JMenu menu = new JMenu("Soubor");
    private JMenu menu2 = new JMenu("Akce");
    private JMenuItem item = new JMenuItem("Načti...");
    private JMenuItem item2 = new JMenuItem("Ulož...");
    private JMenuItem item3 = new JMenuItem("Kopíruj A do B i C");
    private JMenuItem item4 = new JMenuItem("Lze sestrojit trojúhelník?");
    private JFileChooser vyberSouboru = new JFileChooser();


    public Trojuhelnik() {
        setJMenuBar(bar);
        bar.add(menu);
        bar.add(menu2);
        menu.add(item);
        menu.add(item2);
        menu2.add(item3);
        menu2.add(item4);
        item.addActionListener(ActionListener ->nacti());
        item2.addActionListener(ActionListener ->uloz());
        item3.addActionListener(ActionListener ->kopiruj());
        item4.addActionListener(ActionListener ->lzeSestrojit());
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kopiruj();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lzeSestrojit();
            }
        });
    }

    public void nacti(){
        vyberSouboru.setFileFilter(new FileNameExtensionFilter("textové soubory","txt"));
        int vysledek = vyberSouboru.showOpenDialog(this);
        if(vysledek==JFileChooser.APPROVE_OPTION){
            Funkce funkce = new Funkce();
            funkce.cteni(vyberSouboru.getSelectedFile());
            Constructor constructor = funkce.getConstructor();
            textField1.setText(constructor.getA()+"");
            textField2.setText(constructor.getB()+"");
            textField3.setText(constructor.getC()+"");
        }
    }
    public void uloz(){
        vyberSouboru.setFileFilter(new FileNameExtensionFilter("textové soubory","txt"));
        int vysledek = vyberSouboru.showSaveDialog(this);
        if(vysledek==JFileChooser.APPROVE_OPTION) {
            Funkce funkce = new Funkce();
            int a = Integer.parseInt(textField1.getText());
            int b = Integer.parseInt(textField2.getText());
            int c = Integer.parseInt(textField3.getText());
            funkce.setConstructor(new Constructor(a,b,c));
            funkce.ukladani(vyberSouboru.getSelectedFile());
        }
    }
    public void kopiruj(){
        textField2.setText(textField1.getText());
        textField3.setText(textField1.getText());
    }
    public void lzeSestrojit(){
        int a = Integer.parseInt(textField1.getText());
        int b = Integer.parseInt(textField2.getText());
        int c = Integer.parseInt(textField3.getText());
        if(a+b>c&&a+c>b&&b+c>a){
            JOptionPane.showMessageDialog(panel, "Ze stran délek, A: " + a + ", B: " + b + ", C: " + c + " lze sestrojit trojúhelník");
        }
        else{
            JOptionPane.showMessageDialog(panel, "Ze stran délek, A: " + a + ", B: " + b + ", C: " + c + " nelze sestrojit trojúhelník");
        }
    }
    public static void main(String[] args) {
        Trojuhelnik trojuhelnik = new Trojuhelnik();
        trojuhelnik.setContentPane(trojuhelnik.panel);
        trojuhelnik.setTitle("Trojúhelník");
        trojuhelnik.setVisible(true);
        trojuhelnik.pack();
        trojuhelnik.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}