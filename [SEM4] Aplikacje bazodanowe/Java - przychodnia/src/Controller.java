import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class Controller {
	
	private View view;
	private Model model;
 	
	
	Controller(View view, Model model){
		
		this.view = view;
		this.model = model;
		//card1
		this.view.addListenerToButton(view.ButtonShowCard1, new PracownikButtonShowListener());
		this.view.addListenerToButton(view.ButtonAddCard1, new PracownikButtonAddListener());
		this.view.addListenerToButton(view.ButtonEditCard1, new PracownikButtonEditListener());
		this.view.addListenerToButton(view.ButtonDeleteCard1, new PracownikButtonDeleteListener());
		this.view.addListenerToButton(view.ButtonShowOneCard1, new PracownikButtonShowOneListener());
		
		//card2
		this.view.addListenerToButton(view.ButtonShowCard2, new PacjentButtonShowListener());
		this.view.addListenerToButton(view.ButtonAddCard2, new PacjentButtonAddListener());
		this.view.addListenerToButton(view.ButtonDeleteCard2, new PacjentButtonDeleteListener());
		this.view.addListenerToButton(view.ButtonEditCard2, new PacjentButtonEditListener());
		this.view.addListenerToButton(view.ButtonShowOneCard2, new PacjentButtonShowOneListener());
		
		//card3
		this.view.addListenerToButton(view.ButtonShowCard3, new WizytaButtonShowListener());
		this.view.addListenerToButton(view.ButtonAddCard3, new WizytaButtonAddListener());
		this.view.addListenerToButton(view.ButtonDeleteCard3, new WizytaButtonDeleteListener());
		this.view.addListenerToButton(view.ButtonEditCard3, new WizytaButtonEditListener());
		this.view.addListenerToButton(view.ButtonShowOneCard3, new WizytaButtonShowOneListener());
		
		//card4
		this.view.addListenerToButton(view.ButtonShowCard4, new GabinetButtonShowListener());
		this.view.addListenerToButton(view.ButtonAddCard4, new GabinetButtonAddListener());
		this.view.addListenerToButton(view.ButtonDeleteCard4, new GabinetButtonDeleteListener());
		this.view.addListenerToButton(view.ButtonEditCard4, new GabinetButtonEditListener());
		this.view.addListenerToButton(view.ButtonShowOneCard4, new GabinetButtonShowOneListener());
		
		//card5
		this.view.addListenerToButton(view.ButtonShowCard5, new StanowiskoButtonShowListener());
		this.view.addListenerToButton(view.ButtonAddCard5, new StanowiskoButtonAddListener());
		this.view.addListenerToButton(view.ButtonDeleteCard5, new StanowiskoButtonDeleteListener());
		this.view.addListenerToButton(view.ButtonEditCard5, new StanowiskoButtonEditListener());
		this.view.addListenerToButton(view.ButtonShowOneCard5, new StanowiskoButtonShowOneListener());
		
		//card6
		this.view.addListenerToButton(view.ButtonShowCard6, new ChorobaButtonShowListener());
		this.view.addListenerToButton(view.ButtonAddCard6, new ChorobaButtonAddListener());
		this.view.addListenerToButton(view.ButtonDeleteCard6, new ChorobaButtonDeleteListener());
		this.view.addListenerToButton(view.ButtonEditCard6, new ChorobaButtonEditListener());
		this.view.addListenerToButton(view.ButtonShowOneCard6, new ChorobaButtonShowOneListener());
		
		//card7
		this.view.addListenerToButton(view.ButtonAddExampleRecords, new AddExampleRecordsListener());
		this.view.addListenerToButton(view.ButtonCreateTables, new CreateTablesListener());
		
		//card8 
		this.view.addListenerToButton(view.ButtonShowCard8, new HistChorButtonShowListener());
		this.view.addListenerToButton(view.ButtonAddCard8, new HistChorButtonAddListener());
		this.view.addListenerToButton(view.ButtonDeleteCard8, new HistChorButtonDeleteListener());
	}
	
	//card1 listeners
	public class PracownikButtonShowListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			view.ShowTablePracownik(model.selectAllFromPracownik());		
		}
		
	}
	
	public class PracownikButtonAddListener implements ActionListener {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String message = null;
				System.out.println("Kliknieto przycisk Dodaj Pracownika");
				String stanowiska[]=model.selectNazwaFromStanowisko();
				try {
					model.insertIntoPracownik(view.addPracownikWindow(stanowiska));
					message="OK";
				} catch (SQLException e1) {
					message="ERROR";				
				}
				//view.ShowOkErrorMessageAfterAdd(message);
				
	         }	
		
	}
	
	public class PracownikButtonEditListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Kliknieto przycisk Edytuj Pracownika");
			String pesel = view.filterTextPracownik.getText();
			System.out.println("PESEL: "+pesel);
			String stanowiska[]=model.selectNazwaFromStanowisko();
			String[] reszta; 
			try{
				reszta = model.selectFromPracownikByPesel(pesel);
				model.editTablePracownik(view.editPracownikWindow(pesel, stanowiska, reszta));
			} catch(SQLException ex) {
				view.ShowErrorMessageAfterEdit();
				ex.printStackTrace();
			}
			
		}
				
    }	
	
	public class PracownikButtonDeleteListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			System.out.println("Kliknieto przycisk Usuñ Pracownika");
			String pracownicy[]=model.selectImieNazwiskoPeselFromPracownik();
			
			try {
				model.deleteFromPracownik(view.deletePracownikWindow(pracownicy));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}	
	}
		
	public class PracownikButtonShowOneListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			System.out.println("Kliknieto przycisk Poka¿ Informacje (pracownik)");
			String pesel = view.filterTextPracownik.getText();
			System.out.println("PESEL: "+pesel);
			String[] reszta =  model.selectFromPracownikByPesel(pesel);
			if(view.filterTextPracownik.getText().equals("") || reszta[1].equals(""))
			{
				view.ShowErrorMessageAfterEdit();
			}
			else
			{
				view.ShowRecordPracownik(reszta);			
			}
		}
	}
		
	
	
	//card2 listeners
	public class PacjentButtonShowListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.ShowTablePacjent(model.selectAllFromPacjent());
		}
		
	}
	
	public class PacjentButtonAddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Kliknieto przycisk Dodaj Pacjenta");
			Object[] check = new String [9];
			check = view.addPacjentWindow();
			if(!check[2].equals(""))
			{
			try {
				model.insertIntoPacjent(check);
				
			} catch (SQLException e1) {
				e1.printStackTrace();				
			}
			}
			
		}
		
	}
	
	public class PacjentButtonEditListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Kliknieto przycisk Edytuj Pacjenta");
			String pesel = view.filterTextPacjent.getText();
			System.out.println("PESEL: "+pesel);
			String[] reszta;
			try {
				reszta = model.selectFromPacjentByPesel(pesel);
				model.editTablePacjent(view.editPacjentWindow(pesel, reszta));
			} catch (SQLException e) {
				view.ShowErrorMessageAfterEdit();
				e.printStackTrace();
			}
			
		}
		
	}
	
	public class PacjentButtonDeleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			System.out.println("Kliknieto przycisk Usuñ Pacjenta");
			String pacjenci[]=model.selectImieNazwiskoPeselFromPacjent();
			
			try {
				model.deleteFromPacjent(view.deletePacjentWindow(pacjenci));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public class PacjentButtonShowOneListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Kliknieto przycisk Poka¿ Informacje (pacjent)");
			String pesel = view.filterTextPacjent.getText();
			System.out.println("PESEL: "+pesel);
			String[] reszta;
			try {
				reszta = model.selectFromPacjentByPesel(pesel);
				view.ShowRecordPacjent(reszta);	
			} catch (SQLException e1) {
				view.ShowErrorMessageAfterEdit();
				e1.printStackTrace();
			}
			
		}
		
	}
	
	
	//card3 listeners
	public class WizytaButtonShowListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.ShowTableWizyta(model.selectAllFromWizyta());
		}
		
	}
	
	public class WizytaButtonAddListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String message = null;
			System.out.println("Kliknieto przycisk Dodaj Wizyte");
			String pracownicy[]=model.selectImieNazwiskoPeselFromPracownik();
			String pacjenci[]=model.selectImieNazwiskoPeselFromPacjent();
			String gabinety[]=model.selectNumerFromGabinet();
			try {
				model.insertIntoWizyta(view.addWizytaWindow(pracownicy, pacjenci, gabinety, model.currentDateString()));
				message="OK";
			} catch (SQLException e1) {
				message="ERROR";				
			}
			//view.ShowOkErrorMessageAfterAdd(message);
			
         }	
	}
	
	public class WizytaButtonEditListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Kliknieto przycisk Edytuj Wizytê");
			String peseldata[] = view.filterTextWizyta.getText().split(";");
			if(peseldata.length == 2)
			{
				System.out.println("Data: " + peseldata[1] + "PESEL: " + peseldata[0]);
				String[] reszta =  model.selectFromWizytaByDataPesel(peseldata);
				String pracownicy[]=model.selectImieNazwiskoPeselFromPracownik();
				String pacjenci[]=model.selectImieNazwiskoPeselFromPacjent();
				String gabinety[]=model.selectNumerFromGabinet();
				if(view.filterTextWizyta.getText().equals("") || peseldata[1].equals(""))
				{
					view.ShowErrorMessageAfterEdit();
				}
				else
				{
					try {
						model.editTableWizyta(view.editWizytaWindow(peseldata, reszta, pracownicy, pacjenci, gabinety));
					} catch (SQLException e1) {
						e1.printStackTrace();				
					}
				}
			}
			else
			{
				view.ShowErrorMessageAfterEdit();
			}
		}
		
	}
	
	public class WizytaButtonDeleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Kliknieto przycisk Usuñ Gabinet");
			String wizyty[]=model.selectPacjentDataFromWizyta();
			
			try {
				model.deleteFromWizyta(view.deleteWizytaWindow(wizyty));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public class WizytaButtonShowOneListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			System.out.println("Kliknieto przycisk Poka¿ Informacje (wizyta)");
			String peseldata[] = view.filterTextWizyta.getText().split(";");
			if(peseldata.length == 2)
			{
				System.out.println("PESEL: "+peseldata[0]+ " Data:"+peseldata[1]);
				String[] reszta =  model.selectFromWizytaByDataPesel(peseldata);
				if(view.filterTextWizyta.getText().equals("") || reszta[1].equals(""))
				{
					view.ShowErrorMessageAfterEdit();
				}
				else
				{
					view.ShowRecordWizyta(reszta);			
				}
			}
			else
			{
				view.ShowErrorMessageAfterEdit();
			}
			
		}
		
	}
	
	
	//card4 listeners
	public class GabinetButtonShowListener implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.ShowTableGabinet(model.selectAllFromGabinet());
				
	         }	
       }
 
	public class GabinetButtonAddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String message = null;
			System.out.println("Kliknieto przycisk Dodaj Gabinet");
			try {
				model.insertIntoGabinet((view.addGabinetWindow()));
				message="OK";
			} catch (SQLException e1) {
				message="ERROR";				
			}
			//view.ShowOkErrorMessageAfterAdd(message);
			
		}
		
	}

	public class GabinetButtonEditListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Kliknieto przycisk Edytuj Gabinet");
			String numer = view.filterTextGabinet.getText();
			System.out.println("numer: "+numer);
			int reszta =  model.selectFromGabinetByNumer(numer);
			if(view.filterTextGabinet.getText().equals(""))
			{
				view.ShowErrorMessageAfterEdit();
			}
			else
			{
				try {
					model.editTableGabinet(view.editGabinetWindow(numer, reszta));
				} catch (SQLException e1) {
					e1.printStackTrace();				
				}
			} 
		}
		
	}
	
	public class GabinetButtonDeleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			System.out.println("Kliknieto przycisk Usuñ Gabinet");
			String gabinety[]=model.selectNumerFromGabinet();
			
			try {
				model.deleteFromGabinet(view.deleteGabinetWindow(gabinety));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}

	public class GabinetButtonShowOneListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Kliknieto przycisk Poka¿ Informacje (gabinet)");
			String numer = view.filterTextGabinet.getText();
			System.out.println("numer: "+numer);
			int pietro =  model.selectFromGabinetByNumer(numer);
			if(view.filterTextGabinet.getText().equals("") || pietro<0 || pietro>10)
			{
				view.ShowErrorMessageAfterEdit();
			}
			else
			{
				view.ShowRecordGabinet(numer, pietro);			
			}
		}
		
	}
	
	
	//card5 listeners
	public class StanowiskoButtonShowListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.ShowTableStanowisko(model.selectAllFromStanowisko());		
		}
		
	}

	public class StanowiskoButtonAddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String message = null;
			System.out.println("Kliknieto przycisk Dodaj Stanowisko");
			try {
				model.insertIntoStanowisko((view.addStanowiskoWindow()));
				message="OK";
			} catch (SQLException e1) {
				message="ERROR";				
			}
			//view.ShowOkErrorMessageAfterAdd(message);
			
		}
		
	}

	public class StanowiskoButtonEditListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Kliknieto przycisk Edytuj Stanowisko");
			String nazwa = view.filterTextStanowisko.getText();
			System.out.println("nazwa: "+nazwa);
			if(view.filterTextStanowisko.getText().equals(""))
			{
				view.ShowErrorMessageAfterEdit();
			}
			else
			{
				try {
					model.editTableStanowisko(view.editStanowiskoWindow(nazwa));
				} catch (SQLException e1) {
					e1.printStackTrace();				
				}
			} 
		}
		
	}
	
	public class StanowiskoButtonDeleteListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			System.out.println("Kliknieto przycisk Usuñ Stanowisko");
			String stanowiska[]=model.selectNazwaFromStanowisko();
			
			try {
				model.deleteFromStanowisko(view.deleteStanowiskoWindow(stanowiska));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public class StanowiskoButtonShowOneListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.WhatWouldYouSeeMore();
		}
		
	}
	
	
	//card6 listeners
	public class ChorobaButtonShowListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.ShowTableChoroba(model.selectAllFromChoroba());		
		}
		
	}

	public class ChorobaButtonAddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String message = null;
			System.out.println("Kliknieto przycisk Dodaj Chorobê");
			try {
				model.insertIntoChoroba((view.addChorobaWindow()));
				message="OK";
			} catch (SQLException e1) {
				message="ERROR";				
			}
			//view.ShowOkErrorMessageAfterAdd(message);
		}
		
	}

	public class ChorobaButtonEditListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Kliknieto przycisk Edytuj Chorobê");
			String nazwa = view.filterTextChoroba.getText();
			System.out.println("nazwa: "+nazwa);
			String[] reszta =  model.selectFromChorobaByNazwa(nazwa);
			if(view.filterTextChoroba.getText().equals(""))
			{
				view.ShowErrorMessageAfterEdit();
			}
			else
			{
				try {
					model.editTableChoroba(view.editChorobaWindow(nazwa, reszta));
				} catch (SQLException e1) {
					e1.printStackTrace();				
				}
			}
		
		}
	}
	
	public class ChorobaButtonDeleteListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {

			System.out.println("Kliknieto przycisk Usuñ Chorobê");
			String choroby[]=model.selectNazwaFromChoroba();
			
			try {
				model.deleteFromChoroba(view.deleteChorobaWindow(choroby));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

	
		}
	}

	public class ChorobaButtonShowOneListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Kliknieto przycisk Poka¿ Informacje (choroba)");
			String nazwa = view.filterTextChoroba.getText();
			System.out.println("nazwa: "+nazwa);
			String[] reszta =  model.selectFromChorobaByNazwa(nazwa);
			if(view.filterTextChoroba.getText().equals("") || reszta[1].equals(""))
			{
				view.ShowErrorMessageAfterEdit();
			}
			else
			{
				view.showRecordChoroba(reszta);			
			}
		}
		
	}
	
	
	//card7 listeners
	public class AddExampleRecordsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.insertExampleRecords();
		}
		
	}

	public class CreateTablesListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			model.createTables();		
		}
		
	}

	
	//card8 listeners
	public class HistChorButtonShowListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.ShowTableHistChor(model.selectAllFromHistChor());
			System.out.println("Kliknieto histchor show");
			
		}
		
	}

	public class HistChorButtonAddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String message = null;
			System.out.println("Kliknieto przycisk Dodaj Hist Chor");
			String wizyty[] = model.selectFromWizyta();
			String choroby[] = model.selectNazwaFromChoroba();
			try {
				model.insertIntoHistChor(view.addHistChorWindow(wizyty, choroby));
				message="OK";
			} catch (SQLException e1) {
				message="ERROR";				
			}
			//view.ShowOkErrorMessageAfterAdd(message);
		}
		
	}

	public class HistChorButtonDeleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
}
	

