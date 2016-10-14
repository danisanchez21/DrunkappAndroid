package com.cognitioco.drunkster.com.cognitioco.drunkster.model;
import com.orm.SugarRecord;

import java.util.Date;
/**
 * Created by dasan on 10/12/2016.
 */

public class History extends SugarRecord {


    private Date startedDrinking;
    private Date stoppedDrinking;
    private double totalBAC;
    private int numOfDrinks;

}
