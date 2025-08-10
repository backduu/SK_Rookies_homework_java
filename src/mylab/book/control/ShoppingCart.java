package mylab.book.control;

import java.util.*;
import mylab.book.entity.*;

public class ShoppingCart {
	private List<Publication> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + "이(가) 장바구니에 추가되었습니다.");
    }

    public boolean removeItem(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(title)) {
                Publication removed = items.remove(i);
                System.out.println(removed.getTitle() + "이(가) 장바구니에서 제거되었습니다.");
                return true;
            }
        }
        System.out.println("해당 제목의 출판물을 찾을 수 없습니다.");
        return false;
    }

    public void displayCart() {
        System.out.println("====== 장바구니 목록 ======");
        int idx = 0;
        for (Publication item : items) {
            System.out.println((++idx) + ". " + item.toString());
        }

        int total = calculateTotalPrice();
        int discounted = calculateDiscountedPrice();

        System.out.println("\n총 가격: " + total + "원");
        System.out.println("할인 적용 가격: " + discounted + "원");
        System.out.println("할인 금액: " + (total - discounted) + "원");
    }

    public int calculateTotalPrice() {
        int total = 0;
        for (Publication item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public int calculateDiscountedPrice() {
        int total = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) {
                total += item.getPrice() * 0.9;
            } else if (item instanceof Novel) {
                total += item.getPrice() * 0.85;
            } else if (item instanceof ReferenceBook) {
                total += item.getPrice() * 0.8;
            } else {
                total += item.getPrice();
            }
        }
        return total;
    }

    public void printStatistics() {
        int magazineCount = 0;
        int novelCount = 0;
        int referenceBookCount = 0;

        for (Publication item : items) {
            if (item instanceof Magazine) {
                magazineCount++;
            } else if (item instanceof Novel) {
                novelCount++;
            } else if (item instanceof ReferenceBook) {
                referenceBookCount++;
            }
        }

        System.out.println("====== 장바구니 통계 ======");
        System.out.println("잡지: " + magazineCount + "권");
        System.out.println("소설: " + novelCount + "권");
        System.out.println("참고서: " + referenceBookCount + "권");
        System.out.println("총 출판물: " + items.size() + "권");
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Publication[] publication = {
				  new Magazine("마이크로소프트웨어", "2007-10-01", 328, 9900, "월간")             
	              , new Magazine("경영과컴퓨터", "2014-10-03", 316, 9000, "월간")                
	              , new Novel("빠삐용", "2009-07-01", 396, 9800, "베르나르베르베르", "현대소설")
	              , new Novel("남한산성", "2009-04-14", 383, 11000, "김훈", "대하소설")
	              , new ReferenceBook("실용주의프로그래밍", "2007-01-14", 496, 25000, "소프트웨어공학") 
		};
		
        ShoppingCart cart = new ShoppingCart();
    	cart.addItem(publication[0]);
    	cart.addItem(publication[2]);
    	cart.addItem(publication[4]);

    	System.out.println();
    	cart.displayCart();

    	System.out.println();
    	cart.printStatistics();

    	System.out.println();
    	cart.removeItem("빠삐용");
    	cart.displayCart();
	}

}
