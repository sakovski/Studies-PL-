package MockExamples.MockExamples;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class NotesServiceMockitoTest {
	
	@Mock
	NotesStorage storage;
	
	@InjectMocks
	NotesServiceImpl service;
	
	@Test
	public void differentNotesAvarageTest(){
		List<Note> notes = new ArrayList<Note>();
		notes.add(Note.of("Bartek", 2f));
		notes.add(Note.of("Bartek", 3f));
		notes.add(Note.of("Bartek", 4f));
		notes.add(Note.of("Bartek", 5f));
		notes.add(Note.of("Bartek", 6f));
		doReturn(notes).when(storage).getAllNotesOf("Bartek");
		assertThat(service.averageOf("Bartek")).isEqualTo(4f);
	}
	
	@Test
	public void sameNotesAvarageTestShouldReturnNoteValueTest(){
		List<Note> notes = new ArrayList<Note>();
		notes.add(Note.of("Bartek", 3f));
		notes.add(Note.of("Bartek", 3f));
		notes.add(Note.of("Bartek", 3f));
		notes.add(Note.of("Bartek", 3f));
		notes.add(Note.of("Bartek", 3f));
		doReturn(notes).when(storage).getAllNotesOf("Bartek");
		assertThat(service.averageOf("Bartek")).isEqualTo(3f);
	}
	
	@Test
	public void addValidNoteTest()
	{
		List<Note> notes = new ArrayList<Note>();
		Note note = spy(Note.of("Kamil", 4.0f));
		doReturn(notes).when(storage).getAllNotesOf("Kamil");
		doAnswer(new Answer<Void>() {
			  public Void answer(final InvocationOnMock invocation) throws Throwable {
				  notes.add((Note) invocation.getArguments()[0]);
				return null;
			  }
			}).when(storage).add(isA(Note.class));
		service.add(note);
		assertThat(service.averageOf("Kamil")).isEqualTo(notes.get(0).getNote());
	}
}
