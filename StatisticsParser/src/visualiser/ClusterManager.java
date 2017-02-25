package visualiser;

import java.util.ArrayList;
import java.util.List;

final class ClusterManager {
	// TODO(4.2): Adaugati clasele, campurile, constructorii necesari si metodele care lipsesc.

	private static int window=10;
	private static ClusterManager instance = null;
	
	
	protected ClusterManager() {

	   }
	
	public static ClusterManager getInstance() {
	      if(instance == null) {
	         instance = new ClusterManager();
	      }
	      return instance;
	   }

	
	
	
	static public class Cluster{
		
		private List<UserEvent> userEvents;
		private int startTimestamp;
		private int endTimestamp;
		
		public Cluster(List<UserEvent> userEvents,int startTimestamp,int endTimestamp){
			
			this.userEvents=userEvents;
			this.startTimestamp=startTimestamp;
			this.endTimestamp=endTimestamp;
		
		}
	
		public void addUserEvent(UserEvent e){
			this.userEvents.add(e);
		}

		public List<UserEvent> getUserEvents() {
			return userEvents;
		}

		public void setUserEvents(List<UserEvent> userEvents) {
			this.userEvents = userEvents;
		}

		public int getStartTimestamp() {
			return startTimestamp;
		}

		public void setStartTimestamp(int startTimestamp) {
			this.startTimestamp = startTimestamp;
		}

		public int getEndTimestamp() {
			return endTimestamp;
		}

		public void setEndTimestamp(int endTimestamp) {
			this.endTimestamp = endTimestamp;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + endTimestamp;
			result = prime * result + startTimestamp;
			result = prime * result + ((userEvents == null) ? 0 : userEvents.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cluster other = (Cluster) obj;
			if (endTimestamp != other.endTimestamp)
				return false;
			if (startTimestamp != other.startTimestamp)
				return false;
			if (userEvents == null) {
				if (other.userEvents != null)
					return false;
			} else if (!userEvents.equals(other.userEvents))
				return false;
			return true;
		}
	
		
	}
	
	public List<Cluster> cluster(List<UserEvent> userEvents) {
		// TODO(4.2): Implementati metoda care gaseste secvente repetate ale acelorasi elemente.
		// Folositi o fereastra (window) pentru a gasi aceste secvente.
		
		List<Cluster> cluster=new ArrayList<Cluster>();
		int j=0;
		
		for(UserEvent e:userEvents){
			if(cluster.size()==0) {
				cluster.add(new Cluster(new ArrayList<UserEvent>(),e.getTimestamp(),e.getTimestamp()+window-1));
				cluster.get(cluster.size()-1).addUserEvent(e);
			}else{
				for(j=0;j<cluster.size();j++){
					if (cluster.get(j).getUserEvents().get(0).getArea().getPathInEditor().get(0).equals(e.getArea().getPathInEditor().get(0))){
						if(e.getTimestamp()<cluster.get(j).getEndTimestamp()){
							cluster.get(j).addUserEvent(e);
							cluster.get(j).setEndTimestamp(e.getTimestamp()+window-1);
							break;
						}else{
							continue;
						}
					}
				}
				if(j==cluster.size()){
					cluster.add(new Cluster(new ArrayList<UserEvent>(),e.getTimestamp(),e.getTimestamp()+window-1));
					cluster.get(cluster.size()-1).addUserEvent(e);
				}
			}
			
		}
		
	for(int i=0;i<cluster.size();i++){
		if (cluster.get(i).getUserEvents().size()==1) {
			cluster.remove(i); 
			i--;
		}
	}
	return cluster;
	}
	
	
}
