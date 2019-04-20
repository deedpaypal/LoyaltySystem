package com.loyalty.app.util.constants;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.loyalty.app.models.Counter;
import com.loyalty.app.models.Document;
import com.loyalty.app.models.Event;
import com.loyalty.app.models.Rule;

import java.util.ArrayList;
import java.util.List;

public class GlobalVariables {
    public static List<Document> documents = new ArrayList<>();
    public static List<Counter> counters = new ArrayList<>();
    public static List<String> types = new ArrayList<>();
    public static List<Event> events = new ArrayList<>();
    public static List<Rule> rules = new ArrayList<>();
    private static boolean execute = false;

    public static void initializeAll() {
        if (!execute) {
            Config config = new Config("");
            HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance(config);

            execute = true;
        }
    }
}
