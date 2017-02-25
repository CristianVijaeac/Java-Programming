package visualiser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
//import com.google.common.annotations.VisibleForTesting;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;

public final class Task {
	// TODO(2): Adaugati campurile, constructorii necesari si metodele care lipsesc.
	private List<UserEvent> userEvents;
	
	public Task(){
		this.userEvents=new ArrayList<UserEvent>();
	}
	
	public Task(String str){
		this.userEvents=parseLogs(str);
	}
	
	
	public Double meanFrequencyPerTenSeconds() {
		// TODO(2): Implementati metoda care va calcula frecventa medie pe intervale de 10 secunde.
		int i=0,k=1;
		
		ArrayList<Integer> aux=new ArrayList<Integer>();
		ArrayList<Double> tenFreq=new ArrayList<Double>();
		double totalFreq=0;
		for(UserEvent e:userEvents){
			aux.add(e.getTimestamp());
		}
		
		Collections.sort(aux);
		while(i<aux.size()){
			int nrEl=0;
			while(aux.get(i)<k*10){
				nrEl++;
				i++;
				if(i==aux.size()) break;
			}
			tenFreq.add((double)nrEl/10);
			k++;
		}
	
		for(double d:tenFreq)
			totalFreq+=d;

		return totalFreq/tenFreq.size();
	}
	
	public Map<String, Double> computeClicksPerArea() {
		// TODO(2): Calculati numarul de click-uri date pe fiecare zona a editorului.
		
		Map<String,Double> map=Maps.newHashMap();
		
		for(UserEvent e:userEvents) 
			if (map.get(e.getArea().getClass().getCanonicalName())!=null)
				map.put(e.getArea().getClass().getCanonicalName(),map.get(e.getArea().getClass().getCanonicalName())+1);
			else map.put(e.getArea().getClass().getCanonicalName(),(double) 1);
		return map;
	}

	@VisibleForTesting
	List<UserEvent> parseLogs(String logs) {
		// TODO(2): Implementati metoda care va parsa log-urile primite in constructor. Unde
		// trebuie apelata aceasta metoda ?
		List<UserEvent> user_events=new ArrayList<UserEvent>();
		String[] str=logs.split("\n");
		List<EditorElement> e=null;
		UserEvent u=null;
		
		for(int i=0;i<str.length;i++){
			if(str[i].equals("user_event {")){
				u=new UserEvent();
				e=new ArrayList<EditorElement>();
			}
			if(str[i].contains("element")){
				e.add(new EditorElement(str[i].substring(14)));
			}
			if(str[i].contains("timestamp")){
				u.setTimestamp(Integer.parseInt(str[i].substring(16)));
			}
			
			if(str[i].contains("} user_event")){
				u.setPageArea(determineAreaForElements(e));
				user_events.add(u);
			}
		}
		
		
		return user_events;
	}

	@VisibleForTesting
	EditorArea determineAreaForElements(List<EditorElement> elements) {
		// TODO(2): Implementati metoda care determina zona din editor unde s-a dat click, in
		// functie de lista de elemente ce identifica in mod unic zona respectiva.
		FurnitureFactory factory=new FurnitureFactory();
		GetArea area=new GetArea(factory);
		
		return area.determineAreaForElements(elements);
	}

	public List<UserEvent> getUserEvents() {
		return userEvents;
	}

	public void setUserEvents(List<UserEvent> userEvents) {
		this.userEvents = userEvents;
	}
	
	
}
