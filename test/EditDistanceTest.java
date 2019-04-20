import org.junit.Test;

import static org.junit.Assert.*;

public class EditDistanceTest {

    @Test
    public void minDistance() {
        EditDistance edit = new EditDistance();
        System.out.println(edit.minDistance("zoologicoarchaeologist", "zoogeologist"));
    }
}