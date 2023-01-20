package shop.mtcoding.buyer.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.buyer.dto.PurchaseAllDto;
import shop.mtcoding.buyer.model.ProductRepository;
import shop.mtcoding.buyer.model.PurchaseRepository;
import shop.mtcoding.buyer.model.User;
import shop.mtcoding.buyer.service.PurchaseService;

@Controller
public class PurchaseController {

    @Autowired
    private HttpSession session;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/purchase")
    public String purchase(Model model) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }
        List<PurchaseAllDto> purchaseList = purchaseRepository.findByUserId(principal.getId());
        model.addAttribute("purchaseList", purchaseList);
        return "purchase/list";
    }
    
    /*
     * 비즈니스 로직. - DB 관련된 것 -> 이런 것들은 레이어를 분리해 트랜잭션 관리가 필요하다. 단 SELECT이거나 INSERT, DELETE, UPDATE 셋 중 하나만 있을 경우는 할 필요 없음.
     * 비즈니스 로직은 원자성을 가져한다.
     * 서비스 클래스가 필요 . - 서비스의 책임 : 트랜잭션 관리
     * 목적
     * 1. 세션이 있는지 체크
     * 2. 구매 히스토리 남기기
     * 3. 재고 수량 변경
     */
    @PostMapping("/purchase/insert")
    public String insert(int productId, int count) {
        // 1. 세션이 있는지 체크
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }

        //2. 서비스 호출
        int result = purchaseService.구매하기(principal.getId(), productId, count);
        if (result == -1) {
            return "redirect:/notfound";
        }
        
        return "redirect:/";
    }

}
