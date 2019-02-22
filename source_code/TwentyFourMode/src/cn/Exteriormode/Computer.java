package cn.Exteriormode;

// 门面类 
// 相当于对外提供一个入口
public class Computer {

	AliSmsService aliSmsService;
	EamilSmsService eamilSmsService;
	WeiXinSmsService weiXinSmsService;

	//电脑端
	public Computer() {
		aliSmsService = new AliSmsServiceImpl();
		eamilSmsService = new EamilSmsServiceImpl();
		weiXinSmsService = new WeiXinSmsServiceImpl();
	}

	//发送消息
	public void sendMsg() {
		aliSmsService.sendSms();
		eamilSmsService.sendSms();
		weiXinSmsService.sendSms();

	}
	
}
