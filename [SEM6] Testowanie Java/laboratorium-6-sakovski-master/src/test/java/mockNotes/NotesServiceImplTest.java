package mockNotes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class NotesServiceImplTest {

	NotesServiceImpl service;
	MockNotesStorage storage;
	private String bartek = "Bartek";
	private String kamil = "kamil";
	
	@BeforeEach
	public void setUp()
	{
		storage = new MockNotesStorage();
		service = NotesServiceImpl.createWith(storage);
		service.add(Note.of(kamil, 5.0f));
		service.add(Note.of(kamil, 4.0f));
		service.add(Note.of(kamil, 3.0f));
		service.add(Note.of(kamil, 2.0f));
		service.add(Note.of(kamil, 6.0f));
		service.add(Note.of(bartek, 5.0f));
		service.add(Note.of(bartek, 5.0f));
		service.add(Note.of(bartek, 5.0f));
		service.add(Note.of(bartek, 5.0f));
		service.add(Note.of(bartek, 5.0f));
	}
	
	@Test
	public void differentNotesAvarageTest()
	{
		assertEquals(4.0f, service.averageOf(kamil), 0.01f);
	}
	
	@Test
	public void sameNotesAvarageTest()
	{
		assertEquals(5.0f, service.averageOf(bartek), 0.01f);
	}
	
	@Test
	public void addBadNoteTest()
	{
		assertThrows(IllegalArgumentException.class, () -> service.add(Note.of(kamil, 11.0f)));
	}
	
	@Test
	public void checkIfAddedNoteInStorage()
	{
		service.add(Note.of(bartek, 4.9f));
		assertTrue(storage.notes.get(bartek).contains(4.9f));
	}
	
	@AfterEach
	public void tearDown()
	{
		service.clear();
	}
}
