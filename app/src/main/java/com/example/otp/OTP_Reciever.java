package com.example.otp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.telephony.TelephonyCallback;
import android.widget.EditText;

public class OTP_Reciever extends BroadcastReceiver {
    private static EditText editText_otp;
    public void setEditText_otp(EditText editText){
        OTP_Reciever.editText_otp=editText;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage[] smsMessages= Telephony.Sms.Intents.getMessagesFromIntent(intent);
        for(SmsMessage smsMessage:smsMessages){
            String message_body=smsMessage.getMessageBody();
            String getOTP= message_body.split(":")[1];
            editText_otp.setText(getOTP);
        }

    }
}
