import java.util.Scanner;

import adapter.Adapter_Currency;
import builder.VtubeBuilder;
import models.vtuber;
import singleton.VtubeRepository;

public class Main {

	Scanner scan = new Scanner(System.in);
	VtubeRepository VtuberRepo = VtubeRepository.getInstance();
	
	public Main() {
		mainMenu();
	}
	
	public void mainMenu() {
		int menu = 0;
		do {
			System.out.println("1. Add Vtuber");
			System.out.println("2. View All Vtuber");
			System.out.println("3. Graduate Vtuber");
			System.out.println("4. Exit");
			System.out.println(">> ");
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
			System.out.println("Input vuber's name [ 5 - 20 chars (inclusive) ] : ");
			name = scan.nextLine(); 
			if(name.length() > 5 || name.length() < 20) break;
		}
		
		while(true) {
			System.out.println("Input vtuber's age [ min 18 yo ] : ");
			age = scan.nextInt(); scan.nextLine();
			if(age >= 18) break;
		}
		
		while(true) {
			System.out.println("Input vtuber's fav game [ Apex | Rust | Mineccraft (case sensitive) ] : ");
			game = scan.nextLine(); 
			if(game.equals("Apex") || game.equals("Rust") || game.equals("Minecraft")) break;
		}
		
		while(true) {
			System.out.println("Input vtuber's fav anime [ SAO | Oregairu | SPYxFAMILY (case sensitive) ] : ");
			anime = scan.nextLine(); 
			if(anime.equals("SAO") || anime.equals("Oregairu") || anime.equals("SPYxFAMILY")) break;
		}
		
		while(true) {
			System.out.println("Input vtuber's income [$ 2000 - $ 100000 (inclusive) ] : $ ");
			income = scan.nextInt(); scan.nextLine();
			if(income > 2000 || income < 100000) break;
		}
		
		while(true) {
			System.out.println("Add twitter account ? [ Y | N (case sensitive) ] : ");
			yn = scan.nextLine(); 
			if(yn.equals("Y") || yn.equals("N")) break;
		}
		
		vtuber vtuber = null;
		VtubeBuilder builder = new VtubeBuilder();
		
		if(yn.equals("Y")) {
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
		System.out.println("Vtuber successfully added");
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
