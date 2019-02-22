package cn.Strategymode;

//使用上下文 维护算法策略
public class Context {

	Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public void algorithmInterface() {
		strategy.algorithmInterface();
	}
	
}
