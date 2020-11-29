package com.rogeop.lambda.core.filter;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.io.TempDir;

/**
 * Tests PersonFilter
 *
 * @author Robert Pepersack
 */
public class PersonFilterTest {

    PersonFilter personFilter;

    @TempDir
    static Path sharedTempDir;

    @BeforeEach
    public void beforeEach() {
        personFilter = new PersonFilter();
    }

    @Test
    @DisplayName("Testing PersonFilter")
    @EnabledOnOs(OS.WINDOWS)
    @EnabledOnJre(JRE.JAVA_8)
    @Order(1)
    public void test() {
        Path file = sharedTempDir.resolve("test.txt");
        System.out.print("file: " + file);
    }

}