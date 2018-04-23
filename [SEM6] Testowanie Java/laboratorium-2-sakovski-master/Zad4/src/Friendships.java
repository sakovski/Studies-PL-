import java.util.*;

public class Friendships {
    Map<String, List<String>> friendships = new HashMap<>();

    //Dodanie przyjaciół - wykorzystuje funkcje addFriend!	
    public void makeFriends(String person1, String person2) {
        addFriend(person1, person2);
        addFriend(person2, person1);
    }
    
    //Pobranie listy przyjaciol
    public List<String> getFriendsList(String person) {
    	if(!friendships.containsKey(person))
    		throw new IllegalArgumentException("This person doesnt exist!");
    	if(friendships.get(person) == null)
    		throw new IllegalArgumentException("This person has no friend :(");
        return friendships.get(person);
    }
    
    //Sprawdzenie czy przyjaciele
    public boolean areFriends(String person1, String person2) {
    	if(!(friendships.containsKey(person1) && friendships.containsKey(person2)))
    		throw new IllegalArgumentException("You need to enter existing people!");
        if(friendships.get(person1).contains(person2) && friendships.get(person2).contains(person1))
        	return true;
        return false;
    }
    //Dodanie do listy przyjaciol do danej osoby
    private void addFriend(String person, String friend) {
    	if(person.equals("") || friend.equals(""))
    		throw new IllegalArgumentException("Can not add empty string!");
    	else if(friendships.get(person) == null)
        	friendships.put(person, new ArrayList<String>());
        else if(friendships.get(person).contains(friend))
        	throw new IllegalArgumentException("This man is already a friend of this person!");
        friendships.get(person).add(friend);
    }
}
