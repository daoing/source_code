package cn.Strategymode;

public class Client {

	public static void main(String[] args) {
		Context context;
		context = new Context(new StrategyA());
		context.algorithmInterface();
		context = new Context(new StrategyB());
		context.algorithmInterface();
		context = new Context(new StrategyC());
		context.algorithmInterface();

	}
	
}
