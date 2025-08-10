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
        System.out.println(item.getTitle() + "��(��) ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
    }

    public boolean removeItem(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(title)) {
                Publication removed = items.remove(i);
                System.out.println(removed.getTitle() + "��(��) ��ٱ��Ͽ��� ���ŵǾ����ϴ�.");
                return true;
            }
        }
        System.out.println("�ش� ������ ���ǹ��� ã�� �� �����ϴ�.");
        return false;
    }

    public void displayCart() {
        System.out.println("====== ��ٱ��� ��� ======");
        int idx = 0;
        for (Publication item : items) {
            System.out.println((++idx) + ". " + item.toString());
        }

        int total = calculateTotalPrice();
        int discounted = calculateDiscountedPrice();

        System.out.println("\n�� ����: " + total + "��");
        System.out.println("���� ���� ����: " + discounted + "��");
        System.out.println("���� �ݾ�: " + (total - discounted) + "��");
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

        System.out.println("====== ��ٱ��� ��� ======");
        System.out.println("����: " + magazineCount + "��");
        System.out.println("�Ҽ�: " + novelCount + "��");
        System.out.println("����: " + referenceBookCount + "��");
        System.out.println("�� ���ǹ�: " + items.size() + "��");
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Publication[] publication = {
				  new Magazine("����ũ�μ���Ʈ����", "2007-10-01", 328, 9900, "����")             
	              , new Magazine("�濵����ǻ��", "2014-10-03", 316, 9000, "����")                
	              , new Novel("���߿�", "2009-07-01", 396, 9800, "����������������", "����Ҽ�")
	              , new Novel("���ѻ꼺", "2009-04-14", 383, 11000, "����", "���ϼҼ�")
	              , new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������") 
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
    	cart.removeItem("���߿�");
    	cart.displayCart();
	}

}
