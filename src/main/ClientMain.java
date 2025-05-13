package main;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import ESB.CTR;
import ESB.CTRHelper;
import ESB.accountInfoHolder;
import ESB.reqObj;
import ESB.userInfoHolder;

public class ClientMain {
	static CTR helloImpl;
	
	public static void main(String args[]) {
		try{
			// create and initialize the ORB
			ORB orb = ORB.init(args, null);
			
			// get the root naming context
			org.omg.CORBA.Object objRef = 
				orb.resolve_initial_references("NameService");
			// Use NamingContextExt instead of NamingContext. This is 
			// part of the Interoperable naming Service.  
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
				   
			// resolve the Object Reference in Naming
			String name = "Hello";
			helloImpl = CTRHelper.narrow(ncRef.resolve_str(name));
			
			System.out.println("Obtained a handle on server object: " + helloImpl);
			reqObj req = new reqObj("aaaa");
			userInfoHolder user = new userInfoHolder();
			accountInfoHolder account = new accountInfoHolder();
			System.out.println(helloImpl.sayHello(req, user, account));
			//	          helloImpl.shutdown();
			
		} catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}
	}
}
