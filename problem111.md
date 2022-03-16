# qe_Bagas-Dwi-Saputa

---------------
Maven
----------------------
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>test.alterra</groupId>
    <artifactId>BDD</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <serenity.version>2.1.13</serenity.version>
        <serenity.maven.version>2.1.13</serenity.maven.version>
        <serenity.cucumber.version>2.1.2</serenity.cucumber.version>
        <cucumber.version>4.8.0</cucumber.version>
        <encoding>UTF-8</encoding>
        <parallel.tests>4</parallel.tests>
    </properties>

    <dependencies>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.0.13</version>
        </dependency>
        <!--
          - To use Cucumber 4, exclude the old Cucumber 2 cucumber-core dependency from the serenity-core dependency
          - and include the Cucumber 4 cucumber-java and cucumber-junit dependencies.
        -->
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-core</artifactId>
            <version>${serenity.version}</version>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>io.cucumber</groupId>
                    <artifactId>cucumber-core</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>${cucumber.version}</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>${cucumber.version}</version>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-junit</artifactId>
            <version>${serenity.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-screenplay</artifactId>
            <version>${serenity.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-screenplay-webdriver</artifactId>
            <version>${serenity.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-cucumber4</artifactId>
            <version>${serenity.cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.assertj</groupId>
            <artifactId>assertj-core</artifactId>
            <version>3.6.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest-all</artifactId>
            <version>1.3</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.22.1</version>
                <configuration>
                    <skip>true</skip>
                </configuration>
            </plugin>
            <plugin>
                <artifactId>maven-failsafe-plugin</artifactId>
                <version>2.22.1</version>
                <configuration>
                    <includes>
                        <include>**/*Test.java</include>
                        <include>**/Test*.java</include>
                        <include>**/*TestSuite.java</include>
                        <include>**/When*.java</include>
                    </includes>
                    <systemPropertyVariables>
                        <!--suppress UnresolvedMavenProperty -->
                        <webdriver.base.url>${webdriver.base.url}</webdriver.base.url>
                    </systemPropertyVariables>
                    <parallel>classes</parallel>
                    <threadCount>${parallel.tests}</threadCount>
                    <forkCount>${parallel.tests}</forkCount>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>integration-test</goal>
                            <goal>verify</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.0</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>net.serenity-bdd.maven.plugins</groupId>
                <artifactId>serenity-maven-plugin</artifactId>
                <version>${serenity.maven.version}</version>
                <configuration>
                    <!--suppress UnresolvedMavenProperty -->
                    <tags>${tags}</tags>
                </configuration>
                <dependencies>
                    <dependency>
                        <groupId>net.serenity-bdd</groupId>
                        <artifactId>serenity-core</artifactId>
                        <version>${serenity.version}</version>
                    </dependency>
                </dependencies>
                <executions>
                    <execution>
                        <id>serenity-reports</id>
                        <phase>post-integration-test</phase>
                        <goals>
                            <goal>aggregate</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>


---------
CucumberTestSuite
-----------
package starter;

import io.cucumber.junit.CucumberOptions;

import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(

        plugin = {"pretty"},
        
        features = "src/test/resources/features"
        
)

public class CucumberTestSuite {

}


-----------------
resoures-feature
----------------
Feature: Login

  As a user
  
  I want to se my home page
  
  So that I can update my profile

  Scenario: As user i have able to success login
  
    Given I as on the login page
    
    When I enter my username and password correctly
    
    And I click login button
    
    Then I am on the home page

----------
Login Step 
---------
package starter.stepdefinitions;

import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

import net.thucydides.core.annotations.Steps;

import starter.login.Login;


public class LoginStep {

    @Steps
    
    Login login;

    @Given("I as on the login page")
    public void onTheLoginPage() {
        login.onTheLoginPage();
    }
    @When("I enter my username and password correctly")
    public void enterUsernameAndPassword() {
        login.enterUsernameAndPassword();
    }
    @And("I click login button")
    public void clickLoginButton() {
        login.clickLoginButton();
    }
    @Then("I am on the home page")
    public void onTheHomePage(){
        login.onTheHomePage();
    }
}

----------------
Login.Java
-------------
package starter.login;

import net.thucydides.core.annotations.Step;

public class Login {

    @Step("I as on the login page")
    public void onTheLoginPage() {
        System.out.println("I as on the login page");
    }
    @Step("I enter my username and password correctly")
    public void enterUsernameAndPassword() {
        System.out.println("I enter my username and password correctly");
    }
    @Step("I click login button")
    public void clickLoginButton() {
        System.out.println("I click login button");
    }
    @Step("I am on the home page")
    public void onTheHomePage(){
        System.out.println("I am on the home page");
    }
}



