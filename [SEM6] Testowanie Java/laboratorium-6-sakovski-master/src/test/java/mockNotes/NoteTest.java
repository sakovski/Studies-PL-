package mockNotes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NoteTest {

	@Test
	void testCreate() {
		final Note note = Note.of("Mateusz Miotk", 4.5f);
		assertEquals("Mateusz Miotk", note.getName());
		assertEquals(4.5f, note.getNote(),0.01f);
	}
	
	@Test
	void testNullName()
	{
		assertThrows(IllegalArgumentException.class, () -> Note.of(null, 3.0f));
	}
	
	@Test
	void testEmptyStringName()
	{
		assertThrows(IllegalArgumentException.class, () -> Note.of("", 3.0f));
	}	
	
	@Test
	void testNoteLessThan2()
	{
		assertThrows(IllegalArgumentException.class, () -> Note.of("Mateusz Miotk", 1.0f));
	}
	
	@Test
	void testNoteBiggerThan6()
	{
		assertThrows(IllegalArgumentException.class, () -> Note.of("Mateusz Miotk", 6.5f));
	}
}
