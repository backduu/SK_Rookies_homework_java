package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ManageBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Publication[] publication = {
			  new Magazine("마이크로소프트웨어", "2007-10-01", 328, 9900, "월간")             
              , new Magazine("경영과컴퓨터", "2014-10-03", 316, 9000, "월간")                
              , new Novel("빠삐용", "2009-07-01", 396, 9800, "베르나르베르베르", "현대소설")
              , new Novel("남한산성", "2009-04-14", 383, 11000, "김훈", "대하소설")
              , new ReferenceBook("실용주의프로그래밍", "2007-01-14", 496, 25000, "소프트웨어공학") 
		};
		
		System.out.println("==== 도서 정보 출력 ====");
		int idx = 0;
		for(Publication p : publication) {
			System.out.println((++idx) + ". " + p.toString());
		}
		System.out.println("");
		System.out.println("==== 가격 변경 ====");
		int prev = publication[2].getPrice();
		System.out.printf("%s 변경 전 가격: %d\n", publication[2].getTitle(), publication[2].getPrice());
		modifyPrice(publication[2]);
		int next = publication[2].getPrice();
		
		System.out.printf("%s 변경 후 가격: %d\n", publication[2].getTitle(), publication[2].getPrice());
		System.out.printf("차액: %d원\n", prev-next);
		
		System.out.println("");
		System.out.println("==== 출판물 통계 분석 ====");
		StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
		analyzer.printStatistics(publication);
	}
	
	public static void modifyPrice(Publication publication) {
		int currentPrice = publication.getPrice();
		if (publication instanceof Magazine) {
			publication.setPrice((int)(currentPrice * 0.6)); // 40% 할인
		} else if (publication instanceof Novel) {
			publication.setPrice((int)(currentPrice * 0.8)); // 20% 할인 
		} else if (publication instanceof ReferenceBook) {
			publication.setPrice((int)(currentPrice * 0.9)); // 10% 할인
		}
	}
}
