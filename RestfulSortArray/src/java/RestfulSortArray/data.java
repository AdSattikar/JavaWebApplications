/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package RestfulSortArray;

import jakarta.ejb.Singleton;

/**
 *
 * @author Asus
 */
@Singleton
public class data {
    
      private String data;

    public String get() {
        return data;
    }

    public void put(String s) {
        data = s;
    }
}
