package singleton;

import java.util.Vector;

import models.vtuber;

public class VtubeRepository {

	private static VtubeRepository instance = null;
	private Vector<vtuber> vtuberList = null;
	private VtubeRepository() {
		vtuberList = new Vector<>();
	}
	
	public static VtubeRepository getInstance() {
		if(instance == null) {
			synchronized (VtubeRepository.class) {
				if(instance == null) {
					instance = new VtubeRepository();
				}
			}
		}
		return instance;
	}

	public Vector<vtuber> getVtuberList() {
		return vtuberList;
	}

	public void setVtuberList(Vector<vtuber> vtuberList) {
		this.vtuberList = vtuberList;
	}
	
	public void addVtuber(vtuber vtuber) {
		vtuber.join(vtuber.getName());
		vtuberList.add(vtuber);
	}

	public void graduateVtuber(int index) {
		vtuber vt = vtuberList.get(index-1);
		vtuberList.remove(index-1);
		vt.leave(vt.getName());
	}
	
	
}
