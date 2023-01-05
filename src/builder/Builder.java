package builder;

import models.vtuber;

public interface Builder {
	public Builder reset();
	public Builder getName(String name);
	public Builder getAge(int age);
	public Builder getGame(String game);
	public Builder getAnime(String anime);
	public Builder getIncome(int income);
	public Builder addTwitter(String yn);
	public vtuber getVtuber();
}
