package com.buscaminas.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        CasillaTest.class,
        JugadorTest.class,
        TableroTest.class
})
public class BuscaminasTestSuite {
    // Esta clase queda vacía, solo sirve para agrupar tests
}
