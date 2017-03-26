package proxy;

public class UserManagerImpl implements IUserManager{
	
	public void addUser(String username, String password) {
		
		System.out.println("addUser()方法被调用"+this.getClass().getName());
		
	}

}
