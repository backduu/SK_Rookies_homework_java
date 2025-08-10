package mylab.book.control;

import java.text.DecimalFormat;
import java.util.*;

import mylab.book.entity.*;

public class StatisticsAnalyzer {
	// 타입별 평균 가격 계산 메서드
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> totalPriceMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            totalPriceMap.put(type, totalPriceMap.getOrDefault(type, 0) + pub.getPrice());
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> averageMap = new HashMap<>();
        for (String type : totalPriceMap.keySet()) {
            double avg = (double) totalPriceMap.get(type) / countMap.get(type);
            averageMap.put(type, avg);
        }

        return averageMap;
    }
    
    // 특정 연도 출판물 비율 계산
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int matchCount = 0;

        for (Publication pub : publications) {
            String date = pub.getPublishDate();
            if (date != null && date.length() >= 4 && date.substring(0, 4).equals(year)) {
                matchCount++;
            }
        }

        return (double) matchCount * 100 / publications.length;
    }

    
    // 출판물 유형 분포 계산
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> typeCountMap = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            typeCountMap.put(type, typeCountMap.getOrDefault(type, 0) + 1);
        }

        int total = publications.length;
        Map<String, Double> distributionMap = new HashMap<>();
        for (String type : typeCountMap.keySet()) {
            double ratio = (double) typeCountMap.get(type) * 100 / total;
            distributionMap.put(type, ratio);
        }

        return distributionMap;
    }


	// 출판물 타입 확인 헬퍼 메서드
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "소설";
        else if (pub instanceof Magazine) return "잡지";
        else if (pub instanceof ReferenceBook) return "참고서";
        else return "기타";
    }

    // 통계 정보 출력
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("타입별 평균 가격:");
        Map<String, Double> avgMap = calculateAveragePriceByType(publications);
        for (String type : avgMap.keySet()) {
            System.out.printf("- %s: %s원\n", type, df.format(avgMap.get(type)));
        }

        System.out.println("\n출판물 유형 분포:");
        Map<String, Double> distMap = calculatePublicationDistribution(publications);
        for (String type : distMap.keySet()) {
            System.out.printf("- %s: %s%%\n", type, df.format(distMap.get(type)));
        }

        System.out.println("\n2007년도 출판 비율:");
        double ratio = calculatePublicationRatioByYear(publications, "2007");
        System.out.printf("- 2007년 출판 비율: %s%%\n", df.format(ratio));
    }

}
