package shop.mtcoding.buyer.util;

import org.junit.jupiter.api.Test;

public class CookieTest {
    
    @Test
    public void parseTest() {
        //given
        String cookies = "remember=ssar; JSESSIONID=584F6731CED050C889DC08FFF8970998";
        String arr[] = cookies.split(";");
        // for (String string : arr) {
        //     System.out.println(string);
        // }

        // 파싱할 때 trim은 공식.
        String remember = arr[0].split("=")[1].trim();
        // System.out.println(remember);

        // when
    }
}
