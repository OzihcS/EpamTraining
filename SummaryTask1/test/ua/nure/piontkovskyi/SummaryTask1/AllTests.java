package ua.nure.piontkovskyi.SummaryTask1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ua.nure.piontkovskyi.SummaryTask1.coffee.CoffeeTest;
import ua.nure.piontkovskyi.SummaryTask1.container.CoffeeContainerTest;
import ua.nure.piontkovskyi.SummaryTask1.price.PriceListTest;
import ua.nure.piontkovskyi.SummaryTask1.van.CoffeeVanTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({CoffeeTest.class, CoffeeContainerTest.class, PriceListTest.class, CoffeeVanTest.class})
public class AllTests {
}
