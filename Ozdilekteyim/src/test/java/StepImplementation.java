import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

public class StepImplementation extends BasePage {
    By logo = By.id("com.ozdilek.ozdilekteyim:id/iv_storeTopLogo");
    By startShopElement = By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore");
    By categoriesElement = By.id("com.ozdilek.ozdilekteyim:id/nav_categories");
    By categoriesWomen = By.xpath("//*[@text='Kadın']");
    By tapFavourite = By.id("com.ozdilek.ozdilekteyim:id/imgFav");
    By categoriesPants = By.xpath("//*[@text='Pantolon']");
    By productsDetailPage = By.id("com.ozdilek.ozdilekteyim:id/imgInstallmentAtt");
    By productsElement = By.xpath("//*[@resource-id='com.ozdilek.ozdilekteyim:id/imageView']");
    By logInBtn = By.id("com.ozdilek.ozdilekteyim:id/btnLogin");
    By eposta = By.id("com.ozdilek.ozdilekteyim:id/etEposta");
    By password = By.id("com.ozdilek.ozdilekteyim:id/etPassword");
    By backBtn = By.id("com.ozdilek.ozdilekteyim:id/ivBack");
    By addCartBtn = By.id("com.ozdilek.ozdilekteyim:id/relLayAddCartBtn");

    @Step("Uygulamanın açıldığı kontrol edilir")
    public void isOpen() {
        wait(5, logo);
        assertion(logo);
        logger.info("Uygulama açıldı");
    }

    @Step("Alışverişe Başla butonuna tıklanır")
    public void startShop() {
        wait(5, startShopElement);
        clickElement(startShopElement);
        logger.info("Alışverişe Başla butonuna tıklandı");
    }

    @Step("Alışveriş sayfasının açıldığı doğrulanır")
    public void isShopingPage(){
        wait(5,categoriesElement);
        assertion(categoriesElement);
        logger.info("Alışveriş sayfası açıldı");
    }

    @Step("Kategoriler sayfası açılır")
    public void categories() {
        wait(5, categoriesElement);
        clickElement(categoriesElement);
        logger.info("Kategoriler sayfası açıldı");
    }

    @Step("Kategoriler sayfası açıldığı doğrulanır")
    public void isCategoriesPage(){
        wait(5,categoriesWomen);
        assertion(categoriesWomen);
        logger.info("Kategoriler sayfası açıldığı doğrulandı");
    }

    @Step("Menüden kadın seçeneğine tıklanır")
    public void tapCategoriesWomen() {
        wait(5, categoriesWomen);
        clickElement(categoriesWomen);
        logger.info("Menüden kadın seçeneğine tıklandı");
    }

    @Step("Pantolon kategorisi açılır")
    public void tapPants() {
        wait(5, categoriesPants);
        clickElement(categoriesPants);
        logger.info("Pantolon kategorisi açıldı");
    }

    @Step("Sayfanın aşağısına doğru <value> kez scroll edilir")
    public void scroll(String value) throws InterruptedException {
        Thread.sleep(2);
        scrollDown(value);
        logger.info("Sayfanın aşağısına 2 kez scroll edildi");
    }

    @Step("Ürünlerden rastgele bir ürün seçilir")
    public void randomProduct() {
        selectRandom(productsElement);
        logger.info("Rastgele bir ürün seçildi");
    }

    @Step("Ürün detay sayfası açıldığı kontrol edilir")
    public void isProductDetailPage(){
        wait(5,productsDetailPage);
        assertion(productsDetailPage);
        logger.info("Ürün görüntülendi");
    }

    @Step("Favoriler butonuna tıklanır")
    public void addFavourite() {
        wait(5, tapFavourite);
        clickElement(tapFavourite);
        logger.info("Favoriler butonuna tıklandı");
    }

    @Step("Giriş yapma sayfasının açıldığı doğrulanır")
    public void isLoginPage(){
        wait(5,logInBtn);
        assertion(logInBtn);
        logger.info("Giriş sayfası açıldı");
    }

    @Step("Kullanıcı adı alanına <value> bilgisi girilir")
    public void sendUserName(String value) {
        wait(5, eposta);
        clickElement(eposta);
        sendKeys(eposta, value);
        logger.info("Kullanıcı adı alanına text bilgisi girildi");
    }

    @Step("Password alanına <value> yazılır")
    public void sendPasword(String value) {
        wait(5, password);
        clickElement(password);
        sendKeys(password, value);
        logger.info("Password alanına deper yazıldı");
    }

    @Step("Geri butonuna <value> kere tıklanır")
    public void tapBack(String value) {
        int i = 0;
        while (i < Integer.parseInt(value)) {
            wait(5, backBtn);
            clickElement(backBtn);
            logger.info("Geri butonuna tıklandı");
            i++;
        }
    }

    @Step("Seçilen ürün sepete eklenir")
    public void addToCart() {
        wait(5, addCartBtn);
        clickElement(addCartBtn);
        logger.info("Sepete ekle butonuna tıklandı");
    }
}
