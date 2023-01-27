package facade;

import java.util.Random;

import builder.VtubeBuilder;
import models.vtuber;
import singleton.VtubeRepository;

public class initialize {
	private Random random;
	private Randomizer randomizer;
	vtuber vtuber = null;
	VtubeBuilder builder = new VtubeBuilder();
	VtubeRepository VtuberRepo = VtubeRepository.getInstance();

	public initialize() {
		super();
		random = new Random();
		randomizer = new Randomizer();
	}
	
	public void initializeVtuber() {		
		int length = random.nextInt(10-5) + 5;
		String name, game, anime;
		int age, income;
		boolean isTwt;
		
		for(int i = 0; i < 5; i++) {
			isTwt = randomizer.getRandomTwt();
			name = randomizer.getRandomName();
			age = randomizer.getRandomAge();
			game = randomizer.getRandomGame();
			anime = randomizer.getRandomAnime();
			income = randomizer.getRandomIncome();
			
			if(isTwt) {
				vtuber = builder.reset()
						.getName(name)
						.getAge(age)
						.getGame(game)
						.getAnime(anime)
						.getIncome(income)
						.addTwitter("Y")
						.getVtuber();
			}
			else {
				vtuber = builder.reset()
						.getName(name)
						.getAge(age)
						.getGame(game)
						.getAnime(anime)
						.getIncome(income)
						.getVtuber();
			}
			VtuberRepo.addVtuber(vtuber);	
		}
	}
}
