
import com.brianmbauman.codered.core.threat.Threat;
import com.brianmbauman.codered.core.threat.Trajectory;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class DataLoad {

    @Test
    public void testRandomTrajectory() throws IOException{
        Trajectory trajectory = Trajectory.getRandom();
        assertTrue("MaxDistance should be integer greater than 0.", trajectory.getMaxDistance() > 0);
        Map actions = trajectory.getActions();
        assertEquals("Should have Threat.Ability.Z at breakpoint 0.",
                Threat.Ability.Z, actions.get(0));
    }
}
