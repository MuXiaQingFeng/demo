package com.hanser.controller.EID;


public interface EIDController {

    String getProvider(String name, int status);

    String updateSuggestionById(int id, String advice);

}
