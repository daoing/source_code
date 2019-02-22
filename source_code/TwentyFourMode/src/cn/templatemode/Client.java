package cn.templatemode;

public class Client {

	public static void main(String[] args) {

		BankTemplateMethod bankTemplate=new DrawMoney();
		bankTemplate.process();
		
		//匿名内部类方式
		BankTemplateMethod bankTemplateMethod=new BankTemplateMethod() {
			
			@Override
			void transact() {
				System.out.println("我要存钱####");
				
			}
		};
		bankTemplateMethod.process();

	}
}
