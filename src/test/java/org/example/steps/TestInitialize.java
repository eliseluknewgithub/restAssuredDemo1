package org.example.steps;

import cucumber.api.java.Before;
import org.example.CoinMarketCapMethods.CoinMarketCapMethod;
import org.example.BossiniMethods.BossiniMethod;
import org.example.NonBDDReusableMethods.NonBDDReusableMethod;

public class TestInitialize {

    @Before
    public void TestSetup() {
        NonBDDReusableMethod nonBDDReusableMethod = new NonBDDReusableMethod();
        CoinMarketCapMethod coinMarketCapMethod = new CoinMarketCapMethod();
        BossiniMethod bossiniMethod = new BossiniMethod();
    }
}
