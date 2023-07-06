package com.utilities;

import lombok.extern.log4j.Log4j;
import org.assertj.core.api.SoftAssertions;


@Log4j
public final class SoftAssert extends SoftAssertions {


    private static final ThreadLocal<SoftAssert> softly = new ThreadLocal<>();

    private SoftAssert() {

    }

    public static SoftAssert getInstance() {
        if (softly.get() == null) {
            softly.set(new SoftAssert());
        }
        return softly.get();
    }

}
