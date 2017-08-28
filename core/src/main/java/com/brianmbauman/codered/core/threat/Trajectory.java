package com.brianmbauman.codered.core.threat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Trajectory{

    private static final List<Trajectory> list;

    static {
        ObjectMapper mapper = new ObjectMapper();

        try{
            InputStream json = Trajectory.class.getResourceAsStream("/trajectories.json");
            list = Collections.unmodifiableList(Arrays.asList(mapper.readValue(json, Trajectory[].class)));
        } catch (IOException e){
            // TODO: Properly log and exit
            throw new RuntimeException(e);
        }
    }

    public static Trajectory getRandom(){
        return list.get(new Random().nextInt(list.size()));
    }

    @JsonProperty("maxDistance")
    private int maxDistance;
    @JsonProperty("actions")
    private Map<Integer, Threat.Ability> actions;

    public int getMaxDistance(){
        return maxDistance;
    }

    public Map<Integer, Threat.Ability> getActions(){
        return actions;
    }
}
