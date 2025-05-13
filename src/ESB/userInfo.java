package ESB;


/**
* ESB/userInfo.java .
* IDL-to-Javaコンパイラ(ポータブル)、バージョン"3.2"によって生成されました
* ESB.idlから
* 2025年5月1日 7時29分15秒 JST
*/

public final class userInfo implements org.omg.CORBA.portable.IDLEntity
{
  public String userId = null;
  public String userName = null;
  public String phoneNumber = null;

  public userInfo ()
  {
  } // ctor

  public userInfo (String _userId, String _userName, String _phoneNumber)
  {
    userId = _userId;
    userName = _userName;
    phoneNumber = _phoneNumber;
  } // ctor

} // class userInfo
