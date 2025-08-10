package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ManageBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Publication[] publication = {
			  new Magazine("����ũ�μ���Ʈ����", "2007-10-01", 328, 9900, "����")             
              , new Magazine("�濵����ǻ��", "2014-10-03", 316, 9000, "����")                
              , new Novel("���߿�", "2009-07-01", 396, 9800, "����������������", "����Ҽ�")
              , new Novel("���ѻ꼺", "2009-04-14", 383, 11000, "����", "���ϼҼ�")
              , new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������") 
		};
		
		System.out.println("==== ���� ���� ��� ====");
		int idx = 0;
		for(Publication p : publication) {
			System.out.println((++idx) + ". " + p.toString());
		}
		System.out.println("");
		System.out.println("==== ���� ���� ====");
		int prev = publication[2].getPrice();
		System.out.printf("%s ���� �� ����: %d\n", publication[2].getTitle(), publication[2].getPrice());
		modifyPrice(publication[2]);
		int next = publication[2].getPrice();
		
		System.out.printf("%s ���� �� ����: %d\n", publication[2].getTitle(), publication[2].getPrice());
		System.out.printf("����: %d��\n", prev-next);
		
		System.out.println("");
		System.out.println("==== ���ǹ� ��� �м� ====");
		StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
		analyzer.printStatistics(publication);
	}
	
	public static void modifyPrice(Publication publication) {
		int currentPrice = publication.getPrice();
		if (publication instanceof Magazine) {
			publication.setPrice((int)(currentPrice * 0.6)); // 40% ����
		} else if (publication instanceof Novel) {
			publication.setPrice((int)(currentPrice * 0.8)); // 20% ���� 
		} else if (publication instanceof ReferenceBook) {
			publication.setPrice((int)(currentPrice * 0.9)); // 10% ����
		}
	}
}
