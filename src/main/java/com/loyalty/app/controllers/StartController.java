package com.loyalty.app.controllers;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;
import com.loyalty.app.models.Counter;
import com.loyalty.app.models.Document;
import com.loyalty.app.util.constants.CounterTypes;
import com.loyalty.app.util.constants.GlobalVariables;
import com.loyalty.app.util.constants.EventTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

import static com.loyalty.app.util.constants.GlobalVariables.*;

@Controller
@RequestMapping("/")
public class StartController {

    @Autowired
    private HazelcastInstance instance;

    @RequestMapping(method = RequestMethod.GET)
    public String indexGET(ModelMap model) {
        if (!execute) {
            counters = new ArrayList<>(instance.getList("counters"));
            events = new ArrayList<>(instance.getList("events"));
            rules = new ArrayList<>(instance.getList("rules"));

            execute = true;
        }


        model.addAttribute("test", "Please enter inf");
        Field[] fields = EventTypes.class.getDeclaredFields();
        for (Field f : fields) {
            if (!types.contains(f.getName()))
                types.add(f.getName());
        }
        model.addAttribute("types", types);
        model.addAttribute("displaySendAnotherDocument", "none");
        return "start";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String indexPOST(
            @RequestParam(required = false, name = "atmID") String atmID,
            @RequestParam(required = false, name = "clientID") String clientID,
            @RequestParam(required = false, name = "type") String type,
            @RequestParam(required = false, name = "sum") String sum, ModelMap model) {

        int lastIndex = documents.size() == 0 ? 1 : (documents.get(documents.size() - 1).getId() + 1);
        Document document = new Document(lastIndex, new Date(), Integer.parseInt(atmID), Integer.parseInt(clientID), type, Integer.parseInt(sum));

        documents.add(document);

        //если документ еще не прилетал в систему
        if (counters.stream().anyMatch(c -> c.getDocument().getId() != document.getId()) || counters.isEmpty()) {
            //если не существует вообще такой счетчик с clientID то создаем счетчик
            //if (Objects.equals(counterClientID, null)) {
            if (counters.stream().anyMatch(c -> c.getClientID() != document.getClientID()) || counters.isEmpty()) {
                //создаем счетчик с типом операции документа. в данномслучае снятие c операцией сумм
                Counter counter = new Counter(document.getType(), document, CounterTypes.SUM_COUNTER, document.getSum());
                counters.add(counter);
            } else {
                //ищем счетчик с типом снятие и смотрим какие есть операции. если нет то создаем счетчик новый
                if (counters.stream().anyMatch(c -> c.getName().equals(document.getType()))) {
                    Counter existedCounters
                            = counters.stream().filter(c -> c.getDocument().getClientID() == document.getClientID()
                            && c.getType().equals(CounterTypes.SUM_COUNTER) && c.getName().equals(document.getType())).findFirst().get();
                    counters.stream().filter(c -> c.getDocument().getClientID() == document.getClientID()
                            && c.getType().equals(CounterTypes.SUM_COUNTER) && c.getName().equals(document.getType())).findFirst().get().setAmountOfSum(existedCounters.getAmountOfSum() + document.getSum());
                } else {
                    Counter counter = new Counter(document.getType(), document, CounterTypes.SUM_COUNTER, document.getSum());
                    counters.add(counter);
                }
            }
        }

        model.addAttribute("test", "Success");
        model.addAttribute("display", "none");
        model.addAttribute("displaySendAnotherDocument", "block");
        return "start";
    }


}
