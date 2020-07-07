package com.kashif.veterinarypharmacy.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

import com.kashif.veterinarypharmacy.R;

public class CustomProgressDialog {


    Context context;
    Dialog dialog;
    Activity activity;



    public CustomProgressDialog(Context context) {
        this.context = context;
        Create(context);
        activity = (Activity) context;


    }

    public void Create(Context context)
    {

        try {
            dialog = new Dialog(context, R.style.NewDialog);
            dialog.setContentView(R.layout.customprogress_dialog);
            //   dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(true);

   /*          hud = KProgressHUD.create(context)
                    .setStyle(KProgressHUD.Style.PIE_DETERMINATE)
                    .setCancellable(true)
                    .setAnimationSpeed(2)
                    .setDimAmount(0.5f)
                     .setBackgroundColor(context.getResources().getColor(R.color.lenovo_blue));*/
        }catch (Exception exp)
        {
            exp.printStackTrace();
        }

    }

    public void show()
    {

        if(dialog!=null)
        {
            if(!dialog.isShowing())
            {

                if(!activity.isFinishing()) {
                    dialog.show();
                }
            }
        }


    }

    public void dismiss()
    {

        if(dialog!=null)
        {
            if(dialog.isShowing())
            {
                if(!activity.isFinishing())
                {
                    dialog.dismiss();
                }


            }
        }
    }
}
