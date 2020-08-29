package attsd.exam.spring.loginservice.project.controllers.steps;
import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;

import attsd.exam.spring.loginservice.project.repositories.UserRepository;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.UnexpectedAlertBehaviour;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, properties = "spring.main.allow-bean-definition-overriding=true")
@ContextConfiguration(loader = SpringBootContextLoader.class)
public class LoginserviceWebControllerSteps {

	@Autowired
	private UserRepository urepository;


	@LocalServerPort
	private int port;

	private static String baseUrl = "http://localhost:";

	private WebDriver driver;

	@Before
	public void setup() {
		ChromeOptions options = new ChromeOptions()
                        .setHeadless(true);
		driver = new ChromeDriver(options);
		urepository.deleteAll();
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	@Given("The User is on SignUp Page")
	public void the_User_is_on_SignUp_Page() throws Throwable {
			driver.get(baseUrl +port+"/signup");
		}

	@When("^Enters email \"([^\"]*)\" , password \"([^\"]*)\" ,usernumber \"([^\"]*)\" and username \"([^\"]*)\"$")
	public void enters_email_password_and_username(String email, String password,String usernumber, String username) throws Throwable {
			driver.findElement(By.name("email")).sendKeys(email);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("usernumber")).sendKeys(usernumber);
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("submit")).click();
		}

	@Then("^The User is on Login Page$")
	public void the_User_is_on_Login_Page() throws Throwable {
			assertThat(driver.getTitle()).contains("Login");
		}

	@When("^The User load his email \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void load_his_email_and_password(String email, String password) throws Throwable {
			driver.findElement(By.name("email")).sendKeys(email);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("submit")).click();
		}

	@Then("^The user with email \"([^\"]*)\" is logged$")
	public void the_user_with_email_is_logged(String email) throws Throwable {
			assertThat(driver.getTitle()).contains("Login");
		}

	@When("^The user logout$")
		public void the_User_make_logout() throws Throwable {
			driver.get(baseUrl + port+"/logout");
		}

	@Then("^The message \"([^\"]*)\" must be shown$")
		public void a_message_must_be_shown(String expectedMessage) throws Throwable {
		assertThat(driver.getPageSource()).contains(expectedMessage);
		}
	

	
	}