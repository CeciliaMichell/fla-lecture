import java.util.Scanner;

import adapter.Adapter_Currency;
import builder.VtubeBuilder;
import facade.initialize;
import models.vtuber;
import singleton.VtubeRepository;

public class Main {

	Scanner scan = new Scanner(System.in);
	VtubeRepository VtuberRepo = VtubeRepository.getInstance();
	initialize init = new initialize();
	
	public Main() {
		init.initializeVtuber();
		mainMenu();
	}
	
	void cls() {
		for (int i = 0; i < 30; i++) {
			System.out.println("");
		}
	}
	
	public void mainMenu() {
		int menu = 0;
		do {
			cls();
			System.out.println("Welcome to vtubRE Agency");
			System.out.println("-------------------------");
			System.out.println("1. Add Vtuber");
			System.out.println("2. View All Vtuber");
			System.out.println("3. Graduate Vtuber");
			System.out.println("4. Exit");
			System.out.print(">> ");
			try {
				menu = scan.nextInt(); scan.nextLine();
			}catch(Exception ex) {
				throw ex;
			}
			
			switch(menu) {
				case 1:
					add();
					break;
				case 2:
					view();
					break;
				case 3:
					graduate();
					break;
				case 4:
					return;
			}
		}while(menu != 4);
	}
	
	public void add() {
		String name, game, anime, yn;
		int age, income;
		
		while(true) {
			System.out.print("Input vuber's name [ 5 - 20 chars (inclusive) ] : ");
			name = scan.nextLine(); 
			if(name.length() > 5 || name.length() < 20) break;
		}
		
		while(true) {
			System.out.print("Input vtuber's age [ min 18 yo ] : ");
			age = scan.nextInt(); scan.nextLine();
			if(age >= 18) break;
		}
		
		while(true) {
			System.out.print("Input vtuber's fav game [ Apex | Rust | Mineccraft (case sensitive) ] : ");
			game = scan.nextLine(); 
			if(game.equalsIgnoreCase("Apex") || game.equalsIgnoreCase("Rust") || game.equalsIgnoreCase("Minecraft")) break;
		}
		
		while(true) {
			System.out.print("Input vtuber's fav anime [ SAO | Oregairu | SPYxFAMILY (case sensitive) ] : ");
			anime = scan.nextLine(); 
			if(anime.equalsIgnoreCase("SAO") || anime.equalsIgnoreCase("Oregairu") || anime.equalsIgnoreCase("SPYxFAMILY")) break;
		}
		
		while(true) {
			System.out.print("Input vtuber's income [$ 2000 - $ 100000 (inclusive) ] : $ ");
			income = scan.nextInt(); scan.nextLine();
			if(income > 2000 || income < 100000) break;
		}
		
		while(true) {
			System.out.print("Add twitter account ? [ Y | N (case sensitive) ] : ");
			yn = scan.nextLine(); 
			if(yn.equalsIgnoreCase("Y") || yn.equalsIgnoreCase("N")) break;
		}
		
		vtuber vtuber = null;
		VtubeBuilder builder = new VtubeBuilder();
		
		if(yn.equalsIgnoreCase("Y")) {
			vtuber = builder.reset()
					.getName(name)
					.getAge(age)
					.getGame(game)
					.getAnime(anime)
					.getIncome(income)
					.addTwitter(yn)
					.getVtuber();
		} else {
			vtuber = builder.reset()
					.getName(name)
					.getAge(age)
					.getGame(game)
					.getAnime(anime)
					.getIncome(income)
					.getVtuber();
		}
		VtuberRepo.addVtuber(vtuber);
		System.out.println("Press enter to continue..."); scan.nextLine();
	}
	
	public void view() {
		if(VtuberRepo.getVtuberList().isEmpty()){
			System.out.println("No data\n"); return;
		} else {
			Adapter_Currency adapter = null;
			int menu = 0;
			do {
				System.out.println("1. USD");
				System.out.println("2. IDR");
				System.out.println("3. YEN");
				System.out.println("4. Exit");
				System.out.print("[1-4] >> ");
				try {
					menu = scan.nextInt(); scan.nextLine();
				}catch(Exception ex) {
					throw ex;
				}
				
				if(menu == 1) adapter = new Adapter_Currency("USD");
				if(menu == 2) adapter = new Adapter_Currency("IDR");
				if(menu == 3) adapter = new Adapter_Currency("YEN");
				
				int size = VtuberRepo.getVtuberList().size();
				for(int i = 0; i < size; i++) {
					vtuber This = VtuberRepo.getVtuberList().get(i);
					System.out.printf("No : %d\n", i+1);
					System.out.println("Name : " + This.getName());
					System.out.println("Age : " + This.getAge());
					System.out.println("Fav Game : " + This.getGame());
					System.out.println("Fav Anime : " + This.getAnime());
					System.out.println("Income : $ " + adapter.moneyChanger(This.getIncome()));
					if(This.getYn() == null) {
						System.out.println("Twitter Acc : - ");
					} else {
						System.out.println("Twitter Acc : " + This.getName() + " Ch.");					
					}
					System.out.println();
				}
				
			}while(menu != 4);
		}
	}
	
	public void graduate() {
		if(VtuberRepo.getVtuberList().isEmpty()){
			System.out.println("No data\n"); return;
		} else {
			int size = VtuberRepo.getVtuberList().size(), index = 0;
			
			for(int i = 0; i < size; i++) {
				vtuber This = VtuberRepo.getVtuberList().get(i);
				System.out.printf("No : %d\n", i+1);
				System.out.println("Name : " + This.getName());
				System.out.println("Age : " + This.getAge());
				System.out.println("Fav Game : " + This.getGame());
				System.out.println("Fav Anime : " + This.getAnime());
				System.out.println("Income : $ " + This.getIncome());
				if(This.getYn() == null) {
					System.out.println("Twitter Acc : - ");
				} else {
					System.out.println("Twitter Acc : " + This.getName() + " Ch.");					
				}
				System.out.println();
			}
			System.out.println();
			
			while(true) {
				System.out.printf("Input vtuber you want to graduate [ 1 - %d ] : \n", size);
				index = scan.nextInt(); scan.nextLine(); 
				if(index >= 1 && index < size) break;
			}
			VtuberRepo.graduateVtuber(index);
			System.out.println("Press enter to continue..."); scan.nextLine();
		}

	}

	public static void main(String[] args) {
		new Main();
	}

}
