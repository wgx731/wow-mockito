package com.github.wgx731;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class WoWMockitoTest {

    private DaenerysTargaryen mockedMotherOfDragons;

    private DaenerysTargaryen motherOfDragons;
    private GameOfThrones testCase;

    @BeforeEach
    void setUp() {
        mockedMotherOfDragons = Mockito.mock(DaenerysTargaryen.class);
        Mockito
            .when(mockedMotherOfDragons.numberOfDragons())
            .thenReturn(5);
        List<String> mockedNames = new ArrayList<>();
        mockedNames.add("Dave");
        mockedNames.add("John");
        mockedNames.add("Kelvin");
        mockedNames.add("Struct");
        mockedNames.add("Nana");
        Mockito
            .when(mockedMotherOfDragons.dragons())
            .thenReturn(mockedNames);

        motherOfDragons = new DaenerysTargaryen();
        testCase = new GameOfThrones();
    }

    @AfterEach
    void tearDown() {
        testCase = null;
        motherOfDragons = null;

        mockedMotherOfDragons = null;
    }

    @Test
    @Disabled
    void testGameOfThronesWithMock() {
        log.info(testCase.getClass().getCanonicalName());
        log.info(mockedMotherOfDragons.getClass().getCanonicalName());
        assertThat(testCase.storyLineDragonNumber(mockedMotherOfDragons))
            .isEqualTo(3);
        assertThat(testCase.storyLineDragonNumber(mockedMotherOfDragons))
            .isEqualTo(3);
        assertThat(testCase.storyLineDragonNames(mockedMotherOfDragons))
            .containsExactlyInAnyOrder("Kelvin", "Struct", "Nana");
        assertThat(testCase.storyLineDragonNames(mockedMotherOfDragons))
            .containsExactlyInAnyOrder("Kelvin", "Struct", "Nana");
    }

    @Test
    void testGameOfThrones() {
        log.info(testCase.getClass().getCanonicalName());
        log.info(motherOfDragons.getClass().getCanonicalName());
        assertThat(testCase.storyLineDragonNumber(motherOfDragons))
            .isEqualTo(1);
        assertThat(testCase.storyLineDragonNumber(motherOfDragons))
            .isEqualTo(1);
        assertThat(testCase.storyLineDragonNames(motherOfDragons))
            .containsExactlyInAnyOrder("Viserion");
        assertThat(testCase.storyLineDragonNames(motherOfDragons))
            .containsExactlyInAnyOrder("Viserion");
    }

    @Test
    void testGameOfThronesWithMockFix() {
        log.info(testCase.getClass().getCanonicalName());
        log.info(mockedMotherOfDragons.getClass().getCanonicalName());
        assertThat(testCase.storyLineDragonNumber(mockedMotherOfDragons))
            .isEqualTo(3);
        assertThat(testCase.storyLineDragonNumber(mockedMotherOfDragons))
            .isEqualTo(3);
        assertThat(testCase.storyLineDragonNamesFix(mockedMotherOfDragons))
            .containsExactlyInAnyOrder("Kelvin", "Struct", "Nana");
        assertThat(testCase.storyLineDragonNamesFix(mockedMotherOfDragons))
            .containsExactlyInAnyOrder("Kelvin", "Struct", "Nana");
    }

}