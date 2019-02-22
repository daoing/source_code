package cn.abmode;

/**
 * 为宝马523系列生产配件
 * @author aura-bd
 *
 */
public class FactoryBMW523 implements AbstractFactory{

	@Override
	public Engine createEngine() {
		return new EngineB();
	}

	@Override
	public Aircondition createAircondition() {
		return new AirconditionB();
	}

}
