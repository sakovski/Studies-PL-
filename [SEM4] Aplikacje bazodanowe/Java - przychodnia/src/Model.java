import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Model {
	
	DBConnection connection = new DBConnection();
	
	public Model() {
		
		connection.connectDB();
	}
	
	//tab1 methods
	String[] selectNazwaFromStanowisko() {
		
		String[] stanowiska = new String[100];
		try {
			ResultSet result = DBConnection.stmt.executeQuery("SELECT nazwa FROM stanowisko");
			int iter;
			for(iter=0; iter<100 && result.next(); iter++) {
				stanowiska[iter] = result.getString("nazwa");
			}
		} catch (SQLException e) {
			System.err.println("Blad przy wykonywaniu SELECT nazwa FROM stanowisko");
			e.printStackTrace();
		}
		return stanowiska;
		
	}
	
	void insertIntoPracownik(Object[] records) throws NumberFormatException, SQLException {
		String sql = "INSERT INTO pracownik(idstanowisko, imie, nazwisko, pesel, pensja, telefon, email) "
				+ "VALUES((SELECT id_stanowisko FROM stanowisko WHERE nazwa = '"+records[6]+"'),"
				+ "'"+records[0]+"', '"+records[1]+"', '"+records[2]+"', "+records[3]+", '"+records[4]+"', '"+records[5]+"');";
		try {
			DBConnection.stmt.execute(sql);
			System.out.println("Model: Dodano pomyslnie pracownika");
			
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			throw e1;
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy dodawaniu rekordu do tabeli pracownik");
			e2.printStackTrace();
			throw e2;	
		}
			
	}
	
	Object[][] selectAllFromPracownik() {
		
		Object[][] danePracownik = new Object[100][7];
		String sqlmain = "SELECT imie, nazwisko, pesel, pensja, telefon, email, "
					+ "(SELECT nazwa FROM stanowisko WHERE id_stanowisko=idstanowisko) AS stanowisko FROM pracownik";
	
		try {
			ResultSet result = DBConnection.stmt.executeQuery(sqlmain);
			int iter = 0;
			while(result.next()) {
				danePracownik[iter][0] = result.getString("imie"); 
				danePracownik[iter][1] = result.getString("nazwisko");
				danePracownik[iter][2] = result.getString("pesel");
				danePracownik[iter][3] = result.getString("stanowisko");
				danePracownik[iter][4] = result.getString("pensja");
				danePracownik[iter][5] = result.getString("telefon");
				danePracownik[iter][6] = result.getString("email");
				
				iter++;
			}
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy zapytaniu SELECT * FROM pracownik");
			e2.printStackTrace();	
		}
		
		return danePracownik;
	}
	
	void deleteFromPracownik(Object objects) throws SQLException {
		String sql = "DELETE FROM pracownik WHERE pesel = '"+objects+"'";
		try {
			DBConnection.stmt.execute(sql);
			System.out.println("Model: Usuniêto pomyœlnie pracownika");
			
		}  catch (SQLException e2) {
			System.err.println("Model: Blad przy usuwaniu rekordu z tabeli pracownik");
			e2.printStackTrace();
			throw e2;	
		}
	}
	
	String[] selectFromPracownikByPesel(String pesel) {
		
		String[] danePracownik = new String[7];
		String sqlmain = "SELECT imie, nazwisko, pensja, telefon, email, "
					+ "(SELECT nazwa FROM stanowisko WHERE id_stanowisko=idstanowisko) AS stanowisko FROM pracownik WHERE pesel='"+pesel+"';";
	
		try {
				ResultSet result = DBConnection.stmt.executeQuery(sqlmain);		
				danePracownik[0] = result.getString("imie"); 
				danePracownik[1] = result.getString("nazwisko");
				danePracownik[2] = result.getString("pensja");
				danePracownik[3] = result.getString("telefon");
				danePracownik[4] = result.getString("email");
				danePracownik[5] = result.getString("stanowisko");
				
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy zapytaniu SELECT * FROM pracownik by PESEL");
			e2.printStackTrace();	
		}
		
		return danePracownik;
	}
	
	void editTablePracownik(Object[] objects) throws SQLException {
		this.deleteFromPracownik(objects[2]);
		this.insertIntoPracownik(objects);
	}
	
	
	//tab2 methods
	Object[][] selectAllFromPacjent() {
		Object[][] danePacjent = new Object[100][9];
		String sql = "SELECT imie, nazwisko, pesel, ulica, numer_domu, kod_pocztowy, miasto, email, telefon FROM pacjent;";
		try {
			ResultSet result = DBConnection.stmt.executeQuery(sql);
			int iter = 0;
			while(result.next()) {
				danePacjent[iter][0] = result.getString("imie");
				danePacjent[iter][1] = result.getString("nazwisko");
				danePacjent[iter][2] = result.getString("pesel");
				danePacjent[iter][3] = result.getString("ulica");
				danePacjent[iter][4] = result.getString("numer_domu");
				danePacjent[iter][5] = result.getString("kod_pocztowy");
				danePacjent[iter][6] = result.getString("miasto");
				danePacjent[iter][7] = result.getString("email");
				danePacjent[iter][8] = result.getString("telefon");
				iter++;
			}
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy zapytaniu SELECT * FROM pacjent");
			e2.printStackTrace();	
		}
		
		return danePacjent;
	}
	
	void insertIntoPacjent(Object[] records) throws NumberFormatException, SQLException {
		
		String sql = "INSERT INTO pacjent(imie, nazwisko, pesel, ulica, numer_domu, kod_pocztowy, miasto, email, telefon)"
				+ " VALUES('"+records[0]+"', '"+records[1]+"', '"+records[2]+"', '"+records[3]+"', '"+records[4]+"', '"+records[5]+"', "
						+ "'"+records[6]+"', '"+records[7]+"', '"+records[8]+"');";
		try {
			DBConnection.stmt.execute(sql);
			System.out.println("Model: Dodano pomyslnie pacjenta");
			
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			throw e1;
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy dodawaniu rekordu do tabeli pacjent");
			e2.printStackTrace();
			throw e2;	
		}
	}
	
	void deleteFromPacjent(Object objects) throws SQLException {
		
		String sql = "DELETE FROM pacjent WHERE pesel = '"+objects+"'";
		try {
			DBConnection.stmt.execute(sql);
			System.out.println("Model: Usuniêto pomyœlnie pacjenta");
			
		}  catch (SQLException e2) {
			System.err.println("Model: Blad przy usuwaniu rekordu z tabeli pacjent");
			e2.printStackTrace();
			throw e2;	
		}
	}
	
	String[] selectFromPacjentByPesel(String pesel) throws SQLException {
		
		String[] danePacjent = new String[8];
		String sqlmain = "SELECT imie, nazwisko, ulica, numer_domu, kod_pocztowy, miasto, email, telefon"
					+ " FROM pacjent WHERE pesel='"+pesel+"';";
	
		try {
				ResultSet result = DBConnection.stmt.executeQuery(sqlmain);		
				danePacjent[0] = result.getString("imie"); 
				danePacjent[1] = result.getString("nazwisko");
				danePacjent[2] = result.getString("ulica");
				danePacjent[3] = result.getString("numer_domu");
				danePacjent[4] = result.getString("kod_pocztowy");
				danePacjent[5] = result.getString("miasto");
				danePacjent[6] = result.getString("email");
				danePacjent[7] = result.getString("telefon");
				
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy zapytaniu SELECT * FROM pacjent by PESEL");
			e2.printStackTrace();	
		}
		
		return danePacjent;
	}

	void editTablePacjent(Object[] objects) throws SQLException {
		this.deleteFromPacjent(objects[2]);
		this.insertIntoPacjent(objects);
	}
	
	
	//tab3 methods
	Object[][] selectAllFromWizyta() {
		
		Object[][] daneWizyta = new Object[100][5];
		String sqlmain = "SELECT pa.imie AS paimie, pa.nazwisko AS panazwisko, pa.pesel AS papesel,"
				+ " pr.imie AS primie, pr.nazwisko AS prnazwisko, pr.pesel AS prpesel,"
				+ " g.numer AS gnumer, w.data_wizyty as datawizyty, w.diagnoza as diagnoza "
				+ "FROM pacjent AS pa JOIN wizyta AS w ON pa.id_pacjent=w.idpacjent"
				+ " JOIN pracownik AS pr ON pr.id_pracownik=w.idpracownik "
				+ "JOIN gabinet as g ON g.id_gabinet=w.idgabinet;";
		
		try {
			ResultSet result = DBConnection.stmt.executeQuery(sqlmain);
			int iter = 0;
			while(result.next()) {
				daneWizyta[iter][0] = result.getString("paimie") +" "+result.getString("panazwisko") +" "+result.getString("papesel");
				daneWizyta[iter][1] = result.getString("primie") +" "+result.getString("prnazwisko")+" "+result.getString("prpesel");
				daneWizyta[iter][2] = result.getString("gnumer");
				daneWizyta[iter][3] = result.getString("datawizyty");
				daneWizyta[iter][4] = result.getString("diagnoza");
				iter++;
			}
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy zapytaniu SELECT dla wizyty");
			e2.printStackTrace();	
		}
		
		return daneWizyta;
	}

	void insertIntoWizyta(Object[] records) throws NumberFormatException, SQLException {
		String sql = "INSERT INTO wizyta(idpracownik, idpacjent, idgabinet, data_wizyty, diagnoza) "
				+ "VALUES((SELECT id_pracownik FROM pracownik WHERE pesel = '"+records[1]+"'), "
				+ "(SELECT id_pacjent FROM pacjent WHERE pesel = '"+records[0]+"'), "
				+ "(SELECT id_gabinet FROM gabinet WHERE numer = '"+records[2]+"'), "
				+ "'"+records[3]+"', '"+records[4]+"');";
		try {
			DBConnection.stmt.execute(sql);
			System.out.println("Model: Dodano pomyslnie wizyte");
			
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			throw e1;
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy dodawaniu rekordu do tabeli wizyta");
			e2.printStackTrace();
			throw e2;	
		}
	}

	String[] selectImieNazwiskoPeselFromPracownik() {
		

		String[] pracownicy = new String[100];
		try {
			ResultSet result = DBConnection.stmt.executeQuery("SELECT imie, nazwisko, pesel FROM pracownik");
			int iter;
			for(iter=0; iter<100 && result.next(); iter++) {
				pracownicy[iter] = result.getString("imie") + "-" + result.getString("nazwisko") + "-" + result.getString("pesel");
			}
		} catch (SQLException e) {
			System.err.println("Blad przy wykonywaniu SELECT imie, nazwisko, pesel FROM pracownik");
			e.printStackTrace();
		}
		return pracownicy;
	}
	
	String[] selectImieNazwiskoPeselFromPacjent() {
		

		String[] pracownicy = new String[100];
		try {
			ResultSet result = DBConnection.stmt.executeQuery("SELECT imie, nazwisko, pesel FROM pacjent");
			int iter;
			for(iter=0; iter<100 && result.next(); iter++) {
				pracownicy[iter] = result.getString("imie") + "-" + result.getString("nazwisko") + "-" + result.getString("pesel");
			}
		} catch (SQLException e) {
			System.err.println("Blad przy wykonywaniu SELECT imie, nazwisko, pesel FROM pacjent");
			e.printStackTrace();
		}
		return pracownicy;
	}
	
	String[] selectNumerFromGabinet() {
		
		String[] gabinety = new String[100];
		try {
			ResultSet result = DBConnection.stmt.executeQuery("SELECT numer FROM gabinet");
			int iter;
			for(iter=0; iter<100 && result.next(); iter++) {
				gabinety[iter] = result.getString("numer");
			}
		} catch (SQLException e) {
			System.err.println("Blad przy wykonywaniu SELECT numer FROM gabinet");
			e.printStackTrace();
		}
		return gabinety;
	}
	
	String[] selectPacjentDataFromWizyta() {
		String[] wizyty = new String[100];
		try {
			ResultSet result = DBConnection.stmt.executeQuery("SELECT p.imie AS imie, p.nazwisko AS nazwisko, p.pesel AS pesel, w.data_wizyty AS data"
					+ " FROM pacjent AS p JOIN wizyta AS w ON p.id_pacjent=w.idpacjent;");
			int iter;
			for(iter=0; iter<100 && result.next(); iter++) {
				wizyty[iter] = result.getString("imie") + "," + result.getString("nazwisko") + "," + result.getString("pesel") + "," + result.getString("data");
			}
		} catch (SQLException e) {
			System.err.println("Blad przy wykonywaniu SELECT imie, nazwisko, pesel, data FROM wizyta");
			e.printStackTrace();
		}
		return wizyty;
	}
	
	void deleteFromWizyta(String[] peseldata) throws SQLException {
		
		System.out.println(peseldata[2] + "    " + peseldata[3]);
		String sql = "DELETE FROM wizyta WHERE idpacjent = (SELECT id_pacjent FROM pacjent WHERE pesel='"+peseldata[2]+"') "
				+ "AND data_wizyty='"+peseldata[3]+"';";
		try {
			DBConnection.stmt.execute(sql);
			System.out.println("Model: Usuniêto pomyœlnie wizytê");
			
		}  catch (SQLException e2) {
			System.err.println("Model: Blad przy usuwaniu rekordu z tabeli wizyta");
			e2.printStackTrace();
			throw e2;	
		}
	}
	
	String[] selectFromWizytaByDataPesel(String[] peseldata) {
		String[] daneWizyta = new String[5];
		String sqlmain = "SELECT pa.imie AS paimie, pa.nazwisko AS panazwisko, pa.pesel AS papesel,"
				+ " pr.imie AS primie, pr.nazwisko AS prnazwisko, pr.pesel AS prpesel,"
				+ " g.numer AS gnumer, w.data_wizyty as datawizyty, w.diagnoza as diagnoza "
				+ "FROM pacjent AS pa JOIN wizyta AS w ON pa.id_pacjent=w.idpacjent"
				+ " JOIN pracownik AS pr ON pr.id_pracownik=w.idpracownik "
				+ "JOIN gabinet as g ON g.id_gabinet=w.idgabinet WHERE w.data_wizyty='"+peseldata[1]+"' AND pa.pesel='"+peseldata[0]+"';";
		
		try {
			ResultSet result = DBConnection.stmt.executeQuery(sqlmain);
			
				daneWizyta[0] = result.getString("paimie") +" "+result.getString("panazwisko") +" "+peseldata[0];
				daneWizyta[1] = result.getString("primie") +" "+result.getString("prnazwisko")+" "+result.getString("prpesel");
				daneWizyta[2] = result.getString("gnumer");
				daneWizyta[3] = result.getString("datawizyty");
				daneWizyta[4] = result.getString("diagnoza");
				
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy zapytaniu SELECT dla wizyty by peseldata");
			e2.printStackTrace();	
		}
		
		return daneWizyta;
	}

	void editTableWizyta(String[] records) throws SQLException {
		this.deleteFromWizyta(records);
		this.insertIntoWizyta(records);
	}
	
	
	//tab4 methods
	Object[][] selectAllFromGabinet() {
		
		Object[][] daneGabinet = new Object[100][2];
		String sql = "SELECT numer, pietro FROM gabinet;";
		try {
			ResultSet result = DBConnection.stmt.executeQuery(sql);
			int iter = 0;
			while(result.next()) {
				daneGabinet[iter][0] = result.getString("numer");
				daneGabinet[iter][1] = result.getInt("pietro");
				iter++;
			}
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy zapytaniu SELECT * FROM gabinet");
			e2.printStackTrace();	
		}
		
		return daneGabinet;
		
	}

	void insertIntoGabinet(Object[] records) throws NumberFormatException, SQLException {
		
		String sql = "INSERT INTO gabinet(numer, pietro) VALUES('"+records[0]+"', "+records[1]+");";
		try {
			DBConnection.stmt.execute(sql);
			System.out.println("Model: Dodano pomyslnie gabinet");
			
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			throw e1;
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy dodawaniu rekordu do tabeli gabinet");
			e2.printStackTrace();
			throw e2;	
		}
	}

	void deleteFromGabinet(String numer) throws SQLException {
		
		String sql = "DELETE FROM gabinet WHERE numer = '"+numer+"'";
		try {
			DBConnection.stmt.execute(sql);
			System.out.println("Model: Usuniêto pomyœlnie gabinet");
			
		}  catch (SQLException e2) {
			System.err.println("Model: Blad przy usuwaniu rekordu z tabeli gabinet");
			e2.printStackTrace();
			throw e2;	
		}
	}
	
	int selectFromGabinetByNumer(String numer) {
		
		int daneGabinet = 0;
		String sql = "SELECT pietro FROM gabinet WHERE numer='"+numer+"';";
		try {
			ResultSet result = DBConnection.stmt.executeQuery(sql);
				daneGabinet = result.getInt("pietro");
			
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy zapytaniu SELECT pietro FROM gabinet by numer");
			e2.printStackTrace();	
		}
		
		return daneGabinet;
	}
	
	void editTableGabinet(String[] records) throws SQLException {
		this.deleteFromGabinet(records[0]);
		this.insertIntoGabinet(records);
	}
	
	
	//tab5 methods
	Object[][] selectAllFromStanowisko() {
		
		Object[][] daneStanowisko = new Object[100][2];
		String sql = "SELECT nazwa FROM stanowisko;";
		try {
			ResultSet result = DBConnection.stmt.executeQuery(sql);
			int iter = 0;
			while(result.next()) {
				daneStanowisko[iter][0] = iter+1;
				daneStanowisko[iter][1] = result.getString("nazwa");
				iter++;
			}
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy zapytaniu SELECT * FROM stanowisko");
			e2.printStackTrace();	
		}
		
		return daneStanowisko;
	}
	
	void insertIntoStanowisko(Object[] records) throws NumberFormatException, SQLException {
		
		String sql = "INSERT INTO stanowisko(nazwa) VALUES('"+records[0]+"');";
		try {
			DBConnection.stmt.execute(sql);
			System.out.println("Model: Dodano pomyslnie stanowisko");
			
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			throw e1;
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy dodawaniu rekordu do tabeli stanowisko");
			e2.printStackTrace();
			throw e2;	
		}
	}
	
	void deleteFromStanowisko(String nazwa) throws SQLException {
		
		String sql = "DELETE FROM stanowisko WHERE nazwa = '"+nazwa+"'";
		try {
			DBConnection.stmt.execute(sql);
			System.out.println("Model: Usuniêto pomyœlnie stanowisko");
			
		}  catch (SQLException e2) {
			System.err.println("Model: Blad przy usuwaniu rekordu z tabeli stanowisko");
			e2.printStackTrace();
			throw e2;	
		}
	}

	void editTableStanowisko(String[] records) throws SQLException {
		String sql = "UPDATE stanowisko SET nazwa='"+records[0]+"' WHERE id_ ;";
		try {
			DBConnection.stmt.execute(sql);
			System.out.println("Model: Dodano pomyslnie stanowisko");
			
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			throw e1;
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy dodawaniu rekordu do tabeli stanowisko");
			e2.printStackTrace();
			throw e2;	
		}
	}
	
	
	//tab6 methods
	Object[][] selectAllFromChoroba() {
		
		Object[][] daneChoroba = new Object[100][4];
		String sql = "SELECT nazwa, objawy, sposob_leczenia, okres_leczenia FROM choroba;";
		try {
			ResultSet result = DBConnection.stmt.executeQuery(sql);
			int iter = 0;
			while(result.next()) {
				daneChoroba[iter][0] = result.getString("nazwa");
				daneChoroba[iter][1] = result.getString("objawy");
				daneChoroba[iter][2] = result.getString("sposob_leczenia");
				daneChoroba[iter][3] = result.getString("okres_leczenia");
				iter++;
			}
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy zapytaniu SELECT * FROM choroba");
			e2.printStackTrace();	
		}
		
		return daneChoroba;
	}

	void insertIntoChoroba(Object[] records) throws NumberFormatException, SQLException {
		
		String sql = "INSERT INTO choroba(nazwa, objawy, sposob_leczenia, okres_leczenia) "
				+ "VALUES('"+records[0]+"', '"+records[1]+"', '"+records[2]+"', '"+records[3]+"');";
		try {
			DBConnection.stmt.execute(sql);
			System.out.println("Model: Dodano pomyslnie chorobe");
			
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			throw e1;
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy dodawaniu rekordu do tabeli choroba");
			e2.printStackTrace();
			throw e2;	
		}
	}

	void deleteFromChoroba(String nazwa) throws SQLException {
		
		String sql = "DELETE FROM choroba WHERE nazwa = '"+nazwa+"'";
		try {
			DBConnection.stmt.execute(sql);
			System.out.println("Model: Usuniêto pomyœlnie chorobê");
			
		}  catch (SQLException e2) {
			System.err.println("Model: Blad przy usuwaniu rekordu z tabeli choroba");
			e2.printStackTrace();
			throw e2;	
		}
	}
	
	String[] selectNazwaFromChoroba() {
		
		String[] choroby = new String[100];
		try {
			ResultSet result = DBConnection.stmt.executeQuery("SELECT nazwa FROM choroba");
			int iter;
			for(iter=0; iter<100 && result.next(); iter++) {
				choroby[iter] = result.getString("nazwa");
			}
		} catch (SQLException e) {
			System.err.println("Blad przy wykonywaniu SELECT nazwa FROM choroba");
		}
		return choroby;
	}
	
	String[] selectFromChorobaByNazwa(String nazwa) {
		String[] daneGabinet = new String[4];
		String sql = "SELECT nazwa, objawy, sposob_leczenia, okres_leczenia FROM choroba WHERE nazwa='"+nazwa+"';";
		try {
			ResultSet result = DBConnection.stmt.executeQuery(sql);
				daneGabinet[0] = result.getString("nazwa");
				daneGabinet[1] = result.getString("objawy");
				daneGabinet[2] = result.getString("sposob_leczenia");
				daneGabinet[3] = result.getString("okres_leczenia");
			
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy zapytaniu SELECT * FROM choroba by nazwa");
			e2.printStackTrace();	
		}
		
		return daneGabinet;
	}
	
	void editTableChoroba(String[] records) throws SQLException {
		this.deleteFromChoroba(records[0]);
		this.insertIntoChoroba(records);
	}
	
	
	//tab8 methods
	Object[][] selectAllFromHistChor() {
		Object[][] daneWizyta = new Object[100][5];
		String sqlmain = "SELECT pa.imie AS paimie, pa.nazwisko AS panazwisko, pa.pesel AS papesel,"
				+ " pr.imie AS primie, pr.nazwisko AS prnazwisko, pr.pesel AS prpesel,"
				+ " ch.nazwa AS choroba, w.data_wizyty as datawizyty, w.diagnoza as diagnoza "
				+ "FROM pacjent AS pa JOIN wizyta AS w ON pa.id_pacjent=w.idpacjent"
				+ " JOIN pracownik AS pr ON pr.id_pracownik=w.idpracownik "
				+ "JOIN hist_chor AS hist ON hist.idwizyta=w.id_wizyta"
				+ " JOIN choroba AS ch ON ch.id_choroba=hist.idchoroba;";
		
		try {
			ResultSet result = DBConnection.stmt.executeQuery(sqlmain);
			int iter = 0;
			while(result.next()) {
				daneWizyta[iter][0] = result.getString("paimie") +" "+result.getString("panazwisko") +" "+result.getString("papesel");
				daneWizyta[iter][1] = result.getString("primie") +" "+result.getString("prnazwisko")+" "+result.getString("prpesel");
				daneWizyta[iter][2] = result.getString("datawizyty");
				daneWizyta[iter][3] = result.getString("diagnoza");
				daneWizyta[iter][4] = result.getString("choroba");
				iter++;
			}
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy zapytaniu SELECT dla hist_chor");
			e2.printStackTrace();	
		}
		
		return daneWizyta;
	}
	
	void insertIntoHistChor(Object[] records) throws NumberFormatException, SQLException {
		
		System.out.println(records[3]+" "+records[6]+" "+records[8]+" "+records[9]);
		String sql = "INSERT INTO hist_chor(idwizyta, idchoroba) "
				+ "VALUES((SELECT id_wizyta FROM wizyta WHERE idpacjent = (SELECT id_pacjent FROM pacjent WHERE pesel='"+records[3]+"') "
				+ "AND idpracownik=(SELECT id_pracownik FROM pracownik WHERE pesel='"+records[6]+"') AND data_wizyty='"+records[8]+"'),"
				+ " (SELECT id_choroba FROM choroba WHERE nazwa='"+records[9]+"'));";
		
		try {
			DBConnection.stmt.execute(sql);
			System.out.println("Model: Dodano pomyslnie hist_chor");
			
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			throw e1;
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy dodawaniu rekordu do tabeli hist_chor");
			e2.printStackTrace();
			throw e2;	
		}
	}

	String[] selectFromWizyta() {
		String[] daneWizyta = new String[100];
		String sqlmain = "SELECT pa.imie AS paimie, pa.nazwisko AS panazwisko, pa.pesel AS papesel,"
				+ " pr.imie AS primie, pr.nazwisko AS prnazwisko, pr.pesel AS prpesel,"
				+ " g.numer AS gnumer, w.data_wizyty as datawizyty, w.diagnoza as diagnoza "
				+ "FROM pacjent AS pa JOIN wizyta AS w ON pa.id_pacjent=w.idpacjent"
				+ " JOIN pracownik AS pr ON pr.id_pracownik=w.idpracownik "
				+ "JOIN gabinet as g ON g.id_gabinet=w.idgabinet;";
		
		try {
			ResultSet result = DBConnection.stmt.executeQuery(sqlmain);
			int iter = 0;
			while(result.next()) {
				daneWizyta[iter] = result.getString("paimie") +";"+result.getString("panazwisko") +";"+result.getString("papesel")+";"+result.getString("primie") +";"+result.getString("prnazwisko")+";"+result.getString("prpesel")+";"+result.getString("gnumer")+";"+result.getString("datawizyty")+";"+result.getString("diagnoza");
				
				iter++;
			}
		} catch (SQLException e2) {
		
			System.err.println("Model: Blad przy zapytaniu SELECT dla wizyty");
			e2.printStackTrace();	
		}
		
		return daneWizyta;
	}

	
	//defalut methods
	public String currentDateString()
    {
      String currDate;

      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      java.util.Date date = new java.util.Date();
      currDate = dateFormat.format(date);

      return (currDate);
    }

	public void createTables() {
		connection.createTables();
	}
	
	public void insertExampleRecords() {
		connection.InsertExampleRecords();
	}
}