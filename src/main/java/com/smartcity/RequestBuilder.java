package com.smartcity;

import com.smartcity.entity.Level;
import com.smartcity.entity.Request;
import com.smartcity.entity.Services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

/**
 * Builder that requests the client
 * Created by lpotages on 21/10/16.
 */

public class RequestBuilder {
    BufferedReader br;

    public RequestBuilder(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Function that handles the process when handling a new request
     */
    public void newRequest(){
        try{
            System.out.println("==========================");
            System.out.println("---- New Request ----");
            System.out.println("==========================\n");
            System.out.println("---- Enter Service concerned ----");
            System.out.println("- 1) Police -");
            System.out.println("- 2) Ambulance -");
            int type = Integer.parseInt(br.readLine());

            System.out.println("\n---- Veuillez entrer le niveau d'urgence ----");
            System.out.println("- 1) Bas -");
            System.out.println("- 2) Moyen -");
            System.out.println("- 2) Elevé -");
            int urgencyLevel = Integer.parseInt(br.readLine());

            System.out.println("\n---- Veuillez entrer l'adresse concernée ----");
            String address = br.readLine();

            Request request = createRequest(type,urgencyLevel,address);
            System.out.println("\n---- Request created ----");
            System.out.println(request);
            System.out.println("==========================");
            System.out.println("---- End of Request ----");
            System.out.println("==========================");
        }catch(Exception e){
            System.err.println("Error during request");
        }
    }

    /**
     * Function that creates a request
     * @param type Int representing the type of request
     * @param urgencyLevel Int representing the urgency level of the operation
     * @param address The location to go to
     * @return A request entity
     */
    public Request createRequest(int type, int urgencyLevel, String address){
        Request newRequest = new Request();
        newRequest.setAddress(address);

        switch(type) {
            case 1:
                newRequest.setService(Services.POLICE);
                break;
            case 2:
                newRequest.setService(Services.AMBULANCE);
                break;
            default:
                newRequest.setService(Services.AMBULANCE);
        }

        switch(urgencyLevel){
            case 1:
                newRequest.setEmergencyLevel(Level.LOW);
                break;
            case 2:
                newRequest.setEmergencyLevel(Level.MEDIUM);
                break;
            case 3:
                newRequest.setEmergencyLevel(Level.HIGH);
                break;
            default:
                newRequest.setEmergencyLevel(Level.MEDIUM);
                break;
        }

        return newRequest;
    }

    /**
     * Function that sends a request to the server
     * @param request The request to send
     */
    public void sendRequest(Request request){
        System.out.println("----- Requete envoyee ----");
    }
}
