package za.co.reference.designpatterns.creationalpatterns.prototype;

/*
 * Client class
 */
public class CookieMachine{
	
	private Cookie cookie;
	
	public CookieMachine(Cookie cookie){
		this.cookie = cookie;
	}
	
	public Cookie makeCookie(){
		return (Cookie)cookie.clone();
	}
	
	public static void main(String[] args){
		Cookie tempCookie = null;
		Cookie prot = new CoconutCookie();
		CookieMachine cm = new CookieMachine(prot);
		for (int i = 0; i < 100; i++){
			tempCookie = cm.makeCookie();
		}
	}

}
