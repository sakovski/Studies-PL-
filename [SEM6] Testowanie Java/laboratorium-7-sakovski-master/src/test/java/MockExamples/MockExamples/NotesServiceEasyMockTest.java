package MockExamples.MockExamples;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(EasyMockRunner.class)

public class NotesServiceEasyMockTest {
	
	@Mock(type = MockType.NICE)
	NotesStorage storage;
	
	@TestSubject
	NotesServiceImpl service = NotesServiceImpl.createWith(storage);
	
	@Test
	public void differentNotesAvarageTest(){
		List<Note> notes = new ArrayList<Note>();
		notes.add(Note.of("Bartek", 2f));
		notes.add(Note.of("Bartek", 3f));
		notes.add(Note.of("Bartek", 4f));
		notes.add(Note.of("Bartek", 5f));
		notes.add(Note.of("Bartek", 6f));
		expect(storage.getAllNotesOf("Bartek")).andReturn(notes);
		replay(storage);
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
		expect(storage.getAllNotesOf("Bartek")).andReturn(notes);
		replay(storage);
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
