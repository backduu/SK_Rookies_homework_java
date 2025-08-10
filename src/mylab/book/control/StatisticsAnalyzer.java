package mylab.book.control;

import java.text.DecimalFormat;
import java.util.*;

import mylab.book.entity.*;

public class StatisticsAnalyzer {
	// Ÿ�Ժ� ��� ���� ��� �޼���
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
    
    // Ư�� ���� ���ǹ� ���� ���
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

    
    // ���ǹ� ���� ���� ���
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


	// ���ǹ� Ÿ�� Ȯ�� ���� �޼���
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "�Ҽ�";
        else if (pub instanceof Magazine) return "����";
        else if (pub instanceof ReferenceBook) return "����";
        else return "��Ÿ";
    }

    // ��� ���� ���
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("Ÿ�Ժ� ��� ����:");
        Map<String, Double> avgMap = calculateAveragePriceByType(publications);
        for (String type : avgMap.keySet()) {
            System.out.printf("- %s: %s��\n", type, df.format(avgMap.get(type)));
        }

        System.out.println("\n���ǹ� ���� ����:");
        Map<String, Double> distMap = calculatePublicationDistribution(publications);
        for (String type : distMap.keySet()) {
            System.out.printf("- %s: %s%%\n", type, df.format(distMap.get(type)));
        }

        System.out.println("\n2007�⵵ ���� ����:");
        double ratio = calculatePublicationRatioByYear(publications, "2007");
        System.out.printf("- 2007�� ���� ����: %s%%\n", df.format(ratio));
    }

}
