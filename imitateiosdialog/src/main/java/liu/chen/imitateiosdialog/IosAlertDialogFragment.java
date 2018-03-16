package liu.chen.imitateiosdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by lenovo on 2018/3/16.
 */

public class IosAlertDialogFragment extends DialogFragment {
    private String title,msg;
    private OnBtnClickListener onBtnClickListener;
    private Dialog mDialog;
    private View view;
    private TextView ios_alert_dialog_tv_tltle,ios_alert_dialog_tv_msg,ios_alert_dialog_text_no,ios_alert_dialog_text_yes;
    private boolean isShow = false;//记录是否展示防止重复添加

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDialog = new Dialog(getContext(),R.style.ImitateIosThem);
        view = LayoutInflater.from(getContext()).inflate(R.layout.ios_alert_dialog,null);
        ios_alert_dialog_tv_tltle = view.findViewById(R.id.ios_alert_dialog_tv_tltle);
        ios_alert_dialog_tv_msg = view.findViewById(R.id.ios_alert_dialog_tv_msg);
        ios_alert_dialog_text_no = view.findViewById(R.id.ios_alert_dialog_text_no);
        ios_alert_dialog_text_yes = view.findViewById(R.id.ios_alert_dialog_text_yes);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ios_alert_dialog_tv_tltle.setText(title);
        ios_alert_dialog_tv_msg.setText(msg);
        ios_alert_dialog_text_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onBtnClickListener != null){
                    onBtnClickListener.onNoClick();
                }
            }
        });
        ios_alert_dialog_text_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onBtnClickListener != null){
                    onBtnClickListener.onYesClick();
                }
            }
        });
        mDialog.setContentView(view);
        return mDialog;
    }

    /**
     * 展示对话框
     * @param fragmentManager
     * @param title 标题
     * @param msg 内容
     * @param onBtnClickListener 确定 取消的监听事件
     */
    public void show(FragmentManager fragmentManager, String title, String msg, OnBtnClickListener onBtnClickListener){
        if (!isShow){
            isShow = true;
            this.title = title;
            this.msg = msg;
            this.onBtnClickListener = onBtnClickListener;
            show(fragmentManager,null);
        }
    }


    /**
     * 取消对话框
     */
    public void cancel(){
        if (isShow){
            isShow = false;
            mDialog.cancel();
        }
    }

    public interface OnBtnClickListener{
        void onNoClick();
        void onYesClick();
    }
}
