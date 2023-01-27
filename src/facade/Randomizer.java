package facade;

import java.util.Random;

public class Randomizer {
	private Random random;
	private String[] names;
	private String[] games;
	private String[] animes;
	
	public Randomizer() {
		random = new Random();
		
		names = new String[] {
				"Cecilia",
				"Michell",
				"Liliyanti",
				"Bestari",
				"Jia",
				"Xuan",
				"Vivi",
				"Asvina"
		};
		
		games = new String[] {
				"Apex",
				"Rust",
				"Minecraft"
		};
		
		animes = new String[] {
				"SAO",
				"Oregairu",
				"SPYxFAMILY"
		};
	}
	
	public String getRandomName() {
		String firstName = names[random.nextInt(names.length)];
		String lastName = names[random.nextInt(names.length)];
		return firstName + " " + lastName;
	}
	
	public int getRandomAge() {
		int low = 18;
		int high = 50;
		return random.nextInt(high-low) + low;
	}
	
	public String getRandomGame() {
		String game = games[random.nextInt(games.length)];
		return game;
	}
	
	public String getRandomAnime() {
		String anime = games[random.nextInt(animes.length)];
		return anime;
	}
	
	public int getRandomIncome() {
		int low = 2000;
		int high = 100000;
		return random.nextInt(high-low) + low;
	}
	
	public boolean getRandomTwt() {
		return random.nextBoolean();
	}
	
}
