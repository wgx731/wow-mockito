package com.github.wgx731;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GameOfThrones {

    public int storyLineDragonNumber(DaenerysTargaryen dt) {
        int numberOfDragons = dt.numberOfDragons();
        log.info("A dragon has died - number");
        numberOfDragons -= 1;
        log.info("Another dragon has died - number");
        numberOfDragons -= 1;
        return numberOfDragons;
    }

    public List<String> storyLineDragonNames(DaenerysTargaryen dt) {
        List<String> dragons = dt.dragons();
        log.info("dragons list hashcode: " + System.identityHashCode(dragons));
        log.info("A dragon has died - name");
        dragons.remove(0);
        log.info("Another dragon has died - name");
        dragons.remove(0);
        return dragons;
    }

    public List<String> storyLineDragonNamesFix(DaenerysTargaryen dt) {
        List<String> dragons = new ArrayList<>(dt.dragons());
        log.info("dragons list hashcode: " + System.identityHashCode(dragons));
        log.info("A dragon has died - name fix");
        dragons.remove(0);
        log.info("Another dragon has died - name fix");
        dragons.remove(0);
        return dragons;
    }

}
