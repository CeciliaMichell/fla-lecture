package adapter;

public class Adapter_Currency {

	String currency;
	
	public Adapter_Currency(String currency) {
		this.currency = currency;
	}
	
	public int moneyChanger(int money) {
		if(currency.equals("USD")) {
			return money; 
		}else if(currency.equals("IDR")) {
			return money * 15000;
		}else if(currency.equals("YEN")) {
			return money * 136;
		}
		return 0;
	}

}
