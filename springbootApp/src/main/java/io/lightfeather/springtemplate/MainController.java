package io.lightfeather.springtemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.regex.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.File;
import java.util.*;

@SpringBootApplication
@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class MainController {

    @RequestMapping("/")
    public String home() {
        return "Server Application API, Hello!";
    }

    @GetMapping("/api/supervisors")
    public List<Supervisor> getSupervisors() {
        String url = "https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers";
        RestTemplate template = new RestTemplate();

        Supervisor[] supervisors = template.getForObject(url, Supervisor[].class);
        List<Supervisor> supervisorsList = Arrays.asList(supervisors);

        supervisorsList.sort(Comparator.comparing(Supervisor::getDisplayName));
        return removeWithNumberJurisdiction(supervisorsList);
    }

    @PostMapping("/api/submit")
    public String submitData(@RequestBody String jsonData) {
        JSONArray filtedArray = new JSONArray();
        JSONObject jsonObj = new JSONObject(jsonData);

        String firstName = jsonObj.getString("firstName");
        String lastName = jsonObj.getString("lastName");
        String email = jsonObj.getString("email");
        String phone = jsonObj.getString("phone");
        String supervisorDisplay = jsonObj.getString("supervisor");

        String validationString = validateSubmission(firstName,lastName,email,phone);

        if(validationString == "valid") {

            Supervisor newSupervisor = findSupervisor(getSupervisors(), supervisorDisplay);
            Employee newEmployee = new Employee(firstName, lastName, email, phone, newSupervisor);

            System.out.println("Post Request Recieved");

            printFinalResponse(newEmployee);

        }
        else {
            System.out.println("Error: Invalid Arguements");
            return validationString;
        }

        return "";
    }

    private void printFinalResponse(Employee e){
        System.out.println("____________________________________________");
        System.out.println("New Employee Created : ");
        System.out.println("");
        System.out.println("Employee First Name : " + e.getFirstName());
        System.out.println("Employee Last Name : " + e.getLastName());
        System.out.println("Employee Email Address : " + e.getEmail());
        System.out.println("Employee Phone Number: " + e.getPhoneNumber());
        System.out.println("");
        System.out.println("Supervisor First Name : " + e.getSupervisor().getFirstName());
        System.out.println("Supervisor Last Name : " + e.getSupervisor().getLastName());
        System.out.println("Supervisor Phone Number : " + e.getSupervisor().getPhone());
        System.out.println("Supervisor Jurisdiction : " + e.getSupervisor().getJurisdiction());
        System.out.println("____________________________________________");
    }

    private String validateSubmission(String firstName, String lastName, String email, String phone) {

        if(!isValidField(firstName, "^[^\\d]+$", false))
            return "First name contains invalid characters.";
        else if(!isValidField(lastName, "^[^\\d]+$", false))
            return "Last name contains invalid characters.";
        else if(!isValidField(email, "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$", true))
            return "Provided Email is invalid.";
        else if(!isValidField(phone, "^([a-zA-Z,#/ \\.\\(\\)\\-\\+\\*]*[0-9]){7}[0-9a-zA-Z,#/ \\.\\(\\)\\-\\+\\*]*$", true))
            return "Provided phone number invalid format.";


        return "valid";
    }

    private boolean isValidField(String entry, String regex, boolean optional)
    {
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        if (entry.isBlank()) {
            if(optional)
                return true;
            return false;
        }

        Matcher m = p.matcher(entry);

        return m.matches();
    }

    private List<Supervisor> removeWithNumberJurisdiction(List<Supervisor> list) {
        List<Supervisor> newList = new ArrayList<>();
        list.forEach(entry -> {
            if(!StringUtils.isNumeric(entry.getJurisdiction())) {
                newList.add(entry);
            }
        });

        return newList;
    }



    private Supervisor findSupervisor(List<Supervisor> list, String displayString) {
        Supervisor supervisor = new Supervisor();
        list.forEach(entry -> {
            if(entry.getDisplayName().contains(displayString)) {
                supervisor.setId(entry.getId());
                supervisor.setPhone(entry.getPhone());
                supervisor.setJurisdiction(entry.getJurisdiction());
                supervisor.setFirstName(entry.getFirstName());
                supervisor.setLastName(entry.getLastName());
            }
        });

        return supervisor;
    }
}
