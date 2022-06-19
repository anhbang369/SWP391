/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;


import java.util.Comparator;
import user.UserReport;

/**
 *
 * @author 84348
 */
public class SortReport implements Comparator<UserReport> {

    @Override
    public int compare(UserReport o1, UserReport o2) {
        return o1.getBrand().compareTo(o2.getBrand());
    }

}
