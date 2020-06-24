package Login;

import Common.Connection;
import Common.Dummy;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RegisterTestCase extends Connection {
    Dummy dummy = new Dummy();
    protected String ranDomEmail = dummy.RamdomVirtualMail();
    RegisterPage reg;

    @Test
    public void CreateSuccessEmail(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ", ranDomEmail, "123456", "123456");
    }
}
