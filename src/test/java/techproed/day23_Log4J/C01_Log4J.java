package techproed.day23_Log4J;

import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class C01_Log4J {
    @Test
    public void test01() {
        /*
            Log4j system.out.println gibi her test adiminda bilgilendirme yapmamiza yarayan bir api'dir. Log4j ile bu
            bilgilendirmeleri hem konsolda tarih saat olarak hem de src>main>resources icine koydugumuz log4j.xml file da
            belirttigimiz .log uzantili dosyada yinr tarih saat olarak kayit altina almis olacagiz

            Loj4j kullanabilmek icin oncelikle log4j-api ve log4j-care dependency'lerini mvnrepository.com adresinden
            ayni (version numaralarina sahip) alip pom.xml dosyamiza koymaliyiz.
            src>main>resources icine koydugumuz log4j.xml dosyasindaki kodlara pdf'deki adresten ulasabilirsiniz
         */

        /*
        Root level kismina "DEBUG"  yazarsak ==> konsolda hepsi
        "INFO" yazarsak ==> debug haric hepsi
        "ERROR" yazarsak ==> error ve fatal gorunur
        */

        Logger logger = LogManager.getLogger(C01_Log4J.class);
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");
        logger.fatal("FATAL");
        logger.warn("WARNING");
    }
}
