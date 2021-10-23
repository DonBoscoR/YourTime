package com.your.time.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String waitTime = "";
        try {
        	/*String targetDate = "2017/07/23 11:21:56";
            Date d1 = format.parse(targetDate);
            long diff = d1.getTime() - (new Date()).getTime();
            long days = Math.round(diff/1000/60/60/24);
            long reminder = diff>(1000*60*60*24)?diff % (1000*60*60*24):diff;
            long hours = reminder/1000/60/60;
            reminder = reminder>(1000 * 60 * 60)?reminder % (1000*60*60):reminder;
            long minutes = reminder/1000/60;
            reminder = reminder>(1000 * 60)?reminder % (1000*60):reminder;
            long seconds = reminder/1000;
            waitTime = days+"d,"+hours+"h,"+minutes+"m,"+seconds+"s";
            System.out.println("Waiting Time : "+waitTime);*/
        	
        	String targetDate = "2017/07/23 11:21:56";
            Date d1 = format.parse(targetDate);
            long diff = d1.getTime() - (new Date()).getTime();
            diff = diff < 0?0:diff;
            long days = Math.round(diff/1000/60/60/24);
            long reminder = diff % (1000*60*60*24);
            long hours = reminder/1000/60/60;
            reminder = reminder % (1000*60*60);
            long minutes = reminder/1000/60;
            reminder = reminder % (1000*60);
            long seconds = reminder/1000;
            waitTime = days+"d,"+hours+"h,"+minutes+"m,"+seconds+"s";
            System.out.println("Waiting Time : "+waitTime);        	
        	
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

	public void parseDateTime() {
			String waitTime = "";
	        final int pdays;
	        final int phours;
	        final int pmins;
	        final int psecs;
	        long milliseconds = 1000;
	        if(waitTime != null) {
	            String sDays = "0";
	            int iDays = waitTime.indexOf("d");
	            if(iDays != -1){
	                sDays = waitTime.substring(0,iDays);
	            }else{
	                iDays = 0;
	            }
	            String sHours = "0";
	            int iHours = waitTime.indexOf("h");
	            if(iHours != -1){
	                sHours = waitTime.substring(iDays==0?0:iDays+1,iHours);
	            }else {
	                iHours = 0;
	            }
	            String sMins = "0";
	            int iMins = waitTime.indexOf("m");
	            if(iMins != -1){
	                sMins = waitTime.substring(iHours==0?0:iHours+1,iMins);
	            }else{
	                iMins = 0;
	            }
	            String sSecs = "0";
	            int iSecs = waitTime.indexOf("s");
	            if(iSecs != -1){
	                sSecs = waitTime.substring(iMins==0?0:iMins+1,iSecs);
	            }
	            pdays = Integer.parseInt(sDays);
	            phours = Integer.parseInt(sHours);
	            pmins = Integer.parseInt(sMins);
	            psecs = Integer.parseInt(sSecs);
	            milliseconds = (pdays* 1000 * 60 * 60 * 24)+(phours* 1000 * 60 * 60)+(pmins* 1000 * 60)+(psecs* 1000);
	            return ;/*new CountDownTimer(milliseconds, 1000) {
	                int days = pdays;
	                int hours = phours;
	                int mins = pmins;
	                int secs = psecs;
	                public void onTick(long millisUntilFinished) {
	                    if (secs <= 0) {
	                        if(mins <= 0) {
	                            if (hours <= 0) {
	                                if(days <= 0){

	                                }else {
	                                    days = days - 1;
	                                    hours = 23;
	                                    mins = 59;
	                                    secs = 60;
	                                }
	                            }else{
	                                hours = hours -1;
	                                mins = 59;
	                                secs = 60;
	                            }
	                        }else{
	                            mins = mins -1;
	                            secs = 60;
	                        }
	                    }
	                    secs = secs - 1;
	                    String waitingTimeText = (days>0?((days<10?"0"+days:days)+":"):"")+(hours>0?((hours<10?"0"+hours:hours)+":"):"")+(mins>0?((mins<10?"0"+mins:mins)+":"):"")+(secs<10?"0"+secs:secs);
	                    textView.setText(waitingTimeText);
	                    //System.out.println("Waiting TIME: "+waitingTimeText);
	                    //textView.setTextColor(Color.BLACK);
	                }

	                public void onFinish() {
	                    textView.setText("DONE");
	                }
	            };*/
	        }else
	            return ;/*new CountDownTimer(1000, 1000) {
	                public void onTick(long millisUntilFinished) {
	                    textView.setText("DONE");
	                }
	                public void onFinish() {
	                    textView.setText("DONE");
	                }
	            };*/
	}
}
