package cn.Exteriormode;


/**
 * 用例背景
 * 用户注册完之后，需要调用阿里短信接口、邮件接口、微信推送接口。
 * 
 * @author aura-bd
 *
 */
public interface EamilSmsService {

	//发送短信
	public void sendSms();
	
}
