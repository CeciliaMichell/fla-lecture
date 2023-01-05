package builder;

import models.vtuber;

public class VtubeBuilder implements Builder{

	private vtuber vtuber;
	
	public VtubeBuilder() {
		
	}

	@Override
	public Builder reset() {
		vtuber = new vtuber();
		return this;
	}

	@Override
	public Builder getName(String name) {
		vtuber.setName(name);
		return this;
	}

	@Override
	public Builder getAge(int age) {
		vtuber.setAge(age);
		return this;
	}

	@Override
	public Builder getGame(String game) {
		vtuber.setGame(game);
		return this;
	}

	@Override
	public Builder getAnime(String anime) {
		vtuber.setAnime(anime);
		return this;
	}

	@Override
	public Builder getIncome(int income) {
		vtuber.setIncome(income);
		return this;
	}

	@Override
	public Builder addTwitter(String yn) {
		vtuber.setYn(yn);
		return this;
	}

	@Override
	public vtuber getVtuber() {
		return vtuber;
	}

}
