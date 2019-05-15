package com.loyalty.app.util.constants;

import com.loyalty.app.models.Counter;
import com.loyalty.app.models.Document;
import com.loyalty.app.models.Event;
import com.loyalty.app.models.Rule;

import java.util.ArrayList;
import java.util.List;

public class GlobalVariables {
    public static List<Document> documents = new ArrayList<>();
    public static List<Counter> counters;
    public static List<String> types = new ArrayList<>();
    public static List<Event> events;
    public static List<Rule> rules;
    public static boolean execute = false;

}
