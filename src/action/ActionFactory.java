package action;

public class ActionFactory {
	private static ActionFactory af = new ActionFactory();
	public static ActionFactory getInstance() {
		return af;
	}
	private ActionFactory() {}
	
	public Action getAction(String cmd) {
		Action action = null;
		switch(cmd) {
		case "login":
			action = new LoginAction(); 
			break;
		case "login_check":
			action = new LoginCheckAction();
			break;
		case "join":
			action = new JoinAction();
			break;
		case "join_check":
			action = new JoinCheckAction();
			break;
		case "id_check":
			action = new IdCheckAction();
			break;
		case "admin":
			action = new AdminAction();
			break;
		case "main":
			action = new MainAction();
			break;
		case "ad_point":
			action = new AdPointAction();
			break;
		case "buy_content":
			action = new BuyContentAction();
			break;
		case "revise":
			action = new ReviseAction();
			break;
		case "revise_check":
			action = new ReviseCheckAction();
			break;
		case "update":
			action = new UpdateAction();
			break;
		case "delete":
			action = new DeleteAction();
			break;			
		}		
		return action;
	}
}
