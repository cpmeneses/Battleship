package test;
 
import static org.junit.Assert.*;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
 
import org.junit.Before;
import org.junit.Test;
 
import battleship.Battleship;
import battleship.ship.IShip;
 
/**
 * @author jura
 *
 */
public class BattleshipTest2 {
 
    private Battleship battleship;
 
    /**
     * Ship positions we use for testing.
     */
    List<int[]> shipPositions = new ArrayList<int[]>(
            Arrays.asList(new int[][] { { 1, 1 }, { 2, 1 }, { 8, 4 }, { 9, 4 }, { 10, 4 }, { 1, 6 }, { 2, 6 }, { 3, 6 },
                    { 2, 8 }, { 3, 8 }, { 4, 8 }, { 5, 8 }, { 6, 10 }, { 7, 10 }, { 8, 10 }, { 9, 10 }, { 10, 10 } }));
 
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        battleship = new Battleship();
    }
 
    /*
     * Assert methods that facilitates testing.
     */
 
    public void assertShipName(String expectedShipName, IShip ship) {
        if (expectedShipName == null)
            assertNull(ship);
        else {
            assertNotNull(ship);
            assertEquals(expectedShipName, ship.getName());
        }
    }
 
    /**
     * We want to be sure that we understand well how array comparison works
     * using anyMatch method.
     */
 
    /*
     * Methods that simplify testing of displayed territory
     */
 
    /**
     * It prints positions of all ships into stream.
     * 
     * @param battleship
     *            an object that knows territory size
     * @param positions
     *            list of all {x, y} positions, where ships occur.
     * @param stream
     *            output stream with printed territory.
     */
 
    /*
     * Test Territory
     */
 
    @Test
    public void testTerritoryDefaultSizeHeight() {
        assertEquals(10, battleship.getTerritoryHeight());
    }
 
    @Test
    public void testTerritoryDefaultSizeWidth() {
        assertEquals(10, battleship.getTerritoryWidth());
    }
 
    @Test
    public void testTerritoryCustomSizeHeight() {
        battleship.setTerritorySize(4, 7);
        assertEquals(7, battleship.getTerritoryHeight());
    }
 
    @Test
    public void testTerritoryCustomSizeWidth() {
        battleship.setTerritorySize(6, 9);
        assertEquals(6, battleship.getTerritoryWidth());
    }
    
    /*
     * Test Player Names
     */
    
    @Test
    public void testPlayerOneNames() {
      battleship.setPlayerOneName("Gonzalo");
      assertEquals("Gonzalo", battleship.getPlayerOneName());
    }
    
    @Test
    public void testPlayerTwoNames() {
      battleship.setPlayerTwoName("Gonzalo");
      assertEquals("Gonzalo", battleship.getPlayerTwoName());
    }
 
    /*
     * Test Display Territory
     */
    
    @Test
    public void testTildeDisplay() {
      battleship.useTildeDisplay();
    }
    
    @Test
    public void testSpaceDisplay() {
      battleship.useSpaceDisplay();
    }
    
    @Test
    public void testCompactDisplay() {
      battleship.useCompactDisplay();
    }
    
    @Test
    public void testDesktopDisplay() {
      battleship.useDesktopDisplay();
    }
    
    @Test
    public void testReverseDesktopDisplay() {
      battleship.useReverseDesktopDisplay();
    }
 
    /*
     * Test Fleet
     */
 
    @Test
    public void testTraditionalFleet() {
        battleship.useTraditionalFleet();
        assertEquals(5, battleship.getFleetSize());
    }
     
    @Test
    public void testTraditionalFleetAssertShipNamesAndLenght() {
        testTraditionalFleet();
        Iterator<IShip> iterator = battleship.getFleetIterator();
        IShip ship = iterator.next();
        assertEquals("Aircraft carrier", ship.getName());
        assertEquals(5, ship.getLength());
        ship = iterator.next();
        assertEquals("Battleship", ship.getName());
        assertEquals(4, ship.getLength());
        ship = iterator.next();
        assertEquals("Submarine", ship.getName());
        assertEquals(3, ship.getLength());
        ship = iterator.next();
        assertEquals("Destroyer", ship.getName());
        assertEquals(3, ship.getLength());
        ship = iterator.next();
        assertEquals("Patrol boat", ship.getName());
        assertEquals(2, ship.getLength());
        assertFalse(iterator.hasNext());
    }
 
    @Test
    public void testTacticalFleet() {
        battleship.useTacticalFleet();
        assertEquals(7, battleship.getFleetSize());
    }
     
    @Test
    public void testTacticalFleetAssertShipNamesAndLength() {
        testTacticalFleet();
        Iterator<IShip> iterator = battleship.getFleetIterator();
        IShip ship = iterator.next();
        assertEquals("Aircraft carrier", ship.getName());
        assertEquals(5, ship.getLength());
        ship = iterator.next();
        assertEquals("Battleship", ship.getName());
        assertEquals(4, ship.getLength());
        ship = iterator.next();
        assertEquals("Cruiser", ship.getName());
        assertEquals(3, ship.getLength());
        ship = iterator.next();
        assertEquals("Destroyer", ship.getName());
        assertEquals(2, ship.getLength());
        ship = iterator.next();
        assertEquals("Destroyer", ship.getName());
        assertEquals(2, ship.getLength());
        ship = iterator.next();
        assertEquals("Submarine", ship.getName());
        assertEquals(1, ship.getLength());
        ship = iterator.next();
        assertEquals("Submarine", ship.getName());
        assertEquals(1, ship.getLength());
        assertFalse(iterator.hasNext());
    }
 
    @Test
    public void testCustomFleet() {
        battleship.useCustomFleet();
        assertEquals(0, battleship.getFleetSize());
    }
 
    @Test
    public void testCustomFleetWithShips() {
        testCustomFleet();
        battleship.addShip("Aviation", 4);
        assertEquals(1, battleship.getFleetSize());
        battleship.addShip("Nuclear Aircraft", 5);
        assertEquals(2, battleship.getFleetSize());
        battleship.addShip("Amphibious", 4);
        assertEquals(3, battleship.getFleetSize());
    }
 
    @Test
    public void testCustomFleetWithShipsAssertNamesAndLength() {
        testCustomFleetWithShips();
        Iterator<IShip> iterator = battleship.getFleetIterator();
        IShip ship = iterator.next();
        assertEquals("Aviation", ship.getName());
        assertEquals(4, ship.getLength());
        ship = iterator.next();
        assertEquals("Nuclear Aircraft", ship.getName());
        assertEquals(5, ship.getLength());
        ship = iterator.next();
        assertEquals("Amphibious", ship.getName());
        assertEquals(4, ship.getLength());
        assertFalse(iterator.hasNext());
    }
 
    /*
     * Test Deployment
     */
    
    @Test
    public void testBoardEmpty() {
      assertFalse(battleship.isPlayerOneShipAt(1,1));
    }
    
    @Test
    public void testPlayerOneDeployHorizontally() {
        battleship.useTraditionalFleet();
        battleship.playerOneDeployHorizontally(1, 2);
        assert(battleship.isPlayerOneShipAt(1,2));
    }
    
    @Test
    public void testPlayerTwoDeployHorizontally() {
        battleship.useTraditionalFleet();
        battleship.playerTwoDeployHorizontally(1, 2);
        assert(battleship.isPlayerTwoShipAt(1,2));
    }
    
    @Test
    public void testPlayerOneDeployHorizontallyCheckEnd() {
        this.testPlayerOneDeployHorizontally();
        assert(battleship.isPlayerOneShipAt(2, 2));
        assert(battleship.isPlayerOneShipAt(3, 2));
        assert(battleship.isPlayerOneShipAt(4, 2));
        assert(battleship.isPlayerOneShipAt(5, 2));
    }
    
    @Test
    public void testPlayerTwoDeployHorizontallyCheckEnd() {
        this.testPlayerTwoDeployHorizontally();
        assert(battleship.isPlayerTwoShipAt(2, 2));
        assert(battleship.isPlayerTwoShipAt(3, 2));
        assert(battleship.isPlayerTwoShipAt(4, 2));
        assert(battleship.isPlayerTwoShipAt(5, 2));
    }
    
    @Test
    public void testPlayerOneDeployHorizontallyCheckOutside() {
        this.testPlayerOneDeployHorizontallyCheckEnd();
        assertFalse(battleship.isPlayerOneShipAt(6, 2));
    }
    
    @Test
    public void testPlayerTwoDeployHorizontallyCheckOutside() {
        this.testPlayerTwoDeployHorizontallyCheckEnd();
        assertFalse(battleship.isPlayerTwoShipAt(6, 2));
    }
    
    @Test
    public void testPlayerOneDeployHorizontallyCheckAsPlayerTwo() {
        battleship.useTraditionalFleet();
        battleship.playerOneDeployHorizontally(1, 2);
        assertTrue(battleship.isPlayerOneShipAt(1,2));
        assertFalse(battleship.isPlayerTwoShipAt(1,2));
    }
    
    @Test
    public void testPlayerTwoDeployHorizontallyCheckAsPlayerOne() {
        battleship.useTraditionalFleet();
        battleship.playerTwoDeployHorizontally(1, 2);
        assert(battleship.isPlayerTwoShipAt(1,2));
        assertFalse(battleship.isPlayerOneShipAt(1,2));
    }
 
    /**@Test
    public void testplayerOneDeployHorizontally() {
        battleship.useTraditionalFleet();
        assertShipName("Aircraft carrier", battleship.playerOneDeployHorizontally(1, 2));
    }*/
 
    @Test
    public void testplayerOneDeployHorizontallyAssertDeployedShips() {
        this.testPlayerOneDeployHorizontally();
        assertEquals(1, battleship.playerOneNumberOfDeployedShips());
    }
    
    @Test
    public void testplayerTwoDeployHorizontallyAssertDeployedShips() {
        this.testPlayerTwoDeployHorizontally();
        assertEquals(1, battleship.playerTwoNumberOfDeployedShips());
    }
 
    @Test
    public void testplayerOneDeployHorizontallyAssertAnchoredShips() {
        this.testPlayerOneDeployHorizontally();
        assertEquals(0, battleship.playerOneNumberOfAnchoredShips());
    }
    
    @Test
    public void testplayerTwoDeployHorizontallyAssertAnchoredShips() {
        this.testPlayerTwoDeployHorizontally();
        assertEquals(0, battleship.playerTwoNumberOfAnchoredShips());
    }
 
    @Test
    public void testplayerOneDeployVertically() {
        battleship.useTraditionalFleet();
        assertShipName("Aircraft carrier", battleship.playerOneDeployVertically(2, 3));
    }
    
    @Test
    public void testplayerTwoDeployVertically() {
        battleship.useTraditionalFleet();
        assertShipName("Aircraft carrier", battleship.playerTwoDeployVertically(2, 3));
    }
 
    @Test
    public void testplayerOneDeployVerticallyDeployedShips() {
        this.testplayerOneDeployVertically();
        assertEquals(1, battleship.playerOneNumberOfDeployedShips());
    }
    
    @Test
    public void testplayerTwoDeployVerticallyDeployedShips() {
        this.testplayerOneDeployVertically();
        assertEquals(1, battleship.playerOneNumberOfDeployedShips());
    }
 
    @Test
    public void testplayerOneDeployVerticallyAnchoredShips() {
        this.testplayerOneDeployVertically();
        assertEquals(0, battleship.playerOneNumberOfAnchoredShips());
    }
    
    @Test
    public void testplayerTwoDeployVerticallyAnchoredShips() {
        this.testplayerTwoDeployVertically();
        assertEquals(0, battleship.playerTwoNumberOfAnchoredShips());
    }
 
    @Test
    public void testDeployAtTheSamePosition() {
        battleship.useTraditionalFleet();
        assertShipName("Aircraft carrier", battleship.playerOneDeployHorizontally(1, 1));
        assertShipName("", battleship.playerOneDeployHorizontally(1, 1));
        assertEquals(1, battleship.playerOneNumberOfDeployedShips());
        assertEquals(1, battleship.playerOneNumberOfAnchoredShips());
    }
 
    @Test
    public void testDeployShipOutOfTerritory() {
        battleship.useTraditionalFleet();
        battleship.playerOneDeployVertically(8, 8);
        assertEquals(0, battleship.playerOneNumberOfDeployedShips());
        assertEquals(1, battleship.playerOneNumberOfAnchoredShips());
    }
 
    @Test
    public void testUseTightDeploymentCorrectVersion() {
        battleship.useTightDeployment();
        battleship.useTraditionalFleet();
        assertShipName("Aircraft carrier", battleship.playerOneDeployHorizontally(3, 2));
        assertShipName("Battleship", battleship.playerOneDeployVertically(4, 3));
    }
 
    @Test
    public void testUseTightDeploymentIncorrectVersion() {
        battleship.useTightDeployment();
        battleship.useTraditionalFleet();
        assertShipName("Aircraft carrier", battleship.playerOneDeployHorizontally(3, 2));
        assertShipName("", battleship.playerOneDeployVertically(4, 2));
    }
 
    @Test
    public void testUseSpaciousDeploymentCorrectVersion() {
        battleship.useSpaciousDeployment();
        battleship.useTraditionalFleet();
        assertShipName("Aircraft carrier", battleship.playerOneDeployHorizontally(3, 2));
        assertShipName("Battleship", battleship.playerOneDeployVertically(4, 4));
    }
 
    @Test
    public void testUseSpaciousDeploymentIncorrectVersion() {
        battleship.useSpaciousDeployment();
        battleship.useTraditionalFleet();
        assertShipName("Aircraft carrier", battleship.playerOneDeployHorizontally(3, 2));
        assertShipName("", battleship.playerOneDeployVertically(4, 3));
    }
    
    //display
    
    @Test
    public void testDisplayPlayerOneTerritorySpaceDisplay() {
    	battleship.setPlayerOneName("Diego");
    	battleship.useCompactDisplay();
        battleship.useSpaceDisplay();
        battleship.useTraditionalFleet();
        assertShipName("Aircraft carrier", battleship.playerOneDeployHorizontally(1, 1));
        assertEquals("Player: Diego\n with 0 out of 5 affected ship parts.\n\n*****     \n          \n          \n          \n          \n          \n          \n          \n          \n          ",battleship.displayPlayerOneTerritory());
    }
}