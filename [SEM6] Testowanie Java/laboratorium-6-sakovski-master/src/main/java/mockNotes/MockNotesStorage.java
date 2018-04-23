package mockNotes;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class MockNotesStorage implements NotesStorage
{
	
	Multimap<String, Float> notes; 
	
	public MockNotesStorage()
	{
		notes = ArrayListMultimap.create();
	}
	
	@Override
	public void add(Note note) 
	{
		notes.put(note.getName(), note.getNote());	
	}

	@Override
	public List<Note> getAllNotesOf(String name) 
	{
		List<Note> notesByName = new ArrayList<Note>();
		for(float note : notes.get(name))
		{
			notesByName.add(Note.of(name, note));
		}
		return notesByName;
	}

	@Override
	public void clear() 
	{
		notes.clear();
	}

}
