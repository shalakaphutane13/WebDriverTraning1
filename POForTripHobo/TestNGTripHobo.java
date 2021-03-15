package POForTripHobo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNGTripHobo {
	PageFactoryForTripHobo tripHobo;
  @Test
  public void tripHobo() throws InterruptedException {
	  tripHobo.location("Houston");
	  Thread.sleep(5000);
	  tripHobo.dragAnddrop();
	  tripHobo.Mousehover();  
  }
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  //tripHobo =new PageFactoryForTripHobo();
	  PageFactoryForTripHobo tripHobo=new PageFactoryForTripHobo();
  }

  @AfterMethod
  public void afterMethod() {
	  
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
