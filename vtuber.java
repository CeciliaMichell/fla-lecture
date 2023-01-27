package models;

import java.util.Vector;

import observer.Announcer;
import singleton.VtubeRepository;

public class vtuber implements Announcer{
	
	VtubeRepository VtuberRepo = VtubeRepository.getInstance();
	Vector <vtuber> allVtuber = VtuberRepo.getVtuberList();
	private String name;
	private int age;
	private String game;
	private String anime;
	private int income;
	private String yn;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getAnime() {
		return anime;
	}

	public void setAnime(String anime) {
		this.anime = anime;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public String getYn() {
		return yn;
	}

	public void setYn(String yn) {
		this.yn = yn;
	}

	@Override
	public void join(String name) {
		System.out.println("========== Announcement ==========");
		for (vtuber vtuber : allVtuber) {
			System.out.println("["+vtuber.getName()+"] "+name+" has join vtubRE. Please welcome "+name);
		}
		System.out.println();
	}

	@Override
	public void leave(String name) {
		System.out.println("========== Announcement ==========");
		for (vtuber vtuber : allVtuber) {
			System.out.println("["+vtuber.getName()+"] We are so sad to announce that "+name+" has left the from our agency");
		}
		System.out.println();
	}
	
	//template 
		private void getup() {
			try {
				Thread.sleep(2000);
				System.out.println(this.name + " is waking up...");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		private void goLive() {
			try {
				Thread.sleep(2000);
				System.out.println(this.name + " is live now...");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void sleep() {
			try {
				Thread.sleep(2000);
				System.out.println(this.name + " is sleeping zZz...");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void workingOut() {
			try {
				Thread.sleep(2000);
				System.out.println(this.name + " is working out now...");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		private void showEarning() {
			int earning = income + 2000;
			System.out.println("Total Income : IDR" + income);
			this.setIncome(earning);
		}
		
		public void dailyRoutine() {
			System.out.println("===========================================");
			System.out.println("This is your fav vtuber's daily routine : D");
			System.out.println("===========================================");
			getup();
			goLive();
			workingOut();
			sleep();
			showEarning();
		}
		
		
	

}
