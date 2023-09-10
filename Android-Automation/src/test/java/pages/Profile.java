package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static step_definition.StepDefinitions.driver;

public class Profile {

    public static WebElement getFirstNameField(){
        return driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]"));

    }

    public static WebElement getLastNameField(){
        return driver.findElement(By.xpath("public static WebElement getFirstNameField(){\n" +
                "        return driver.findElement(By.xpath(\"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]\"));\n" +
                "        \n" +
                "    }"));

    }

}
