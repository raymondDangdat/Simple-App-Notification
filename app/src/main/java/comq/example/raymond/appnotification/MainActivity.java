package comq.example.raymond.appnotification;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static comq.example.raymond.appnotification.App.CHANNEL_1_ID;
import static comq.example.raymond.appnotification.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;

    private Button btn_channel1, btn_channel2;
    private EditText editTextTitle, editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);

        btn_channel1 = findViewById(R.id.btn_channel1);
        btn_channel2 = findViewById(R.id.btn_channel2);
        editTextMessage = findViewById(R.id.edit_text_message);
        editTextTitle = findViewById(R.id.edit_text_title);

        btn_channel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel2();
            }
        });
        
        btn_channel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel1();
            }
        });
    }

    private void sendOnChannel1() {
        String title = editTextTitle.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_looks_one)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(1, notification);

    }

    private void sendOnChannel2() {
        String title = editTextTitle.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_looks_two)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();
        notificationManager.notify(2, notification);
    }
}
