package ua.nure.piontkovskyi.SummaryTask1;

import ua.nure.piontkovskyi.SummaryTask1.coffee.Coffee;
import ua.nure.piontkovskyi.SummaryTask1.coffee.CoffeeGrade;
import ua.nure.piontkovskyi.SummaryTask1.coffee.CoffeeState;
import ua.nure.piontkovskyi.SummaryTask1.container.CoffeeContainer;
import ua.nure.piontkovskyi.SummaryTask1.container.ContainerType;
import ua.nure.piontkovskyi.SummaryTask1.container.ContainerVolume;
import ua.nure.piontkovskyi.SummaryTask1.price.PriceList;
import ua.nure.piontkovskyi.SummaryTask1.van.CoffeeVan;

import java.util.HashMap;
import java.util.Map;

public class Demo {

    private static PriceList priceList = new PriceList();

    public static PriceList getPriceList() {
        return priceList;
    }

    public static void setPriceList(PriceList priceList) {
        Demo.priceList = priceList;
    }

    public static void initializePrices() {
        Map<CoffeeState, Double> pricesForArabica = new HashMap<>();
        pricesForArabica.put(CoffeeState.GRAIN, 0.5);
        pricesForArabica.put(CoffeeState.GROUND, 0.3);
        pricesForArabica.put(CoffeeState.INSTANT, 0.7);

        priceList.setPrice(CoffeeGrade.ARABICA, pricesForArabica);

        Map<CoffeeState, Double> pricesForRobusta = new HashMap<>();
        pricesForRobusta.put(CoffeeState.GRAIN, 0.4);
        pricesForRobusta.put(CoffeeState.GROUND, 0.9);
        pricesForRobusta.put(CoffeeState.INSTANT, 0.6);

        priceList.setPrice(CoffeeGrade.ROBUSTA, pricesForRobusta);

        Map<CoffeeState, Double> priceForElscelsa = new HashMap<>();
        priceForElscelsa.put(CoffeeState.GRAIN, 0.7);
        priceForElscelsa.put(CoffeeState.GROUND, 0.8);
        priceForElscelsa.put(CoffeeState.INSTANT, 0.4);

        priceList.setPrice(CoffeeGrade.EKSCELSA, priceForElscelsa);

        Map<CoffeeState, Double> pricesForLiberica = new HashMap<>();
        pricesForLiberica.put(CoffeeState.GRAIN, 0.6);
        pricesForLiberica.put(CoffeeState.GROUND, 0.5);
        pricesForLiberica.put(CoffeeState.INSTANT, 0.8);

        priceList.setPrice(CoffeeGrade.LIBERICA, pricesForLiberica);

    }

    public static void main(String[] args) {
        initializePrices();

        CoffeeContainer grainArabicaSmallInPackage = new CoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN),
                ContainerVolume.SMALL, priceList, ContainerType.PACKAGE);
        CoffeeContainer instantArabicaSmallInPackage = new CoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.INSTANT),
                ContainerVolume.SMALL, priceList, ContainerType.PACKAGE);
        CoffeeContainer instantArabicaSmallInJar = new CoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.INSTANT),
                ContainerVolume.SMALL, priceList, ContainerType.JAR);

        CoffeeContainer grainRobustaSmallInPackage = new CoffeeContainer(new Coffee(CoffeeGrade.ROBUSTA, CoffeeState.GRAIN),
                ContainerVolume.SMALL, priceList, ContainerType.PACKAGE);
        CoffeeContainer instantRobustaSmallInPackage = new CoffeeContainer(new Coffee(CoffeeGrade.ROBUSTA, CoffeeState.INSTANT),
                ContainerVolume.SMALL, priceList, ContainerType.PACKAGE);
        CoffeeContainer instantRobustaSmallInJar = new CoffeeContainer(new Coffee(CoffeeGrade.ROBUSTA, CoffeeState.INSTANT),
                ContainerVolume.SMALL, priceList, ContainerType.JAR);
        CoffeeContainer groundRobustaMediumInPackage = new CoffeeContainer(new Coffee(CoffeeGrade.ROBUSTA, CoffeeState.GROUND),
                ContainerVolume.MEDIUM, priceList, ContainerType.PACKAGE);

        CoffeeContainer grainEkscelsaSmallInPackage = new CoffeeContainer(new Coffee(CoffeeGrade.EKSCELSA, CoffeeState.GRAIN),
                ContainerVolume.SMALL, priceList, ContainerType.PACKAGE);
        CoffeeContainer groundEkscelsaMediumInPackage = new CoffeeContainer(new Coffee(CoffeeGrade.EKSCELSA, CoffeeState.GROUND),
                ContainerVolume.MEDIUM, priceList, ContainerType.PACKAGE);


        CoffeeVan van = new CoffeeVan(100);

        try {
            van.addCoffee(grainArabicaSmallInPackage);
            int roastedBeansArabicaSmallCount = 4;
            for (int i = 0; i < roastedBeansArabicaSmallCount; ++i) {
                van.addCoffee(grainEkscelsaSmallInPackage);
            }
            van.addCoffee(instantArabicaSmallInJar);

            van.addCoffee(grainArabicaSmallInPackage);

            van.addCoffee(instantArabicaSmallInPackage);


            int instantRobustaLargeCount = 5;
            for (int i = 0; i < instantRobustaLargeCount; ++i) {
                van.addCoffee(instantRobustaSmallInPackage);
            }
            van.addCoffee(groundRobustaMediumInPackage);

            van.addCoffee(instantRobustaSmallInJar);
            van.addCoffee(grainRobustaSmallInPackage);
            van.addCoffee(groundEkscelsaMediumInPackage);

        } catch (Exception e) {
            System.out.println("Exception!");
        }
        for (int i = 0; i < van.getContainers().size(); i++) {
            System.out.println(i + 1 + ". " + van.getContainers().get(i).toString());
        }

        van.sortByPriceToWeight();
        System.out.println("=========================");

        for (int i = 0; i < van.getContainers().size(); i++) {
            System.out.println(i + 1 + ". " + van.getContainers().get(i).toString());
        }

    }

}
