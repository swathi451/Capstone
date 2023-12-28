package drivers;

import org.openqa.selenium.WebDriver;

import java.sql.Driver;

public class ChromeDriverManager implements DriverManager<WebDriver> {
@Override
    public WebDriver create(){
    return new io.github.bonigarcia.wdm.managers.ChromeDriverManager().create();
}
}
