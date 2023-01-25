package br.com.accenture.core;

import br.com.accenture.enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;
    private static String nomeCenario;
    private static File diretorio;
    private static int numPrint;

    public static File getDiretorio() {
        return diretorio;
    }

    public static String getNomeCenario() {
        return nomeCenario;
    }

    public static void setNomeCenario(String nomeCenario) {
        Driver.nomeCenario = nomeCenario;
    }

    public static void criaDiretorio() {
        String caminho = "src/test/resources/evidence";
        diretorio = new File(caminho + "/" + nomeCenario);
        diretorio.mkdir();
        numPrint = 0;
    }

    public static void printScreen(String passo) {
        numPrint++;
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String caminho = diretorio.getPath() + "/" + numPrint + " - " + passo + ".png";
        try {
            FileUtils.copyFile(file, new File(caminho));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String printScreen() {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        int _numberPrint = numPrint + 1;

        try {
            FileUtils.copyFile(srcFile, new File("imgs\\screenshot_" + _numberPrint + ".png"));
            numPrint = _numberPrint;

        } catch (Exception e) {
            System.err.println(e);
        }
        return "imgs\\screenshot_" + _numberPrint + ".png";
    }

    public Driver(Browser navegador) {

        switch (navegador) {
            case CHROME:
                startChrome();
                break;
            case FIREFOX:
                startFirefox();
                break;
            case EDGE:
                startEdge();
                break;
            case IE:
                startIE();
                break;
        }

        wait = new WebDriverWait(driver, 30);
        action = new Actions(driver);
        driver.manage().window().maximize();
    }

    private void startIE() {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
    }

    private void startEdge() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

    private void startFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    private void startChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        boolean headless = Boolean.parseBoolean(System.getProperty("headless"));
        chromeOptions.setHeadless(headless);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().setSize(new Dimension(1280, 720));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebElement visibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;

    }

    public static void invisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }


    public static void closeAlert() {

        for (int i = 0; i < 10; i++) {
            try {
                driver.switchTo().alert().accept();
                break;
            } catch (Exception e) {
                waitMillisSeconds(500);
            }

        }


    }

    public static String getAlertMsg(){
        String msg = "";
        for (int i = 0; i < 10; i++) {
            try {
                msg = driver.switchTo().alert().getText();
                break;
            } catch (Exception e) {
                waitMillisSeconds(500);
            }

        }
        return msg;
    }

    public static void waitMillisSeconds(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
