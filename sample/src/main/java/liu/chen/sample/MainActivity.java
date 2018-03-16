package liu.chen.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import liu.chen.imitateiosdialog.IosAlertDialogFragment;
import liu.chen.imitateiosdialog.IosDialogFragment;

public class MainActivity extends AppCompatActivity {
    private Button main_btn_alert_dialog,main_btn_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_btn_alert_dialog = findViewById(R.id.main_btn_alert_dialog);
        main_btn_dialog = findViewById(R.id.main_btn_dialog);

        main_btn_alert_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final IosAlertDialogFragment iosAlertDialogFragment = new IosAlertDialogFragment();
                iosAlertDialogFragment.show(getSupportFragmentManager(), "标题", "内容", new IosAlertDialogFragment.OnBtnClickListener() {
                    @Override
                    public void onNoClick() {
                        iosAlertDialogFragment.cancel();
                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onYesClick() {
                        iosAlertDialogFragment.cancel();
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        main_btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout,null);
                final IosDialogFragment iosDialogFragment = new IosDialogFragment();
                iosDialogFragment.show(getSupportFragmentManager(), "自定义", dialogView, new IosAlertDialogFragment.OnBtnClickListener() {
                    @Override
                    public void onNoClick() {
                        iosDialogFragment.cancel();
                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onYesClick() {
                        iosDialogFragment.cancel();
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
