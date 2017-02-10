package youlook.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import youlook.Utils.StringUtils;
import youlook.dao.RecordDao;
import youlook.model.Record;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private RecordDao recordDao;

    @RequestMapping(value = "/countDigits", method = RequestMethod.GET)
    public
    @ResponseBody
    String countDigits(@RequestParam("str") String str) {
        try {
            Record record = StringUtils.getNewRecord(str);
            recordDao.save(record);

            return record.getMessage();
        } catch (IllegalAccessError ex) {
            return ex.toString();
        }
    }

    @RequestMapping(value = "/listProcessedStrings", method = RequestMethod.GET)

    public
    @ResponseBody
    String listProcessedStrings() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        for (Record record : recordDao.findAll()) {
            resultMap.put(record.getStr(), record.getDigitCount());
        }

        return mapper.writeValueAsString(resultMap);
    }


}
