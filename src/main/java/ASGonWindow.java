import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ASGonWindow extends JFrame implements ActionListener
{
    JLabel lMocsprezyny, lMasakuli, lEnergia, lfps, lTytul;
    JTextField tMocsprezyny, tMasakuli;
    JButton bPrzeliczaj;
    JCheckBox cSpeclufa, cKomorahu, cCylinder;


    double tempMoc, tempMasa, komora=1, cylinder=1, lufa=1;


    public ASGonWindow()
    {

        setTitle("Parametry balistyczne ASG"); // nazywamy methods na obiekcie JFrame do skonfigurowania jej
        setSize(600,420);
        setLayout(null);

        lTytul = new JLabel(" KARABIN ASG - BALISTYKA "); // etykieta zmiennej dla obiektu JLabel i stworzenie etykiety
        lTytul.setBounds(220,20,200,20); // wprowadzenie setText method na JLabel by ustawic wlasciwosc textowa
        add(lTytul); // odwolanie sie do add method z JFrame object by dodac etykiete okna

        lMocsprezyny = new JLabel(" Wprowadz moc sprezyny w m/s: "); // etykieta zmiennej dla obiektu JLabel i stworzenie etykiety
        lMocsprezyny.setBounds(20,60,200,20); // wprowadzenie setText method na JLabel by ustawic wlasciwosc textowa
        add(lMocsprezyny); // odwolanie sie do add method z JFrame object by dodac etykiete okna

        tMocsprezyny = new JTextField("");
        tMocsprezyny.setBounds(220,60,200,20);
        add(tMocsprezyny);

        lMasakuli = new JLabel(" Wprowadz masę kuli w gramach: "); // etykieta zmiennej dla obiektu JLabel i stworzenie etykiety
        lMasakuli.setBounds(20,100,200,20); // wprowadzenie setText method na JLabel by ustawic wlasciwosc textowa
        add(lMasakuli);

        tMasakuli = new JTextField("");
        tMasakuli.setBounds(220,100,200,20);
        add(tMasakuli);

        cSpeclufa= new JCheckBox(" Lufa precyzyjna fi 6.02mm");
        cSpeclufa.setBounds(220,140,200,20);
        add(cSpeclufa);

        cKomorahu= new JCheckBox(" Komora Hop-up uszczelniona");
        cKomorahu.setBounds(220,180,200,20);
        add(cKomorahu);

        cCylinder= new JCheckBox(" Wzmocniony cylinder");
        cCylinder.setBounds(220,220,200,20);
        add(cCylinder);



        bPrzeliczaj = new JButton("Sprawdz balistyke");
        bPrzeliczaj.setBounds(220,260,200,20);
        add(bPrzeliczaj);
        bPrzeliczaj.addActionListener(this);

        lEnergia = new JLabel(""); // etykieta zmiennej dla obiektu JLabel i stworzenie etykiety
        lEnergia.setBounds(20,300,580,20); // wprowadzenie setText method na JLabel by ustawic wlasciwosc textowa
        add(lEnergia); // odwolanie sie do add method z JFrame object by dodac etykiete okna


        lfps = new JLabel(""); // etykieta zmiennej dla obiektu JLabel i stworzenie etykiety
        lfps.setBounds(20,340,580,20); // wprowadzenie setText method na JLabel by ustawic wlasciwosc textowa
        add(lfps); // odwolanie sie do add method z JFrame object by dodac etykiete okna

    }


    public static void main(String [] args) {


        ASGonWindow app = new ASGonWindow();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);


    }
        public void actionPerformed(ActionEvent e)
        {

        if (cSpeclufa.isSelected()) { lufa = 1.03; } else { lufa = 1; };
        if (cKomorahu.isSelected()) { komora = 1.01;} else { komora = 1; };
        if (cCylinder.isSelected()) { cylinder = 1.02;} else { cylinder = 1; };

        tempMoc = Double.parseDouble(tMocsprezyny.getText());
        tempMasa = Double.parseDouble(tMasakuli.getText());
        Double fps = ((tempMoc*3.370079)* lufa * komora * cylinder); // predkosc wylotowa ilosc stop na 1 m
        Double energia = ((tempMasa/2)*(Math.pow(tempMoc,2))/1000)* lufa * komora * cylinder ; // energia pocisku

            String wynik = new Double(energia).toString();
            String sfps = new Double(fps).toString();

            lEnergia.setText("Energia kinetyczna kuli o masie " + tempMasa + " g wynosi: " + wynik + " Joulea ");
            lfps.setText("Predkosc kuli: " + sfps + " Fps ");


        }



}
