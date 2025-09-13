package entities;

import algorithm.sort.base.SelectionSort;
import algorithm.sort.strategy.SortingStrategyL;
import entities.units.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombatUnitTest {

    private CombatUnit combatUnit;

    @Test
    public void testCombatUnitCommander() {
        combatUnit = new Commander();

        assertEquals('C', combatUnit.getSymbol());
        assertEquals(10, combatUnit.getValue());
        assertEquals('C', combatUnit.toProcessSymbol());
        assertEquals(10, combatUnit.toProcessNumeric());
        assertEquals(
                "CombatUnit{symbol=C, value=10}",
                combatUnit.toString()
        );
    }

    @Test
    public void testCombatUnitDoctor() {
        combatUnit = new Doctor();

        assertEquals('M', combatUnit.getSymbol());
        assertEquals(20, combatUnit.getValue());
        assertEquals('M', combatUnit.toProcessSymbol());
        assertEquals(20, combatUnit.toProcessNumeric());
        assertEquals(
                "CombatUnit{symbol=M, value=20}",
                combatUnit.toString()
        );
    }

    @Test
    public void testCombatUnitTank() {
        combatUnit = new Tank();

        assertEquals('T', combatUnit.getSymbol());
        assertEquals(30, combatUnit.getValue());
        assertEquals('T', combatUnit.toProcessSymbol());
        assertEquals(30, combatUnit.toProcessNumeric());
        assertEquals(
                "CombatUnit{symbol=T, value=30}",
                combatUnit.toString()
        );
    }

    @Test
    public void testCombatUnitSniper() {
        combatUnit = new Sniper();

        assertEquals('S', combatUnit.getSymbol());
        assertEquals(40, combatUnit.getValue());
        assertEquals('S', combatUnit.toProcessSymbol());
        assertEquals(40, combatUnit.toProcessNumeric());
        assertEquals(
                "CombatUnit{symbol=S, value=40}",
                combatUnit.toString()
        );
    }

    @Test
    public void testCombatUnitInfantry() {
        combatUnit = new Infantry();

        assertEquals('I', combatUnit.getSymbol());
        assertEquals(50, combatUnit.getValue());
        assertEquals('I', combatUnit.toProcessSymbol());
        assertEquals(50, combatUnit.toProcessNumeric());
        assertEquals(
                "CombatUnit{symbol=I, value=50}",
                combatUnit.toString()
        );
    }

    @Test
    public void testCombatUnitEmpty() {
        combatUnit = new Empty();

        assertEquals('*', combatUnit.getSymbol());
        assertEquals(60, combatUnit.getValue());
        assertEquals('*', combatUnit.toProcessSymbol());
        assertEquals('*', combatUnit.toProcessNumeric());
        assertEquals(
                "CombatUnit{symbol=*, value=60}",
                combatUnit.toString()
        );
    }

}
