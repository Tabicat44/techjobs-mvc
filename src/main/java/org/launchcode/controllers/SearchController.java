package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results

    @RequestMapping(value = "results")
    public String results(Model model,
                         @RequestParam String searchTerm, @RequestParam String searchType) {

//        ArrayList<HashMap<String, string>> foundOutSearchResults = new ArrayList
        ArrayList<HashMap<String, String>> foundOutSearchResults;


        if(searchType.equals("all")) {
            foundOutSearchResults = JobData.findByValue(searchTerm);
        }

        else{

                foundOutSearchResults = JobData.findByColumnAndValue(searchTerm, searchType);
        }

        model.addAttribute("Columns", ListController.columnChoices);
//        model.addAttribute("theSearchType", searchType);
        model.addAttribute("jobSearchResults", foundOutSearchResults);


        return "search";

    }


}
