package tests.Test01;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C19_FileExist {

    @Test
    public void test() {
        System.out.println(System.getProperty("user.home"));

        //   /Users/nazmiberksahin/Desktop

        // Masaustundeki bir dosya yolunun tum bilgisayarlarda sorunsuz
        // calismasi icin dosya yolunu ikiye ayiracagiz
        // 1. herkesin bilgisayarinda farkli olan kisim
        //  bu kismi bilgisayardan System.getProperty("user.home") kodu ile alabiliriz
        // 2. herkes icin ayni olan kisim bu kisim 1.maddedeki yolun devami seklinde olur

        String dosyaYolu = System.getProperty("user.home") + "/Desktop/flower.jpeg";
        System.out.println("Dosya Yolu : " + dosyaYolu);
        System.out.println(Paths.get(dosyaYolu));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }

}
