import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;


public class Listener implements WebDriverListener {
	
	
	@Override
	public void beforeClick(WebElement element) {
	    System.out.println("Before clicking: " + element);
}
	@Override
    public void afterClick(WebElement element) {
        System.out.println("After clicking: " + element);
    }
		

    @Override
    public void beforeGet(WebDriver driver, String url) {
        System.out.println("Before navigating to: " + url);
        
}
    @Override 
    public void afterGet(WebDriver driver, String Url) {
    	System.out.println("After navigating to"+ Url);
    }
}