package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import techproed.utilities.TestBase;

public class C04_Faker {
    @Test
    public void faker() {
        /*
            Faker class'indan sahte verileri kullanabilmek icin obje olusturmamiz gerekiyor
         */
        Faker faker = new Faker();

        //faker objesini kullanarak bir isim yazdiralim
        System.out.println("Isim : " + faker.name().firstName());

        //faker objesini kullanarak bir lastName yazdiralim
        System.out.println("SoyIsim : " + faker.name().lastName());

        //faker objesini kullanarak bir fullName yazdiralim
        System.out.println("Isim_Soyisim : " + faker.name().fullName());

        //faker objesini kullanarak bir adress yazdiralim
        System.out.println("Adres : " + faker.address().fullAddress());

        //faker objesini kullanarak bir tel_no yazdiralim
        System.out.println("Cep_No : " + faker.phoneNumber().cellPhone());
        System.out.println("Tel_No : " + faker.phoneNumber().phoneNumber());

        //Rastgele 15 haneli bir numara yazdiralim
        System.out.println(faker.number().digits(15));

        //Meslek pozisyonu
        System.out.println(faker.job().position());
    }
}
