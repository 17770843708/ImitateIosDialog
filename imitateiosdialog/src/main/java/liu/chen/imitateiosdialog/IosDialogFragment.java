package liu.chen.imitateiosdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by lenovo on 2018/3/16.
 */

public class IosDialogFragment extends DialogFragment {
    private String title;
    private IosAlertDialogFragment.OnBtnClickListener onBtnClickListener;
    private Dialog dialog;
    private View dialogView,contentView;
    private TextView ios_dialog_tv_tltle,ios_dialog_text_no,ios_dialog_text_yes;
    private LinearLayout ios_dialog_lin;
    private boolean isShow = false;//记录是否展示防止重复添加

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new Dialog(getContext(),R.style.ImitateIosThem);
        dialogView = LayoutInflater.from(getContext()).inflate(R.layout.ios_dialog,null);
        ios_dialog_tv_tltle = dialogView.findViewById(R.id.ios_dialog_tv_tltle);
        ios_dialog_text_no = dialogView.findViewById(R.id.ios_dialog_text_no);
        ios_dialog_text_yes = dialogView.findViewById(R.id.ios_dialog_text_yes);
        ios_dialog_lin = dialogView.findViewById(R.id.ios_dialog_lin);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ios_dialog_tv_tltle.setText(title);
        if (contentView != null){
            ios_dialog_lin.addView(contentView);
        }
        ios_dialog_text_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onBtnClickListener != null){
                    onBtnClickListener.onNoClick();
                }
            }
        });
        ios_dialog_text_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onBtnClickListener != null){
                    onBtnClickListener.onYesClick();
                }
            }
        });
        dialog.setContentView(dialogView);
        return dialog;
    }

    /**
     * 展示对话框
     * @param fragmentManager
     * @param title 标题
     * @param contentView 自定义的布局
     * @param onBtnClickListener 确定 取消的监听事件
     */
    public void show(FragmentManager fragmentManager, String title, View contentView, IosAlertDialogFragment.OnBtnClickListener onBtnClickListener){
        if (!isShow){
            isShow = true;
            this.title = title;
            this.contentView = contentView;
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
            dialog.cancel();
        }
    }

    public interface OnBtnClickListener{
        void onNoClick();
        void onYesClick();
    }
}
