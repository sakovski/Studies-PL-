import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:DataBase.db";
    
    public static Connection conn;
    public static Statement stmt;
	
	public void connectDB() {
		
		//dodaje klase JDBC
	    try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
	    
	  //Nawiazuje polaczenie z baza danych
	    try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem po³¹czenia");
            e.printStackTrace();
        }
	}
	
	public void createTables(){
		
		 //Tworzy tabele
	    try {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS stanowisko(id_stanowisko INTEGER PRIMARY KEY AUTOINCREMENT, "
            		+ "nazwa VARCHAR(30) NOT NULL UNIQUE);");
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli stanowisko");
            e.printStackTrace();
        }
	    
	    try {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS gabinet(id_gabinet INTEGER PRIMARY KEY AUTOINCREMENT, "
            		+ "numer VARCHAR(10) NOT NULL UNIQUE, "
            		+ "pietro INTEGER NOT NULL);");       
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli gabinet");
            e.printStackTrace();
        }
	    
	    try {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS pracownik(id_pracownik INTEGER PRIMARY KEY AUTOINCREMENT, "
            		+ "idstanowisko INTEGER NOT NULL, "
            		+ "imie VARCHAR(40) NOT NULL, "
            		+ "nazwisko VARCHAR(40) NOT NULL, "
            		+ "pesel VARCHAR(11) NOT NULL UNIQUE, "
            		+ "pensja DECIMAL(10,2) NOT NULL, "
            		+ "telefon VARCHAR(9) NOT NULL UNIQUE, "
            		+ "email VARCHAR(100) NOT NULL UNIQUE, "
            		+ "FOREIGN KEY(idstanowisko) REFERENCES stanowisko(id_stanowisko));");
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli pracownik");
            e.printStackTrace();
        }
	    
	    try {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS pacjent(id_pacjent INTEGER PRIMARY KEY AUTOINCREMENT, "
            		+ "imie VARCHAR(40) NOT NULL, "
            		+ "nazwisko VARCHAR(40) NOT NULL, "
            		+ "pesel VARCHAR(11) NOT NULL UNIQUE, "
            		+ "ulica VARCHAR(50) NOT NULL, "
            		+ "numer_domu VARCHAR(8) NOT NULL, "
            		+ "kod_pocztowy VARCHAR(6) NOT NULL, "
            		+ "miasto VARCHAR(30) NOT NULL, "
            		+ "email VARCHAR(100) NOT NULL, "
            		+ "telefon VARCHAR NOT NULL);");
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli pacjent");
            e.printStackTrace();
        }
	    
	    try {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS choroba(id_choroba INTEGER PRIMARY KEY AUTOINCREMENT, "
            		+ "nazwa VARCHAR(40) NOT NULL UNIQUE, "
            		+ "objawy VARCHAR(100), "
            		+ "sposob_leczenia VARCHAR(100), "
            		+ "okres_leczenia VARCHAR(10));");
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli choroba");
            e.printStackTrace();
        }
	    
	    try {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS wizyta(id_wizyta INTEGER PRIMARY KEY AUTOINCREMENT, "
            		+ "idpracownik INTEGER NOT NULL, "
            		+ "idpacjent INTEGER NOT NULL, "
            		+ "idgabinet INTEGER NOT NULL, "
            		+ "data_wizyty DATE NOT NULL, "
            		+ "diagnoza VARCHAR(200), "
            		+ "FOREIGN KEY(idpracownik) REFERENCES pracownik(id_pracownik), "
            		+ "FOREIGN KEY(idpacjent) REFERENCES pacjent(id_pacjent), "
            		+ "FOREIGN KEY(idgabinet) REFERENCES pracownik(id_gabinet));");
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli wizyta");
            e.printStackTrace();
        }
	    
	    try {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS hist_chor(id_hist_chor INTEGER PRIMARY KEY AUTOINCREMENT, "
            		+ "idwizyta INTEGER NOT NULL, "
            		+ "idchoroba INTEGER NOT NULL, "
            		+ "FOREIGN KEY(idwizyta) REFERENCES wizyta(id_wizyta)"
            		+ "FOREIGN KEY(idchoroba) REFERENCES choroba(id_choroba)); ");
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli choroba");
            e.printStackTrace();
        }
	    
	    System.out.println("Polaczenie z baza i stworzenie tabel  pomyslne");
	}
	
public void InsertExampleRecords() {
		
		try {
            stmt.executeUpdate("INSERT INTO stanowisko(nazwa) VALUES('lekarz-pediatra');");
            stmt.executeUpdate("INSERT INTO stanowisko(nazwa) VALUES('lekarz-ginekolog');");
            stmt.executeUpdate("INSERT INTO stanowisko(nazwa) VALUES('lekarz-okulista');");
            stmt.executeUpdate("INSERT INTO stanowisko(nazwa) VALUES('lekarz-dermatolog');");
            stmt.executeUpdate("INSERT INTO stanowisko(nazwa) VALUES('lekarz-laryngolog');");
            stmt.executeUpdate("INSERT INTO stanowisko(nazwa) VALUES('lekarz-geriatra');");
            stmt.executeUpdate("INSERT INTO stanowisko(nazwa) VALUES('lekarz-stomatolog');");
            stmt.executeUpdate("INSERT INTO stanowisko(nazwa) VALUES('pielêgniarka');");
            System.out.println("Pomyœlnie dodano przyk³adowe stanowiska");
        } catch (SQLException e) {
            System.err.println("B³¹d przy wprowadzaniu przyk³adowych rekordów do tabeli stanowisko");
            e.printStackTrace();
        }
		
		try {
            stmt.executeUpdate("INSERT INTO gabinet(numer, pietro) VALUES('1',0);");
            stmt.executeUpdate("INSERT INTO gabinet(numer, pietro) VALUES('2a',0);");
            stmt.executeUpdate("INSERT INTO gabinet(numer, pietro) VALUES('2b',0);");
            stmt.executeUpdate("INSERT INTO gabinet(numer, pietro) VALUES('13',1);");
            stmt.executeUpdate("INSERT INTO gabinet(numer, pietro) VALUES('14',1);");
            stmt.executeUpdate("INSERT INTO gabinet(numer, pietro) VALUES('21a',2);");
            stmt.executeUpdate("INSERT INTO gabinet(numer, pietro) VALUES('21b',2);");
            System.out.println("Pomyœlnie dodano przyk³adowe gabinety");
        } catch (SQLException e) {
            System.err.println("B³¹d przy wprowadzaniu przyk³adowych rekordów do tabeli gabinet");
            e.printStackTrace();
        }
		
		try {
            stmt.executeUpdate("INSERT INTO choroba(nazwa, objawy, sposob_leczenia, okres_leczenia) VALUES('Ospa Wietrzna', 'Objawy ospy s¹ bardzo z³e', "
            		+ "'Leczyæ tylko akupunktur¹ do¿yln¹', '14 dni');");
            stmt.executeUpdate("INSERT INTO choroba(nazwa, objawy, sposob_leczenia, okres_leczenia) VALUES('Zapalenie P³uc', 'Objawy te¿ s¹ bardzo z³e', "
            		+ "'Leczyæ tylko injekcj¹ domiêœniow¹', '10 dni');");
            stmt.executeUpdate("INSERT INTO choroba(nazwa, objawy, sposob_leczenia, okres_leczenia) VALUES('Zapalenie Ucha', 'Objawy s¹ bardzo, bardzo z³e', "
            		+ "'Leczyæ patyczkami do uszu', '7 dni');");
            stmt.executeUpdate("INSERT INTO choroba(nazwa, objawy, sposob_leczenia, okres_leczenia) VALUES('Odra', 'Objawy odry s¹ bardzo z³e', "
            		+ "'Leczyæ tylko maœci¹ na zajady', '28 dni');");
            stmt.executeUpdate("INSERT INTO choroba(nazwa, objawy, sposob_leczenia, okres_leczenia) VALUES('Grypa ¿o³¹dkowa', 'Objawy tej gryby s¹ bardzo z³e', "
            		+ "'Leczyæ tylko tabletkami koj¹cymi', '20 dni');");
            System.out.println("Pomyœlnie dodano przyk³adowe choroby");
        } catch (SQLException e) {
            System.err.println("B³¹d przy wprowadzaniu przyk³adowych rekordów do tabeli choroba");
            e.printStackTrace();
        }
		
		try {
            stmt.executeUpdate("INSERT INTO pracownik(idstanowisko, imie, nazwisko, pesel, pensja, telefon, email) "
            		+ "VALUES((SELECT id_stanowisko FROM stanowisko WHERE id_stanowisko=1), "
            		+ "'Mariusz', 'Drygas', '89031203456', 5000.50, '567098234', 'mdrygas@kozaczek.pl');");
            stmt.executeUpdate("INSERT INTO pracownik(idstanowisko, imie, nazwisko, pesel, pensja, telefon, email) "
            		+ "VALUES((SELECT id_stanowisko FROM stanowisko WHERE id_stanowisko=1), "
            		+ "'Pawe³', 'Rosó³', '82031106796', 15000.48, '568092234', 'prosol@gmail.com');");
            stmt.executeUpdate("INSERT INTO pracownik(idstanowisko, imie, nazwisko, pesel, pensja, telefon, email) "
            		+ "VALUES((SELECT id_stanowisko FROM stanowisko WHERE id_stanowisko=2), "
            		+ "'Kamil', 'Karniak','58091105783', 8790.23, '569222234', 'kkarniak@wp.pl');");
            stmt.executeUpdate("INSERT INTO pracownik(idstanowisko, imie, nazwisko, pesel, pensja, telefon, email) "
            		+ "VALUES((SELECT id_stanowisko FROM stanowisko WHERE id_stanowisko=3), "
            		+ "'Sylwia', 'B¹bska', '91122190987', 14000.78, '678098235', 'sbabska@kozaczek.pl');");
            stmt.executeUpdate("INSERT INTO pracownik(idstanowisko, imie, nazwisko, pesel, pensja, telefon, email) "
            		+ "VALUES((SELECT id_stanowisko FROM stanowisko WHERE id_stanowisko=4), "
            		+ "'Karolina', 'Mula³a', '79031203456', 12345.98, '880456234', 'kmulala@vp.pl');");
            stmt.executeUpdate("INSERT INTO pracownik(idstanowisko, imie, nazwisko, pesel, pensja, telefon, email) "
            		+ "VALUES((SELECT id_stanowisko FROM stanowisko WHERE id_stanowisko=5), "
            		+ "'Mariusz', 'Bart³omiejczyk', '66091325436', 7560.00, '760345098', 'mbartlomiejczyk@kozaczek.pl');");
           
            System.out.println("Pomyœlnie dodano przyk³adowych pracowników");
        } catch (SQLException e) {
            System.err.println("B³¹d przy wprowadzaniu przyk³adowych rekordów do tabeli pracownik");
            e.printStackTrace();
        }
		
		try {
            stmt.executeUpdate("INSERT INTO pacjent(imie, nazwisko, pesel, ulica, numer_domu, kod_pocztowy, miasto, email, telefon) "
            		+ "VALUES('Mariusz', 'Kowalski', '75031203456', 'Morska', '14a', '10-134', 'Olsztyn', 'mkowalski@gmail.com', '647632159');");
            stmt.executeUpdate("INSERT INTO pacjent(imie, nazwisko, pesel, ulica, numer_domu, kod_pocztowy, miasto, email, telefon) "
            		+ "VALUES('Marian', 'Kowalski', '45050983458', 'Ludowa', '14c', '10-138', 'Orneta', 'mariankowalski@gmail.com', '347632159');");
            stmt.executeUpdate("INSERT INTO pacjent(imie, nazwisko, pesel, ulica, numer_domu, kod_pocztowy, miasto, email, telefon) "
            		+ "VALUES('Zygmunt', 'Kowalski', '44031203456', 'Œledziowa', '1', '88-134', 'Gdynia', 'zygmuntkowalski@gmail.com', '847632159');");
            stmt.executeUpdate("INSERT INTO pacjent(imie, nazwisko, pesel, ulica, numer_domu, kod_pocztowy, miasto, email, telefon) "
            		+ "VALUES('Aldona', 'Kowalski', '98031203453', 'Grunwaldzka', '145', '88-131', 'Gdañsk', 'aldonakowalski@gmail.com', '547632159');");
            stmt.executeUpdate("INSERT INTO pacjent(imie, nazwisko, pesel, ulica, numer_domu, kod_pocztowy, miasto, email, telefon) "
            		+ "VALUES('Czes³aw', 'Ma³kowski', '89031203456', 'Morska', '14a', '10-134', 'Olsztyn', 'cmalkowski@gmail.com', '547489159');");
            	
            
            System.out.println("Pomyœlnie dodano przyk³adowych pacjentów");
        } catch (SQLException e) {
            System.err.println("B³¹d przy wprowadzaniu przyk³adowych rekordów do tabeli pacjent");
            e.printStackTrace();
        }
		
		try {
            stmt.executeUpdate("INSERT INTO wizyta(idpracownik, idpacjent, idgabinet, data_wizyty, diagnoza) "
            		+ "VALUES(1, 1, 1, '2017-02-20', 'Prawdopodobne zapalenie oskrzeli');");
            stmt.executeUpdate("INSERT INTO wizyta(idpracownik, idpacjent, idgabinet, data_wizyty, diagnoza) "
            		+ "VALUES(1, 2, 1, '2017-02-21', 'Prawdopodobne zapalenie p³uc');");
            stmt.executeUpdate("INSERT INTO wizyta(idpracownik, idpacjent, idgabinet, data_wizyty, diagnoza) "
            		+ "VALUES(2, 2, 3, '2017-02-22', 'Prawdopodobne z³amanie obojczyka');");
           
            
            System.out.println("Pomyœlnie dodano przyk³adowe wizyty");
        } catch (SQLException e) {
            System.err.println("B³¹d przy wprowadzaniu przyk³adowych rekordów do tabeli wizyta");
            e.printStackTrace();
        }
		
		try {
            stmt.executeUpdate("INSERT INTO hist_chor(idwizyta, idchoroba) "
            		+ "VALUES(1, 1);");
            stmt.executeUpdate("INSERT INTO hist_chor(idwizyta, idchoroba) "
            		+ "VALUES(1, 2);");
            stmt.executeUpdate("INSERT INTO hist_chor(idwizyta, idchoroba) "
            		+ "VALUES(2, 3);");
            
           
            System.out.println("Pomyœlnie dodano przyk³adowe choroby do wizyt");
        } catch (SQLException e) {
            System.err.println("B³¹d przy wprowadzaniu przyk³adowych rekordów do tabeli hist_chor");
            e.printStackTrace();
        }
				
	}

public void CloseConnection() {
	//Zamyka polaczenie z baza danych
    try {
        conn.close();
    } catch (SQLException e) {
        System.err.println("Problem z zamknieciem polaczenia");
        e.printStackTrace();
    }
}

}
