import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class View extends MyFrame {
	//initialized in constructor
	JPanel mainPanel;
	JTabbedPane cards;		
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	JPanel panel6;
	JPanel panel7;
	JPanel panel8;
	
    //card1
    JTextField filterTextPracownik;
    JLabel filterLabelPracownik;
    JButton ButtonShowCard1;
	JButton ButtonAddCard1;
	JButton ButtonEditCard1;
	JButton ButtonDeleteCard1;
	JButton ButtonShowOneCard1;
	private ImageIcon ImageCard1;
	JLabel LabelImageCard1;
	GridBagConstraints constraintsButtonShowCard = new GridBagConstraints(); 
 	GridBagConstraints constraintsButtonAddCard = new GridBagConstraints(); 
 	GridBagConstraints constraintsButtonEditCard = new GridBagConstraints();
 	GridBagConstraints constraintsButtonDeleteCard = new GridBagConstraints();
 	GridBagConstraints constraintsButtonShowOneCard = new GridBagConstraints();
 	GridBagConstraints constraintsFilterLabelCard = new GridBagConstraints(); 
 	GridBagConstraints constraintsFilterTextCard = new GridBagConstraints(); 
 	GridBagConstraints constraintsImageCard = new GridBagConstraints();
 	
 	//card2
 	JTextField filterTextPacjent;
    JLabel filterLabelPacjent;
 	JButton ButtonAddCard2;
	JButton ButtonEditCard2;
	JButton ButtonDeleteCard2;
	JButton ButtonShowCard2;
	JButton ButtonShowOneCard2;
	private ImageIcon ImageCard2;
	JLabel LabelImageCard2;
	
 	
 	//card3
 	JTextField filterTextWizyta;
    JLabel filterLabelWizyta;
 	JButton ButtonAddCard3;
	JButton ButtonEditCard3;
	JButton ButtonDeleteCard3;
	JButton ButtonShowCard3;
	JButton ButtonShowOneCard3;
	private ImageIcon ImageCard3;
	JLabel LabelImageCard3;
	;
 	
 	//card4
 	JTextField filterTextGabinet;
    JLabel filterLabelGabinet;
 	JButton ButtonAddCard4;
	JButton ButtonEditCard4;
	JButton ButtonDeleteCard4;
	JButton ButtonShowCard4;
	JButton ButtonShowOneCard4;
	private ImageIcon ImageCard4;
	JLabel LabelImageCard4;
	
 	
 	//card5
 	JTextField filterTextStanowisko;
    JLabel filterLabelStanowisko;
 	JButton ButtonAddCard5;
	JButton ButtonEditCard5;
	JButton ButtonDeleteCard5;
	JButton ButtonShowCard5;
	JButton ButtonShowOneCard5;
	private ImageIcon ImageCard5;
	JLabel LabelImageCard5;
	
 	
 	//card6
 	JTextField filterTextChoroba;
    JLabel filterLabelChoroba;
 	JButton ButtonAddCard6;
	JButton ButtonEditCard6;
	JButton ButtonDeleteCard6;
	JButton ButtonShowCard6;
	JButton ButtonShowOneCard6;
	private ImageIcon ImageCard6;
	JLabel LabelImageCard6;
	
 	
 	//card7
 	JButton ButtonAddExampleRecords;
	JButton ButtonCreateTables; 
	GridBagConstraints constraintsButtonAddExampleRecords = new GridBagConstraints(); 
 	GridBagConstraints constraintsButtonCreateTables = new GridBagConstraints();
 	
 	//card8
 	JButton ButtonAddCard8;
	JButton ButtonEditCard8;
	JButton ButtonDeleteCard8;
	JButton ButtonShowCard8;
	private ImageIcon ImageCard8;
	JLabel LabelImageCard8;
	
	View() {
		mainPanel = new JPanel(new CardLayout());
		cards = new JTabbedPane();
		
	    panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		
		
		GridBagLayout layoutcard1 = new GridBagLayout();
		GridBagLayout layoutcard2 = new GridBagLayout();
		GridBagLayout layoutcard3 = new GridBagLayout();
		GridBagLayout layoutcard4 = new GridBagLayout();
		GridBagLayout layoutcard5 = new GridBagLayout();
		GridBagLayout layoutcard6 = new GridBagLayout();
		GridBagLayout layoutcard7 = new GridBagLayout();
		GridBagLayout layoutcard8 = new GridBagLayout();
		
     	panel1.setLayout(layoutcard1);
     	panel2.setLayout(layoutcard2);
     	panel3.setLayout(layoutcard3);
     	panel4.setLayout(layoutcard4);
     	panel5.setLayout(layoutcard5);
     	panel6.setLayout(layoutcard6);
     	panel7.setLayout(layoutcard7);
     	panel8.setLayout(layoutcard8);
     	
		FillCard1();
		FillCard2();
		FillCard3();
		FillCard4();
		FillCard5();
		FillCard6();
		FillCard7();
		FillCard8();	
		
        cards.addTab("Pracownicy",panel1);
        cards.setMnemonicAt(0, KeyEvent.VK_1);
        cards.addTab("Pacjenci",panel2);
        cards.setMnemonicAt(1, KeyEvent.VK_2);
        cards.addTab("Wizyty",panel3);
        cards.setMnemonicAt(2, KeyEvent.VK_3);   
        cards.addTab("Gabinety",panel4);
        cards.setMnemonicAt(3, KeyEvent.VK_4);      
        cards.addTab("Stanowiska",panel5);
        cards.setMnemonicAt(4, KeyEvent.VK_5);     
        cards.addTab("Choroby",panel6);
        cards.setMnemonicAt(5, KeyEvent.VK_6);	
        cards.addTab("Historia Chorób", panel8);
        cards.setMnemonicAt(6, KeyEvent.VK_7);
        cards.addTab("Opcje",panel7);
        cards.setMnemonicAt(7, KeyEvent.VK_8);
        cards.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT); 
        
		mainPanel.add(cards);
		this.add(mainPanel);
	}
	
	void FillCard1() {
		
		ImageCard1 = new ImageIcon("lekarz.jpg");
	    LabelImageCard1 = new JLabel(ImageCard1);
		ButtonShowCard1 = new JButton("Wyswietl Pracowników");
		ButtonAddCard1 = new JButton("Dodaj Pracownika");
		ButtonEditCard1 = new JButton("Edytuj Pracownika");
		ButtonDeleteCard1 = new JButton("Usuñ Pracownika");
		ButtonShowOneCard1 = new JButton("Poka¿ informacje");
		
		filterLabelPracownik = new JLabel("Wpisz PESEL:", SwingConstants.TRAILING);
		filterTextPracownik = new JTextField();
		
     	constraintsImageCard.gridx = 0;
     	constraintsImageCard.gridy = 0;
     	constraintsImageCard.gridwidth = 6;
     	constraintsImageCard.gridheight = 4;
     	constraintsImageCard.weightx = 400;
     	constraintsImageCard.weighty = 100;
     	constraintsImageCard.fill = GridBagConstraints.BOTH;
     	constraintsButtonAddCard.gridx = 6;
     	constraintsButtonAddCard.gridy = 0;
     	constraintsButtonAddCard.gridwidth = 1;
     	constraintsButtonAddCard.gridheight = 1;
     	constraintsButtonAddCard.weightx = 10;
     	constraintsButtonAddCard.weighty = 10;
     	constraintsButtonAddCard.fill = GridBagConstraints.BOTH;  
     	constraintsButtonEditCard.gridx = 6;
     	constraintsButtonEditCard.gridy = 1;
     	constraintsButtonEditCard.gridwidth = 1;
     	constraintsButtonEditCard.gridheight = 1;
     	constraintsButtonEditCard.weightx = 10;
     	constraintsButtonEditCard.weighty = 10;
     	constraintsButtonEditCard.fill = GridBagConstraints.BOTH;  
     	constraintsButtonDeleteCard.gridx = 6;
     	constraintsButtonDeleteCard.gridy = 2;
     	constraintsButtonDeleteCard.gridwidth = 1;
     	constraintsButtonDeleteCard.gridheight = 1;
     	constraintsButtonDeleteCard.weightx = 10;
     	constraintsButtonDeleteCard.weighty = 10;
     	constraintsButtonDeleteCard.fill = GridBagConstraints.BOTH;
    	constraintsButtonShowCard.gridx = 6;
     	constraintsButtonShowCard.gridy = 3;
     	constraintsButtonShowCard.gridwidth = 1;
     	constraintsButtonShowCard.gridheight = 1;
     	constraintsButtonShowCard.weightx = 10;
     	constraintsButtonShowCard.weighty = 10;
     	constraintsButtonShowCard.fill = GridBagConstraints.BOTH; 
     	constraintsButtonShowOneCard.gridx = 6;
     	constraintsButtonShowOneCard.gridy = 4;
     	constraintsButtonShowOneCard.gridwidth = 1;
     	constraintsButtonShowOneCard.gridheight = 1;
     	constraintsButtonShowOneCard.weightx = 10;
     	constraintsButtonShowOneCard.weighty = 10;
     	constraintsButtonShowOneCard.fill = GridBagConstraints.HORIZONTAL; 
     	constraintsFilterLabelCard.gridx = 0;
     	constraintsFilterLabelCard.gridy = 4;
     	constraintsFilterLabelCard.gridwidth = 1;
     	constraintsFilterLabelCard.gridheight = 1;
     	constraintsFilterLabelCard.weightx = 10;
     	constraintsFilterLabelCard.weighty = 10;
     	constraintsFilterLabelCard.fill = GridBagConstraints.NONE;
     	constraintsFilterTextCard.gridx = 1;
     	constraintsFilterTextCard.gridy = 4;
     	constraintsFilterTextCard.gridwidth = 5;
     	constraintsFilterTextCard.gridheight = 1;
     	constraintsFilterTextCard.weightx = 300;
     	constraintsFilterTextCard.weighty = 100;
     	constraintsFilterTextCard.fill = GridBagConstraints.HORIZONTAL;
     	
     	panel1.add(LabelImageCard1, constraintsImageCard);
		panel1.add(ButtonAddCard1, constraintsButtonAddCard);
		panel1.add(ButtonEditCard1, constraintsButtonEditCard);
		panel1.add(ButtonDeleteCard1, constraintsButtonDeleteCard);
		panel1.add(ButtonShowCard1, constraintsButtonShowCard);
		panel1.add(ButtonShowOneCard1, constraintsButtonShowOneCard);
		panel1.add(filterLabelPracownik, constraintsFilterLabelCard);
		panel1.add(filterTextPracownik, constraintsFilterTextCard);
	}
	
	void FillCard2() {
			ImageCard2 = new ImageIcon("pacjent.jpg");
		    LabelImageCard2 = new JLabel(ImageCard2);
		    ButtonAddCard2 = new JButton("Dodaj Pacjenta");
			ButtonEditCard2 = new JButton("Edytuj Pacjenta");
			ButtonDeleteCard2 = new JButton("Usuñ Pacjenta");
			ButtonShowCard2 = new JButton("Wyœwietl Pacjentów");
			ButtonShowOneCard2 = new JButton("Poka¿ informacje");
			filterLabelPacjent = new JLabel("Wpisz PESEL:", SwingConstants.TRAILING);
			filterTextPacjent = new JTextField();
					
		  		    
	     	panel2.add(ButtonAddCard2, constraintsButtonAddCard);
			panel2.add(ButtonEditCard2, constraintsButtonEditCard);
			panel2.add(ButtonDeleteCard2, constraintsButtonDeleteCard);
			panel2.add(ButtonShowCard2, constraintsButtonShowCard);
			panel2.add(LabelImageCard2, constraintsImageCard);
			panel2.add(ButtonShowOneCard2, constraintsButtonShowOneCard);
			panel2.add(filterLabelPacjent, constraintsFilterLabelCard);
			panel2.add(filterTextPacjent, constraintsFilterTextCard);
	}

	void FillCard3() {
		ImageCard3 = new ImageIcon("wizyta.jpg");
	    LabelImageCard3 = new JLabel(ImageCard3);
	    ButtonAddCard3 = new JButton("Dodaj Wizytê");
		ButtonEditCard3 = new JButton("Edytuj Wizytê");
		ButtonDeleteCard3 = new JButton("Usuñ Wizytê");
		ButtonShowCard3 = new JButton("Wyœwietl Wizyty");
		ButtonShowOneCard3 = new JButton("Poka¿ informacje");
		filterLabelWizyta = new JLabel("Wpisz dane(PESEL pacjenta;data):", SwingConstants.TRAILING);
		filterTextWizyta = new JTextField();
		
	    
     	panel3.add(ButtonAddCard3, constraintsButtonAddCard);
		panel3.add(ButtonEditCard3, constraintsButtonEditCard);
		panel3.add(ButtonDeleteCard3, constraintsButtonDeleteCard);
		panel3.add(ButtonShowCard3, constraintsButtonShowCard);
		panel3.add(LabelImageCard3, constraintsImageCard);
		panel3.add(ButtonShowOneCard3, constraintsButtonShowOneCard);
		panel3.add(filterLabelWizyta, constraintsFilterLabelCard);
		panel3.add(filterTextWizyta, constraintsFilterTextCard);
	}
	
	void FillCard4() {
		              
	    ImageCard4 = new ImageIcon("gabinet.jpg");
	    LabelImageCard4 = new JLabel(ImageCard4);
	    ButtonAddCard4 = new JButton("Dodaj Gabinet");
		ButtonEditCard4 = new JButton("Edytuj Gabinet");
		ButtonDeleteCard4 = new JButton("Usuñ Gabinet");
		ButtonShowCard4 = new JButton("Wyœwietl Gabinety");
		ButtonShowOneCard4 = new JButton("Poka¿ informacje");
		filterLabelGabinet = new JLabel("Wpisz numer:", SwingConstants.TRAILING);
		filterTextGabinet = new JTextField();
	    
     	panel4.add(ButtonAddCard4, constraintsButtonAddCard);
		panel4.add(ButtonEditCard4, constraintsButtonEditCard);
		panel4.add(ButtonDeleteCard4, constraintsButtonDeleteCard);
		panel4.add(ButtonShowCard4, constraintsButtonShowCard);
		panel4.add(LabelImageCard4, constraintsImageCard);
		panel4.add(ButtonShowOneCard4, constraintsButtonShowOneCard);
		panel4.add(filterLabelGabinet, constraintsFilterLabelCard);
		panel4.add(filterTextGabinet, constraintsFilterTextCard);
	}

	void FillCard5() {
		 	ImageCard5 = new ImageIcon("stanowisko.jpg");
		    LabelImageCard5 = new JLabel(ImageCard5);
		    ButtonAddCard5 = new JButton("Dodaj Stanowisko");
			ButtonEditCard5 = new JButton("Edytuj Stanowisko");
			ButtonDeleteCard5 = new JButton("Usuñ Stanowisko");
			ButtonShowCard5 = new JButton("Wyœwietl Stanowiska");
			ButtonShowOneCard5 = new JButton("Poka¿ informacje");
			filterLabelStanowisko = new JLabel("Wpisz nazwê:", SwingConstants.TRAILING);
			filterTextStanowisko = new JTextField();
			    
	     	panel5.add(ButtonAddCard5, constraintsButtonAddCard);
			panel5.add(ButtonEditCard5, constraintsButtonEditCard);
			panel5.add(ButtonDeleteCard5, constraintsButtonDeleteCard);
			panel5.add(ButtonShowCard5, constraintsButtonShowCard);
			panel5.add(LabelImageCard5, constraintsImageCard);
			panel5.add(ButtonShowOneCard5, constraintsButtonShowOneCard);
			panel5.add(filterLabelStanowisko, constraintsFilterLabelCard);
			panel5.add(filterTextStanowisko, constraintsFilterTextCard);
	}
	
	void FillCard6() {
		 	ImageCard6 = new ImageIcon("choroba.jpg");
		    LabelImageCard6 = new JLabel(ImageCard6);
		    ButtonAddCard6 = new JButton("Dodaj Chorobê");
			ButtonEditCard6 = new JButton("Edytuj Chorobê");
			ButtonDeleteCard6 = new JButton("Usuñ Chorobê");
			ButtonShowCard6 = new JButton("Wyœwietl Choroby");  
			ButtonShowOneCard6 = new JButton("Poka¿ informacje");
			filterLabelChoroba = new JLabel("Wpisz nazwê:", SwingConstants.TRAILING);
			filterTextChoroba = new JTextField();
		    
	     	panel6.add(ButtonAddCard6, constraintsButtonAddCard);
			panel6.add(ButtonEditCard6, constraintsButtonEditCard);
			panel6.add(ButtonDeleteCard6, constraintsButtonDeleteCard);
			panel6.add(ButtonShowCard6, constraintsButtonShowCard);
			panel6.add(LabelImageCard6, constraintsImageCard);
			panel6.add(ButtonShowOneCard6, constraintsButtonShowOneCard);
			panel6.add(filterLabelChoroba, constraintsFilterLabelCard);
			panel6.add(filterTextChoroba, constraintsFilterTextCard);
	}
	
	void FillCard8() {
		ImageCard8 = new ImageIcon("histchor.jpg");
	    LabelImageCard8 = new JLabel(ImageCard8);
	    ButtonAddCard8 = new JButton("Dodaj chorobê do wizyty");
		ButtonDeleteCard8 = new JButton("Usuñ chorobê do wizyty");
		ButtonShowCard8 = new JButton("Wyœwietl choroby do wizyt");
		    
     	panel8.add(ButtonAddCard8, constraintsButtonAddCard);
		panel8.add(ButtonDeleteCard8, constraintsButtonDeleteCard);
		panel8.add(ButtonShowCard8, constraintsButtonShowCard);
		panel8.add(LabelImageCard8, constraintsImageCard);
	}
	
	void FillCard7() {
		
		ButtonAddExampleRecords = new JButton("Dodaj przyk³adowe rekordy.");
		ButtonCreateTables = new JButton("Utwórz tabele.");
		
		constraintsButtonAddExampleRecords.gridx = 0;
		constraintsButtonAddExampleRecords.gridy= 0;
		constraintsButtonAddExampleRecords.gridwidth = 1;
		constraintsButtonAddExampleRecords.gridheight = 1;
		constraintsButtonAddExampleRecords.weightx = 300;
		constraintsButtonAddExampleRecords.weighty = 100;
		constraintsButtonAddExampleRecords.fill = GridBagConstraints.NONE;
		constraintsButtonCreateTables.gridx = 1;
		constraintsButtonCreateTables.gridy = 0;
		constraintsButtonCreateTables.gridwidth = 1;
		constraintsButtonCreateTables.gridheight = 1;
		constraintsButtonCreateTables.weightx = 300;
		constraintsButtonCreateTables.weighty = 100;
		constraintsButtonCreateTables.fill = GridBagConstraints.NONE;
     	
     	panel7.add(ButtonAddExampleRecords, constraintsButtonAddExampleRecords);
		panel7.add(ButtonCreateTables, constraintsButtonCreateTables);
	}
	
	//card1 methods
    Object[] addPracownikWindow(String[] stanowiska) {	
		
		JTextField imie = new JTextField();
		JTextField nazwisko = new JTextField();
		JTextField pesel = new JTextField();
		JTextField pensja = new JTextField();
		JTextField telefon = new JTextField();
		JTextField email = new JTextField();
		JComboBox stanowisko = new JComboBox(stanowiska);
		
		Object[] pola = {
		"Imie", imie,
		"Nazwisko", nazwisko,
		"Pesel", pesel,
		"Pensja", pensja,
		"Telefon", telefon,
		"Email", email,
		"Stanowisko", stanowisko
		};
				
		String PeselPattern = "^([0-9]{11})$";
		String ImieNazwiskoPattern = "^[A-Z][a-z]+$";
		String TelefonPattern = "^[0-9]{9}$";
		String EmailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern patternpesel = Pattern.compile(PeselPattern);
		Pattern patternimienazwisko = Pattern.compile(ImieNazwiskoPattern);
		Pattern patterntelefon = Pattern.compile(TelefonPattern);
		Pattern patternemail = Pattern.compile(EmailPattern);
		Matcher matcherpesel;  
		Matcher matcherimie; 
		Matcher matchernazwisko;  
		Matcher matchertelefon;  
		Matcher matcheremail;  
		int i=0;
		while(i==0)
		{
			int optionpane = JOptionPane.showConfirmDialog(null, pola, "Dodaj Pracownika", JOptionPane.OK_CANCEL_OPTION);
			
			if(optionpane == JOptionPane.OK_OPTION)
			{
				matcherpesel = patternpesel.matcher(pesel.getText().toString());
				matcherimie = patternimienazwisko.matcher(imie.getText().toString());
				matchernazwisko = patternimienazwisko.matcher(nazwisko.getText().toString());
				matchertelefon = patterntelefon.matcher(telefon.getText().toString());
				matcheremail = patternemail.matcher(email.getText());
				System.out.println(matcherpesel.matches()+" "+matcherimie.matches()+" "+matchernazwisko.matches()+" "+matchertelefon.matches()+" "+matcheremail.matches());
				if(matcherimie.matches() && matchernazwisko.matches() && matcherpesel.matches() && matchertelefon.matches() && matcheremail.matches())
				{
					Object[] polawypelnione = new Object[7];
					polawypelnione[0] = imie.getText();
					polawypelnione[1] = nazwisko.getText();
					polawypelnione[2] = pesel.getText();
					polawypelnione[3] = Float.parseFloat(pensja.getText());
					polawypelnione[4] = telefon.getText();
					polawypelnione[5] = email.getText();
					polawypelnione[6] = stanowisko.getSelectedItem().toString();
					i=1;
					JOptionPane.showMessageDialog(null, "Rekord dodany pomyœlnie!");
					return polawypelnione;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "WPISZ POPRAWNE DANE!");
				}
			}
			else
			{
				i=1;
			}
		}
		return null;
	}
  
    void ShowTablePracownik(Object[][] daneKolumn) {
    	
    	System.out.println("Wyswietlam tabele pracownik");
		
		String[] nazwy_kolumn_pracownik = {"Imie", "Nazwisko", "Pesel", "Stanowisko", "Pensja", "Telefon", "Email"};
							  
		TableModel modeltable = new DefaultTableModel(daneKolumn, nazwy_kolumn_pracownik)
		{
		    public boolean isCellEditable(int row, int column)
		    {
		      return false; 
		    }
	    };
		JTable tabelpracownik = new JTable(modeltable);
		JScrollPane scrollpane = new JScrollPane(tabelpracownik);
		scrollpane.setSize(new Dimension(1150, 200));
		scrollpane.setPreferredSize(new Dimension(1150, scrollpane.getPreferredSize().height));
		
		JOptionPane.showMessageDialog(null, scrollpane, "Pracownicy", JOptionPane.OK_OPTION);
    }
    
    String deletePracownikWindow(String[] pracownicy) {
    	
    	JComboBox pracownik = new JComboBox(pracownicy);
		
		Object[] pola = {
		"Wybierz pracownika", pracownik,
		};
		String polewypelnione = null;
		String splitpracownik[] = new String[3];
		int okcancel = JOptionPane.showConfirmDialog(null, pola, "Usuñ pracownika", JOptionPane.OK_CANCEL_OPTION);
		if(okcancel == JOptionPane.OK_OPTION)
		{
			if(this.ShowYesNoMessageAfterDelete() == JOptionPane.OK_OPTION)
			{
				polewypelnione = pracownik.getSelectedItem().toString();
				splitpracownik = polewypelnione.split("-");
				
			}
			else
			{
				splitpracownik[2] = null;
			}
		}
		return splitpracownik[2];
    }
   
    Object[] editPracownikWindow(String peselv, String[] stanowiska, String[] reszta) {
    	
    	JTextField imie = new JTextField(reszta[0]);
		JTextField nazwisko = new JTextField(reszta[1]);
		JTextField pesel = new JTextField(peselv);
		JTextField pensja = new JTextField(reszta[2]);
		JTextField telefon = new JTextField(reszta[3]);
		JTextField email = new JTextField(reszta[4]);
		JComboBox stanowisko = new JComboBox(stanowiska);
		
		Object[] pola = {
		"Imie", imie,
		"Nazwisko", nazwisko,
		"Pesel", pesel,
		"Pensja", pensja,
		"Telefon", telefon,
		"Email", email,
		"Stanowisko", stanowisko
		};
		
		String PeselPattern = "^([0-9]{11})$";
		String ImieNazwiskoPattern = "^[A-Z][a-z]+$";
		String TelefonPattern = "^[0-9]{9}$";
		String EmailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern patternpesel = Pattern.compile(PeselPattern);
		Pattern patternimienazwisko = Pattern.compile(ImieNazwiskoPattern);
		Pattern patterntelefon = Pattern.compile(TelefonPattern);
		Pattern patternemail = Pattern.compile(EmailPattern);
		Matcher matcherpesel;  
		Matcher matcherimie; 
		Matcher matchernazwisko;  
		Matcher matchertelefon;  
		Matcher matcheremail;  
		int i=0;
		while(i==0)
		{
			int optionpane = JOptionPane.showConfirmDialog(null, pola, "Edytuj Pracownika", JOptionPane.OK_CANCEL_OPTION);
			
			if(optionpane == JOptionPane.OK_OPTION)
			{
				matcherpesel = patternpesel.matcher(pesel.getText().toString());
				matcherimie = patternimienazwisko.matcher(imie.getText().toString());
				matchernazwisko = patternimienazwisko.matcher(nazwisko.getText().toString());
				matchertelefon = patterntelefon.matcher(telefon.getText().toString());
				matcheremail = patternemail.matcher(email.getText());
				System.out.println(matcherpesel.matches()+" "+matcherimie.matches()+" "+matchernazwisko.matches()+" "+matchertelefon.matches()+" "+matcheremail.matches());
				if(matcherimie.matches() && matchernazwisko.matches() && matcherpesel.matches() && matchertelefon.matches() && matcheremail.matches())
				{
					Object[] polawypelnione = new Object[7];
					polawypelnione[0] = imie.getText();
					polawypelnione[1] = nazwisko.getText();
					polawypelnione[2] = pesel.getText();
					polawypelnione[3] = Float.parseFloat(pensja.getText());
					polawypelnione[4] = telefon.getText();
					polawypelnione[5] = email.getText();
					polawypelnione[6] = stanowisko.getSelectedItem().toString();
					i=1;
					JOptionPane.showMessageDialog(null, "Rekord edytowany pomyœlnie!");
					return polawypelnione;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "WPISZ POPRAWNE DANE!");
				}
			}
			else
			{
				i=1;
			}
		}
		return null;
    }
    
    void ShowRecordPracownik(String[] data) {
    	JOptionPane.showMessageDialog(null, "Imiê: "+data[0]+", Nazwisko: "+data[1]+", Pensja: "+data[2]+"pln, "
    			+ "Telefon:"+data[3]+", Email:"+data[4]+", Stanowisko:"+data[5], "Pracownik", JOptionPane.OK_OPTION);
    }

    
    //card2 methods
    Object[] addPacjentWindow() {
    	
    	JTextField imie = new JTextField();
		JTextField nazwisko = new JTextField();
		JTextField pesel = new JTextField();
		JTextField ulica = new JTextField();
		JTextField numer_domu = new JTextField();
		JTextField kod_pocztowy = new JTextField();
		JTextField miasto = new JTextField();
		JTextField email = new JTextField();
		JTextField telefon = new JTextField();
	
		Object[] pola = {
		"Imie", imie,
		"Nazwisko", nazwisko,
		"Pesel", pesel,
		"Ulica", ulica,
		"Numer domu", numer_domu,
		"Kod pocztowy", kod_pocztowy,
		"Miasto", miasto,
		"Email", email,
		"Telefon", telefon,
		};
		
		String PeselPattern = "^([0-9]{11})$";
		String ImieNazwiskoMiastoPattern = "^[A-Z][a-z]+$";
		String TelefonPattern = "^[0-9]{9}$";
		String EmailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String KodPocztowyPattern="^[0-9]{2}-[0-9]{3}$";
		Pattern patternpesel = Pattern.compile(PeselPattern);
		Pattern patternimienazwisko = Pattern.compile(ImieNazwiskoMiastoPattern);
		Pattern patterntelefon = Pattern.compile(TelefonPattern);
		Pattern patternemail = Pattern.compile(EmailPattern);
		Pattern patternkodpocztowy = Pattern.compile(KodPocztowyPattern);
		Matcher matcherpesel;  
		Matcher matcherimie; 
		Matcher matchernazwisko;  
		Matcher matchermiasto;
		Matcher matchertelefon;  
		Matcher matcheremail;  
		Matcher matcherkodpocztowy;
		int i=0;
		while(i==0)
		{
			int optionpane = JOptionPane.showConfirmDialog(null, pola, "Dodaj Pacjenta", JOptionPane.OK_CANCEL_OPTION);
			
			if(optionpane == JOptionPane.OK_OPTION)
			{
				matcherpesel = patternpesel.matcher(pesel.getText().toString());
				matcherimie = patternimienazwisko.matcher(imie.getText().toString());
				matchernazwisko = patternimienazwisko.matcher(nazwisko.getText().toString());
				matchertelefon = patterntelefon.matcher(telefon.getText().toString());
				matcheremail = patternemail.matcher(email.getText());
				matcherkodpocztowy = patternkodpocztowy.matcher(kod_pocztowy.getText());
				matchermiasto = patternimienazwisko.matcher(miasto.getText());
				System.out.println(matcherpesel.matches()+" "+matcherimie.matches()+" "+matchernazwisko.matches()+" "+matchertelefon.matches()+" "+matcheremail.matches()+" "+matcherkodpocztowy.matches());
				if(matcherimie.matches() && matchernazwisko.matches() && matcherpesel.matches() && matchermiasto.matches() && matchertelefon.matches() && matcheremail.matches() && matcherkodpocztowy.matches())
				{
					Object[] polawypelnione = new Object[9];
					polawypelnione[0] = imie.getText();
					polawypelnione[1] = nazwisko.getText();
					polawypelnione[2] = pesel.getText();
					polawypelnione[3] = ulica.getText();
					polawypelnione[4] = numer_domu.getText();
					polawypelnione[5] = kod_pocztowy.getText();
					polawypelnione[6] = miasto.getText();
					polawypelnione[7] = email.getText();
					polawypelnione[8] = telefon.getText();
					i=1;
					JOptionPane.showMessageDialog(null, "Rekord dodany pomyœlnie!");
					return polawypelnione;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "WPISZ POPRAWNE DANE!");
				}
			}
			else
			{
				i=1;
			}
		}
		return null;
    }
     
    void ShowTablePacjent(Object[][] daneKolumn) {
    	
    	System.out.println("Wyswietlam tabele pacjent");
		
		String[] nazwy_kolumn_pacjent = {"Imie", "Nazwisko", "Pesel", "Ulica", "Numer domu", "Kod pocztowy", "Miasto", "Email", "Telefon"};
							  
		TableModel modeltable = new DefaultTableModel(daneKolumn, nazwy_kolumn_pacjent)
		{
		    public boolean isCellEditable(int row, int column)
		    {
		      return false; 
		    }
	    };
		JTable tabelpacjent = new JTable(modeltable);
		JScrollPane scrollpane = new JScrollPane(tabelpacjent);
		scrollpane.setSize(new Dimension(1150, 200));
		scrollpane.setPreferredSize(new Dimension(1150, scrollpane.getPreferredSize().height));
		
		JOptionPane.showMessageDialog(null, scrollpane, "Pacjenci", JOptionPane.OK_OPTION);
    }
    
    String deletePacjentWindow(String[] pacjenci) {
    	JComboBox pacjent = new JComboBox(pacjenci);
			
		Object[] pola = {
		"Wybierz pacjenta", pacjent,
		};
		String polewypelnione = null;
		String splitpacjent[] = new String[3];
		int okcancel = JOptionPane.showConfirmDialog(null, pola, "Usuñ pacjenta", JOptionPane.OK_CANCEL_OPTION);
		if(okcancel == JOptionPane.OK_OPTION)
		{
			if(this.ShowYesNoMessageAfterDelete() == JOptionPane.OK_OPTION)
			{
				polewypelnione = pacjent.getSelectedItem().toString();
				splitpacjent = polewypelnione.split("-");
				
			}
			else
			{
				splitpacjent[2] = null;
			}
		}
		return splitpacjent[2];
    }
    
    Object[] editPacjentWindow(String peselv, String[] reszta) {
    	
    	JTextField imie = new JTextField(reszta[0]);
		JTextField nazwisko = new JTextField(reszta[1]);
		JTextField pesel = new JTextField(peselv);
		JTextField ulica = new JTextField(reszta[2]);
		JTextField numer_domu = new JTextField(reszta[3]);
		JTextField kod_pocztowy = new JTextField(reszta[4]);
		JTextField miasto = new JTextField(reszta[5]);
		JTextField email = new JTextField(reszta[6]);
		JTextField telefon = new JTextField(reszta[7]);
		
		Object[] pola = {
		"Imie", imie,
		"Nazwisko", nazwisko,
		"Pesel", pesel,
		"Ulica", ulica,
		"Numer Domu", numer_domu,
		"Kod pocztowy", kod_pocztowy,
		"Miasto", miasto,
		"Email", email,
		"Telefon", telefon
		};
		
		String PeselPattern = "^([0-9]{11})$";
		String ImieNazwiskoMiastoPattern = "^[A-Z][a-z]+$";
		String TelefonPattern = "^[0-9]{9}$";
		String EmailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String KodPocztowyPattern="^[0-9]{2}-[0-9]{3}$";
		Pattern patternpesel = Pattern.compile(PeselPattern);
		Pattern patternimienazwisko = Pattern.compile(ImieNazwiskoMiastoPattern);
		Pattern patterntelefon = Pattern.compile(TelefonPattern);
		Pattern patternemail = Pattern.compile(EmailPattern);
		Pattern patternkodpocztowy = Pattern.compile(KodPocztowyPattern);
		Matcher matcherpesel;  
		Matcher matcherimie; 
		Matcher matchernazwisko;  
		Matcher matchermiasto;
		Matcher matchertelefon;  
		Matcher matcheremail;  
		Matcher matcherkodpocztowy;
		int i=0;
		while(i==0)
		{
			int optionpane = JOptionPane.showConfirmDialog(null, pola, "Edytuj Pacjenta", JOptionPane.OK_CANCEL_OPTION);
			
			if(optionpane == JOptionPane.OK_OPTION)
			{
				matcherpesel = patternpesel.matcher(pesel.getText().toString());
				matcherimie = patternimienazwisko.matcher(imie.getText().toString());
				matchernazwisko = patternimienazwisko.matcher(nazwisko.getText().toString());
				matchertelefon = patterntelefon.matcher(telefon.getText().toString());
				matcheremail = patternemail.matcher(email.getText());
				matcherkodpocztowy = patternkodpocztowy.matcher(kod_pocztowy.getText());
				matchermiasto = patternimienazwisko.matcher(miasto.getText());
				System.out.println(matcherpesel.matches()+" "+matcherimie.matches()+" "+matchernazwisko.matches()+" "+matchertelefon.matches()+" "+matcheremail.matches()+" "+matcherkodpocztowy.matches());
				if(matcherimie.matches() && matchernazwisko.matches() && matcherpesel.matches() && matchermiasto.matches() && matchertelefon.matches() && matcheremail.matches() && matcherkodpocztowy.matches())
				{
					Object[] polawypelnione = new Object[9];
					polawypelnione[0] = imie.getText();
					polawypelnione[1] = nazwisko.getText();
					polawypelnione[2] = pesel.getText();
					polawypelnione[3] = ulica.getText();
					polawypelnione[4] = numer_domu.getText();
					polawypelnione[5] = kod_pocztowy.getText();
					polawypelnione[6] = miasto.getText();
					polawypelnione[7] = email.getText();
					polawypelnione[8] = telefon.getText();
					i=1;
					JOptionPane.showMessageDialog(null, "Rekord edytowany pomyœlnie!");
					return polawypelnione;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "WPISZ POPRAWNE DANE!");
				}
			}
			else
			{
				i=1;
			}
		}
		return null;
    }
    
    void ShowRecordPacjent(String[] data) {
    	JOptionPane.showMessageDialog(null, "Imiê: "+data[0]+", Nazwisko: "+data[1]+", Adres: "+data[2]+""
    			+ " "+data[3]+" "+data[4]+" "+data[5]+", Email: "+data[6]+", Telefon: "+data[7], "Pacjent", JOptionPane.OK_OPTION);
    }
  
    
    //card3 methods
	Object[] addWizytaWindow(String[] pracownicy, String[] pacjenci, String[] gabinety, String data) {
    	
    	JComboBox pacjent = new JComboBox(pacjenci);
    	JComboBox pracownik = new JComboBox(pracownicy);
    	JComboBox gabinet = new JComboBox(gabinety);
    	JTextField data_wizyty = new JTextField(data);
		JTextField diagnoza = new JTextField();
		
		Object[] pola = {
		"Pacjent", pacjent,
		"pracownik", pracownik,
		"Data(RRRR-MM-DD)", data_wizyty,
		"Gabinet", gabinet,
		"Diagnoza", diagnoza
		};
		
		String DataPattern = "^[2][0][1-9][1-9]-[0-1][0-9]-[0-3][0-9]$";
		Pattern patterndata = Pattern.compile(DataPattern);
		Matcher matcherdata;
		
		int i=0;
		while(i==0)
		{
			int optionpane = JOptionPane.showConfirmDialog(null, pola, "Dodaj Wizyte", JOptionPane.OK_CANCEL_OPTION);
			if(optionpane == JOptionPane.OK_OPTION)
			{
				matcherdata = patterndata.matcher(data_wizyty.getText().toString());
				if(matcherdata.matches())
				{
					String[] polawypelnione = new String[5];
					polawypelnione[0] = pacjent.getSelectedItem().toString();
					String splitspacjent[] = polawypelnione[0].split("-");
					polawypelnione[0] = splitspacjent[2];
					polawypelnione[1] = pracownik.getSelectedItem().toString();
					String splitspracownik[] = polawypelnione[1].split("-");
					polawypelnione[1] = splitspracownik[2];
					polawypelnione[2] = gabinet.getSelectedItem().toString();
					polawypelnione[3] = data_wizyty.getText();
					polawypelnione[4] = diagnoza.getText();
					i=1;
					JOptionPane.showMessageDialog(null, "Rekord dodany pomyœlnie!");
					return polawypelnione;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "B£ÊDNA DATA!");
				}				
			}
			else
			{
				i=1;
			}
		}
		return null;
    }
    
    void ShowTableWizyta(Object[][] daneKolumn) {
    	
    	System.out.println("Wyswietlam tabele wizyta");
		
		String[] nazwy_kolumn_wizyta = {"Pacjent", "Pracownik", "Gabinet", "Data wizyty", "Diagnoza"};
							  
		TableModel modeltable = new DefaultTableModel(daneKolumn, nazwy_kolumn_wizyta)
		{
		    public boolean isCellEditable(int row, int column)
		    {
		      return false; 
		    }
	    };
		JTable tabelwizyta = new JTable(modeltable);
		JScrollPane scrollpane = new JScrollPane(tabelwizyta);
		scrollpane.setSize(new Dimension(1150, 200));
		scrollpane.setPreferredSize(new Dimension(1150, scrollpane.getPreferredSize().height));
		
		JOptionPane.showMessageDialog(null, scrollpane, "Wizyty", JOptionPane.OK_OPTION);
    }
    
    String[] deleteWizytaWindow(String[] wizyty) {
    	JComboBox wizyta = new JComboBox(wizyty);
		
		Object[] pola = {
		"Wybierz wizytê", wizyta,
		};
		String polewypelnione = null;
		String splitwizyta[] = new String[4];
		int okcancel = JOptionPane.showConfirmDialog(null, pola, "Usuñ wizytê", JOptionPane.OK_CANCEL_OPTION);
		if(okcancel == JOptionPane.OK_OPTION)
		{
			if(this.ShowYesNoMessageAfterDelete() == JOptionPane.OK_OPTION)
			{
				polewypelnione = wizyta.getSelectedItem().toString();
				splitwizyta = polewypelnione.split(",");
				
			}
			else
			{
				splitwizyta[2] = null; //pesel
				splitwizyta[3] = null; //data
			}
		}
		return splitwizyta;
    }
    
    String[] editWizytaWindow(String[] peseldata, String[] reszta, String[] pracownicy, String[] pacjenci, String[] gabinety) {
    	JComboBox pacjent = new JComboBox(pacjenci);
    	JComboBox pracownik = new JComboBox(pracownicy);
    	JComboBox gabinet = new JComboBox(gabinety);
    	JTextField data_wizyty = new JTextField(peseldata[1]);
		JTextField diagnoza = new JTextField(reszta[4]);
		
		Object[] pola = {
		"Pacjent", pacjent,
		"pracownik", pracownik,
		"Data(RRRR-MM-DD)", data_wizyty,
		"Gabinet", gabinet,
		"Diagnoza", diagnoza
		};
		
		String DataPattern = "^[2][0][1-9][1-9]-[0-1][0-9]-[0-3][0-9]$";
		Pattern patterndata = Pattern.compile(DataPattern);
		Matcher matcherdata;
		
		int i=0;
		while(i==0)
		{
			int optionpane = JOptionPane.showConfirmDialog(null, pola, "Edytuj Wizyte", JOptionPane.OK_CANCEL_OPTION);
			if(optionpane == JOptionPane.OK_OPTION)
			{
				matcherdata = patterndata.matcher(data_wizyty.getText().toString());
				if(matcherdata.matches())
				{
					String[] polawypelnione = new String[5];
					polawypelnione[0] = pacjent.getSelectedItem().toString();
					String splitspacjent[] = polawypelnione[0].split("-");
					polawypelnione[0] = splitspacjent[2];
					polawypelnione[1] = pracownik.getSelectedItem().toString();
					String splitspracownik[] = polawypelnione[1].split("-");
					polawypelnione[1] = splitspracownik[2];
					polawypelnione[2] = gabinet.getSelectedItem().toString();
					polawypelnione[3] = data_wizyty.getText();
					polawypelnione[4] = diagnoza.getText();
					i=1;
					JOptionPane.showMessageDialog(null, "Rekord edytowany pomyœlnie!");
					return polawypelnione;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "B£ÊDNA DATA!");
				}				
			}
			else
			{
				i=1;
			}
		}
		return null;
    }
    
    void ShowRecordWizyta(String[] data) {
    	JOptionPane.showMessageDialog(null, "Pacjent: "+data[0]+", Pracownik:"
    			+ " "+data[1]+", Gabinet:"+data[2]+", Data wizyty:"+data[3]+", Diagnoza:"+data[4], "Wizyta", JOptionPane.OK_OPTION);
    }
    
    
    //card4 methods
    Object[] addGabinetWindow() {
    	JTextField numer = new JTextField();
		JTextField pietro = new JTextField();
			
		Object[] pola = {
		"Numer", numer,
		"Piêtro", pietro,
		};
		
		String PietroPattern = "^[0-5]$";
		Pattern patternpietro = Pattern.compile(PietroPattern);
		Matcher matcherpietro;
		
		int i=0;
		while(i==0)
		{
			int optionpane = JOptionPane.showConfirmDialog(null, pola, "Dodaj Gabinet", JOptionPane.OK_CANCEL_OPTION);
			if(optionpane == JOptionPane.OK_OPTION)
			{
				matcherpietro = patternpietro.matcher(pietro.getText().toString());
				if(matcherpietro.matches())
				{
					Object[] polawypelnione = new Object[2];
					polawypelnione[0] = numer.getText();
					polawypelnione[1] = Integer.parseInt(pietro.getText());
					i=1;
					JOptionPane.showMessageDialog(null, "Rekord dodany pomyœlnie!");
					return polawypelnione;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Nie mamy tyle piêter, to nie drapacz chmur! :(");
				}
			}
			else
			{
				i=1;
			}
		}
		return null;
    }
    
    void ShowTableGabinet(Object[][] daneKolumn) {
    	
    	System.out.println("Wyswietlam tabele gabinet");
			
		String[] nazwy_kolumn_gabinet = {"Numer", "Pietro"};
							  
		TableModel modeltable = new DefaultTableModel(daneKolumn, nazwy_kolumn_gabinet)
		{
		    public boolean isCellEditable(int row, int column)
		    {
		      return false; 
		    }
	    };
		JTable tabelgabinet = new JTable(modeltable);
		JScrollPane scrollpane = new JScrollPane(tabelgabinet);
		
		//scrollkajak.setVisible(true);
		JOptionPane.showMessageDialog(null, scrollpane, "Gabinety", JOptionPane.OK_OPTION);
    }

    String deleteGabinetWindow(String[] gabinety) {
    	
    	JComboBox gabinet = new JComboBox(gabinety);
		
		Object[] pola = {
		"Wybierz gabinet", gabinet,
		};
		String polewypelnione = null;
		int okcancel = JOptionPane.showConfirmDialog(null, pola, "Usuñ gabinet", JOptionPane.OK_CANCEL_OPTION);
		if(okcancel == JOptionPane.OK_OPTION)
		{
			if(this.ShowYesNoMessageAfterDelete() == JOptionPane.OK_OPTION)
			{
				polewypelnione = gabinet.getSelectedItem().toString();
				
			}
			else
			{
				polewypelnione = null;
			}
		}
		return polewypelnione;
    }

    String[] editGabinetWindow(String numerv, int reszta) {
    	JTextField numer = new JTextField(numerv);
		JTextField pietro = new JTextField(reszta);
			
		Object[] pola = {
		"Numer", numer,
		"Piêtro", pietro,
		};
		
		String PietroPattern = "^[0-5]$";
		Pattern patternpietro = Pattern.compile(PietroPattern);
		Matcher matcherpietro;
		
		int i=0;
		while(i==0)
		{
			int optionpane = JOptionPane.showConfirmDialog(null, pola, "Edytuj Gabinet", JOptionPane.OK_CANCEL_OPTION);
			if(optionpane == JOptionPane.OK_OPTION)
			{
				matcherpietro = patternpietro.matcher(pietro.getText().toString());
				if(matcherpietro.matches())
				{
					String[] polawypelnione = new String[2];
					polawypelnione[0] = numer.getText();
					polawypelnione[1] = pietro.getText();
					i=1;
					JOptionPane.showMessageDialog(null, "Rekord edytowany pomyœlnie!");
					return polawypelnione;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Nie mamy tyle piêter, to nie drapacz chmur! :(");
				}
			}
			else
			{
				i=1;
			}
		}
		return null;
    }
    
    void ShowRecordGabinet(String numer, int pietro) {
    	JOptionPane.showMessageDialog(null, "Numer: "+numer+", Piêtro: "+pietro, "Gabinet", JOptionPane.OK_OPTION);
    }
    
    
    //card5 methods
    Object[] addStanowiskoWindow() {
    	
    	JTextField nazwa = new JTextField();
			
		Object[] pola = {
		"Nazwa", nazwa,
		};
		
		int optionpane = JOptionPane.showConfirmDialog(null, pola, "Dodaj Stanowisko", JOptionPane.OK_CANCEL_OPTION);
		if(optionpane == JOptionPane.OK_OPTION)
		{
			Object[] polawypelnione = new Object[1];
			polawypelnione[0] = nazwa.getText();
			JOptionPane.showMessageDialog(null, "Dodano rekord pomyœlnie!");
			return polawypelnione;
		}
		else
		{
			return null;
		}
    }
    
    void ShowTableStanowisko(Object[][] daneKolumn) {
    	
    	System.out.println("Wyswietlam tabele stanowisko");
		
		String[] nazwy_kolumn_stanowisko = {"L.P.", "Stanowisko"};
							  
		TableModel modeltable = new DefaultTableModel(daneKolumn, nazwy_kolumn_stanowisko)
		{
		    public boolean isCellEditable(int row, int column)
		    {
		      return false; 
		    }
	    };
		JTable tabelstanowisko = new JTable(modeltable);
		JScrollPane scrollpane = new JScrollPane(tabelstanowisko);
		
		JOptionPane.showMessageDialog(null, scrollpane, "Stanowiska", JOptionPane.OK_OPTION);
    }
    
    String deleteStanowiskoWindow(String[] stanowiska) {
    	
    	JComboBox stanowisko = new JComboBox(stanowiska);
		
		Object[] pola = {
		"Wybierz stanowisko", stanowisko,
		};
		String polewypelnione = null;
		int okcancel = JOptionPane.showConfirmDialog(null, pola, "Usuñ stanowisko", JOptionPane.OK_CANCEL_OPTION);
		if(okcancel == JOptionPane.OK_OPTION)
		{
			if(this.ShowYesNoMessageAfterDelete() == JOptionPane.OK_OPTION)
			{
				polewypelnione = stanowisko.getSelectedItem().toString();
				
			}
			else
			{
				polewypelnione = null;
			}
		}
		return polewypelnione;
    }
    
    String[] editStanowiskoWindow(String nazwav) {
    	
    	JTextField nazwa = new JTextField(nazwav);
		
		Object[] pola = {
		"Nazwa", nazwa,
		};
		
		int optionpane = JOptionPane.showConfirmDialog(null, pola, "Edytuj Stanowisko", JOptionPane.OK_CANCEL_OPTION);
		if(optionpane == JOptionPane.OK_OPTION)
		{
			String[] polawypelnione = new String[1];
			polawypelnione[0] = nazwa.getText();
			JOptionPane.showConfirmDialog(null, "Edytowano rekord pomyœlnie!");
			return polawypelnione;
		}
		else
		{
			return null;
		}
    }
    
    
    //card6 methods
    Object[] addChorobaWindow() {
    	JTextField nazwa = new JTextField();
    	JTextField objawy = new JTextField();
    	JTextField sposob_leczenia = new JTextField();
    	JTextField okres_leczenia = new JTextField();
		
		Object[] pola = {
		"Nazwa", nazwa,
		"Objawy", objawy,
		"Sposób leczenia", sposob_leczenia,
		"Okres leczenia", okres_leczenia
		};
		
		int optionpane = JOptionPane.showConfirmDialog(null, pola, "Dodaj Chorobê", JOptionPane.OK_CANCEL_OPTION);
		if(optionpane == JOptionPane.OK_OPTION)
		{
			Object[] polawypelnione = new Object[4];
			polawypelnione[0] = nazwa.getText();
			polawypelnione[1] = objawy.getText();
			polawypelnione[2] = sposob_leczenia.getText();
			polawypelnione[3] = okres_leczenia.getText();
			JOptionPane.showMessageDialog(null, "Dodano rekord pomyœlnie!");
			return polawypelnione;
		}
		else
		{
			return null;
		}
    }
    
    void ShowTableChoroba(Object[][] daneKolumn) {
System.out.println("Wyswietlam tabele stanowisko");
		
		String[] nazwy_kolumn_choroba = {"Nazwa", "Objawy", "Sposób leczenia", "Okres leczenia"};
							  
		TableModel modeltable = new DefaultTableModel(daneKolumn, nazwy_kolumn_choroba)
		{
		    public boolean isCellEditable(int row, int column)
		    {
		      return false; 
		    }
	    };
		JTable tabelchoroba = new JTable(modeltable);
		JScrollPane scrollpane = new JScrollPane(tabelchoroba);
		scrollpane.setSize(new Dimension(1150, 200));
		scrollpane.setPreferredSize(new Dimension(1150, scrollpane.getPreferredSize().height));
		
		JOptionPane.showMessageDialog(null, scrollpane, "Choroby", JOptionPane.OK_OPTION);
    }
    
    String deleteChorobaWindow(String[] choroby) {
    	
    	JComboBox choroba = new JComboBox(choroby);
		
		Object[] pola = {
		"Wybierz chorobê", choroba,
		};
		String polewypelnione = null;
		int okcancel = JOptionPane.showConfirmDialog(null, pola, "Usuñ chorobê", JOptionPane.OK_CANCEL_OPTION);
		if(okcancel == JOptionPane.OK_OPTION)
		{
			if(this.ShowYesNoMessageAfterDelete() == JOptionPane.OK_OPTION)
			{
				polewypelnione = choroba.getSelectedItem().toString();
				
			}
			else
			{
				polewypelnione = null;
			}
		}
		return polewypelnione;
    }
    
    void showRecordChoroba(String[] records) {
    	JOptionPane.showMessageDialog(null, "Nazwa:"+records[0]+", Objawy:"+records[1]+", Sposób leczenia:"+records[2]+","
    			+ " Okres leczenia:"+records[3], "Choroba", JOptionPane.OK_OPTION);
    }
    
    String[] editChorobaWindow(String nazwav, String[] reszta) {
    	
    	JTextField nazwa = new JTextField(nazwav);
    	JTextField objawy = new JTextField(reszta[1]);
    	JTextField sposob_leczenia = new JTextField(reszta[2]);
    	JTextField okres_leczenia = new JTextField(reszta[3]);
		
		Object[] pola = {
		"Nazwa", nazwa,
		"Objawy", objawy,
		"Sposób leczenia", sposob_leczenia,
		"Okres leczenia", okres_leczenia
		};
		
		int optionpane = JOptionPane.showConfirmDialog(null, pola, "Edytuj Chorobê", JOptionPane.OK_CANCEL_OPTION);
		if(optionpane == JOptionPane.OK_OPTION)
		{
			String[] polawypelnione = new String[4];
			polawypelnione[0] = nazwa.getText();
			polawypelnione[1] = objawy.getText();
			polawypelnione[2] = sposob_leczenia.getText();
			polawypelnione[3] = okres_leczenia.getText();
			JOptionPane.showMessageDialog(null, "Edytowano rekord pomyœlnie!");
			return polawypelnione;
		}
		else
		{
			return null;
		}	
    }
    
    
    //card8 methods
    void ShowTableHistChor(Object[][] daneKolumn) {
    	
    	System.out.println("Wyswietlam tabele hist_chor");
		
		String[] nazwy_kolumn_wizyta = {"Pacjent", "Pracownik", "Data wizyty", "Diagnoza", "Choroba"};
							  
		TableModel modeltable = new DefaultTableModel(daneKolumn, nazwy_kolumn_wizyta)
		{
		    public boolean isCellEditable(int row, int column)
		    {
		      return false; 
		    }
	    };
		JTable tabelwizyta = new JTable(modeltable);
		JScrollPane scrollpane = new JScrollPane(tabelwizyta);
		scrollpane.setSize(new Dimension(1150, 200));
		scrollpane.setPreferredSize(new Dimension(1150, scrollpane.getPreferredSize().height));
		
		JOptionPane.showMessageDialog(null, scrollpane, "Wizyty", JOptionPane.OK_OPTION);
    }
    
    Object[] addHistChorWindow(String[] wizyty, String[] choroby) {
    	
    	JComboBox wizyta = new JComboBox(wizyty);
		JComboBox choroba = new JComboBox(choroby);
		
		Object[] pola = {
		"Wizyta(Pacjent, lekarz, data, diagnoza)", wizyta,
		"Choroba", choroba,
		};
		
		int optionpane = JOptionPane.showConfirmDialog(null, pola, "Dodaj chorobê do wizyty", JOptionPane.OK_CANCEL_OPTION);
		if(optionpane == JOptionPane.OK_OPTION)
		{
			String[] polawypelnione = new String[10];
			polawypelnione[0] = wizyta.getSelectedItem().toString();
			String splitwizyta[] = polawypelnione[0].split(";");
			polawypelnione[1] = splitwizyta[0];
			polawypelnione[2] = splitwizyta[1];
			polawypelnione[3] = splitwizyta[2];
			polawypelnione[4] = splitwizyta[3];
			polawypelnione[5] = splitwizyta[4];
			polawypelnione[6] = splitwizyta[5];
			polawypelnione[7] = splitwizyta[6];
			polawypelnione[8] = splitwizyta[7];    
			polawypelnione[9] = choroba.getSelectedItem().toString();
			JOptionPane.showMessageDialog(null, "Dodano rekord pomyœlnie!");
			return polawypelnione;
		}
		else
		{
			return null;
		}
    }
    
    
    //default methods
    void ShowOkErrorMessageAfterAdd(String okerror) {
    	String message = null;
  
    	if(okerror=="OK")
    	{
    		message = "Rekord dodany pomyœlnie!";
       	}
    	else
    	{
    		message = "B£¹D: Sprawdz, czy wpisa³eœ dane poprawnie!";
    	}
    	JOptionPane.showMessageDialog(panel1, message);
    }
    
    int ShowYesNoMessageAfterDelete() {
    	 int dialogButton = JOptionPane.YES_NO_OPTION;
         int dialogResult = JOptionPane.showConfirmDialog (null, "Czy napewno chcesz skasowaæ dany rekord?","UWAGA!",dialogButton);
         return dialogResult;
    }
	
    void ShowErrorMessageAfterEdit() {
    	JOptionPane.showMessageDialog(null, "Wpisz poprawne dane w pole!", "B£¥D!", JOptionPane.OK_OPTION);
    }
    
	void addListenerToButton(JButton button, ActionListener listener){
		button.addActionListener(listener);	
	}
	
	void WhatWouldYouSeeMore() {
		JOptionPane.showMessageDialog(null, "A co byœ chcia³ tu wiêcej wyœwietliæ? :)");
	}
}
